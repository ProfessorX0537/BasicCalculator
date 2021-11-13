import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GroupActivity {
    public static void main(String[] args) {
        MainWindow2 mainWindow = new MainWindow2();
        mainWindow.setVisible(true);

    }
}
class MainWindow2 extends JFrame {

    public MainWindow2() {
        JFrame mainWindow = new JFrame();
        this.setTitle("Python Calculator");
        //TODO add an icon
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel calcPanel = new JPanel();
        calcPanel.setBackground(Color.ORANGE);
        calcPanel.setVisible(false);
        add(calcPanel);

        // Step 2
        JPanel displayPanel = new JPanel();
        calcPanel.add(displayPanel, BorderLayout.NORTH);
        displayPanel.setBackground(Color.BLACK);
        calcPanel.add(displayPanel);

        JTextField display1 = new JTextField(5);
        displayPanel.add(display1);

        var opCombo = new JComboBox<String>();
        opCombo.addItem("+");
        opCombo.addItem("-");
        opCombo.addItem("*");
        opCombo.addItem("/");
        displayPanel.add(opCombo);


        JTextField display2 = new JTextField(5);
        displayPanel.add(display2);

        JTextField answerField = new JTextField(10);
        displayPanel.add(answerField);

        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var calculator = new JMenu("Calculator");
        menuBar.add(calculator);

        // creates extra window with calc on it
        var startAction = new AbstractAction("Start") {
            public void actionPerformed(ActionEvent event) {
                calcPanel.setVisible(true);
            }
        };
        JMenuItem startItem = calculator.add(startAction);

        // will exit the whole program
        var exitAction = new AbstractAction("Exit") {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        };
        JMenuItem exitItem = calculator.add(exitAction);

        var help = new JMenu("Help");
        menuBar.add(help);

        var helpAction = new AbstractAction("Help") {
            public void actionPerformed(ActionEvent event) {
                 HelpWindow help = new HelpWindow();
                 help.setVisible(true);
            }
        };
        JMenuItem helpItem = help.add(helpAction);


        var about = new JMenu("About");
        menuBar.add(about);

        var aboutAction = new AbstractAction("About") {
            public void actionPerformed(ActionEvent event) {
                var aboutText = new TextArea();
                aboutText.setText("Author: Xavier Hines\nInfo: Junior in computer science major\n" +
                        "Date: 11/13/21\nProgram: This is a simple calculator that performs basic math" +
                        "\noperations with normal integers.");
                aboutText.setEditable(false);
                aboutText.setSize(350, 100);

                calcPanel.add(aboutText);
                aboutText.setVisible(true);
            }
        };
        JMenuItem aboutItem = about.add(aboutAction);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        displayPanel.add(buttonPanel);

        JButton buttonEquals = new JButton("=");
        buttonPanel.add(buttonEquals);

        buttonEquals.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Operations operations = new Operations();
               String prevValue1 = display1.getText();
               String prevValue2 = display2.getText();
               String op = opCombo.getItemAt(opCombo.getSelectedIndex());
               System.out.println(op);

               switch (op) {
                   case "+" -> answerField.setText(operations.Add(Integer.parseInt(prevValue1, 10), Integer.parseInt(prevValue2, 10)));
                   case "-" -> answerField.setText(operations.Subtract(Integer.parseInt(prevValue1, 10), Integer.parseInt(prevValue2, 10)));
                   case "*" -> answerField.setText(operations.Multiply(Integer.parseInt(prevValue1, 10), Integer.parseInt(prevValue2, 10)));
                   case "/" -> answerField.setText(operations.Divide(Integer.parseInt(prevValue1, 10), Integer.parseInt(prevValue2, 10)));
                   default -> answerField.setText("No valid operation entered");
               }
           }
        }
        );

        JButton buttonClear = new JButton("C");
        buttonPanel.add(buttonClear);

        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display1.setText("");
                display2.setText("");
                answerField.setText("");
            }
        });
    }
}

class Operations2 {
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

class HelpWindow extends JFrame {
    public HelpWindow() {
        JFrame help = new JFrame();
        help.setTitle("Calculator Operation Help");
        setSize(250,200);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JPanel helpPanel = new JPanel();
        helpPanel.setBackground(Color.ORANGE);
        add(helpPanel);
        JTextArea textBox = new JTextArea();
        textBox.setBackground(Color.ORANGE);
        textBox.setEditable(false);
        helpPanel.add(textBox);

        textBox.setText("Operation Examples: \n\"+\" will perform simple addition" +
                "\n\tExample: 5 + 5 = 10" +
                "\n\"-\" will perform simple subtraction" +
                "\n\tExample: 100 - 25 = 75" +
                "\n\"*\" will perform simple Multiplication" +
                "\n\tExample: 100 * 10 = 1000" +
                "\n\"/\" will perform simple division" +
                "\n\tExample: 81 / 9 = 9");
        textBox.setVisible(true);
        helpPanel.setVisible(true);
    }


}
