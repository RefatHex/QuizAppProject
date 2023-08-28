import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class resultPage {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    ImageIcon imageIcon;
    Image image;
    String imageLocation;

    public resultPage(int correctCount, int falseCount) {
        int expectedCorrectAns = 2;
        if ( expectedCorrectAns>correctCount) {
            imageLocation = "tooBad.jpg";
        } else {
            imageLocation = "goodJob.jpg";
        }

        try {
            image = ImageIO.read(new File(imageLocation));
            imageIcon = new ImageIcon(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel imageLabel = new JLabel(imageIcon);
        frame.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight() + 300);
        panel.setLayout(null);

        JLabel text = new JLabel("Thanks for taking our quiz");
        JLabel correctResult = new JLabel("Correct answer: " + correctCount);
        JLabel falseResult = new JLabel("False answer: " + falseCount);
        JButton finishBtn = new JButton("Finish");

        int labelHeight = imageIcon.getIconHeight();
        int labelWidth = imageIcon.getIconWidth();
        int setY = labelHeight + 10;

        imageLabel.setBounds(0, 0, labelWidth, labelHeight);
        text.setBounds((labelWidth - 200) / 2, setY, 200, 30);
        correctResult.setBounds((labelWidth - 200) / 2, setY + 40, 200, 30);
        falseResult.setBounds((labelWidth - 200) / 2, setY + 70, 200, 30);
        finishBtn.setBounds((labelWidth - 70) / 2, setY + 130, 70, 35);

        finishBtn.addActionListener(e -> {
            frame.setVisible(false);
            new ThankYou();
        });

        panel.add(imageLabel);
        panel.add(text);
        panel.add(correctResult);
        panel.add(falseResult);
        panel.add(finishBtn);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

}
