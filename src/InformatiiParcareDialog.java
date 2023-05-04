
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformatiiParcareDialog extends JDialog {
    private Parcare parcare;

    public InformatiiParcareDialog(JFrame owner, Parcare parcare) {
        super(owner, "Informatii Parcare", true);
        this.parcare = parcare;

        initComponents();
        pack();
        setLocationRelativeTo(owner);
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel pentru informatii capacitate parcare si locuri libere
        JPanel panelInformatii = new JPanel(new GridLayout(1, 2));
        JLabel capacitateParcareLabel = new JLabel("Capacitate parcare: " + parcare.getCapacitate());
        JLabel locuriLibereLabel = new JLabel("Locuri libere: " + parcare.getLocuriDisponibile());
        panelInformatii.add(capacitateParcareLabel);
        panelInformatii.add(locuriLibereLabel);
        add(panelInformatii, BorderLayout.NORTH);

        TabelMasiniParcate tabelMasiniParcateModel = new TabelMasiniParcate(parcare.getBileteEmise());
        JTable tabelMasiniParcate = new JTable(tabelMasiniParcateModel);
        JScrollPane scrollPane = new JScrollPane(tabelMasiniParcate);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelButoane = new JPanel();

        // Buton pentru eliminarea unei masini
        JButton butonEliminaMasina = new JButton("Elimina masina");
        butonEliminaMasina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexSelectat = tabelMasiniParcate.getSelectedRow();
                if (indexSelectat >= 0) {
                    parcare.getBileteEmise().remove(indexSelectat);
                    tabelMasiniParcateModel.fireTableDataChanged();
                    locuriLibereLabel.setText("Locuri libere: " + parcare.getLocuriDisponibile());
                } else {
                    JOptionPane.showMessageDialog(InformatiiParcareDialog.this, "Selectati o masina pentru a o elimina.", "Eroare", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panelButoane.add(butonEliminaMasina);

        JButton butonInchidere = new JButton("Inchidere");
        butonInchidere.addActionListener(e -> dispose());
        panelButoane.add(butonInchidere);

        add(panelButoane, BorderLayout.SOUTH);
    }
}