import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Produktu bat da hau. Dendako gauza bat.
 * 
 * @author Ikaperez25
 */
public class Produktua {
    private String ean13;
    private String izena;
    private Kategoria kategoriaNagusia;

    private List<Kategoria> bigarrenMailakoKategoria;
    private Map<String, String> atributuak;

    /**
     * Produktu berri bat sortzeko balio du. Kodea, izena eta taldea behar dira.
     */
    public Produktua(String ean13, String izena, Kategoria kategoriaNagusia) {
        this.ean13 = ean13;
        this.izena = izena;
        this.kategoriaNagusia = kategoriaNagusia;
        this.bigarrenMailakoKategoria = new ArrayList<>();
        this.atributuak = new HashMap<>();
    }

    /**
     * Produktuaren kodea lortzeko.
     */
    public String getEan13() {
        return ean13;
    }

    /**
     * Produktuaren izena lortzeko.
     */
    public String getIzena() {
        return izena;
    }

    /**
     * Produktuaren talde nagusia lortzeko.
     */
    public Kategoria getKategoriaNagusia() {
        return kategoriaNagusia;
    }

    /**
     * Produktua testu moduan idazteko. Izena eta kodea erakusten ditu.
     */
    public String toString() {
        return izena + " (" + ean13 + ")";
    }
}
