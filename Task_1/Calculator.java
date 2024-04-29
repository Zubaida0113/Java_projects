import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

    JFrame f;
    JTextField text;
    JButton[] numberButtons = new JButton[10];
    JButton[] funcButtons = new JButton[9];
    JButton add, sub, mul, div;
    JButton decimal, equal, delete, clear, negative;
    JPanel panel;

    Font myfont = new Font("Ariel", Font.BOLD, 30);

    double val1 = 0, val2 = 0, result = 0;
    char operator;

    Calculator() {
        f = new JFrame("Calculator_2.0");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(420, 550);
        f.setLayout(null);

        text = new JTextField();
        text.setBounds(0, 0, 420, 100);
        text.setFont(myfont);
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        text.setEditable(false);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        decimal = new JButton(".");
        equal = new JButton("=");
        clear = new JButton("Clr");
        delete = new JButton("Del");
        negative = new JButton("+/-");

        funcButtons[0] = add;
        funcButtons[1] = sub;
        funcButtons[2] = mul;
        funcButtons[3] = div;
        funcButtons[4] = decimal;
        funcButtons[5] = equal;
        funcButtons[6] = clear;
        funcButtons[7] = delete;
        funcButtons[8] = negative;

        for (int i = 0; i < 9; i++) {
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myfont);
            funcButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);

        }
        negative.setBounds(0, 100, 130, 90);
        delete.setBounds(130, 100, 130, 90);
        clear.setBounds(260, 100, 140, 90);

        panel = new JPanel();
        panel.setBounds(0, 190, 400, 320);
        panel.setLayout(new GridLayout(4, 4, 0, 0));
        panel.setBackground(Color.BLACK);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(add);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(sub);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(mul);
        panel.add(decimal);
        panel.add(numberButtons[0]);
        panel.add(div);
        panel.add(equal);

        f.add(panel);
        f.add(negative);
        f.add(clear);
        f.add(delete);
        f.add(text);
        f.setVisible(true);
    }

    public static void main(String[] args) {

        @SuppressWarnings("unused")
        Calculator cal = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimal) {
            text.setText(text.getText().concat("."));
        }
        if (e.getSource() == add) {
            val1 = Double.parseDouble(text.getText());
            operator = '+';
            text.setText("");
        }
        if (e.getSource() == sub) {
            val1 = Double.parseDouble(text.getText());
            operator = '-';
            text.setText("");
        }
        if (e.getSource() == mul) {
            val1 = Double.parseDouble(text.getText());
            operator = '*';
            text.setText("");
        }
        if (e.getSource() == div) {
            val1 = Double.parseDouble(text.getText());
            operator = '/';
            text.setText("");
        }
        if (e.getSource() == equal) {
            val2 = Double.parseDouble(text.getText());

            switch (operator) {

                case '+':
                    result = val1 + val2;
                    break;

                case '-':
                    result = val1 - val2;
                    break;

                case '*':
                    result = val1 * val2;
                    break;

                case '/':
                    result = val1 / val2;
                    break;
            }
            text.setText(String.valueOf(result));
            val1 = result;
        }
        if (e.getSource() == clear) {
            text.setText("");
        }
        if (e.getSource() == delete) {
            String s = text.getText();
            text.setText("");
            for (int i = 0; i < s.length() - 1; i++) {
                text.setText(text.getText() + s.charAt(i));
            }
        }
        if (e.getSource() == negative) {
            Double temp = Double.parseDouble(text.getText());
            temp *= -1;
            text.setText(String.valueOf(temp));

        }

    }

}
