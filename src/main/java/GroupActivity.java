import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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
        setSize(500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel calcPanel = new JPanel();
        calcPanel.setBackground(Color.ORANGE);
        calcPanel.setVisible(false);
        add(calcPanel);

        // Step 2
        JPanel displayPanel = new JPanel();
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
                /** action listener opens another window with text describing how to use calc
                 * examples for each op
                 */
                System.out.println("test"); //prints to console not window
            }
        };
        JMenuItem helpItem = help.add(helpAction);


        var about = new JMenu("About");
        menuBar.add(about);
        var aboutAction = new AbstractAction("About") {
            public void actionPerformed(ActionEvent event) {
                /**
                 * info about author in another window or dialogue box
                 */

                System.out.println("test"); //prints to console not window
            }
        };
        JMenuItem aboutItem = about.add(aboutAction);

        JPanel buttonPanel = new JPanel();
        calcPanel.add(buttonPanel);

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
