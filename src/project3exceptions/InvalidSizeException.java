package project3exceptions;

/**
 *
 * @author Ian
 */
public class InvalidSizeException extends ArrayIndexOutOfBoundsException{
     InvalidSizeException(String message) {
        super(message);
     }
}
