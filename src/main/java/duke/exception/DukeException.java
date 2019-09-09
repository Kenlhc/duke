package duke.exception;

/**
 * One of the Exceptions thrown in Duke
 */
public class DukeException extends Exception {
    /**
     * This exception is thrown when an error pertaining to duke occurs
     * @param message The message to be displayed when an error has occurred
     */
    public DukeException (String message){
        super(message);
    }
}
