package bolyai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // PIPELINE (csővezeték)
    // 1. adatok beolvasása -> 2. adatok feldolgozása -> 3. adatok kiírása
    public static void main(String[] args) {
        // Ha bárhol történik hiba, akkor megszakad a try blokk,
        // és a catch blokkban folytatódik a program végrehajtása.
        // 1. - adatok beolvasása
        // 2. - adatok feldolgozása
        // 3. - adatok kiírása
        // Ha bárhol hiba van, akkor a többi lépést NEM kell folytatni.
        try {
            /*
                1. Adatok beolvasása
             */
            List<Donto> dontok = dontokBeolvasasa("SuperBowl.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        1. Adatok beolvasása
    */

    // A metóduson belül nincs hibakezelés (catch blokk).
    // Mivel a metódusban szerepelnek "kockázatos" utasítások (fájlból olvasás),
    // de nincs hibakezelésre vonatkozó rész,
    // emiatt az "adatokBeolvasasa" metódus is "kockázatos" lesz.
    // A hibakezlés hiányát a "throws IOException"-el kell jelölni (hiba "továbbdobása").
    // Javaban kötelező a hibakezelés.
    // A hibákat
    // - vagy el kell "kapni" (catch blokk),
    // - vagy "tovább kell dobni" a hívó felé (throws).
    private static List<Donto> dontokBeolvasasa(String utvonal) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(utvonal))) {
            List<Donto> dontok = new ArrayList<>();

            reader.readLine(); // fejléc "eldobása", nem mentjük semmilyen változóba

            String sor; // következő beolvasott sor

            // Ha vége van a fájlnak, akkor a reader.readLine() null-t ad vissza.
            // Összetett kifejezés:
            // 1. line változóban elmenti a beolvasott értéket
            // 2. ellenőrizzük, hogy végére értünk-e a fájlnak
            while ((sor = reader.readLine()) != null) {
                // sor konvertálása döntővé a segédmetódus segítségével
                Donto donto = sorbolDonto(sor);
                // döntő hozzáfűzése a lista végére
                dontok.add(donto);
            }

            return dontok;
        }
    }

    private static Donto sorbolDonto(String sor) {
        // A fájl 1 sorának "széttörése" az elválasztó karakter (";") mentén
        // különálló értékekre.
        String[] ertekek = sor.split(";");

        // Új (üres, mivel nincs konstruktor) Donto példány létrehozása.
        Donto donto = new Donto();

        // Döntő értékeinek a beállítása.
        donto.sorszam = ertekek[0];
        donto.datum = ertekek[1];
        donto.gyoztes = ertekek[2];
        donto.eredmeny = ertekek[3];
        donto.vesztes = ertekek[4];
        donto.helyszin = ertekek[5];
        donto.varosAllam = ertekek[6];
        donto.nezoszam = Integer.parseInt(ertekek[7]);

        // Kész döntő visszaadása a hívónak (main metódus)
        return donto;
    }

}
