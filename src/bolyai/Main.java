package bolyai;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Heterogén kollekció:
        // Bármilyen interfészt implementáló objektumot tárolhat.
        Tevekenyseg[] tevekenysegek = {
                new Utazas(
                        LocalDate.of(2022, 12, 10),
                        "Hawaii",
                        KozlekedesiEszkoz.REPULO,
                        1_000_000,
                        900
                ),
                new Utazas(
                        LocalDate.of(2022, 12, 15),
                        "Eger",
                        KozlekedesiEszkoz.BUSZ,
                        5_000,
                        120
                ),
                new SzabadidosTevekenyseg(
                        LocalDate.of(2022, 12, 20),
                        "Futás",
                        60
                )
        };

        int osszIdo = osszIdo(tevekenysegek);

        System.out.printf("Összes eltöltött idő: %d\n", osszIdo);
    }

    private static int osszIdo(Tevekenyseg[] tevenysegek) {
        int osszeg = 0;

        for (Tevekenyseg tevekenyseg : tevenysegek) {
            // POLIMORFIZMUS / többalakúság
            // Mindig a megfelelő getHosszPercben kerül meghívásra.
            osszeg += tevekenyseg.getHosszPercben();
        }

        return osszeg;
    }

    /* private static int osszIdo(Utazas[] utazasok) {
        int osszeg = 0;

        for (Utazas utazas : utazasok) {
            osszeg += utazas.getHosszPercben();
        }

        return osszeg;
    } */

    /* private static int osszIdo(SzabadidosTevekenyseg[] tevekenysegek) {
        int osszeg = 0;

        for (SzabadidosTevekenyseg tevekenyseg : tevekenysegek) {
            osszeg += tevekenyseg.getHosszPercben();
        }

        return osszeg;
    } */

}
