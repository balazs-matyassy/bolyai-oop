package bolyai;

import java.util.Objects;

// 1. Adatstruktúra létrehozása (fejléc alapján)
public class Donto {
    public String sorszam;

    public String datum;

    public String gyoztes;

    public String eredmeny;

    public String vesztes;

    public String helyszin;

    public String varosAllam;

    public int nezoszam;

    // Az @Override annotáció azt jelzi,
    // hogy a metódus az ősosztályból (ebben az esetben Object) származik.
    // Minden objektum (Object minden leszármazottja) rendelkezik a következő 3 metódussal:
    // - equals: üzleti egyenlőség vizsgálata (alapértelmezetten ==)
    //      Általában kulcs (egyik objektummal lehet-e a másikat frissíteni -> pl. bevallás javított példánya)
    //      VAGY MINDEN mező alapján szokott működni (teljes egyezőséget vizsgál).
    //      Minden mezőre akkor szokott épülni, ha a mezők értéke utólag NEM változhat.
    // - hashCode: keresés gyorsítása, equals-al konzisztensnek kell lennie a működésének
    //      (az equals által használt mezők részhalmazára támaszkodhat)
    // - toString: objektum szöveges reprezentációját visszaadó metódus,
    //      pl. System.out.println(obj) esetében kerül meghívásra.

    // Két objektum üzleti egyezőségét visszaadó metódus.
    // Ez az implementáció a KULCS (sorszám) alapján válaszolja meg az egyezőséget.
    // Két objektum akkor egyenlő, ha a kulcsok egyenlő (a többi mező értéke eltérhet).
    // Jelentősége: Új bejegyzést kell-e valamihez létrehozni vagy a régit kell frissíteni?
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Donto)) return false;
        Donto donto = (Donto) o;
        return sorszam.equals(donto.sorszam);
    }

    // Az egyenlőséget kulcs alapján vizsgáló equals metódus párja.
    // A hashCode metódus a kereséseket gyorsítja meg.
    // Mindig az equals metódus mezőire / mezőinek részhalmazára támaszkodhat (kevesebb lehet, több nem).
    @Override
    public int hashCode() {
        return Objects.hash(sorszam);
    }

    /*
    // Az egyenlőséget MINDEN mező alapján vizsgáló equals implementáció.
    // Általában adatstruktúráknál (rekordok) szokták használni, ahol NEM változhatnak meg később az értékek.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Donto)) return false;
        Donto donto = (Donto) o;
        return nezoszam == donto.nezoszam && Objects.equals(sorszam, donto.sorszam) && Objects.equals(datum, donto.datum) && Objects.equals(gyoztes, donto.gyoztes) && Objects.equals(eredmeny, donto.eredmeny) && Objects.equals(vesztes, donto.vesztes) && Objects.equals(helyszin, donto.helyszin) && Objects.equals(varosAllam, donto.varosAllam);
    }

    // Az egyelőséget MINDEN mező alapján vizsgáló equals metódus párja.
    @Override
    public int hashCode() {
        return Objects.hash(sorszam, datum, gyoztes, eredmeny, vesztes, helyszin, varosAllam, nezoszam);
    }
     */

    // Egy objektum szöveges reprezentációját visszaadó metódus.
    // Pl. a System.out.println(donto); használja.
    @Override
    public String toString() {
        return "Donto{" +
                "sorszam='" + sorszam + '\'' +
                ", datum='" + datum + '\'' +
                ", gyoztes='" + gyoztes + '\'' +
                ", eredmeny='" + eredmeny + '\'' +
                ", vesztes='" + vesztes + '\'' +
                ", helyszin='" + helyszin + '\'' +
                ", varosAllam='" + varosAllam + '\'' +
                ", nezoszam=" + nezoszam +
                '}';
    }
}
