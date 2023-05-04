import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bilet {
    private LocalDateTime dataEmitere;
    private String numarAuto;
    private int durata;
    private String metodaPlata;
    private String detaliiPlata;

    public Bilet(LocalDateTime dataEmitere, String numarAuto, int durata, String metodaPlata) {
        this.dataEmitere = dataEmitere;
        this.numarAuto = numarAuto;
        this.durata = durata;
        this.metodaPlata = metodaPlata;
    }

    public LocalDateTime getDataEmitere() {
        return dataEmitere;
    }

    public void setDataEmitere(LocalDateTime dataEmitere) {
        this.dataEmitere = dataEmitere;
    }

    public String getNumarAuto() {
        return numarAuto;
    }

    public void setNumarAuto(String numarAuto) {
        this.numarAuto = numarAuto;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getMetodaPlata() {
        return metodaPlata;
    }

    public void setMetodaPlata(String metodaPlata) {
        this.metodaPlata = metodaPlata;
    }

    public String getDetaliiPlata() {
        return detaliiPlata;
    }

    public void setDetaliiPlata(String detaliiPlata) {
        this.detaliiPlata = detaliiPlata;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dataEmitereFormatata = this.dataEmitere.format(formatter);
        return "DATA: " + dataEmitereFormatata + ", NUMAR: " + this.numarAuto + ", DURATA: " + this.durata + " ORE, METODA PLATA: " + this.metodaPlata;
    }
}
