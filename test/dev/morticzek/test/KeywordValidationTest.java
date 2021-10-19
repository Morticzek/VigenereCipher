package dev.morticzek.test;
import dev.morticzek.model.InvalidModelException;
import dev.morticzek.model.VigenereModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import pl.polsl.rafal.synoradzki.model.*;

/**
 * Test checking the process of keyword validation
 *
 * @author Morticzek [https://github.com/Morticzek]
 * @version 1.0
 */

public class KeywordValidationTest {
        /**
         * Instance of VigenereModel used in testing
         */
        private VigenereModel vigenereModel;
        /**
         * Setup function used to initialize data ready for testing
         */
        @BeforeEach
        public void setup(){vigenereModel = new VigenereModel("Message","",true,false);}
        /**
         * Unit test function used to check a valid keyword validation
         */
        @Test
        public void testValidKeywordValidation()
        {
                try {
                        String keyword = "Key";
                        vigenereModel.vigenereKeywordValidation(keyword);
                        Assertions.assertEquals("KEY",vigenereModel.getKeyword(), "Successful validation");
                } catch (InvalidModelException invalidModelException) {
                        Assertions.fail("Validation of a valid key fails");
                }
        }
        /**
         * Unit test function used to check an invalid keyword validation
         */
        @Test
        public void testInvalidKeywordValidation()
        {
                Boolean testStatus = false;
                try {
                        String keyword = "234";
                        vigenereModel.vigenereKeywordValidation(keyword);
                        Assertions.fail("The function vigenereKeywordValidation should've thrown an exception due to an invalid model component");
                } catch (InvalidModelException invalidModelException) {
                        testStatus = true;
                        Assertions.assertEquals(true, testStatus, "Expected result - exception has been thrown");
                }
        }
        /**
         * Unit test function used to check an empty keyword validation
         */
        @Test
        public void testEmptyKeywordValidation()
        {
                Boolean testStatus = false;
                try {
                        String keyword = "";
                        vigenereModel.vigenereKeywordValidation(keyword);
                        Assertions.fail("The function vigenereKeywordValidation should've thrown an exception due to an invalid model component");
                } catch (InvalidModelException invalidModelException) {
                        testStatus = true;
                        Assertions.assertEquals(true, testStatus, "Expected result - exception has been thrown");
                }
        }
        /**
         * Unit test function used to check a valid keyword validation
         */
        @Test
        public void testNonLatinSymbolsKeywordValidation()
        {
                Boolean testStatus = false;
                try {
                        String keyword = "Żółć";
                        vigenereModel.vigenereKeywordValidation(keyword);
                        Assertions.fail("vigenereKeywordValidation didn't remove all (or any) of the symbols");
                } catch (InvalidModelException invalidModelException) {
                        testStatus = true;
                        Assertions.assertEquals(true, testStatus, "Expected result - exception has been thrown");
                }
        }
}
