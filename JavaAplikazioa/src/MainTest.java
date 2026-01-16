import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));

        // Garbitu eta hasieratu
        Main.biltegia = new ArrayList<>();
        Main.katalogoa = new HashMap<>();
        Main.hasieratuBiltegia();
        Main.hasieratuKatalogoa();
    }

    @AfterEach
    void restore() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    // PK4 - B2, B3, B4 Baliozko kasua
    @Test
    void testProduktuaSartuOndo() {
        // Input: EAN(11111) Apal(1) Ilara(0) Zutabea(0) Kantitatea(5)
        String input = "11111\n1\n0\n0\n5\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Main.scanner = new Scanner(System.in); // Scanner eguneratu input berriarekin

        Main.produktuBatSartu();

        // Egiaztatu mezua
        assertTrue(outContent.toString().contains("Produktua sartuta."));

        // Egiaztatu
        Gelaxka g = Main.biltegia.get(0).lortuGelaxka(0, 0);
        assertFalse(g.getInbentarioa().isEmpty());
    }

    // PK3 - EB1a (EAN okerra)
    @Test
    void testProduktuaEanOkerra() {
        String input = "99999\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Main.scanner = new Scanner(System.in);

        Main.produktuBatSartu();

        assertTrue(outContent.toString().contains("Produktua ez da existitzen."));
    }

    // PK5 - EB2 (Apalategi okerra)
    @Test
    void testApalategiOkerra() {
        // Apalategi ID 30 (ez da existitzen)
        String input = "11111\n30\n0\n0\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Main.scanner = new Scanner(System.in);

        Main.produktuBatSartu();

        assertTrue(outContent.toString().contains("Apalategi okerra."));
    }

    // PK6 - EB3 (Koordenatu okerrak - Ilara gehiegi)
    @Test
    void testKoordenatuOkerrak() {
        // Ilara 9 (ez da existitzen)
        String input = "11111\n1\n9\n0\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Main.scanner = new Scanner(System.in);

        Main.produktuBatSartu();

        assertTrue(outContent.toString().contains("Koordenatu okerrak."));
    }
}
