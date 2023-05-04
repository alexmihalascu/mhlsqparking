// TabelMasiniParcate.java
import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TabelMasiniParcate extends AbstractTableModel {
    private List<Bilet> bilete;
    private final String[] coloane = {"Data si ora emitere", "Numar de inmatriculare", "Durata", "Metoda plata"};

    public TabelMasiniParcate(List<Bilet> bilete) {
        this.bilete = bilete;
    }

    @Override
    public int getRowCount() {
        return bilete.size();
    }

    @Override
    public int getColumnCount() {
        return coloane.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return coloane[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bilet bilet = bilete.get(rowIndex);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String dataEmitereFormatata = bilet.getDataEmitere().format(formatter);

        switch (columnIndex) {
            case 0:
                return dataEmitereFormatata;
            case 1:
                return bilet.getNumarAuto();
            case 2:
                return bilet.getDurata();
            case 3:
                return bilet.getMetodaPlata();
            default:
                return null;
        }
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
}