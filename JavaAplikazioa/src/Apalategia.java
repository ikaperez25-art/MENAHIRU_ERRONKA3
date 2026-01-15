public class Apalategia {
    private int id;
    // Matrizea (Array bidimentsionala) gelaxkak kudeatzeko
    // Matriz (Array bidimensional) para gestionar las celdas
    // Al segundo [] columnas
    private Gelaxka[][] matrizea;

    public Apalategia(int id, int ilarak, int zutabeak) {
        this.id = id;
        this.matrizea = new Gelaxka[ilarak][zutabeak];

        for (int i = 0; i < ilarak; i++) {
            for (int j = 0; j < zutabeak; j++) {
                this.matrizea[i][j] = new Gelaxka();
            }
        }
    }

    public Gelaxka lortuGelaxka(int ilara, int zutabea) {
        // Control de seguridad: asegurar que no pedimos fuera de los límites.
        // Ej: si tiene 5 filas, no podemos pedir la 8.
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
