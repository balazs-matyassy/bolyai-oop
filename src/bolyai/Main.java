package bolyai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<Donto> dontok = new ArrayList<>();

            /*
                3. Adatok kiírása
             */
            // Írásra nyitunk meg egy fájlt.
            // Itt sincs hibakezelés (ebben az esetben a külső catch kezeli az esetleges hibákat).
            try (PrintWriter writer = new PrintWriter("SuperBowlNew.txt")) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        3. Adatok kiírása
    */
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
