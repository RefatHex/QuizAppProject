import javax.swing.*;

import java.io.*;
import java.util.HashMap;

public class LoginApp extends JFrame {
    private HashMap<String, String> loginData;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginApp() {
        loginData = new HashMap<>();
        this.loadLoginData();

        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Signup");


        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (loginData.containsKey(username) && loginData.get(username).equals(password)) {
                new Greetings();
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials.");
            }
        });


        signupButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (loginData.containsKey(username)) {
                JOptionPane.showMessageDialog(this, "Username already exists. Please choose a different username.");
            } else {
                loginData.put(username, password);
                JOptionPane.showMessageDialog(this, "Signup Successful!,Now Login");
                saveLoginData();
            }
        });

        int labelX = 50;
        int fieldX = 150;
        int y = 50;
        int width = 120;
        int height = 25;

        usernameLabel.setBounds(labelX, y, 80, height);
        usernameField.setBounds(fieldX, y, width, height);
        passwordLabel.setBounds(labelX, y + height + 10, 80, height);
        passwordField.setBounds(fieldX, y + height + 10, width, height);
        loginButton.setBounds(labelX, y + 2 * (height + 10), width, height);
        signupButton.setBounds(fieldX, y + 2 * (height + 10), width, height);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(signupButton);

        setLayout(null);
        setVisible(true);
    }

    public void saveLoginData() {
        try (FileWriter writer = new FileWriter("logindata.txt")) {
            for (String username : loginData.keySet()) {
                writer.write(username + ":" + loginData.get(username) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadLoginData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("logindata.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String username = parts[0];
                    String password = parts[1];
                    loginData.put(username, password);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
