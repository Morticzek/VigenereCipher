package dev.morticzek.model;

import java.util.ArrayList;

/**
 * VigenereModel is a public class containing the logic and components of the Vigenere Cipher model.
 *
 * @author Morticzek [https://github.com/Morticzek]
 * @version 3.0
 */

public class VigenereModel {
    /**
     * String used to store the original message utilized in encryption/decryption.
     */
    private String message;
    /**
     * String used to store the keyword utilized in encryption/decryption.
     */
    private String keyword;
    /**
     * String used to store the result of message encryption.
     */
    private String encryptedMessage;
    /**
     * String used to store the result of message decryption.
     */
    private String decryptedMessage;
    /**
     * Boolean determining encryption process execution.
     */
    private boolean encryptionMode;
    /**
     * Boolean determining decryption process execution.
     */
    private boolean decryptionMode;

    /**
     * Class constructor with 4 parameters.
     *
     * @param message Message to be encrypted/decrypted.
     * @param keyword Keyword to be used for encryption/decryption.
     * @param encryptionMode Boolean value determining whether encryption should be performed or not.
     * @param decryptionMode Boolean value determining whether decryption should be performed or not.
     */
    public VigenereModel(String message, String keyword, boolean encryptionMode, boolean decryptionMode)
    {
        this.message = message;
        this.keyword = keyword;
        this.encryptionMode = encryptionMode;
        this.decryptionMode = decryptionMode;
    }

    /**
     * Get method for the message parameter.
     *
     * @return Original message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get method for the keyword parameter.
     *
     * @return Encryption/decryption keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * Get method for the encryptedMessage parameter.
     *
     * @return Message after the encryption process
     */
    public String getEncryptedMessage() {
        return encryptedMessage;
    }

    /**
     * Get method for the decryptedMessage parameter.
     *
     * @return Message after the decryption process
     */
    public String getDecryptedMessage() {
        return decryptedMessage;
    }

    /**
     * Get method for the encryptionMode parameter.
     *
     * @return Boolean value determining encryption process
     */
    public boolean isEncryptionMode() {
        return encryptionMode;
    }

    /**
     * Get method for the decryptionMode parameter.
     *
     * @return Boolean value determining decryption process
     */
    public boolean isDecryptionMode() {
        return decryptionMode;
    }

    /**
     * Set method for the message parameter.
     *
     * @param message Original message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Set method for the keyword parameter.
     *
     * @param keyword Encryption/decryption keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Set method for the encryptedMessage parameter.
     *
     * @param encryptedMessage Message after the encryption process
     */
    public void setEncryptedMessage(String encryptedMessage) {
        this.encryptedMessage = encryptedMessage;
    }

    /**
     * Set method for the decryptedMessage parameter.
     *
     * @param decryptedMessage Message after the decryption process
     */
    public void setDecryptedMessage(String decryptedMessage) {
        this.decryptedMessage = decryptedMessage;
    }

    /**
     * Set method for the encryptionMode parameter.
     *
     * @param encryptionMode Boolean value determining encryption process
     */
    public void setEncryptionMode(boolean encryptionMode) {
        this.encryptionMode = encryptionMode;
    }

    /**
     * Set method for the decryptionMode parameter.
     *
     * @param decryptionMode Boolean value determining decryption process
     */
    public void setDecryptionMode(boolean decryptionMode) {
        this.decryptionMode = decryptionMode;
    }

    /**
     * Method responsible for validating a received message and setting it in the model.
     *
     * @param message Original message
     * @throws InvalidModelException When throughout the process of validation no valid character was left
     */
    public void vigenereMessageValidation(String message) throws InvalidModelException {
        String temp = message;
        this.message = "";
        for(char i : temp.toCharArray())
        {
            if((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z'))
            {
                this.message += i;
            }
            else if(i == ' ')
                this.message += ' ';
        }
        if (this.message.isEmpty())
            throw new InvalidModelException("Invalid message.");
        else setMessage(this.message);
    }

    /**
     * Method responsible for validating a received keyword and setting it in the model.
     *
     * @param keyword Keyword used for encryption/decryption
     * @throws InvalidModelException When throughout the process of validation no valid character was left
     */
    public void vigenereKeywordValidation(String keyword) throws InvalidModelException {
        String temp = keyword;
        this.keyword = "";
        for(char i : temp.toCharArray())
        {
            if(i >= 'A' && i <= 'Z')
            {
                this.keyword += i;
            }
            else if(i >= 'a' && i <= 'z')
            {
                this.keyword += (char)(i - 32);
            }
        }
        if(this.keyword.isEmpty())
            throw new InvalidModelException("Invalid keyword.");
        setKeyword(this.keyword);
    }

    /**
     * Method performing the encryption process and setting the result in the model.
     *
     * @param message Original message
     * @param keyword Keyword used for encryption
     */
    public void vigenereEncryption(String message, String keyword)
    {
        String output = "";
        for(int i = 0, j = 0; i < message.length(); i++)
        {
            char symbol = message.charAt(i);
            if(symbol >= 'A' && symbol <= 'Z') {
                output += (char) ((symbol + keyword.charAt(j) - 130) % 26 + 65);
                j = (j + 1) % keyword.length();
            }
            else if(symbol >= 'a' && symbol <= 'z') {
                output += (char) ((symbol + keyword.charAt(j) - 162) % 26 + 97);
                j = (j + 1) % keyword.length();
            }
            else if(symbol == ' ')
                output += (char)(32);
        }
        setEncryptedMessage(output);
    }

    /**
     * Method performing the decryption process and setting the result in the model.
     *
     * @param message Original message
     * @param keyword Keyword used for decryption
     */
    public void vigenereDecryption(String message, String keyword)
    {
        String output = "";
        for(int i = 0, j = 0; i < message.length(); i++)
        {
            char symbol = message.charAt(i);
            if(symbol >= 'A' && symbol <= 'Z') {
                output += (char) ((symbol - keyword.charAt(j) + 26) % 26 + 65);
                j = (j + 1) % keyword.length();
            }
            else if(symbol >= 'a' && symbol <= 'z') {
                output += (char) ((symbol - keyword.charAt(j) - 6) % 26 + 97);
                j = (j + 1) % keyword.length();
            }
            else if(symbol == ' ')
                output += (char)(32);
        }
        setDecryptedMessage(output);
    }

    /**
     * Method collecting arguments from the command line and combining them into a model.
     *
     * @param args Command line arguments
     * @return VigenereModel object containing parameters
     * @throws InvalidModelException When any of the parameters required for the construction of the model is missing
     */
    public ArrayList<String> fetchCommandLineArguments (ArrayList<String> args) throws InvalidModelException {
        ArrayList<String> arguments = new ArrayList<>(3);
        for(int i = 0; i < 3; i++){arguments.add("");}
        for(int i = 0; i < args.size(); i++)
        {
            String opt = args.get(i);
            switch(opt) {
                case "-w":
                    String word = "";
                    for(int j = i+1; j < args.size(); j++)
                    {
                        if(args.get(j).charAt(0) != '-') {
                            word = word + args.get(j) + " ";
                            i = j;
                        }
                        else break;
                    }
                    arguments.set(0, word);
                    break;
                case "-k":
                    String key = "";
                    for(int j = i+1; j < args.size(); j++)
                    {
                        if(args.get(j).charAt(0) != '-') {
                            key = key + args.get(j);
                            i = j;
                        }
                        else break;
                    }
                    arguments.set(1, key);
                    break;
                case "--e":
                    arguments.set(2, "1");
                    break;
                case "--d":
                    arguments.set(2, "2");
                    break;
            }
        }
        if(arguments.contains(""))
        {
            throw new InvalidModelException("Invalid or incomplete data from the command line.");
        }
        else return arguments;
    }

    /**
     * Method marking the type of operation to be performed (encryption or decryption).
     *
     * @param args Program arguments
     * @return Two-element boolean table containing information about the process to execute
     * @throws InvalidModelException When an invalid option has been provided, resulting in both values being false
     */
    public ArrayList<Boolean> checkOperationType(ArrayList<String> args) throws InvalidModelException
    {
        ArrayList<Boolean> ops = new ArrayList<>(2);
        ops.add(0, false);
        ops.add(1, false);
        if(args.get(2).charAt(0) == '1'){
            ops.set(0, true);
        }
        else if(args.get(2).charAt(0) == '2') {
            ops.set(1, true);
        }
        else throw new InvalidModelException("Invalid option.");
        return ops;
    }

    /**
     * Method resetting parameters present in a model instance.
     *
     * @param vigenereModel Model object
     */
    public void resetModel(VigenereModel vigenereModel)
    {
        vigenereModel.message = "";
        vigenereModel.keyword = "";
        vigenereModel.encryptedMessage = "";
        vigenereModel.decryptedMessage = "";
        vigenereModel.encryptionMode = false;
        vigenereModel.decryptionMode = false;
    }
}
