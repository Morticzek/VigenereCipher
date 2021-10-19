package dev.morticzek.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 * VigenereGUI class is a public class responsible for the initialization of the GUI and its components.
 *
 * @author Morticzek [https://github.com/Morticzek]
 * @version 3.0
 */
public class VigenereGUI extends JFrame {

    /**
     * Frame of the window
     */
    private JFrame frame;

    /**
     * Main panel of the window
     */
    private JPanel dialogPane;

    /**
     * Button bar
     */
    private JPanel buttonBar;

    /**
     * "Encryption" button
     */
    private JButton encryptButton;

    /**
     * "Decryption" button
     */

    private JButton decryptButton;

    /**
     * Main JSplitPane
     */
    private JSplitPane mainSplitPane;

    /**
     * Text section JSplitPane
     */
    private JSplitPane textSplitPane;

    /**
     * Message section JPanel
     */
    private JPanel messagePanel;

    /**
     * "Message" label
     */
    private JLabel messageLabel;

    /**
     * Message text field
     */
    private JTextField messageText;

    /**
     * Keyword section JPanel
     */
    private JPanel keywordPanel;

    /**
     * "Keyword" label
     */
    private JLabel keywordLabel;

    /**
     * Keyword text field
     */
    private JTextField keywordText;

    /**
     * History section JPanel
     */
    private JPanel historyPanel;

    /**
     * "History" label
     */
    private JLabel historyLabel;

    /**
     * History section JScrollPane
     */
    private JScrollPane historyScrollPane;


    /**
     * Main menu bar
     */
    private JMenuBar menuBar;

    /**
     * Main menu
     */
    private JMenu menu;

    /**
     * "Clean History" menu item
     */
    private JMenuItem menuItemCleanHistory;

    /**
     * "Clean Text Fields" menu item
     */
    private JMenuItem menuItemCleanTextFields;

    /**
     * "Exit" menu item
     */
    private JMenuItem menuItemExit;

    /**
     * Table model for JTable
     */
    private DefaultTableModel tableModel = new DefaultTableModel();

    /**
     * Table for history
     */
    private JTable table = new JTable(tableModel);

    /**
     * Instantiates a new Vigenere GUI.
     */
    public VigenereGUI() {
        initComponents();
    }

    /**
     * Gets message text.
     *
     * @return the message text
     */
    public JTextField getMessageText() {
        return messageText;
    }

    /**
     * Sets message text.
     *
     * @param messageText the message text
     */
    public void setMessageText(JTextField messageText) {
        this.messageText = messageText;
    }

    /**
     * Gets keyword text.
     *
     * @return the keyword text
     */
    public JTextField getKeywordText() {
        return keywordText;
    }

    /**
     * Gets encrypt button.
     *
     * @return the encrypt button
     */
    public JButton getEncryptButton() {
        return encryptButton;
    }

    /**
     * Gets menu.
     *
     * @return the menu
     */
    public JMenu getMenu() {
        return menu;
    }

    /**
     * Sets menu.
     *
     * @param menu the menu
     */
    public void setMenu(JMenu menu) {
        this.menu = menu;
    }

    /**
     * Gets menu item clean history.
     *
     * @return the menu item clean history
     */
    public JMenuItem getMenuItemCleanHistory() {
        return menuItemCleanHistory;
    }

    /**
     * Gets menu item clean text fields.
     *
     * @return the menu item clean text fields
     */
    public JMenuItem getMenuItemCleanTextFields() {
        return menuItemCleanTextFields;
    }

    /**
     * Gets menu item exit.
     *
     * @return the menu item exit
     */
    public JMenuItem getMenuItemExit() {
        return menuItemExit;
    }


    /**
     * Gets decrypt button.
     *
     * @return the decrypt button
     */
    public JButton getDecryptButton() {
        return decryptButton;
    }

    /**
     * Gets table model.
     *
     * @return the table model
     */
    public DefaultTableModel getTableModel() {return tableModel;}

    /**
     * Initialize window.
     */
    public void initWindow()
    {
        frame = new JFrame("Vigenere Cipher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(dialogPane);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Close button mouse clicked.
     */
    public void closeButtonMouseClicked() {
        System.exit(0);
    }

    /**
     * Show error dialog.
     *
     * @param message the message
     */
    public void showErrorDialog(String message)
    {
        JOptionPane errorDialog = new JOptionPane(message);
        errorDialog.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Add encryption to history.
     *
     * @param message the message
     * @param keyword the keyword
     * @param result  the result
     */
    public void addEncryptionToHistory(String message, String keyword, String result)
    {
        tableModel.addRow(new Object[]{message, keyword, "Encryption", result});
        JOptionPane.showMessageDialog(null, "Encryption Result: " + result, "Encryption Result", JOptionPane.INFORMATION_MESSAGE);
        table.repaint();
    }

    /**
     * Add decryption to history.
     *
     * @param message the message
     * @param keyword the keyword
     * @param result  the result
     */
    public void addDecryptionToHistory(String message, String keyword, String result)
    {
        tableModel.addRow(new Object[]{message, keyword, "Decryption", result});
        JOptionPane.showMessageDialog(null, "Decryption Result: " + result, "Decryption Result", JOptionPane.INFORMATION_MESSAGE);
        table.repaint();
    }

    /**
     * Clean history table.
     */
    public void historyCleaner()
    {
        tableModel.setRowCount(0);
    }

    /**
     * Clean text fields.
     */
    public void textFieldsCleaner()
    {
        messageText.setText(null);
        keywordText.setText(null);
    }

    /**
     * Initialize components.
     */
    private void initComponents() {
        dialogPane = new JPanel();
        buttonBar = new JPanel();
        encryptButton = new JButton();
        decryptButton = new JButton();
        mainSplitPane = new JSplitPane();
        textSplitPane = new JSplitPane();
        messagePanel = new JPanel();
        messageLabel = new JLabel();
        messageText = new JTextField();
        keywordPanel = new JPanel();
        keywordLabel = new JLabel();
        keywordText = new JTextField();
        historyPanel = new JPanel();
        historyLabel = new JLabel();
        historyScrollPane = new JScrollPane();
        menuBar = new JMenuBar();
        menu = new JMenu();
        menuItemCleanHistory = new JMenuItem();
        menuItemCleanTextFields = new JMenuItem();
        menuItemExit = new JMenuItem();

        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
        dialogPane.setLayout(new BorderLayout());

        buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
        buttonBar.setLayout(new GridBagLayout());
        ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
        ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

        encryptButton.setText("Encrypt");
        buttonBar.add(encryptButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        decryptButton.setText("Decrypt");
        buttonBar.add(decryptButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

        mainSplitPane.setResizeWeight(0.7);

        textSplitPane.setResizeWeight(0.5);
        textSplitPane.setDividerSize(5);
        textSplitPane.setMinimumSize(new Dimension(300, 150));
        textSplitPane.setPreferredSize(new Dimension(300, 150));
        textSplitPane.setMaximumSize(new Dimension(300, 150));

        messagePanel.setMaximumSize(new Dimension(150, 140));
        messagePanel.setPreferredSize(new Dimension(190, 140));
        messagePanel.setMinimumSize(new Dimension(150, 140));
        messagePanel.setLayout(new GridBagLayout());
        ((GridBagLayout)messagePanel.getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)messagePanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
        ((GridBagLayout)messagePanel.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
        ((GridBagLayout)messagePanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        messageLabel.setText("Message");
        messageLabel.setPreferredSize(new Dimension(140, 30));
        messageLabel.setMinimumSize(new Dimension(140, 30));
        messageLabel.setMaximumSize(new Dimension(140, 30));
        messagePanel.add(messageLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        messageText.setMaximumSize(new Dimension(140, 70));
        messageText.setPreferredSize(new Dimension(140, 70));
        messageText.setMinimumSize(new Dimension(140, 70));
        messagePanel.add(messageText, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        textSplitPane.setLeftComponent(messagePanel);

        keywordPanel.setMinimumSize(new Dimension(150, 140));
        keywordPanel.setPreferredSize(new Dimension(190, 140));
        keywordPanel.setMaximumSize(new Dimension(150, 140));
        keywordPanel.setLayout(new GridBagLayout());
        ((GridBagLayout)keywordPanel.getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)keywordPanel.getLayout()).rowHeights = new int[] {0, 0, 0};
        ((GridBagLayout)keywordPanel.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
        ((GridBagLayout)keywordPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

        keywordLabel.setText("Keyword");
        keywordLabel.setMaximumSize(new Dimension(140, 30));
        keywordLabel.setPreferredSize(new Dimension(140, 30));
        keywordLabel.setMinimumSize(new Dimension(140, 30));
        keywordPanel.add(keywordLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        keywordText.setPreferredSize(new Dimension(140, 70));
        keywordText.setMaximumSize(new Dimension(140, 70));
        keywordText.setMinimumSize(new Dimension(140, 70));
        keywordPanel.add(keywordText, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        textSplitPane.setRightComponent(keywordPanel);

        mainSplitPane.setLeftComponent(textSplitPane);

        tableModel.addColumn("Message");
        tableModel.addColumn("Keyword");
        tableModel.addColumn("Operation");
        tableModel.addColumn("Result");

        historyPanel.setLayout(new GridBagLayout());
        ((GridBagLayout)historyPanel.getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)historyPanel.getLayout()).rowHeights = new int[] {0, 0, 0};
        ((GridBagLayout)historyPanel.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
        ((GridBagLayout)historyPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

        historyLabel.setText("History");
        historyLabel.setPreferredSize(new Dimension(190, 30));
        historyLabel.setMinimumSize(new Dimension(190, 30));
        historyLabel.setMaximumSize(new Dimension(190, 30));
        historyPanel.add(historyLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        historyScrollPane.setPreferredSize(new Dimension(250, 100));
        historyScrollPane.setMinimumSize(new Dimension(250, 100));
        historyScrollPane.setMaximumSize(new Dimension(250, 100));
        historyScrollPane.setViewportView(table);

        historyPanel.add(historyScrollPane, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        mainSplitPane.setRightComponent(historyPanel);

        dialogPane.add(mainSplitPane, BorderLayout.CENTER);

        menuBar.setPreferredSize(new Dimension(59, 30));

        menu.setText("Program");

        menuItemCleanHistory.setText("Clean History");
        menu.add(menuItemCleanHistory);

        menuItemCleanTextFields.setText("Clean Text Fields");
        menu.add(menuItemCleanTextFields);

        menuItemExit.setText("Exit");
        menu.add(menuItemExit);

        menuBar.add(menu);

        dialogPane.add(menuBar, BorderLayout.NORTH);

        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
    }
}
