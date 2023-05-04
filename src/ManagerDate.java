import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ManagerDate {
    private String numeFisier;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public ManagerDate(String numeFisier) {
        this.numeFisier = numeFisier;
    }

    public List<Bilet> incarcaBilete() {
        List<Bilet> bilete = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(numeFisier))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                String[] elemente = linie.split(";\\s+"); // Schimbă delimitatorul în "; "
                LocalDateTime dataEmitere = LocalDateTime.parse(elemente[0].substring(6), formatter); // Extragere Data
                String numarAuto = elemente[1].substring(7); // Extragere Numar
                int durata = Integer.parseInt(elemente[2].substring(11)); // Extragere Numar ore
                String metodaPlata = elemente[3].substring(13); // Extragere Tip de plata

                Bilet bilet = new Bilet(dataEmitere, numarAuto, durata, metodaPlata);
                bilete.add(bilet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bilete;
    }

    public void salveazaBilet(Bilet bilet) {
        try (FileWriter fileWriter = new FileWriter(numeFisier, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            printWriter.println(String.format("Data: %s; Numar: %s; Numar ore: %d; Tip de plata: %s",
                    formatter.format(bilet.getDataEmitere()),
                    bilet.getNumarAuto(),
                    bilet.getDurata(),
                    bilet.getMetodaPlata()));

        } catch (IOException e) {
            System.out.println("Nu s-a putut salva biletul in fisier.");
        }
    }
}
