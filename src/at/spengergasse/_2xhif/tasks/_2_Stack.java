package at.spengergasse._2xhif.tasks;

import at.spengergasse._2xhif.domain.POI;
import at.spengergasse._2xhif.foundation.TourNavigator;

public class _2_Stack {
    public static void main(String[] args) {
        final TourNavigator tourNavigator = new TourNavigator();

        final POI poi1 = new POI(1L, "Die Nachtwache", "Ein großes Ölgemälde von Rembrandt van Rijn.", 1642);
        final POI poi2 = new POI(2L, "Self-Portrait with Cropped Hair", "Ein Selbstporträt Kahlos nach der Trennung von Rivera.", 1940);
        final POI poi3 = new POI(3L, "Die Beständigkeit der Erinnerung", "Berühmtes surrealistisches Werk mit schmelzenden Uhren.", 1931);

        tourNavigator.goBack(); // FIXME: this throws an exception

        tourNavigator.visit(poi1);
        tourNavigator.visit(poi2);
        System.out.println("Currently visiting: " + tourNavigator.getCurrentLocation());

        final POI lastPOI = tourNavigator.goBack();
        System.out.println("Currently visiting: " + tourNavigator.getCurrentLocation());

        tourNavigator.visit(poi3);

        tourNavigator.endTour();

        tourNavigator.getCurrentLocation(); // FIXME: this throws an exception
    }
}
