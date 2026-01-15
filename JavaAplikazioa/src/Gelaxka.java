import java.util.HashMap;
import java.util.Map;

public class Gelaxka {
    // Map bat erabiltzen dugu: Gakoa (Produktua) -> Balioa (Kantitatea)
    private Map<Produktua, Integer> inbentarioa;
    private boolean beteta;

    public Gelaxka() {
        this.inbentarioa = new HashMap<>();
        this.beteta = false;
    }

    public void sartuProduktua(Produktua p, int kantitatea) {
        if (beteta) {
            System.out.println("Errorea: Gelaxka beteta dago.");
            return;
        }

        if (inbentarioa.containsKey(p)) {
            int dagoenKantitatea = inbentarioa.get(p);
            inbentarioa.put(p, dagoenKantitatea + kantitatea);
        } else {
            inbentarioa.put(p, kantitatea);
        }
    }

    public void ateraProduktua(Produktua p, int kantitatea) {
        if (!inbentarioa.containsKey(p)) {
            System.out.println("Errorea: Produktua ez dago hemen.");
            return;
        }

        int dagoenKantitatea = inbentarioa.get(p);

        if (kantitatea >= dagoenKantitatea) {
            // Dena edo gehiago atera nahi badugu, produktua ezabatu mapatik
            inbentarioa.remove(p);
        } else {
            // Bestela, kantitatea eguneratu
            inbentarioa.put(p, dagoenKantitatea - kantitatea);
        }
    }

    public Map<Produktua, Integer> getInbentarioa() {
        return inbentarioa;
    }

    public boolean isBeteta() {
        return beteta;
    }

    public void setBeteta(boolean beteta) {
        this.beteta = beteta;
    }

    // Hau "imprimitzeko" metodoa da, System.out.println(gelaxka) egitean
    public String toString() {
        if (inbentarioa.isEmpty()) {
            return "Hutsik";
        }
        // Maparen edukia testu bihurtzen du
        return inbentarioa.toString();
    }
}
