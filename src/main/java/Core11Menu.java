import java.awt.event.*;
import javax.swing.*;

/**
 * Code comes form Core Java 11 text book
 * Chapter 11 List 11.6
 */
public class Core11Menu {
    public static void main(String[] args) {
        MenuFrame m = new MenuFrame();
        m.setVisible(true);
    }
}
    /**
     * A frame with a sample menu bar.
     */
     class MenuFrame extends JFrame {
        private static final int DEFAULT_WIDTH = 300;
        private static final int DEFAULT_HEIGHT = 200;
        private final Action saveAction;
        private final Action saveAsAction;
        private final JCheckBoxMenuItem readonlyItem;
        private final JPopupMenu popup;

        /**
         * A sample action that prints the action name to System.out.
         */
        class TestAction extends AbstractAction {
            public TestAction(String name) {
                super(name);
            }

            public void actionPerformed(ActionEvent event) {
                System.out.println(getValue(Action.NAME) + " selected.");
            }
        }

        public MenuFrame() {
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            var fileMenu = new JMenu("File");
            fileMenu.add(new TestAction("New"));

            // demonstrate accelerators
            var openItem = fileMenu.add(new TestAction("Open"));
            openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
            fileMenu.addSeparator();
            saveAction = new TestAction("Save");
            JMenuItem saveItem = fileMenu.add(saveAction);
            saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

            saveAsAction = new TestAction("Save As");
            fileMenu.add(saveAsAction);
            fileMenu.addSeparator();
            fileMenu.add(new AbstractAction("Exit") {
                public void actionPerformed(ActionEvent event) {
                    System.exit(0);
                }
            });

            // demonstrate checkbox and radio button menus
            readonlyItem = new JCheckBoxMenuItem("Read-only");
            readonlyItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    boolean saveOk = !readonlyItem.isSelected();
                    saveAction.setEnabled(saveOk);
                    saveAsAction.setEnabled(saveOk);
                }
            });

            var group = new ButtonGroup();
            var insertItem = new JRadioButtonMenuItem("Insert");
            insertItem.setSelected(true);
            var overtypeItem = new JRadioButtonMenuItem("Overtype");
            group.add(insertItem);
            group.add(overtypeItem);

            // demonstrate icons
            var cutAction = new TestAction("Cut");
            cutAction.putValue(Action.SMALL_ICON, new ImageIcon("cut.gif"));
            var copyAction = new TestAction("Copy");
            copyAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
            var pasteAction = new TestAction("Paste");
            pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("paste.gif"));
            var editMenu = new JMenu("Edit");
            editMenu.add(cutAction);
            editMenu.add(copyAction);
            editMenu.add(pasteAction);

            // demonstrate nested menus
            var optionMenu = new JMenu("Options");
            optionMenu.add(readonlyItem);
            optionMenu.addSeparator();
            optionMenu.add(insertItem);
            optionMenu.add(overtypeItem);
            editMenu.addSeparator();
            editMenu.add(optionMenu);

            // demonstrate mnemonics
            var helpMenu = new JMenu("Help");
            helpMenu.setMnemonic('H');
            var indexItem = new JMenuItem("Index");
            indexItem.setMnemonic('I');
            helpMenu.add(indexItem);

            // you can also add the mnemonic key to an action
            var aboutAction = new TestAction("About");
            aboutAction.putValue(Action.MNEMONIC_KEY, (int) 'A');
            helpMenu.add(aboutAction);

            // add all top-level menus to menu bar
            var menuBar = new JMenuBar();
            setJMenuBar(menuBar);

            menuBar.add(fileMenu);
            menuBar.add(editMenu);
            menuBar.add(helpMenu);

            // demonstrate pop-ups
            popup = new JPopupMenu();
            popup.add(cutAction);
            popup.add(copyAction);
            popup.add(pasteAction);
            var panel = new JPanel();
            panel.setComponentPopupMenu(popup);
            add(panel);
        }
    }

