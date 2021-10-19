package dev.morticzek.test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import dev.morticzek.model.VigenereModel;

import java.util.stream.Stream;

/**
 * Parameterized test checking results of encryption and decryption
 *
 * @author Morticzek [https://github.com/Morticzek]
 * @version 1.0
 */

public class ParameterizedTests {
    /**
     * Instance of VigenereModel used in testing
     */
    private VigenereModel vigenereModel;

    /**
     * Function returning a stream of arguments to be used in encryption
     * @return Stream of elements of type Arguments
     */
    private static Stream<Arguments> encryptionStringsProvider()
    {
        return Stream.of(
                Arguments.of("Test","BC","Ugtv"),
                Arguments.of("Cat","BD","Ddu"),
                Arguments.of("","AE",""),
                Arguments.of("Żółć","AD",""),
                Arguments.of("","","")
        );
    }

    /**
     * Function returning a stream of arguments to be used in decryption
     * @return Stream of elements of type Arguments
     */
    private static Stream<Arguments> decryptionStringsProvider()
    {
        return Stream.of(
                Arguments.of("Test","BC","Scrr"),
                Arguments.of("Cat","BD","Bxs"),
                Arguments.of("","AE",""),
                Arguments.of("Żółć","AD",""),
                Arguments.of("","","")
        );
    }
    /**
     * Setup function used to initialize data ready for testing
     */
    @BeforeEach
    void setup(){vigenereModel = new VigenereModel("","",true,false);}
    /**
     * Parameterized test function checking results of encryption
     *
     * @param original Original message
     * @param key Key used to encrypt
     * @param expected Expected message result
     */
    @ParameterizedTest
    @MethodSource("encryptionStringsProvider")
    void checkEncryptResult(String original, String key, String expected)
    {
        vigenereModel.setMessage(original);
        vigenereModel.setKeyword(key);
        vigenereModel.vigenereEncryption(vigenereModel.getMessage(), vigenereModel.getKeyword());
        Assertions.assertEquals(expected, vigenereModel.getEncryptedMessage(),
                "Obtained results cover valid messages and keywords");
    }
    /**
     * Parameterized test function checking results of decryption
     *
     * @param original Original message
     * @param key Key used to decrypt
     * @param expected Expected message result
     */
    @ParameterizedTest
    @MethodSource("decryptionStringsProvider")
    void checkDecryptResult(String original, String key, String expected)
    {
        vigenereModel.setMessage(original);
        vigenereModel.setKeyword(key);
        vigenereModel.vigenereDecryption(vigenereModel.getMessage(), vigenereModel.getKeyword());
        Assertions.assertEquals(expected,vigenereModel.getDecryptedMessage(),
                "Obtained results cover valid messages and keywords");
    }

}
