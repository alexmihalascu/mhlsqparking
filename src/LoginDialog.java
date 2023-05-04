import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginDialog extends JDialog {
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private boolean loginSuccess = false;
    private JLabel labelError;

    public LoginDialog(JFrame owner) {
        super(owner, "Login", true);
        setLayout(new BorderLayout());

        JPanel panelInput = new JPanel();

        panelInput.setLayout(new GridLayout(2, 2));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInput.add(new JLabel("Username:"));
        textFieldUsername = new JTextField();
        panelInput.add(textFieldUsername);

        panelInput.add(new JLabel("Parola:"));
        passwordField = new JPasswordField();
        panelInput.add(passwordField);

        add(panelInput, BorderLayout.CENTER);

        labelError = new JLabel(" ");
        labelError.setForeground(Color.RED);
        labelError.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelError, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelButtons.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        JButton buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = new String(passwordField.getPassword());

                if (checkCredentials(username, password)) {
                    loginSuccess = true;
                    dispose();
                } else {
                    labelError.setText("Username sau parola incorecte!");
                }
            }
        });
        panelButtons.add(buttonLogin);

        JButton buttonAnulare = new JButton("Anulare");
        buttonAnulare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panelButtons.add(buttonAnulare);

        add(panelButtons, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(owner);
    }

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    private boolean checkCredentials(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("users.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials.length == 2 && credentials[0].equals(username) && credentials[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
