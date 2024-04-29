
/*This is the Main class of Password generator project
I have created a package named password which contains PasswordUtil class (the backend java code of password generation)
*/
import password.PasswordUtil;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class passwordGenerator extends JFrame implements ActionListener {

    JFrame f;
    JTextField password;
    JPanel panel;
    JLabel title;
    JButton generate;
    Font titlefont = new Font("Ariel", Font.BOLD, 30);
    Font bodyfont = new Font("Ariel", Font.BOLD, 25);
    Border border = new MatteBorder(5, 5, 5, 5, Color.BLUE);
    PasswordUtil passwordUtil = new PasswordUtil();

    passwordGenerator() {
        f = new JFrame("Password Generator");
        f.setLayout(null);
        f.setSize(500, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        title = new JLabel("Password Generator", SwingConstants.CENTER);
        title.setFont(titlefont);
        title.setPreferredSize(new Dimension(300, 50));
        title.setBounds(0, 0, 500, 50);
        title.setOpaque(true);
        title.setForeground(Color.WHITE);
        title.setBackground(Color.BLUE);

        password = new JTextField();
        password.setBounds(50, 150, 400, 50);
        password.setFont(bodyfont);
        password.setBackground(Color.WHITE);
        password.setForeground(Color.BLACK);
        password.setBorder(border);

        generate = new JButton("Generate password");
        generate.setToolTipText("Password of maximum length 10 will be created");
        generate.setFont(bodyfont);
        generate.setBorder(border);
        generate.setBounds(50, 80, 250, 50);
        generate.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(0, 0, 500, 300);
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
        panel.add(title);
        panel.add(generate);
        panel.add(password);

        f.add(panel);
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generate) {
            String generatedPassword = passwordUtil.generatePassword();
            password.setText(generatedPassword);
        }
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        passwordGenerator gui = new passwordGenerator();
    }
}
