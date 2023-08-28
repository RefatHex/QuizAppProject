import javax.swing.*;

public class ThankYou {
    public ThankYou() {
        JFrame frame = new JFrame("Thank You");
        ImageIcon imageIcon = new ImageIcon("thankYou.jpg");
        JLabel label = new JLabel(imageIcon);
        frame.getContentPane().add(label);

        frame.setSize(imageIcon.getIconWidth()+50, imageIcon.getIconHeight()+50);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
