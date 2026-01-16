/**
 * Apalategi bat da. Gelaxka asko ditu barruan.
 * 
 * @author Ikaperez25
 */
public class Apalategia {
    private int id;
    private Gelaxka[][] matrizea;

    /**
     * Apalategi berria sortzeko. Lerroak eta zutabeak behar dira.
     */
    public Apalategia(int id, int ilarak, int zutabeak) {
        this.id = id;
        this.matrizea = new Gelaxka[ilarak][zutabeak];

        for (int i = 0; i < ilarak; i++) {
            for (int j = 0; j < zutabeak; j++) {
                this.matrizea[i][j] = new Gelaxka();
            }
        }
    }

    /**
     * Gelaxka zehatz bat lortzeko.
     */
    public Gelaxka lortuGelaxka(int ilara, int zutabea) {
        if (ilara >= 0 && ilara < matrizea.length && zutabea >= 0 && zutabea < matrizea[0].length) {
            return matrizea[ilara][zutabea];
        }
        return null; // Si no existe, devolver null.
    }

    public int getId() {
        return id;
    }

    public int getIlarak() {
        return matrizea.length;
    }

    public int getZutabeak() {
        return matrizea[0].length;
    }
}
