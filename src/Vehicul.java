public class Vehicul {
    private String numarInmatriculare;
    private String tipVehicul;

    public Vehicul(String numarInmatriculare, String tipVehicul) {
        this.numarInmatriculare = numarInmatriculare;
        this.tipVehicul = tipVehicul;
    }

    public String getNumarInmatriculare() {
        return numarInmatriculare;
    }

    public String getTipVehicul() {
        return tipVehicul;
    }
}