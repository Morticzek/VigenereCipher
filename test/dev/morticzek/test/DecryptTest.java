package dev.morticzek.test;
import dev.morticzek.model.InvalidModelException;
import dev.morticzek.model.VigenereModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test checking decryption process
 *
 * @author Morticzek [https://github.com/Morticzek]
 * @version 1.0
 */

public class DecryptTest {
    /**
     * Instance of VigenereModel used in testing
     */
    private VigenereModel vigenereModel;

    /**
     * Setup function used to initialize data ready for testing
     */
    @BeforeEach
    public void setup(){vigenereModel = new VigenereModel("","KEY",false,true);}
    /**
     * Unit test function used to check a valid word decryption
     */
    @Test
    public void testDecryptWord() {
        try {
            String message = "Word";
            vigenereModel.vigenereMessageValidation(message);
            vigenereModel.vigenereDecryption(vigenereModel.getMessage(), vigenereModel.getKeyword());
            Assertions.assertEquals("Mktt", vigenereModel.getDecryptedMessage(), "Successful decryption");
        } catch (InvalidModelException invalidModelException) {
            Assertions.fail("Decryption of a valid word with a valid key fails");
        }
    }
    /**
     * Unit test function used to check an invalid word decryption
     */
    @Test
    public void testDecryptInvalidWord() {
        Boolean testStatus = false;
        try {
            String message = "234";
            vigenereModel.vigenereMessageValidation(message);
            vigenereModel.vigenereDecryption(vigenereModel.getMessage(), vigenereModel.getKeyword());
            Assertions.fail("The function vigenereMessageValidation should've thrown an exception due to an invalid model component");
        } catch (InvalidModelException invalidModelException)
        {
            testStatus = true;
            Assertions.assertEquals(true, testStatus, "Expected result - exception has been thrown");
        }
    }
    /**
     * Unit test function used to check an empty word decryption
     */
    @Test
    public void testDecryptEmptyWord() {
        Boolean testStatus = false;
        try {
            String message = "";
            vigenereModel.vigenereMessageValidation(message);
            vigenereModel.vigenereDecryption(vigenereModel.getMessage(), vigenereModel.getKeyword());
            Assertions.fail("The function vigenereMessageValidation should've thrown an exception due to an invalid model component");
        } catch (InvalidModelException invalidModelException)
        {
            testStatus = true;
            Assertions.assertEquals(true, testStatus, "Expected result - exception has been thrown");
        }
    }
    /**
     * Unit test function used to check a non-latin symbols word decryption
     */
    @Test
    public void testDecryptNonLatinSymbolsWord() {
        Boolean testStatus = false;
        try {
            String message = "Żółć";
            vigenereModel.vigenereMessageValidation(message);
            vigenereModel.vigenereDecryption(vigenereModel.getMessage(),vigenereModel.getKeyword());
            Assertions.fail("vigenereMessageValidation didn't remove all (or any) of the symbols and performed decryption");
        } catch (InvalidModelException invalidModelException) {
            testStatus = true;
            Assertions.assertEquals(true, testStatus, "Expected result - exception has been thrown");
        }
    }
}
