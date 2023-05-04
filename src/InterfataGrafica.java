import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class InterfataGrafica {
    private JFrame frame;
    private Parcare parcare;
    private ManagerDate managerDate;

    public InterfataGrafica(Parcare parcare, ManagerDate managerDate) {
        this.parcare = parcare;
        this.managerDate = managerDate;
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame("mhlsqParking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JPanel panelTitlu = new JPanel();
        JLabel titlu = new JLabel("mhlsqParking");
        panelTitlu.add(titlu);
        frame.add(panelTitlu, BorderLayout.NORTH);

        JPanel panelButoane = new JPanel();
        panelButoane.setLayout(new GridLayout(3, 1));

        JButton butonEmitereBilet = new JButton("Emitere Bilet");
        butonEmitereBilet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmitereBiletDialog emitereBiletDialog = new EmitereBiletDialog(frame, parcare, managerDate);
                emitereBiletDialog.setVisible(true);
            }
        });
        panelButoane.add(butonEmitereBilet);

        JButton butonInformatii = new JButton("Administrare Parcare");
        butonInformatii.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InformatiiParcareDialog informatiiParcareDialog = new InformatiiParcareDialog(frame, parcare);
                informatiiParcareDialog.setVisible(true);
            }
        });
        panelButoane.add(butonInformatii);

        JButton butonIesire = new JButton("Iesire");
        butonIesire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panelButoane.add(butonIesire);

        frame.add(panelButoane, BorderLayout.CENTER);
    }

    public void show() {
        frame.setVisible(true);
    }
}





