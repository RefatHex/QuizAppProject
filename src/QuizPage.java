import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class QuizPage {
    private JFrame frame;
    private JPanel qusPanel;
    private JLabel qus;
    private JCheckBox option1;
    private JCheckBox option2;
    private JCheckBox option3;
    private int correctCount;
    private int falseCount;

    public QuizPage() {
        frame = new JFrame();
        qusPanel = new JPanel();
        correctCount = 0;
        falseCount = 0;
        qus1();
    }

    public void qus1() {
        createQuestionPanel();
        createButtons();
        addQuestion("1) How are you?");
        addOptions("Fine", "Tired", "Been doing great");
        addButtons(e -> qus2(), e -> qus1());
        frame.add(qusPanel);
        frame.setVisible(true);
    }

    private void qus2() {
        createQuestionPanel();
        createButtons();
        addQuestion("2) Are you ok to give up?");
        addOptions("No", "What can I do", "I don't care");
        addButtons(e -> qus3(), e -> qus1());
        frame.add(qusPanel);
        frame.setVisible(true);
    }

    private void qus3() {
        createQuestionPanel();
        createButtons();
        addQuestion("3) Are you going to repeat the mistake?");
        addOptions("Yes", "What can I do", "No");
        addButtons(e -> {
            new resultPage(correctCount,falseCount);
            frame.setVisible(false);
        }, e -> qus2());
        frame.add(qusPanel);
        frame.setVisible(true);
    }


    private void createQuestionPanel() {
        frame.setSize(500, 250);
        frame.getContentPane().removeAll();
        qusPanel.removeAll();
        qusPanel.setLayout(new BorderLayout());
        qusPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void createButtons() {
        JPanel buttonPanel = new JPanel();
        JButton nextButton = new JButton("Next");
        JButton prevButton = new JButton("Prev");
        buttonPanel.add(nextButton);
        buttonPanel.add(prevButton);
        qusPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addQuestion(String question) {
        qus = new JLabel(question);
        qusPanel.add(qus, BorderLayout.NORTH);
    }

    private void addOptions(String option1Text, String option2Text, String option3Text) {
        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new GridLayout(3, 1));
        option1 = new JCheckBox(option1Text);
        option2 = new JCheckBox(option2Text);
        option3 = new JCheckBox(option3Text);
        optionPanel.add(option1);
        optionPanel.add(option2);
        optionPanel.add(option3);
        qusPanel.add(optionPanel, BorderLayout.CENTER);
    }

    private void addButtons(ActionListener nextButtonAction, ActionListener prevButtonAction) {
        JPanel buttonPanel = new JPanel();
        JButton nextButton = new JButton("Next");
        JButton prevButton = new JButton("Prev");
        nextButton.addActionListener(e -> {
            if (qus.getText().equals("1) How are you?")) {
                if (option1.isSelected() && !option2.isSelected() && !option3.isSelected()) {
                    correctCount++;
                } else {
                    falseCount++;
                }
            } else if (qus.getText().equals("2) Are you ok to give up?")) {
                if (!option1.isSelected() && option2.isSelected() && !option3.isSelected()) {
                    correctCount++;
                } else {
                    falseCount++;
                }
            } else if (qus.getText().equals("3) Are you going to repeat the mistake?")) {
                if (!option1.isSelected() && !option2.isSelected() && option3.isSelected()) {
                    correctCount++;
                } else {
                    falseCount++;
                }
            }

            nextButtonAction.actionPerformed(e);

        });

        prevButton.addActionListener(prevButtonAction);
        buttonPanel.add(nextButton);
        buttonPanel.add(prevButton);
        qusPanel.add(buttonPanel, BorderLayout.SOUTH);
        nextButton.addActionListener(nextButtonAction);
    }

}