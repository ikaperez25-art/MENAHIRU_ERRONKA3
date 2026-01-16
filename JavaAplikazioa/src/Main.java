import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Programa nagusia. Hemen hasten da dena.
 * 
 * @author Ikaperez25
 */
public class Main {
    private static List<Apalategia> biltegia = new ArrayList<>();
    private static Map<String, Produktua> katalogoa = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Programaren hasiera.
     */
    public static void main(String[] args) {
        hasieratuBiltegia();
        hasieratuKatalogoa();

        boolean irten = false;
        while (!irten) {
            erakutsiMenua();
            int aukera = scanner.nextInt();
            scanner.nextLine();

            switch (aukera) {
                case 1:
                    produktuBatSartu();
                    break;
                case 2:
                    produktuBatAtera();
                    break;
                case 3:
                    gelaxkaKontsultatu();
                    break;
                case 4:
                    inbentarioaIkusi();
                    break;
                case 0:
                    irten = true;
                    break;
                default:
                    System.out.println("Aukera okerra.");
            }
        }
    }

    /**
     * Biltegia prestatzeko.
     */
    private static void hasieratuBiltegia() {
        for (int i = 1; i <= 25; i++) {

            biltegia.add(new Apalategia(i, 5, 6));
        }
        System.out.println("Biltegia hasieratuta: 25 apalategi.");
    }

    /**
     * Produktuak eta taldeak sortzeko.
     */
    private static void hasieratuKatalogoa() {
        Kategoria arropa = new Kategoria("Arropa", null);
        Kategoria kamiseta = new Kategoria("Kamiseta", arropa);

        Produktua p1 = new Produktua("11111", "Zubieta Kamiseta (M)", kamiseta);
        Produktua p2 = new Produktua("22222", "Zubieta Kamiseta (L)", kamiseta);

        katalogoa.put(p1.getEan13(), p1);
        katalogoa.put(p2.getEan13(), p2);
    }

    /**
     * Aukerak erakusteko.
     */
    private static void erakutsiMenua() {
        System.out.println("\n--- BILTEGI KUDEAKETA ---");
        System.out.println("1. Produktua sartu");
        System.out.println("2. Produktua atera");
        System.out.println("3. Gelaxka kontsultatu");
        System.out.println("4. Inbentario osoa ikusi");
        System.out.println("0. Irten");
        System.out.print("Aukeratu: ");
    }

    /**
     * Gauza bat apalategian sartzeko.
     */
    private static void produktuBatSartu() {
        System.out.print("Sartu produktuaren EAN kodea (11111 edo 22222): ");
        String ean = scanner.nextLine();
        Produktua p = katalogoa.get(ean);

        if (p == null) {
            System.out.println("Produktua ez da existitzen.");
            return;
        }

        System.out.print("Sartu Apalategi ID (1-25): ");
        int apalaId = scanner.nextInt();
        System.out.print("Sartu Ilara (0-4): ");
        int ilara = scanner.nextInt();
        System.out.print("Sartu Zutabea (0-5): ");
        int zutabea = scanner.nextInt();
        System.out.print("Kantitatea: ");
        int kantitatea = scanner.nextInt();

        if (apalaId < 1 || apalaId > biltegia.size()) {
            System.out.println("Apalategi okerra.");
            return;
        }

        Apalategia apalategia = biltegia.get(apalaId - 1);
        Gelaxka g = apalategia.lortuGelaxka(ilara, zutabea);

        if (g != null) {
            g.sartuProduktua(p, kantitatea);
            System.out.println("Produktua sartuta.");
        } else {
            System.out.println("Koordenatu okerrak.");
        }
    }

    /**
     * Gauza bat apalategitik ateratzeko.
     */
    private static void produktuBatAtera() {

        System.out.println("Funtzionalitate hau inplementatzeke dago oraindik.");
    }

    /**
     * Kaxa batean zer dagoen ikusteko.
     */
    private static void gelaxkaKontsultatu() {
        System.out.print("Sartu Apalategi ID (1-25): ");
        int apalaId = scanner.nextInt();
        System.out.print("Sartu Ilara: ");
        int ilara = scanner.nextInt();
        System.out.print("Sartu Zutabea: ");
        int zutabea = scanner.nextInt();

        Apalategia apalategia = biltegia.get(apalaId - 1);
        Gelaxka g = apalategia.lortuGelaxka(ilara, zutabea);

        if (g != null) {
            System.out.println("Edukia: " + g);
        }
    }

    /**
     * Biltegi osoan zer dagoen ikusteko.
     */
    private static void inbentarioaIkusi() {
        for (Apalategia a : biltegia) {
            for (int i = 0; i < a.getIlarak(); i++) {
                for (int j = 0; j < a.getZutabeak(); j++) {
                    Gelaxka g = a.lortuGelaxka(i, j);
                    if (!g.getInbentarioa().isEmpty()) {
                        System.out.println("Apalategia " + a.getId() + " [" + i + "," + j + "]: " + g);
                    }
                }
            }
        }
    }
}
