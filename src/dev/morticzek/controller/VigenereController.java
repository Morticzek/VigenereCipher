package dev.morticzek.controller;

import dev.morticzek.model.InvalidModelException;
import dev.morticzek.model.VigenereModel;
import dev.morticzek.view.VigenereGUI;

import java.util.ArrayList;

/**
 * VigenereController is a public class managing the execution flow of the Vigenere Cipher procedure.
 *
 * @author Morticzek [https://github.com/Morticzek]
 * @version 2.0
 */
public class VigenereController {

    /**
     * Field used to construct an instance of {@link VigenereModel}.
     */
    private final VigenereModel vigModel;

    /**
     * Field used to construct an instance of {@link VigenereGUI}.
     */
    private final VigenereGUI vigGUI;

    /**
     * Instantiates a new VigenereController.
     *
     * @param args Command line arguments
     */
    public VigenereController(ArrayList<String> args) {
        VigenereModel vigModel = new VigenereModel("","",false,false);
        String error;
        this.vigModel = vigModel;
        this.vigGUI = new VigenereGUI();
        initializeActionListeners();
        vigGUI.initWindow();
        try {
            ArrayList<Boolean> cliOperations;
            ArrayList<String> cliArguments = vigModel.fetchCommandLineArguments(args);
            cliOperations = vigModel.checkOperationType(cliArguments);
            vigModel.vigenereMessageValidation(cliArguments.get(0));
            vigModel.vigenereKeywordValidation(cliArguments.get(1));
            vigModel.setEncryptionMode(cliOperations.get(0));
            vigModel.setDecryptionMode(cliOperations.get(1));
            if (isEncryptionMode())
            {
                encryptMessage(getMessage());
                vigGUI.addEncryptionToHistory(getMessage(), getKeyword(), getEncryptedMessage());
            }
            if (isDecryptionMode())
            {
                decryptMessage(getMessage());
                vigGUI.addDecryptionToHistory(getMessage(), getKeyword(), getDecryptedMessage());
            }
        } catch (InvalidModelException invalidModelException) {
            error = invalidModelException.getMessage();
            vigGUI.showErrorDialog(error);
            vigModel.resetModel(vigModel);
        }
    }

    /**
     * Initializes action listeners.
     */
    public void initializeActionListeners()
    {
        vigGUI.getEncryptButton().addActionListener(e -> encryptMessage());
        vigGUI.getDecryptButton().addActionListener(e -> decryptMessage());
        vigGUI.getMenuItemCleanHistory().addActionListener(e -> cleanHistory());
        vigGUI.getMenuItemCleanTextFields().addActionListener(e -> cleanTextFields());
        vigGUI.getMenuItemExit().addActionListener(e -> exitProgram());
    }

    /**
     * Encrypt message.
     */
    public void encryptMessage()
    {
        vigModel.setMessage(vigGUI.getMessageText().getText());
        vigModel.setKeyword(vigGUI.getKeywordText().getText());
        String error;
        try {
            vigModel.vigenereMessageValidation(vigModel.getMessage());
            vigModel.vigenereKeywordValidation(vigModel.getKeyword());
            vigModel.setEncryptionMode(true);
            encryptMessage(getMessage());
            vigGUI.addEncryptionToHistory(getMessage(), getKeyword(), getEncryptedMessage());
            vigModel.resetModel(vigModel);
        } catch (InvalidModelException invalidModelException) {
            error = invalidModelException.getMessage();
            vigGUI.showErrorDialog(error);
            vigModel.resetModel(vigModel);
        }
    }

    /**
     * Decrypt message.
     */
    public void decryptMessage()
    {
        vigModel.setMessage(vigGUI.getMessageText().getText());
        vigModel.setKeyword(vigGUI.getKeywordText().getText());
        String error;
        try {
            vigModel.vigenereMessageValidation(vigModel.getMessage());
            vigModel.vigenereKeywordValidation(vigModel.getKeyword());
            vigModel.setDecryptionMode(true);
            decryptMessage(getMessage());
            vigGUI.addDecryptionToHistory(getMessage(), getKeyword(), getDecryptedMessage());
            vigModel.resetModel(vigModel);
        } catch (InvalidModelException invalidModelException) {
            error = invalidModelException.getMessage();
            vigGUI.showErrorDialog(error);
            vigModel.resetModel(vigModel);
        }
    }

    /**
     * Clean history.
     */
    public void cleanHistory()
    {
        vigGUI.historyCleaner();
    }

    /**
     * Clean text fields.
     */
    public void cleanTextFields()
    {
        vigGUI.textFieldsCleaner();
    }

    /**
     * Exit program.
     */
    public void exitProgram()
    {
        vigGUI.closeButtonMouseClicked();
    }

    /**
     * Get method for invoking getMessage method.
     *
     * @return Original message
     */
    public String getMessage()
    {
        return vigModel.getMessage();
    }

    /**
     * Get method for invoking getEncryptedMessage method.
     *
     * @return Encrypted message
     */
    public String getEncryptedMessage()
    {
        return vigModel.getEncryptedMessage();
    }

    /**
     * Get method for invoking getDecryptedMessage method.
     *
     * @return Decrypted message
     */
    public String getDecryptedMessage()
    {
        return vigModel.getDecryptedMessage();
    }

    /**
     * Get method for invoking getKeyword method.
     *
     * @return Keyword keyword
     */
    public String getKeyword()
    {
        return vigModel.getKeyword();
    }

    /**
     * Get method for invoking isEncryptionMode method.
     *
     * @return Boolean value determining encryption process
     */
    public boolean isEncryptionMode()
    {
        return vigModel.isEncryptionMode();
    }

    /**
     * Get method for invoking isDecryptionMode method.
     *
     * @return Boolean value determining decryption process
     */
    public boolean isDecryptionMode()
    {
        return vigModel.isDecryptionMode();
    }

    /**
     * Method for invoking vigenereEncryption method.
     *
     * @param message Original message
     */
    public void encryptMessage(String message)
    {
        this.vigModel.vigenereEncryption(message, getKeyword());
    }

    /**
     * Method for invoking vigenereDecryption method.
     *
     * @param message Original message
     */
    public void decryptMessage(String message)
    {
        this.vigModel.vigenereDecryption(message, getKeyword());
    }
}
