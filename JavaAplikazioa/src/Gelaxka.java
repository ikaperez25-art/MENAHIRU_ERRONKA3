import java.util.HashMap;
import java.util.Map;

/**
 * Apalategiko kaxa bat da. Hemen gordetzen dira produktuak.
 * 
 * @author Ikaperez25
 */
public class Gelaxka {
    private Map<Produktua, Integer> inbentarioa;
    private boolean beteta;

    /**
     * Kaxa huts bat sortzen du.
     */
    public Gelaxka() {
        this.inbentarioa = new HashMap<>();
        this.beteta = false;
    }

    /**
     * Gauzak kaxan sartzeko.
     */
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

    /**
     * Gauzak kaxatik ateratzeko.
     */
    public void ateraProduktua(Produktua p, int kantitatea) {
        if (!inbentarioa.containsKey(p)) {
            System.out.println("Errorea: Produktua ez dago hemen.");
            return;
        }

        int dagoenKantitatea = inbentarioa.get(p);

        if (kantitatea >= dagoenKantitatea) {
            inbentarioa.remove(p);
        } else {
            inbentarioa.put(p, dagoenKantitatea - kantitatea);
        }
    }

    /**
     * Zer dagoen ikusteko.
     */
    public Map<Produktua, Integer> getInbentarioa() {
        return inbentarioa;
    }

    /**
     * Beteta dagoen jakiteko.
     */
    public boolean isBeteta() {
        return beteta;
    }

    /**
     * Beteta dagoen ala ez aldatzeko.
     */
    public void setBeteta(boolean beteta) {
        this.beteta = beteta;
    }

    /**
     * Kaxaren edukia testu bezala erakusteko.
     */
    public String toString() {
        if (inbentarioa.isEmpty()) {
            return "Hutsik";
        }

        return inbentarioa.toString();
    }
}
