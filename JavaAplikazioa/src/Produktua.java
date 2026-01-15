import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Produktua {
    private String ean13;
    private String izena;
    private Kategoria kategoriaNagusia;

    private List<Kategoria> bigarrenMailakoKategoria;
    private Map<String, String> atributuak;

    public Produktua(String ean13, String izena, Kategoria kategoriaNagusia) {
        this.ean13 = ean13;
        this.izena = izena;
        this.kategoriaNagusia = kategoriaNagusia;
        this.bigarrenMailakoKategoria = new ArrayList<>();
        this.atributuak = new HashMap<>();
    }

    public String getEan13() {
        return ean13;
    }

    public String getIzena() {
        return izena;
    }

    public Kategoria getKategoriaNagusia() {
        return kategoriaNagusia;
    }

    // toString metodoa objektua testu bezala ikusteko balio du
    public String toString() {
        return izena + " (" + ean13 + ")";
    }
}
