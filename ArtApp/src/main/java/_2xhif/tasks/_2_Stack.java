package _2xhif.tasks;

import at.spengergasse._2xhif.domain.POI;
import at.spengergasse._2xhif.foundation.TourNavigator;
import at.spengergasse._2xhif.foundation.exception.EmptyTourException;

public class _2_Stack {
    public static void main(String[] args) {
        final TourNavigator tourNavigator = new TourNavigator();

        final POI poi1 = new POI(1L, "Die Nachtwache", "Ein großes Ölgemälde von Rembrandt van Rijn.", 1642);
        final POI poi2 = new POI(2L, "Self-Portrait with Cropped Hair", "Ein Selbstporträt Kahlos nach der Trennung von Rivera.", 1940);
        final POI poi3 = new POI(3L, "Die Beständigkeit der Erinnerung", "Berühmtes surrealistisches Werk mit schmelzenden Uhren.", 1931);

        try {
            tourNavigator.goBack(); // FIXME: this throws an exception
        } catch (EmptyTourException e) {
            System.err.printf("goBack failed with exception: %s%n", e.getMessage());
        }

        tourNavigator.visit(poi1);
        tourNavigator.visit(poi2);

        try {
            System.out.println("Currently visiting: " + tourNavigator.getCurrentLocation());
        } catch (EmptyTourException e) {
            System.err.printf("getCurrentLocation failed with exception %s%n", e.getMessage());
        }

        try {
            final POI lastPOI = tourNavigator.goBack();
            System.out.println("Currently visiting: " + tourNavigator.getCurrentLocation());
        } catch (EmptyTourException e) {
            System.err.println(e);
        }

        tourNavigator.visit(poi3);

        tourNavigator.endTour();

        try {
            tourNavigator.getCurrentLocation(); // FIXME: this throws an exception
        } catch (EmptyTourException e) {
            System.err.printf("getCurrentLocation failed with exception %s%n", e.getMessage());
        }
    }
}
