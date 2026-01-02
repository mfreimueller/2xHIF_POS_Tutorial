package at.spengergasse._2xhif.foundation.exception;

public class MalformedFileException extends Exception {
    public MalformedFileException(String field, int lineCount, Throwable cause) {
        super(String.format("Malformed field: %s at line %s, caused by %s", field, lineCount, cause.getMessage()));
    }
}
