package bolyai;

import java.time.LocalDate;

public class MagyarEmber {

    // STATIC + FINAL:
    // Az osztályhoz tartozik, de SOHA többet nem változik.
    public static final String ALLAMALAPITO = "I. (Szent) István";

    // STATIC:
    // Mező vagy metódus NEM az objektumokhoz / példányokhoz tartozik,
    // hanem az osztályhoz (minden példányra jellemző).
    // Konkrét magyar ember nélkül el tudjuk-e dönteni, hogy ki a köztársasági elnök?
    // IGEN -> static
    private static String koztarsasagiElnok;

    // FINAL:
    // SOHA nem változhat meg.
    // Pontosan 1x kötelező írni (az ÖSSZES konstruktorban).
    private final String szemelyiSzam;

    private String nev;

    private Nem nem;

    private LocalDate szuletesnap;

    // NINCS default konstruktor -> Ember-t NEM lehet személyi szám nélkül példányosítani.

    public MagyarEmber(String szemelyiSzam) {
        this.szemelyiSzam = szemelyiSzam;
    }

    public MagyarEmber(String szemelyiSzam, String nev, Nem nem, LocalDate szuletesnap) {
        this.szemelyiSzam = szemelyiSzam;
        this.nev = nev;
        this.nem = nem;
        this.szuletesnap = szuletesnap;
    }

    // Metódus is static.
    // Meghívható konkrét példány nélkül.
    public static String getKoztarsasagiElnok() {
        return koztarsasagiElnok;
    }

    public static void setKoztarsasagiElnok(String koztarsasagiElnok) {
        MagyarEmber.koztarsasagiElnok = koztarsasagiElnok;
    }

    public String getSzemelyiSzam() {
        return szemelyiSzam;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Nem getNem() {
        return nem;
    }

    public void setNem(Nem nem) {
        this.nem = nem;
    }

    public LocalDate getSzuletesnap() {
        return szuletesnap;
    }

    public void setSzuletesnap(LocalDate szuletesnap) {
        this.szuletesnap = szuletesnap;
    }
}
