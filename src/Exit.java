import javax.swing.*;

public class Exit {
    JFrame frame=new JFrame();
    JPanel exitPanel=new JPanel();

    public Exit() {
        ImageIcon imageIcon=new ImageIcon("running.jpg");
        JLabel exitImage=new JLabel(imageIcon);
        frame.setSize(imageIcon.getIconWidth(),imageIcon.getIconHeight()+100);
        JButton tryBtn = new JButton("Try once");
        tryBtn.setBounds((imageIcon.getIconWidth() - 70) / 2, imageIcon.getIconHeight() + 130, 70, 50);
        tryBtn.addActionListener(e-> {
            new QuizPage();
            frame.setVisible(false);
        });
        exitPanel.add(exitImage);exitPanel.add(tryBtn);
        frame.getContentPane().add(exitPanel);
        frame.setVisible(true);
    }

}
