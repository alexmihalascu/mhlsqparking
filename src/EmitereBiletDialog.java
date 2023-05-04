import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class EmitereBiletDialog extends JDialog {
    private JTextField textFieldNumarAuto;
    private JSpinner textFieldDurata;
    private Parcare parcare;
    private ManagerDate managerDate;

    public EmitereBiletDialog(JFrame owner, Parcare parcare, ManagerDate managerDate) {
        super(owner, "Emitere Bilet", true);
        this.parcare = parcare;
        this.managerDate = managerDate;

        setLayout(new GridLayout(3, 2));

        add(new JLabel("Numar Auto:"));
        textFieldNumarAuto = new JTextField();
        add(textFieldNumarAuto);

        add(new JLabel("Durata (ore):"));
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 24, 1);
        textFieldDurata = new JSpinner(model);
        add(textFieldDurata);

        JButton buttonEmitere = new JButton("Emitere Bilet");
        buttonEmitere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adaugaBilet();
            }
        });
        add(buttonEmitere);

        JButton buttonAnulare = new JButton("Anulare");
        buttonAnulare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(buttonAnulare);

        pack();
        setLocationRelativeTo(owner);
    }

    private void adaugaBilet() {
        String numarAuto = textFieldNumarAuto.getText();
        LocalDateTime dataEmitere = LocalDateTime.now();
        int durata = ((Number) textFieldDurata.getValue()).intValue();

        PlataDialog plataDialog = new PlataDialog((JFrame) getOwner(), textFieldNumarAuto, textFieldDurata);
        plataDialog.setVisible(true);

        if (!plataDialog.isCancelled()) {
            String metodaPlata = plataDialog.getMetodaPlata();
            Bilet bilet = new Bilet(dataEmitere, numarAuto, durata, metodaPlata);
            parcare.adaugaBilet(bilet);
            managerDate.salveazaBilet(bilet);

            if (plataDialog.getMetodaPlata().equals("SMS")) {
                String smsMessage = plataDialog.getSmsMessage();
                JOptionPane.showMessageDialog(this, smsMessage, "Plata prin SMS", JOptionPane.INFORMATION_MESSAGE);
            }

            JOptionPane.showMessageDialog(this, "Bilet emis cu succes!", "Succes", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }
}

//textFieldNumarAuto: un obiect de tip JTextField, utilizat pentru introducerea numărului de înmatriculare al mașinii;
//        textFieldDurata: un obiect de tip JSpinner, utilizat pentru introducerea duratei de parcare în ore;
//        parcare: un obiect de tip Parcare, utilizat pentru a adăuga biletul emis;
//        managerDate: un obiect de tip ManagerDate, utilizat pentru a salva biletul emis în fișier;
//        buttonEmitere: un obiect de tip JButton, utilizat pentru a emite biletul;
//        buttonAnulare: un obiect de tip JButton, utilizat pentru a anula procesul de emitere a biletului;
//        plataDialog: un obiect de tip PlataDialog, utilizat pentru a afișa dialogul de plată;
//        bilet: un obiect de tip Bilet, utilizat pentru a crea biletul cu informațiile introduse de utilizator.