import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

public class GFrame extends JFrame {
    Parser p;

    GFrame(String title) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);
        this.getContentPane().setBackground(Color.decode("#4E586e"));
        JButton b = new JButton();
        b.setBounds(130, 100, 100, 40);
        b.setBackground(Color.decode("#F78361"));
        b.setText("Evaluate");

        JTextField tf = new JTextField();
        tf.setBounds(130, 50, 220, 40);

        JButton bClear = new JButton();
        bClear.setBounds(250, 100, 100, 40);
        bClear.setBackground(Color.decode("#F78361"));
        bClear.setText("Clear");

        this.add(b);
        this.add(bClear);
        this.add(tf);
        this.setSize(400, 500);
        this.setLayout(null);
        this.setVisible(true);

        JLabel label = new JLabel("Enter Expression: ");
        label.setBounds(130, 20, 150, 40);
        this.add(label);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tf.getText().length() != 0) {
                    p = new Parser(tf.getText());
                    tf.setText(Double.toString(p.eval()));
                } else {
                    tf.setText("No input");
                }
            }
        });

        bClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText("");
            }
        });
    }
}
