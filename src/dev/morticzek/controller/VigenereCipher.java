package dev.morticzek.controller;

import java.util.ArrayList;

/**
 * Program performing encryption and decryption of a provided message
 * using the Vigenere Cipher method.
 *
 * @author Morticzek [https://github.com/Morticzek]
 * @version 3.0
 */
public class VigenereCipher {
    /**
     * Main function of the program.
     *
     * @param args Command line arguments
     */
    public static void main(String... args) {
        ArrayList<String> arguments = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            arguments.add(args[i]);
        }
        VigenereController vigenereController = new VigenereController(arguments);
    }
}
