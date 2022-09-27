package bolyai;

import java.io.IOException;
import java.io.PrintWriter;
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
            List<Donto> dontok = new ArrayList<>();

            /*
                3. Adatok kiírása
             */
            dontokKiirasa("SuperBowlNew.txt", dontok);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        3. Adatok kiírása
    */
    private static void dontokKiirasa(String utvonal, List<Donto> dontok) throws IOException {
        // Írásra nyitunk meg egy fájlt.
        // Itt sincs hibakezelés (ebben az esetben a külső catch kezeli az esetleges hibákat).
        try (PrintWriter writer = new PrintWriter(utvonal)) {
            // Ha szeretnénk fejlécet:
            writer.println("Ssz;Dátum;Győztes;Eredmény;Vesztes;Helyszín;VárosÁllam;Nézőszám");

            // for-each szerkezet
            // Egy gyűjtemény (List<T>, Set<T> vagy T[] (tömb)) minden elemét értékenként bejárunk.
            // A feldolgozáshoz nincs szükség az indexre.
            for (Donto donto : dontok) {
                // Döntő visszaalakítása sorrá a segédmetódus segítségével.
                // Ebben az esetben változatlan formában írjuk ki az értékeket,
                // de amúgy lehtőség lenne a dontobolSor metódusban egyéb formátumra is konvertálni.
                String sor = dontobolSor(donto);
                // Konvertált sor kiírása a megnyitott fájlba.
                // lsd. System.out.println: NINCS formázás, VAN sortörés.
                writer.println(sor);
            }
        }
    }

    private static String dontobolSor(Donto donto) {
        return donto.sorszam
                + ";" + donto.datum
                + ";" + donto.gyoztes
                + ";" + donto.eredmeny
                + ";" + donto.vesztes
                + ";" + donto.helyszin
                + ";" + donto.varosAllam
                + ";" + donto.nezoszam; // számból automatikus a szöveggé konvertálás
    }

}
