package at.spengergasse._2xhif.foundation.exception;

public class DuplicatedPOIException extends RuntimeException {
    public DuplicatedPOIException(Long id) {
        // super("POI with ID " + id + " was already part of exhibition.");
        super("POI with ID %d was already part of exhibition.".formatted(id));
    }
}
