import javax.swing.JFrame;

public class Aplicatie {
    public static void main(String[] args) {
        Parcare parcare = new Parcare(100);
        ManagerDate managerDate = new ManagerDate("bilete.csv");
        parcare.getBileteEmise().addAll(managerDate.incarcaBilete());

        JFrame frame = new JFrame("Aplicatie Parcare");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LoginDialog loginDialog = new LoginDialog(frame);
        loginDialog.setVisible(true);

        if (loginDialog.isLoginSuccess()) {
            InterfataGrafica interfataGrafica = new InterfataGrafica(parcare, managerDate);
            interfataGrafica.show();
        } else {
            System.exit(0);
        }
    }
}