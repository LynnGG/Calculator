import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame implements ActionListener {
    JFrame frame;
    JButton[] buttons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JTextField jTextField;
    JButton addButton, subButton, mulButton, divButton;
    JButton dotButton, relButton, delButton, clrButton;
    JButton[] arrJButton = {
            addButton = new JButton("+"),
            subButton = new JButton("-"),
            mulButton = new JButton("*"),
            dotButton = new JButton("."),
            divButton = new JButton("/"),
            relButton = new JButton("="),
            clrButton = new JButton("AC"),
            delButton = new JButton("<-")};
    JPanel jPanel;
    double num1, num2, rel;
    char checkPoint;
    String text;
    Font font = new Font("Monaco", Font.PLAIN, 25);

    Frame() {
        frame = new JFrame("Cặc");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(380, 550);

        jTextField = new JTextField();
        jTextField.setBounds(30, 20, 320, 50);
        jTextField.setFont(font);

        frame.add(jTextField);
        jPanel = new JPanel();
        jPanel.setBounds(30, 80, 320, 350);
        jPanel.setLayout(new GridLayout(4, 4, 10, 10));

        for (int i = 0; i < arrJButton.length; i++) {
            functionButtons[i] = arrJButton[i];
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }
        int k = 0;
        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].addActionListener(this);
            buttons[i].setFont(font);
            buttons[i].setFocusable(false);
        }
        for (int i = 1; i < 10; i++) {
            jPanel.add(buttons[i]);
            if (i % 3 == 0) {
                jPanel.add(arrJButton[k]);
                k += 1;
            }
        }
        jPanel.add(arrJButton[k]);
        jPanel.add(buttons[0]);

        for (int i = arrJButton.length - 2; i > k; i--) {
            if (i % 3 == 0) {
                jPanel.add(arrJButton[i]);
            }
            jPanel.add(arrJButton[i]);
        }
        frame.add(jPanel);

        arrJButton[6].setBounds(20, 450, 165, 50);
        arrJButton[7].setBounds(195, 450, 155, 50);
        frame.add(arrJButton[6]);
        frame.add(arrJButton[7]);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == buttons[i]) {
                jTextField.setText(jTextField.getText().concat(String.valueOf(i)));
            }
        }
        for (int i = 0; i < arrJButton.length - 3; i++) {
            if (e.getSource() == arrJButton[i] && i != 3) {
                num1 = Double.parseDouble(jTextField.getText());
                jTextField.setText(jTextField.getText().concat("" + arrJButton[i].getText()));
                checkPoint = arrJButton[i].getText().charAt(0);
                jTextField.setText("");
            }
        }
        boolean k = false;
        if (e.getSource() == arrJButton[3]) {
            text = jTextField.getText();
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '.') {
                    k = true;
                }
            }
            if(!k){
                jTextField.setText(jTextField.getText().concat("" + arrJButton[3].getText()));
            }
        }
        if (e.getSource() == arrJButton[5]) {
            num2 = Double.parseDouble(jTextField.getText());
            switch (checkPoint) {
                case '+':
                    rel = num1 + num2;
                    break;
                case '-':
                    rel = num1 - num2;
                    break;
                case '*':
                    rel = num1 * num2;
                    break;
                case '/':
                    rel = num1 / num2;
                    break;
                default:
                    rel = num2;
                    break;
            }
            jTextField.setText(String.valueOf(rel));
            num1 = rel;
        }
        if (e.getSource() == arrJButton[6]) {
            num1 = 0;
            num2 = 0;
            rel = 0;
            jTextField.setText("");
        }
        if(e.getSource() == arrJButton[7])
        {
            text = jTextField.getText();
            jTextField.setText("");
            for (int i = 0; i < text.length()-1; i++) {
                jTextField.setText(jTextField.getText()+text.charAt(i));
            }
        }
    }
}
