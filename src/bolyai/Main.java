package bolyai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

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
            /*
                1. Adatok beolvasása
             */
            List<Donto> dontok = dontokBeolvasasa("SuperBowl.txt");

            Donto elsoDonto = new Donto();
            elsoDonto.sorszam = "I.";
            elsoDonto.datum = "1967.01.15.";
            elsoDonto.gyoztes = "Green Bay Packers";
            elsoDonto.eredmeny = "35-10";
            elsoDonto.vesztes = "Kansas City Chiefs";
            elsoDonto.helyszin = "Los Angeles Memorial Coliseum";
            elsoDonto.varosAllam = "Los Angeles, Kalifornia";
            elsoDonto.nezoszam = 61946;

            // NEM jön létre új példány (new operátor NEM kerül meghívásra).
            // Új referenciát hozunk létre a létező objektumhoz.
            Donto masolat = elsoDonto;
            // masolat.nezoszam = 0; // elsoDonto.nezoszam is 0 lesz.
            // STACK: primitív típusok (int, long, byte, float, double, char, boolean...)
            //      + referenciák (pl. @501)
            // HEAP: Objektumok.
            // Több referencia mutathat ugyanarra az objektumra (2 póráz 1 kutyán).

            // Ezért nem szabad szövegeket == -vel összehasonlítani.
            System.out.println("Hello World" == "Hello " + "World"); // false
            System.out.println("Hello World".equals("Hello World")); // true

            // false: 2 azonos tartalmú másolat,
            // de másik példányok
            System.out.println(elsoDonto == dontok.get(0));
            // true: 2 azonos tartalmú másolat
            System.out.println(elsoDonto.equals(dontok.get(0)));
            // toString kerül meghívásra
            System.out.println(elsoDonto);

            // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html
            // List<T>: dinamikusan bővülő tömb
            // Implementációk:
            // - ArrayList<T>: Index alapján gyorsabb elérés.
            // - LinkedList<T>: Gyorsabb hozzáfűzés a lista végére (elejére).
            // Pl. List<Donto> dontok = new ArrayList<>();
            //      <>: diamond operátor (jobb oldalon NEM kell megint megadni a típust)
            // Fontosabb metódusok:
            // - dontok.size(): Listában tárolt elemek számát visszaadó metódus.
            // - dontok.isEmpty(): Üres-e a lista (elemszám == 0)?
            // - dontok.add(donto): Új döntő hozzáfűzése a lista végére.
            // - dontok.add(0, donto): Új döntő beszúrása az adott indexre.
            // - dontok.get(0): Adott indexen található elem visszaadása.
            //      Első elem indexe: 0, utolsó elem indexe: size - 1.
            // - dontok.remove(donto): Annak a döntőnek a törlése, ahol donto.equals(listaEleme).
            // - dontok.remove(0): Döntő törlése az adott indexről.
            // - dontok.contains(donto): Tartalmazza-e a lista a paraméterül adott döntőt?
            //      (Van-e olyan döntő a listában, ahol donto.equals(listaEleme)?)
            // - dontok.indexOf(donto): Melyik indexen van az adott döntő a listában
            //      (melyik indexű elemre igaz a donto.equals(listaEleme)?)
            // - dontok.clear(): Minden döntő törlése.

            // Lista bejárása:
            for (Donto donto : dontok) {
                // Csináljunk valamit.
            }

            // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Set.html
            // Set<T>: Egyedi elemeket tartalmazó kollekció (equals és hashCode alapján).
            // "Halmaz" megvalósítása.
            // Implementációk:
            // - HashSet<T>: Gyorsabb elérés, nem rendezett elemekkel is kompatibilis.
            //      Elemek véletlenszerű sorrendben kerülnek tárolásra.
            // - TreeSet<T>: Elemek rendezett sorrendben kerülnek tárolásra.
            //      Elemeknek implementálniuk kell a Comparable<T>-t.
            // Pl. Set<Donto> dontok = new HashSet<>();
            // Fontosabb metódusok:
            // - dontok.size(): Listában tárolt elemek számát visszaadó metódus.
            // - dontok.isEmpty(): Üres-e a lista (elemszám == 0)?
            // - dontok.add(donto): Új döntő hozzáfűzése a lista végére.
            // - dontok.remove(donto): Annak a döntőnek a törlése, ahol donto.equals(listaEleme).
            // - dontok.contains(donto): Tartalmazza-e a lista a paraméterül adott döntőt?
            //      (Van-e olyan döntő a listában, ahol donto.equals(listaEleme)?)
            // - dontok.clear(): Minden döntő törlése.
            // Bejárás: for-each segítségével

            // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html
            // Map<K, V>: Kulcs-érték párokat tartalmazó adatstruktúra (függvényszerű kapcsolat)
            // Implementációk:
            // - HashMap<K, V>: Kulcsok alapján rendezetlen, kicsit gyorsabb.
            // - TreeMap<K, V>: Kulcsok alapján rendezett.
            // Pl. Map<String, Integer> lakossagOrszagonkent = new TreeMap<>();
            // Fontosabb metódusok:
            // lakossagOrszagonkent.get("Magyarország"): Adott ország lakosságát visszaadó metódus.
            //      Ha nincs bejegyzés, akkor null (érvénytelen, ismeretlen) értéket ad vissza.
            // lakossagOrszagonkent.getOrDefault("Bergengócia", 0): Adott ország lakosságát visszaadó metódus.
            //      Ha nincs bejegyzés, akkor 0 (default) értéket ad vissza.
            // lakossagOrszagonkent.put("Magyarország", 10_000_000): Új érték hozzáadása a gyűjteményhez.
            //      (Vagy régi felülírása).
            // lakossagOrszagonkent.containsKey("Magyarorszag"): Van-e bejegyzés az adott kulcshoz?
            // lakossagOrszagonkent.size(): Bejegyzések számát visszaadó metódus.
            // lakossagOrszagonkent.clear(): Bejegyzéseket törlő metódus.

            Map<String, Integer> lakossagOrszagonkent = new TreeMap<>();
            lakossagOrszagonkent.put("Magyarország", 10_000_000);
            lakossagOrszagonkent.put("Németország", 80_000_000);

            // Map bejárása kulcsok szerint:
            for (String orszag : lakossagOrszagonkent.keySet()) {
                System.out.println(orszag + ": " + lakossagOrszagonkent.get(orszag));
            }

            // Map bejárása értékek szerint (kulcsot (országot) ebben az esetben nehéz lekérdezni):
            for (int lakossag : lakossagOrszagonkent.values()) {
                System.out.println(lakossag);
            }

            // Map bejárása kulcs-érték párok szerint:
            for (Entry<String, Integer> bejegyzes : lakossagOrszagonkent.entrySet()) {
                System.out.println(bejegyzes.getKey() + ": " + bejegyzes.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        1. Adatok beolvasása
    */

    // A metóduson belül nincs hibakezelés (catch blokk).
    // Mivel a metódusban szerepelnek "kockázatos" utasítások (fájlból olvasás),
    // de nincs hibakezelésre vonatkozó rész,
    // emiatt az "adatokBeolvasasa" metódus is "kockázatos" lesz.
    // A hibakezlés hiányát a "throws IOException"-el kell jelölni (hiba "továbbdobása").
    // Javaban kötelező a hibakezelés.
    // A hibákat
    // - vagy el kell "kapni" (catch blokk),
    // - vagy "tovább kell dobni" a hívó felé (throws).
    private static List<Donto> dontokBeolvasasa(String utvonal) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(utvonal))) {
            List<Donto> dontok = new ArrayList<>();

            reader.readLine(); // fejléc "eldobása", nem mentjük semmilyen változóba

            String sor; // következő beolvasott sor

            // Ha vége van a fájlnak, akkor a reader.readLine() null-t ad vissza.
            // Összetett kifejezés:
            // 1. line változóban elmenti a beolvasott értéket
            // 2. ellenőrizzük, hogy végére értünk-e a fájlnak
            while ((sor = reader.readLine()) != null) {
                // sor konvertálása döntővé a segédmetódus segítségével
                Donto donto = sorbolDonto(sor);
                // döntő hozzáfűzése a lista végére
                dontok.add(donto);
            }

            return dontok;
        }
    }

    private static Donto sorbolDonto(String sor) {
        // A fájl 1 sorának "széttörése" az elválasztó karakter (";") mentén
        // különálló értékekre.
        String[] ertekek = sor.split(";");

        // Új (üres, mivel nincs konstruktor) Donto példány létrehozása.
        Donto donto = new Donto();

        // Döntő értékeinek a beállítása.
        donto.sorszam = ertekek[0];
        donto.datum = ertekek[1];
        donto.gyoztes = ertekek[2];
        donto.eredmeny = ertekek[3];
        donto.vesztes = ertekek[4];
        donto.helyszin = ertekek[5];
        donto.varosAllam = ertekek[6];
        donto.nezoszam = Integer.parseInt(ertekek[7]);

        // Kész döntő visszaadása a hívónak (main metódus)
        return donto;
    }

}
