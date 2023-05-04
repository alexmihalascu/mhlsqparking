import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PlataDialog extends JDialog {
    private JComboBox<String> comboBoxPlata;
    private JTextField textFieldNumarAuto;
    private JSpinner textFieldDurata;
    private boolean cancelled = true;
    private JLabel labelTotalPlata;
    private JTextField textFieldNumarCard;
    private JTextField textFieldDataExpirare;
    private JTextField textFieldCVV;
    private JPanel cardInfoPanel;

    public PlataDialog(JFrame owner, JTextField textFieldNumarAuto, JSpinner textFieldDurata) {
        super(owner, "Plata", true);
        this.textFieldNumarAuto = textFieldNumarAuto;
        this.textFieldDurata = textFieldDurata;

        setLayout(new GridLayout(6, 2));

        add(new JLabel("Metoda de plata:"));
        comboBoxPlata = new JComboBox<>(new String[]{"SMS", "Card"});
        comboBoxPlata.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getItem().equals("Card")) {
                        cardInfoPanel.setVisible(true);
                    } else {
                        cardInfoPanel.setVisible(false);
                    }
                    pack();
                }
            }
        });
        add(comboBoxPlata);

        add(new JLabel("Total plata:"));
        int durata = ((Number) textFieldDurata.getValue()).intValue();
        int totalPlata = durata * 3;
        labelTotalPlata = new JLabel(totalPlata + " RON");
        add(labelTotalPlata);

        cardInfoPanel = new JPanel(new GridLayout(3, 2));
        cardInfoPanel.add(new JLabel("Număr card:"));
        textFieldNumarCard = new JTextField(16);
        cardInfoPanel.add(textFieldNumarCard);

        cardInfoPanel.add(new JLabel("Data expirare:"));
        textFieldDataExpirare = new JTextField(5);
        cardInfoPanel.add(textFieldDataExpirare);

        cardInfoPanel.add(new JLabel("CVV:"));
        textFieldCVV = new JTextField(3);
        cardInfoPanel.add(textFieldCVV);

        add(cardInfoPanel);
        cardInfoPanel.setVisible(false);

        JButton buttonConfirma = new JButton("Confirma");
        buttonConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxPlata.getSelectedItem().equals("Card") && !isCardValid()) {
                    JOptionPane.showMessageDialog(PlataDialog.this,
                            "Informațiile despre card sunt invalide. Verificați și încercați din nou.",
                            "Eroare",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    cancelled = false;
                    dispose();
                }
            }
        });
        add(buttonConfirma);

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

    private boolean isCardValid() {
        String cardNumber = textFieldNumarCard.getText();
        String expirationDate = textFieldDataExpirare.getText();
        String cvv = textFieldCVV.getText();

        return cardNumber.matches("^\\d{16}$") &&
                expirationDate.matches("^\\d{2}/\\d{2}$") &&
                cvv.matches("^\\d{3}$");
    }

    public String getMetodaPlata() {
        return (String) comboBoxPlata.getSelectedItem();
    }

    public String getSmsMessage() {
        if (getMetodaPlata().equals("SMS")) {
            String numarAuto = textFieldNumarAuto.getText();
            int durata = ((Number) textFieldDurata.getValue()).intValue();
            return "Pentru sms dati sms la nr 9999 cu textul " + numarAuto + " - " + durata + " ore.";
        }
        return "";
    }

    public boolean isCancelled() {
        return cancelled;
    }
}