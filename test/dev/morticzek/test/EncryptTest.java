package dev.morticzek.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import dev.morticzek.model.InvalidModelException;
import dev.morticzek.model.VigenereModel;

/**
 * Test checking encryption process
 *
 * @author Morticzek [https://github.com/Morticzek]
 * @version 1.0
 */

public class EncryptTest {
    /**
     * Instance of VigenereModel used in testing
     */
    private VigenereModel vigenereModel;
    /**
     * Setup function used to initialize data ready for testing
     */
    @BeforeEach
    public void startup(){vigenereModel = new VigenereModel("","KEY",true,false);}
    /**
     * Unit test function used to check a valid word encryption
     */
    @Test
    public void testEncryptWord()
    {
        try {
            String message = "Word";
            vigenereModel.vigenereMessageValidation(message);
            vigenereModel.vigenereEncryption(vigenereModel.getMessage(), vigenereModel.getKeyword());
            Assertions.assertEquals("Gspn",vigenereModel.getEncryptedMessage(), "Successful encryption");
        } catch (InvalidModelException invalidModelException)
        {
            Assertions.fail("Encryption of a valid word with a valid key fails");
        }
    }
    /**
     * Unit test function used to check an invalid word encryption
     */
    @Test
    public void testEncryptInvalidWord()
    {
        Boolean testStatus = false;
        try {
            String message = "234";
            vigenereModel.vigenereMessageValidation(message);
            vigenereModel.vigenereEncryption(vigenereModel.getMessage(),vigenereModel.getKeyword());
            Assertions.fail("The function vigenereMessageValidation should've thrown an exception due to an invalid model component");
        } catch (InvalidModelException invalidModelException) {
            testStatus = true;
            Assertions.assertEquals(true, testStatus, "Expected result - exception has been thrown");
        }
    }
    /**
     * Unit test function used to check an empty word encryption
     */
    @Test
    public void testEncryptEmptyWord()
    {
        Boolean testStatus = false;
        try {
            String message = "";
            vigenereModel.vigenereMessageValidation(message);
            vigenereModel.vigenereEncryption(vigenereModel.getMessage(),vigenereModel.getKeyword());
            Assertions.fail("The function vigenereMessageValidation should've thrown an exception due to an invalid model component");
        } catch (InvalidModelException invalidModelException) {
            testStatus = true;
            Assertions.assertEquals(true, testStatus, "Expected result - exception has been thrown");
        }
    }
    /**
     * Unit test function used to check a non-latin symbols word encryption
     */
    @Test
    public void testEncryptNonLatinSymbolsWord()
    {
        Boolean testStatus = false;
        try {
            String message = "Żółć";
            vigenereModel.vigenereMessageValidation(message);
            vigenereModel.vigenereEncryption(vigenereModel.getMessage(),vigenereModel.getKeyword());
            Assertions.fail("vigenereMessageValidation didn't remove all (or any) of the symbols and performed encryption");
        } catch (InvalidModelException invalidModelException) {
            testStatus = true;
            Assertions.assertEquals(true, testStatus, "Expected result - exception has been thrown");
        }
    }
}
