package bolyai;

public class SakkDonto implements SportDonto {
    private String datum;

    private String vilagos;

    private String sotet;

    private String helyszin;

    private SakkEredmeny eredmeny;

    public SakkDonto() {
    }

    public SakkDonto(String datum, String vilagos, String sotet, String helyszin, SakkEredmeny eredmeny) {
        this.datum = datum;
        this.vilagos = vilagos;
        this.sotet = sotet;
        this.helyszin = helyszin;
        this.eredmeny = eredmeny;
    }

    @Override
    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getVilagos() {
        return vilagos;
    }

    public void setVilagos(String vilagos) {
        this.vilagos = vilagos;
    }

    public String getSotet() {
        return sotet;
    }

    public void setSotet(String sotet) {
        this.sotet = sotet;
    }

    @Override
    public String getHelyszin() {
        return helyszin;
    }

    public void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }

    public SakkEredmeny getEredmeny() {
        return eredmeny;
    }

    public void setEredmeny(SakkEredmeny eredmeny) {
        this.eredmeny = eredmeny;
    }

    @Override
    public boolean isDontetlen() {
        // Stringgel ellentétben equals és == is jó
        // (Mert az enumok singletonok)
        return eredmeny == SakkEredmeny.DONTETLEN;
    }
}
