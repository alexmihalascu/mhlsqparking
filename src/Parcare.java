
import java.util.ArrayList;
import java.util.List;

public class Parcare {
    private int capacitate;
    private List<Bilet> bileteEmise;

    public Parcare(int capacitate) {
        this.capacitate = capacitate;
        bileteEmise = new ArrayList<>();
    }

    public int getCapacitate() {
        return capacitate;
    }

    public int getLocuriDisponibile() {
        return capacitate - bileteEmise.size();
    }

    public List<Bilet> getBileteEmise() {
        return bileteEmise;
    }

    public void adaugaBilet(Bilet bilet) {
        if (getLocuriDisponibile() > 0) {
            bileteEmise.add(bilet);
        } else {
            System.out.println("Parcarea este plina!");
        }
    }
}
