package dev.morticzek.test;
import dev.morticzek.model.InvalidModelException;
import dev.morticzek.model.VigenereModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import pl.polsl.rafal.synoradzki.model.*;
import java.util.ArrayList;
/**
 * Test checking operation type mapping
 *
 * @author Morticzek [https://github.com/Morticzek]
 * @version 1.0
 */

public class OperationTypeTest {
    /**
     * Instance of VigenereModel used in testing
     */
    private VigenereModel vigenereModel;
    /**
     * String array of arguments
     */
    String[] args;
    /**
     * ArrayList of type String containing arguments from args array
     */
    ArrayList<String> argsList;
    /**
     * ArrayList of type Boolean containing boolean values for operation types
     */
    ArrayList<Boolean> ops;
    /**
     * Setup function used to initialize data ready for testing
     */
    @BeforeEach
    public void setup()
    {
        vigenereModel = new VigenereModel("","",false,false);
        ops = new ArrayList<>(2);
        ops.add(0,false);
        ops.add(1,false);
        args = new String[]{"Word","Key"};
        argsList = new ArrayList<>();
        for(int i = 0; i < args.length; i++)
        {
            argsList.add(args[i]);
        }
    }
    /**
     * Unit test function used to check operation type mapping of a valid argument
     */
    @Test
    public void validOperationTypeCheck()
    {
        try {
            argsList.add("1");
            ops = vigenereModel.checkOperationType(argsList);
            Assertions.assertEquals(true, ops.get(0), "Successful operation mapping");
        } catch (InvalidModelException invalidModelException) {
            Assertions.fail("Mapping of an operation type fails");
        }
    }
    /**
     * Unit test function used to check operation type mapping of an invalid argument
     */
    @Test
    public void invalidOperationTypeCheck()
    {
        Boolean testStatus = false;
        try {
            argsList.add(2, "3");
            ops = vigenereModel.checkOperationType(argsList);
            Assertions.fail("The function checkOperationType should've thrown an exception due to an invalid model component");
        } catch (InvalidModelException invalidModelException) {
            testStatus = true;
            Assertions.assertEquals(testStatus, true, "Expected result - exception has been thrown");
        }
    }
    /**
     * Unit test function used to check operation type mapping of an empty argument
     */
    @Test
    public void emptyOperationTypeCheck()
    {
        Boolean testStatus = false;
        try {
            argsList.add(2, "");
            ops = vigenereModel.checkOperationType(argsList);
            Assertions.fail("The function checkOperationType should've thrown an exception due to an invalid model component");
        } catch (InvalidModelException invalidModelException) {
            testStatus = true;
            Assertions.assertEquals(testStatus, true, "InvalidModelException has been thrown");
        }
        catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
            testStatus = true;
            Assertions.assertEquals(testStatus, true, "StringIndexOutOfBoundsException has been thrown");
        }
    }
}
