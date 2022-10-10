package bolyai;

public class Main {

    public static void main(String[] args) {
        // NEM lehet személyi szám nélkül példányosítani,
        // mivel a szemelyiSzam final.
        MagyarEmber magyarEmber = new MagyarEmber("123456");

        MagyarEmber.setKoztarsasagiElnok("Göncz Árpád");
        MagyarEmber.setKoztarsasagiElnok("Mádl Ferenc");
        MagyarEmber.setKoztarsasagiElnok("Sólyom László");
        MagyarEmber.setKoztarsasagiElnok("Schmitt Pál");
        MagyarEmber.setKoztarsasagiElnok("Áder János");
        MagyarEmber.setKoztarsasagiElnok("Novák Katalin");

        System.out.println(MagyarEmber.getKoztarsasagiElnok());

        // Math.abs statikus segédmetódus ->
        // NEM példányhoz, hanem a Math osztályhoz tartozik.
        System.out.println(Math.abs(-5));

        System.out.printf("Államalapító: %s\n", MagyarEmber.ALLAMALAPITO);
    }

}
