import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingGame extends JFrame implements ActionListener {
    JFrame f;
    JTextField text;
    JTextArea result;
    JPanel panel;
    JLabel title, info;
    JButton enter;
    int VAL = 1 + (int) (100 * Math.random());
    int remainingGuesses = 5;

    Font myfont = new Font("Ariel", Font.BOLD, 30);
    Font resfont = new Font("Ariel", Font.ITALIC, 25);
    Color darkGreen = new Color(0, 100, 0);
    Border border = new MatteBorder(5, 5, 5, 5, darkGreen);

    GuessingGame() {
        f = new JFrame("Number Guessing Game");
        f.setLayout(null);
        f.setSize(600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        title = new JLabel("Number Guessing Game", SwingConstants.CENTER);
        title.setFont(myfont);
        title.setPreferredSize(new Dimension(300, 50));
        title.setBounds(0, 0, 600, 50);
        title.setOpaque(true);
        title.setBackground(Color.orange);

        info = new JLabel("Instruction: Enter a number between 1 to 100");
        info.setFont(resfont);
        info.setBounds(50, 65, 520, 30);
        info.setForeground(Color.black);

        text = new JTextField();
        text.setBounds(50, 120, 250, 70);
        text.setFont(myfont);
        text.setBackground(Color.WHITE);
        text.setForeground(Color.BLACK);
        text.setBorder(border);

        enter = new JButton("ENTER");
        enter.setFont(myfont);
        enter.setBounds(320, 120, 150, 70);
        enter.addActionListener(this);

        result = new JTextArea();
        result.setBounds(50, 220, 500, 110);
        result.setFont(resfont);
        result.setBackground(Color.WHITE);
        result.setEditable(false); // Disable editing
        result.setLineWrap(true); // Enable automatic wrapping of text
        result.setWrapStyleWord(true); // Wrap at word boundaries
        result.setBorder(border);

        panel = new JPanel();
        panel.setBounds(0, 0, 600, 400);
        panel.setLayout(null);
        panel.setBackground(Color.GREEN);
        panel.add(enter);
        panel.add(title);
        panel.add(result);
        panel.add(info);

        f.getContentPane().add(panel);
        f.add(text);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        GuessingGame g = new GuessingGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int guess;
        try {
            guess = Integer.parseInt(text.getText());
        } catch (NumberFormatException ex) {
            result.setText("Invalid input. Please enter a number.");
            return;
        }

        if (guess == VAL) {
            result.setText("Congratulations! You guessed the right number.");
            disableInput(); // Disable input after correct guess
        } else if (guess < VAL) {
            result.setText("Bummer! Wrong answer. Try again.\nHint: The number is greater than " + guess);
        } else {
            result.setText("Bummer! Wrong answer. Try again.\nHint: The number is less than " + guess);
        }

        remainingGuesses--;
        if (remainingGuesses <= 0) {
            result.setText("You have exhausted your chances.\nThe number was " + VAL + ".\nBetter Luck Next Time!");
            disableInput(); // Disable input after all chances are used
        }
    }

    private void disableInput() {
        text.setEditable(false);
        enter.setEnabled(false);
    }

}
