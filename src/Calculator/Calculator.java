package Calculator;
import com.sun.source.tree.WhileLoopTree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculator {
    private JPanel mainform;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton subbtn;
    private JButton a7Button;
    private JButton CEButton;
    private JButton modbtn;
    private JButton divbtn;
    private JButton a8Button;
    private JButton a9Button;
    private JButton xButton;
    private JFormattedTextField display;
    private JButton addbtn;
    private JButton equalbtn;
    private JButton a3Button;
    private JButton dotbtn;
    private JButton a2Button;
    private JButton a1Button;
    private JButton plusminsign;
    private JButton zerobtn;
    private JButton cbtn;
    static StringBuilder displayText = new StringBuilder();

    public Calculator() {
        this.display.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        dotbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displayText.indexOf(".") == -1) {
                    displayText.append(".");
                    display.setText(String.valueOf(displayText));
                }
            }
        });
        plusminsign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displayText.charAt(0) == '-') {
                    displayText.deleteCharAt(0);
                } else {
                    displayText.insert(0, '-');
                }
                display.setText(String.valueOf(displayText));
            }
        });
        modbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displayText.indexOf("%") == -1 && displayText.indexOf("+") == -1 &&
                        displayText.indexOf("-") == -1 && displayText.indexOf("x") == -1 &&
                        displayText.indexOf("*") == -1 && displayText.indexOf("/") == -1) {
                    displayText.append("%");
                    display.setText(String.valueOf(displayText));
                }
            }
        });
        divbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displayText.indexOf("%") == -1 && displayText.indexOf("+") == -1 &&
                        displayText.indexOf("-") == -1 && displayText.indexOf("x") == -1 &&
                        displayText.indexOf("*") == -1 && displayText.indexOf("/") == -1) {
                    displayText.append("/");
                    display.setText(String.valueOf(displayText));
                }
            }
        });
        xButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displayText.indexOf("%") == -1 && displayText.indexOf("+") == -1 &&
                        displayText.indexOf("-") == -1 && displayText.indexOf("x") == -1 &&
                        displayText.indexOf("*") == -1 && displayText.indexOf("/") == -1) {
                    displayText.append("x");
                    display.setText(String.valueOf(displayText));
                }
            }
        });
        subbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displayText.indexOf("%") == -1 && displayText.indexOf("+") == -1 &&
                        displayText.indexOf("-") == -1 && displayText.indexOf("x") == -1 &&
                        displayText.indexOf("*") == -1 && displayText.indexOf("/") == -1) {
                    displayText.append("-");
                    display.setText(String.valueOf(displayText));
                }
            }
        });
        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displayText.indexOf("%") == -1 && displayText.indexOf("+") == -1 &&
                        displayText.indexOf("-") == -1 && displayText.indexOf("x") == -1 &&
                        displayText.indexOf("*") == -1 && displayText.indexOf("/") == -1) {
                    displayText.append("+");
                    display.setText(String.valueOf(displayText));
                }
            }
        });
        CEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    displayText.deleteCharAt(displayText.length() - 1);
                    display.setText(String.valueOf(displayText));
                } catch (Exception exception) {
                }

            }
        });
        cbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayText.setLength(0);
                display.setText(String.valueOf(displayText));
            }
        });
        zerobtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayText.append("0");
                display.setText(String.valueOf(displayText));
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayText.append("1");
                display.setText(String.valueOf(displayText));
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayText.append("2");
                display.setText(String.valueOf(displayText));
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayText.append("3");
                display.setText(String.valueOf(displayText));
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayText.append("4");
                display.setText(String.valueOf(displayText));
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayText.append("5");
                display.setText(String.valueOf(displayText));
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayText.append("6");
                display.setText(String.valueOf(displayText));
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayText.append("7");
                display.setText(String.valueOf(displayText));
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayText.append("8");
                display.setText(String.valueOf(displayText));
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayText.append("9");
                display.setText(String.valueOf(displayText));
            }
        });
        display.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || c == '+' || c == '-' || c == 'x' || c == '*' || c == '/' || c == '%')) {
                    e.consume();
                }
                displayText = new StringBuilder(display.getText());
            }
        });
        equalbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String DivMulPattern = "/([0-9]*\\.?[0-9]*)([\\*/])([0-9]*\\.?[0-9]*)/";
                    String AddSubPattern = "/([0-9]*\\.?[0-9]*)([\\+\\-])([0-9]*\\.?[0-9]*)/";

                    Double t;
                    String[] s;
                    /*
                    try{
                        Pattern r = Pattern.compile(DivMulPattern);
                        Matcher m = r.matcher(display.getText());
                        if (m.group(2) == "*" || m.group(2) == "x") {
                            s = displayText.toString().split("\\*");
                            t = Double.parseDouble(s[0]) * Double.parseDouble(s[1]);
                        }
                        else {
                            s = displayText.toString().split("/");
                            t = Double.parseDouble(s[0]) / Double.parseDouble(s[1]);
                        }
                    }
                    catch (Exception exception){display.setText(exception.getMessage());}
                    try{
                        Pattern r = Pattern.compile(AddSubPattern);
                        Matcher m = r.matcher(display.getText());
                        if (m.group(2) == "+") {
                            s = displayText.toString().split("\\*");
                            t = Double.parseDouble(s[0]) + Double.parseDouble(s[1]);
                        }
                        else
                        {
                            s = displayText.toString().split("-");
                            t = Double.parseDouble(s[0]) - Double.parseDouble(s[1]);
                        }
                    }
                    catch (Exception exception){display.setText(exception.getMessage());}
                    */

                    if (displayText.indexOf("+") != -1) {
                        s = displayText.toString().split("\\+");
                        t = Double.parseDouble(s[0]) + Double.parseDouble(s[1]);
                    } else if (displayText.indexOf("-") != -1) {
                        s = displayText.toString().split("-");
                        t = Double.parseDouble(s[0]) - Double.parseDouble(s[1]);
                    } else if (displayText.indexOf("/") != -1) {
                        s = displayText.toString().split("/");
                        t = Double.parseDouble(s[0]) / Double.parseDouble(s[1]);
                    } else if (displayText.indexOf("%") != -1) {
                        s = displayText.toString().split("%");
                        t = Double.parseDouble(s[0]) % Double.parseDouble(s[1]);

                    } else if (displayText.indexOf("x") != -1) {
                        s = displayText.toString().split("x");
                        t = Double.parseDouble(s[0]) * Double.parseDouble(s[1]);

                    } else if (displayText.indexOf("*") != -1) {
                        s = displayText.toString().split("\\*");
                        t = Double.parseDouble(s[0]) * Double.parseDouble(s[1]);

                    } else {
                        t = Double.parseDouble(display.getText());
                    }

                    if (t % 1 == 0) {
                        displayText = new StringBuilder(String.valueOf(t.intValue()));
                    } else
                        displayText = new StringBuilder(String.valueOf(t));
                    display.setText(String.valueOf(displayText));
                } catch (Exception exception) {
                    display.setText(exception.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setResizable(false);
        frame.setContentPane(new Calculator().mainform);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
   } 
}
