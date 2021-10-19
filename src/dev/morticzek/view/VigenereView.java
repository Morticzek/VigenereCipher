package dev.morticzek.view;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * VigenereView is a public class responsible for the interaction with the user.
 *
 * @author Morticzek [https://github.com/Morticzek]
 * @version 2.0
 * @deprecated Removed in version: 3.0, use VigenereGUI instead.
 */

public class VigenereView implements IVigenereShow {
    /**
     * Class constructor printing out the first message of the program.
     *
     */
    public VigenereView()
    {
        System.out.println("Vigenere Cipher\n");
    }

    /**
     * Method used to fetch data from the user through the use of a scanner.
     *
     * @return String table of arguments
     */
    public ArrayList<String> fetchEntryData()
    {
        ArrayList<String> argsTable = new ArrayList<>(3);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Please provide a message to encrypt or decrypt:");
        argsTable.add(scanner.nextLine());
        System.out.println("Please provide a key to encrypt or decrypt:");
        argsTable.add(scanner.nextLine());
        System.out.println("What do you want to do? Choose an option:");
        System.out.println("Encryption - 1");
        System.out.println("Decryption - 2");
        argsTable.add(scanner.nextLine());
        return argsTable;
    }

    /**
     * Method printing out an error message in case of invalid or incomplete command line arguments.
     *
     * @param errorMessage Message regarding an error
     */
    public void commandLineError(String errorMessage)
    {
        IVigenereShow vigenereShowInterface;
        vigenereShowInterface = (error) ->
        {
            System.err.println(error);
        };
        vigenereShowInterface.showMessage(errorMessage);
        System.err.println("Usage: [-w] [<arg> ...] [-k] [<arg> ...] [--e] [--d]\n" +
                "Switching to scanner mode.\n");
    }

    /**
     * Method printing out an error message in case of invalid or incomplete scanner input data.
     *
     * @param errorMessage Message regarding an error
     */
    public void scannerError(String errorMessage)
    {
        IVigenereShow vigenereShowInterface;
        vigenereShowInterface = (error) ->
        {
            System.err.println(error);
        };
        vigenereShowInterface.showMessage(errorMessage);
        System.err.println("Invalid or incomplete data provided to the scanner.\n" +
                "Please retry.\n");
    }

    /**
     * Method printing out acquired data to the user through the standard output stream.
     *
     * @param encrypt Encrypted message
     * @param decrypt Decrypted message
     * @param message Original message
     * @param isEncryptMode Boolean value determining the execution of the encryption process
     * @param isDecryptMode Boolean value determining the execution of the decryption process
     */
    public void showVigenereResults(String encrypt, String decrypt, String message, boolean isEncryptMode, boolean isDecryptMode)
    {
        System.out.println("Original message: " + message);
        if(isEncryptMode)
            System.out.println("Encrypted message: " + encrypt);
        if(isDecryptMode)
            System.out.println("Decrypted message: " + decrypt);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}

/**
 * VigenereShowInterface is an interface providing a method for printing out messages
 */
interface IVigenereShow
{
    /**
     * Method printing out the given message
     * @param message Message to be printed
     */
    void showMessage(String message);
}
