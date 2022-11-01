package project3exceptions;
import java.util.InputMismatchException;

/**
 *
 * @author Ian
 */
public class InvalidInputException extends InputMismatchException{
     InvalidInputException(String message) {
        super(message);
     }    
}
