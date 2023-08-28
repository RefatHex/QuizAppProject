import javax.swing.*;
import java.awt.*;

public class Greetings {
    public Greetings() {
        JFrame frame = new JFrame("Greetings");
        frame.setSize(500, 200);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);



        JLabel text = new JLabel("                    "
                + "Hello Welcome to our quiz app");
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            new QuizPage();
            frame.setVisible(false);
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            new Exit();
            frame.setVisible(false);
        });
        text.setBounds(110, 50, 200, 30);

        startButton.setBounds(130, 100, 70, 35);

        exitButton.setBounds(270, 100, 70, 35);
        mainPanel.add(text);
        mainPanel.add(startButton);
        mainPanel.add(exitButton);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }

}