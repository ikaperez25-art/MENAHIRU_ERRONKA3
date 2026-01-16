/**
 * Produktuen talde bat da. Adibidez 'Arropa'.
 * 
 * @author Ikaperez25
 */
public class Kategoria {
    private String izena;
    private Kategoria gurasoa;

    /**
     * Talde berri bat sortzeko.
     */
    public Kategoria(String izena, Kategoria gurasoa) {
        this.izena = izena;
        this.gurasoa = gurasoa;
    }

    /**
     * Izena lortzeko.
     */
    public String getIzena() {
        return izena;
    }

    /**
     * Taldearen izena erakusteko.
     */
    public String toString() {
        return izena;
    }

}
