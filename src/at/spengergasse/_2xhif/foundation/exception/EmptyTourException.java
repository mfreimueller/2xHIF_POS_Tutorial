package at.spengergasse._2xhif.foundation.exception;

public class EmptyTourException extends Exception {
    public EmptyTourException(String message) {
        super(message);
    }

    public EmptyTourException(String message, Throwable cause) {
        super(message, cause);
    }
}
