package bolyai;

import java.util.Objects;

// 1. Adatstruktúra létrehozása (fejléc alapján)
// Getterek-setterek segítségével el tudjuk rejteni az objektum belső állapotát.
// "A városfalon belülre kerülnek az értékek".
// Innentől fogva csak kérni lehet az objektumot, hogy visszaadja az adott értéket.
// Pl. Excel számított cella.
// Pl. Más pénztárcájába sem lehet belenézni, de meg lehet kérdezni, hogy mennyi pénze van.
//
// Szabadstrand: Érdemes azonnal falat építeni, mivel egyébként át kell szoktatni az embereket,
// vagy pedig nem lehet belépődíjat szedni, ha csak egy fal nélkül építünk kaput.
public class Donto {
    private String sorszam;

    private String datum;

    private String gyoztes;

    private String eredmeny;

    private String vesztes;

    private String helyszin;

    private String varosAllam;

    private int nezoszam;

    // Default konstruktor: Nem csinál semmit.
    // Ha létrehozunk legalább 1 konstruktort, akkor a default konstruktor letiltásra kerül.
    // Ha ez nem cél (továbbra is engedélyezni szeretnénk az értékek utólagos beállítását),
    // akkor definiálnunk kell egy default konstruktor.
    public Donto() {
    }

    // Konstruktor:
    // Megtanítjuk a létrehozás alatt álló példányt inicializálni (mezőket beállítani) önmagát.
    // Pl. Donto donto = new Donto(
    //      "I.", "1967.01.15.",
    //      "Green Bay Packers", "35-10", "Kansas City Chiefs",
    //      "Los Angeles Memorial Coliseum", "Los Angeles, Kalifornia",
    //      61946
    // );
    public Donto(
            String sorszam, String datum,
            String gyoztes, String eredmeny, String vesztes,
            String helyszin, String varosAllam,
            int nezoszam
    ) {
        this.sorszam = sorszam;
        this.datum = datum;
        this.gyoztes = gyoztes;
        this.eredmeny = eredmeny;
        this.vesztes = vesztes;
        this.helyszin = helyszin;
        this.varosAllam = varosAllam;
        this.nezoszam = nezoszam;
    }

    // Bizonyos esetekben érdemes lehet további formátumokra is konstruktort létrehozni.
    // Ebben az esetben "megtanítjuk" a létrehozás alatt álló objektumot CSV-ből inicializálni magát.
    // Pl. Donto donto =
    //      new Donto("I.;1967.01.15.;Green Bay Packers;35-10;Kansas City Chiefs;Los Angeles Memorial Coliseum;Los Angeles, Kalifornia;61946");
    // Ha sok helyen van erre a funkcióra szükség, akkor érdemes az objektumot "megtanítani".
    // Ha több konstruktor van, akkor szignatúra (paraméterek száma és típusa) alapján dől el, hogy melyik fut le.
    public Donto(String csvSor) {
        String[] ertekek = csvSor.split(";");

        this.sorszam = ertekek[0];
        this.datum = ertekek[1];
        this.gyoztes = ertekek[2];
        this.eredmeny = ertekek[3];
        this.vesztes = ertekek[4];
        this.helyszin = ertekek[5];
        this.varosAllam = ertekek[6];
        this.nezoszam = Integer.parseInt(ertekek[7]);
    }

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

    public String getSorszam() {
        return sorszam;
    }

    public void setSorszam(String sorszam) {
        this.sorszam = sorszam;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getGyoztes() {
        return gyoztes;
    }

    public void setGyoztes(String gyoztes) {
        this.gyoztes = gyoztes;
    }

    public String getEredmeny() {
        return eredmeny;
    }

    public void setEredmeny(String eredmeny) {
        this.eredmeny = eredmeny;
    }

    public String getVesztes() {
        return vesztes;
    }

    public void setVesztes(String vesztes) {
        this.vesztes = vesztes;
    }

    public String getHelyszin() {
        return helyszin;
    }

    public void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }

    public String getVarosAllam() {
        return varosAllam;
    }

    public void setVarosAllam(String varosAllam) {
        this.varosAllam = varosAllam;
    }

    public int getNezoszam() {
        return nezoszam;
    }

    public void setNezoszam(int nezoszam) {
        this.nezoszam = nezoszam;
    }
}
