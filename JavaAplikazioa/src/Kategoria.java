public class Kategoria {
    private String izena;
    private Kategoria gurasoa;

    public Kategoria(String izena, Kategoria gurasoa) {
        this.izena = izena;
        this.gurasoa = gurasoa;
    }

    public String getIzena() {
        return izena;
    }

    public String toString() {
        return izena;
    }

}
