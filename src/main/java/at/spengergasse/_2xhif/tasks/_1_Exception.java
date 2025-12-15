package at.spengergasse._2xhif.tasks;

import at.spengergasse._2xhif.domain.POI;
import at.spengergasse._2xhif.foundation.exception.DataViolationException;

public class _1_Exception {
    public static void main(String[] args) {
        final POI poi = new POI(1L);

        // TODO: create a new exception called DataViolationException in at.spengergasse.2xhif.foundation

        // TODO: implement null checks in ::setTitle and ::setDescription and throw DataViolationException exceptions
        try {
            poi.setTitle(null);
        } catch (DataViolationException e) {
            System.err.println(e.getMessage());
        }

        try {
            poi.setTitle("    ");
        } catch (DataViolationException e) {
            System.err.println(e.getMessage());
        }

        try {
            poi.setDescription(null);
        } catch (DataViolationException e) {
            System.err.println(e.getMessage());
        }

        try {
            poi.setDescription("      ");
        } catch (DataViolationException e) {
            System.err.println(e.getMessage());
        }

        // TODO: make sure that the following calls work properly (i.e. throw no exception)
        try {
            poi.setTitle("Der Kuss");

            poi.setDescription("Ein bekanntes Ölgemälde mit aufgelegtem Blattgold von Gustav Klimt.");
        } catch (DataViolationException e) {
            throw new IllegalStateException("This shouldn't have happened...");
        }

        // TODO: print poi to stdout
        System.out.println("POI: " + poi);
    }
}
