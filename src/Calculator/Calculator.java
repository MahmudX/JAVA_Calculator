package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculator {
    private JPanel mainForm;
    private JFormattedTextField display;
    private JButton a4Button, a5Button, a6Button, subBtn;
    private JButton a7Button, CEButton, modBtn, divBtn, a8Button, a9Button, xButton;
    private JButton addBtn, equalBtn, a3Button;
    private JButton dotBtn, a2Button, a1Button, plusMinSign;
    private JButton zeroBtn, cBtn, openingParenthesis, closingParenthesis;
    private JButton nButton;
    private JButton expButton;
    private JButton xYButton;
    private JButton logButton;
    private JButton lnButton;
    private JButton button4;
    static StringBuilder displayText = new StringBuilder();
    Stack<String> bracketStack = new Stack<String>();

    public Calculator() {
        this.display.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        //  Adds a Decimal Point in the expression
        dotBtn.addActionListener(e -> {
            if (displayText.indexOf(".") == -1) {
                displayText.append(".");
                display.setText(String.valueOf(displayText));
            }
        });

        // Adds plus or minus sign at the end
        plusMinSign.addActionListener(e -> {
            if (displayText.charAt(0) == '-')
                displayText.deleteCharAt(0);
            else
                displayText.insert(0, '-');
            display.setText(String.valueOf(displayText));
        });

        // Delete Button
        CEButton.addActionListener(e -> {
            try {
                displayText.deleteCharAt(displayText.length() - 1);
                display.setText(String.valueOf(displayText));
            } catch (Exception ignored) {
            }

        });

        // Clear Button
        cBtn.addActionListener(e -> {
            displayText.setLength(0);
            display.setText(String.valueOf(displayText));
        });

        // Char assignment
        modBtn.addActionListener(e -> changeDisplay("%"));
        divBtn.addActionListener(e -> changeDisplay("/"));
        xButton.addActionListener(e -> changeDisplay("*"));
        subBtn.addActionListener(e -> changeDisplay("-"));
        addBtn.addActionListener(e -> changeDisplay("+"));
        zeroBtn.addActionListener(e -> changeDisplay("0"));
        a1Button.addActionListener(e -> changeDisplay("1"));
        a2Button.addActionListener(e -> changeDisplay("2"));
        a3Button.addActionListener(e -> changeDisplay("3"));
        a4Button.addActionListener(e -> changeDisplay("4"));
        a5Button.addActionListener(e -> changeDisplay("5"));
        a6Button.addActionListener(e -> changeDisplay("6"));
        a7Button.addActionListener(e -> changeDisplay("7"));
        a8Button.addActionListener(e -> changeDisplay("9"));
        a9Button.addActionListener(e -> changeDisplay("9"));
        openingParenthesis.addActionListener(e -> {
            if (displayText.length() == 0 || displayText.charAt(displayText.length() - 1) != ')') {
                bracketStack.push("(");
                changeDisplay("(");
            }
        });
        closingParenthesis.addActionListener(e -> {
            if (!bracketStack.isEmpty()) {
                bracketStack.pop();
                changeDisplay(")");
            }
        });

        // Keyboard Input Handling
        display.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                char[] legalChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '%', '-', '+', '/', '*', '(', ')'};
                if (!(new String(legalChar).contains(String.valueOf(c))))
                    e.consume();
                displayText = new StringBuilder(display.getText());
            }
        });

        // Result Button
        equalBtn.addActionListener(e -> {
            try {
                if (displayText.charAt(0) != '(')
                    displayText.insert(0, '(');
                if (displayText.charAt(displayText.length() - 1) != ')')
                    displayText.append(")");
                double res = calculator((displayText.toString()).split(""));
                displayText.setLength(0);
                if (res % 1 == 0)
                    displayText.append((int) res);
                else
                    displayText.append(res);
                display.setText(String.valueOf(displayText));
                displayText.setLength(0);
            } catch (Exception ignored) {
            }
        });
    }

    // Display changing function
    private void changeDisplay(String ch) {
        displayText.append(ch);
        display.setText(String.valueOf(displayText));
    }

    // Calculator Engine
    public static double calculator(String[] strArr) {
        Stack<String> operators = new Stack<String>();
        Stack<Double> operands = new Stack<Double>();
        StringBuilder temp = new StringBuilder();
        for (String str : strArr) {
            if (str.trim().equals("")) {
                continue;
            }

            switch (str) {
                case "(":
                    break;
                case ")":
                    if (temp.length() > 0) {
                        operands.push(Double.parseDouble(temp.toString()));
                        temp.setLength(0);
                    }
                    double right = operands.pop();
                    double left = operands.pop();
                    String operator = operators.pop();
                    double value = 0;
                    switch (operator) {
                        case "+":
                            value = left + right;
                            break;
                        case "-":
                            value = left - right;
                            break;
                        case "*":
                            value = left * right;
                            break;
                        case "/":
                            value = left / right;
                            break;
                        case "%":
                            value = left % right;
                            break;
                        default:
                            break;
                    }
                    operands.push(value);
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                    if (temp.length() > 0) {
                        operands.push(Double.parseDouble(temp.toString()));
                        temp.setLength(0);
                    }
                    operators.push(str);
                    break;
                default:
                    temp.append(str);
                    break;
            }
        }

        return operands.pop();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setResizable(false);
        frame.setContentPane(new Calculator().mainForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
