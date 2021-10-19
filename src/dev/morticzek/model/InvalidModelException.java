package dev.morticzek.model;

/**
 * InvalidModelException is an exception class used in case of invalid results of a model or its components.
 *
 * @author Morticzek [https://github.com/Morticzek]
 * @version 1.0
 */
public class InvalidModelException extends Exception{
    /**
     * Exception constructor.
     * @param errorMessage Message with an error
     */
    public InvalidModelException(String errorMessage)
    {
        super(errorMessage);
    }
}
