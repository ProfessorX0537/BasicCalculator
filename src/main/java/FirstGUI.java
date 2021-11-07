import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
/*
Xavier Hines
Programming Practicum 305, Section C
GUI intro calculator
Input must be set as num operator num
if not num operator num program crashes fix later
 */

public class FirstGUI {

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);

    }
}

class MainWindow extends JFrame {
    public MainWindow() {
        JFrame mainWindow = new JFrame();
        this.setTitle("Python Calculator");
        //TODO add an icon
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.ORANGE);
        add(mainPanel);

        // Step 2
        JPanel displayPanel = new JPanel();
        displayPanel.setBackground(Color.BLACK);
        mainPanel.add(displayPanel);

        JTextField display = new JTextField(20);
        display.setEditable(false);
        displayPanel.add(display);

        // Step 3
        JButton buttonEquals = new JButton("=");
        JButton buttonC = new JButton("C");

        JButton buttonAdd = new JButton("+");
        JButton buttonSubtract = new JButton("-");
        JButton buttonMultiply = new JButton("*");
        JButton buttonDivided = new JButton("/");

        JButton buttonZero = new JButton("0");
        JButton buttonOne = new JButton("1");
        JButton buttonTwo = new JButton("2");
        JButton buttonThree = new JButton("3");
        JButton buttonFour = new JButton("4");
        JButton buttonFive = new JButton("5");
        JButton buttonSix = new JButton("6");
        JButton buttonSeven = new JButton("7");
        JButton buttonEight = new JButton("8");
        JButton buttonNine = new JButton("9");

        // add a layout manager to panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,4));
//        buttonPanelOperators.setLayout(new GridLayout(1, 4));
        mainPanel.add(buttonPanel);

        // Add button components
        //Row #1
        buttonPanel.add(buttonOne);
        buttonPanel.add(buttonTwo);
        buttonPanel.add(buttonThree);
        buttonPanel.add(buttonAdd);

        //Row #2
        buttonPanel.add(buttonFour);
        buttonPanel.add(buttonFive);
        buttonPanel.add(buttonSix);
        buttonPanel.add(buttonSubtract);


        //Row #3
        buttonPanel.add(buttonSeven);
        buttonPanel.add(buttonEight);
        buttonPanel.add(buttonNine);
        buttonPanel.add(buttonMultiply);

        //Row #4
        buttonPanel.add(buttonC);
        buttonPanel.add(buttonZero);
        buttonPanel.add(buttonEquals);
        buttonPanel.add(buttonDivided);

        // implement action Listeners
        buttonZero.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String prevValue = display.getText();
                    display.setText(prevValue + "0");
                }
            }
        );

        buttonOne.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   String prevValue = display.getText();
                   // allows for continuous input of 1;
                   display.setText(prevValue + "1");
                }
            }
        );

        buttonTwo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  String prevValue = display.getText();
                    display.setText(prevValue + "2");
                }
            }
        );

        buttonThree.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String prevValue = display.getText();
                    display.setText(prevValue + "3");
                }
            }
        );

        buttonFour.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String prevValue = display.getText();
                    display.setText(prevValue + "4");
                }
            }
        );

        buttonFive.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String prevValue = display.getText();
                    display.setText(prevValue + "5");
                }
            }
        );

        buttonSix.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String prevValue = display.getText();
                    display.setText(prevValue + "6");
                }
            }
        );

        buttonSeven.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String prevValue = display.getText();
                    display.setText(prevValue + "7");
                }
            }
        );

        buttonEight.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String prevValue = display.getText();
                    display.setText(prevValue + "8");
                }
            }
        );

        buttonNine.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   String prevValue = display.getText();
                    display.setText(prevValue + "9");
                }
            }
        );

        buttonAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //TODO bug which allows multiple operators
                    String prevValue = display.getText();
                    display.setText(prevValue + " + ");
                }
            }
        );

        buttonSubtract.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String prevValue = display.getText();
                    display.setText(prevValue + " - ");
                }
            }
        );

        buttonMultiply.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String prevValue = display.getText();
                    display.setText(prevValue + " * ");
                }
            }
        );

        buttonDivided.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String prevValue = display.getText();
                    display.setText(prevValue + " / ");
                }
            }
        );

        buttonC.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    display.setText("");
                }
            }
        );

        buttonEquals.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Operations operations = new Operations();
                    String prevValue = display.getText();
                    Object[] s1 = Arrays.stream(prevValue.split(" ")).toArray();
                    //TODO if input isn't (num operator num) then will index out of bounds

                    String op = (String) s1[1];
                    switch (op) {
                        case "+" -> display.setText(prevValue + " = " + operations.Add(Integer.parseInt((String) s1[0], 10), Integer.parseInt((String) s1[2], 10)));
                        case "-" -> display.setText(prevValue + " = " + operations.Subtract(Integer.parseInt((String) s1[0], 10), Integer.parseInt((String) s1[2], 10)));
                        case "*" -> display.setText(prevValue + " = " + operations.Multiply(Integer.parseInt((String) s1[0], 10), Integer.parseInt((String) s1[2], 10)));
                        case "/" -> display.setText(prevValue + " = " + operations.Divide(Integer.parseInt((String) s1[0], 10), Integer.parseInt((String) s1[2], 10)));
                        default -> display.setText("No valid operation entered");
                    }
                }
            }
        );

        //setVisible(true); generally found at end of GUI code
        // however was set true in main
    }
}

class Operations {
    public String Add(int num1, int num2) {
        int solution = num1 + num2;
        return "" + solution;
    }

    public String Subtract(int num1, int num2) {
        int solution = num1 - num2;
        return "" + solution;
    }

    public String Multiply(int num1, int num2) {
        int solution = num1 * num2;
        return "" + solution;
    }

    public String Divide(int num1, int num2) {
        int solution = num1 / num2;
        return "" + solution;
    }
}

