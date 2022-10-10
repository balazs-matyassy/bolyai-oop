package bolyai;

import java.time.LocalDate;
import java.util.Objects;

public class Utazas implements Tevekenyseg {

    private LocalDate datum;

    private String cel;

    private KozlekedesiEszkoz kozlekedesiEszkoz;

    // Összes primitív típusnak van egy wrapper megfelelője
    // (int -> Integer, boolean -> Boolean, double -> Double)
    // Integer: nullázható (el tudjuk tárolni, hogy ismeretlen egy érték)
    // int: nem nullázható (lehet 0, de tudjuk, hogy ismeretlen vagy ingyenes utazás)
    // private Integer ar = null;
    private int ar;

    private int hosszPercben;

    public Utazas() {
    }

    public Utazas(
            LocalDate datum, String cel,
            KozlekedesiEszkoz kozlekedesiEszkoz,
            int ar, int hosszPercben
    ) {
        this.datum = datum;
        this.cel = cel;
        this.kozlekedesiEszkoz = kozlekedesiEszkoz;
        this.ar = ar;
        this.hosszPercben = hosszPercben;
    }

    @Override
    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public KozlekedesiEszkoz getKozlekedesiEszkoz() {
        return kozlekedesiEszkoz;
    }

    public void setKozlekedesiEszkoz(KozlekedesiEszkoz kozlekedesiEszkoz) {
        this.kozlekedesiEszkoz = kozlekedesiEszkoz;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    @Override
    public int getHosszPercben() {
        return hosszPercben;
    }

    public void setHosszPercben(int hosszPercben) {
        this.hosszPercben = hosszPercben;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utazas)) return false;
        Utazas utazas = (Utazas) o;
        return datum.equals(utazas.datum) && cel.equals(utazas.cel) && kozlekedesiEszkoz == utazas.kozlekedesiEszkoz;
    }

    @Override
    public int hashCode() {
        return Objects.hash(datum, cel, kozlekedesiEszkoz);
    }

    @Override
    public String toString() {
        return "Utazas{" +
                "datum=" + datum +
                ", cel='" + cel + '\'' +
                ", kozlekedesiEszkoz=" + kozlekedesiEszkoz +
                ", ar=" + ar +
                ", hosszPercben=" + hosszPercben +
                '}';
    }
}
