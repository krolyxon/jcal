import java.util.Vector;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.*;

public class GFrame extends JFrame {
    Parser p;
    JTextField tf;

    private JButton newButton(String text, int d1, int d2, int d3, int d4) {
        JButton b = new JButton();
        // b.setBackground(Color.decode("#F78361"));
        b.setBackground(Color.decode("#2B2B2B"));
        b.setForeground(Color.decode("#e5e5e5"));
        b.setFont((new Font("Times New Roman", Font.PLAIN, 20)));
        b.setBounds(d1, d2, d3, d4);
        b.setText(text);
        return b;
    }

    private void actionAdderForTextField(JButton b, String val) {
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText(tf.getText() + val);
            }
        });

    }

    GFrame(String title) {
        History history = new History();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);
        this.getContentPane().setBackground(Color.decode("#111111"));
        this.setResizable(false);

        // Text Field
        tf = new JTextField();
        tf.setBackground(Color.decode("#2B2B2B"));
        tf.setForeground(Color.decode("#e5e5e5"));
        tf.setMargin(new Insets(0, 10, 0, 10));
        tf.setBounds(40, 50, 310, 40);
        tf.setFont((new Font("Times New Roman", Font.PLAIN, 20)));

        // History Text Field
        JTextField tHist = new JTextField();
        tHist.setBounds(100, 10, 310, 40);
        tHist.setEditable(false);

        // Buttons
        JButton bEval = newButton("=", 250, 100, 100, 40);
        JButton bClear = newButton("CL", 180, 100, 60, 40);
        JButton bAdd = newButton("+", 250, 300, 100, 40);
        JButton bSub = newButton("-", 250, 250, 100, 40);
        JButton bMul = newButton("X", 250, 200, 100, 40);
        JButton bDiv = newButton("%", 250, 150, 100, 40);
        JButton bCut = newButton("<x", 180, 300, 60, 40);
        JButton bRightPar = newButton(")", 110, 100, 60, 40);
        JButton bLeftPar = newButton("(", 40, 100, 60, 40);
        JButton bDoubleZero = newButton("00", 40, 300, 60, 40);
        JButton bZero = newButton("0", 110, 300, 60, 40);
        JButton bOne = newButton("1", 40, 250, 60, 40);
        JButton bTwo = newButton("2", 110, 250, 60, 40);
        JButton bThree = newButton("3", 180, 250, 60, 40);
        JButton bFour = newButton("4", 40, 200, 60, 40);
        JButton bFive = newButton("5", 110, 200, 60, 40);
        JButton bSix = newButton("6", 180, 200, 60, 40);
        JButton bSeven = newButton("7", 40, 150, 60, 40);
        JButton bEight = newButton("8", 110, 150, 60, 40);
        JButton bNine = newButton("9", 180, 150, 60, 40);

        // Add the buttons to the Frame
        this.add(bEval);
        this.add(bClear);
        this.add(bAdd);
        this.add(bSub);
        this.add(bMul);
        this.add(bDiv);
        this.add(bCut);
        this.add(bRightPar);
        this.add(bLeftPar);
        this.add(bDoubleZero);
        this.add(bZero);
        this.add(bOne);
        this.add(bTwo);
        this.add(bThree);
        this.add(bFour);
        this.add(bFive);
        this.add(bSix);
        this.add(bSeven);
        this.add(bEight);
        this.add(bNine);
        this.add(tf);
        // this.add(tHist);
        this.setSize(400, 400);
        this.setLayout(null);
        this.setVisible(true);

        JLabel label = new JLabel("Enter Expression: ");
        label.setFont((new Font("Times New Roman", Font.PLAIN, 20)));
        label.setBounds(40, 20, 150, 40);
        label.setForeground(Color.decode("#e5e5e5"));
        this.add(label);

        // ActionsListeners
        bEval.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tf.getText().length() != 0) {
                    p = new Parser(tf.getText());
                    tf.setText(Double.toString(p.eval()));

                    // Save to history
                    history.addHistory(tf.getText());

                    tHist.setText("");
                    Vector<String> s = history.getHistory();
                    for (int i = 0; i < s.size(); i++) {
                        System.out.println(s.get(i));
                        tHist.setText(new String(s.get(i).concat(tHist.getText())).concat("\n"));
                    }

                } else {
                    tf.setText("No input");
                }
            }
        });

        // Common actions that just appends the symbols to the text field
        actionAdderForTextField(bAdd, "+");
        actionAdderForTextField(bSub, "-");
        actionAdderForTextField(bMul, "*");
        actionAdderForTextField(bDiv, "/");
        actionAdderForTextField(bRightPar, ")");
        actionAdderForTextField(bLeftPar, "(");
        actionAdderForTextField(bDoubleZero, "00");
        actionAdderForTextField(bZero, "0");
        actionAdderForTextField(bOne, "1");
        actionAdderForTextField(bTwo, "2");
        actionAdderForTextField(bThree, "3");
        actionAdderForTextField(bFour, "4");
        actionAdderForTextField(bFive, "5");
        actionAdderForTextField(bSix, "6");
        actionAdderForTextField(bSeven, "7");
        actionAdderForTextField(bEight, "8");
        actionAdderForTextField(bNine, "9");

        bClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText("");
            }
        });

        bCut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tf.getText();
                tf.setText(text.substring(0, text.length() - 1));
            }
        });

        // bOne.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // tf.setText(tf.getText() + "1");
        // }
        // });
    }
}
