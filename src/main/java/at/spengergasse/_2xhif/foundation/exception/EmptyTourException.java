package at.spengergasse._2xhif.foundation.exception;

public class EmptyTourException extends RuntimeException {
    public EmptyTourException(String message) {
        super(message);
    }

    public EmptyTourException(String message, Throwable cause) {
        super(message, cause);
    }
}
