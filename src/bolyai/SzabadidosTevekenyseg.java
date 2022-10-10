package bolyai;

import java.time.LocalDate;
import java.util.Objects;

public class SzabadidosTevekenyseg implements Tevekenyseg {

    private LocalDate datum;

    private String megjegyzes;

    private int hosszPercben;

    public SzabadidosTevekenyseg() {
    }

    public SzabadidosTevekenyseg(LocalDate datum, String megjegyzes, int hosszPercben) {
        this.datum = datum;
        this.megjegyzes = megjegyzes;
        this.hosszPercben = hosszPercben;
    }

    @Override
    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
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
        if (!(o instanceof SzabadidosTevekenyseg)) return false;
        SzabadidosTevekenyseg that = (SzabadidosTevekenyseg) o;
        return datum.equals(that.datum) && megjegyzes.equals(that.megjegyzes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datum, megjegyzes);
    }

    @Override
    public String toString() {
        return "SzabadidosTevekenyseg{" +
                "datum=" + datum +
                ", megjegyzes='" + megjegyzes + '\'' +
                ", hosszPercekben=" + hosszPercben +
                '}';
    }
}
