package at.spengergasse._2xhif.foundation.exception;

public class DuplicatedEntryException extends RuntimeException {
    public DuplicatedEntryException(Long id) {
        super("POI with ID %d is already part of this tour.".formatted(id));
    }
}
