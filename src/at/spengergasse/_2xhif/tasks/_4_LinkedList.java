package at.spengergasse._2xhif.tasks;

import at.spengergasse._2xhif.domain.HistoryTour;
import at.spengergasse._2xhif.domain.POI;
import at.spengergasse._2xhif.domain.RandomTour;

public class _4_LinkedList {
    public static void main(String[] args) {
        final POI poi1 = new POI(1L, "Balloon Girl", "Stencil-Graffiti eines jungen Mädchens mit einem roten Herzballon.", 2002);
        final POI poi2 = new POI(2L, "Die Nachtwache", "Ein großes Ölgemälde von Rembrandt van Rijn.", 1642);
        final POI poi3 = new POI(3L, "Self-Portrait with Cropped Hair", "Ein Selbstporträt Kahlos nach der Trennung von Rivera.", 1940);
        final POI poi4 = new POI(4L, "Die Beständigkeit der Erinnerung", "Berühmtes surrealistisches Werk mit schmelzenden Uhren.", 1931);
        final POI poi5 = new POI(5L, "Mona Lisa", "Porträtgemälde von Lisa del Giocondo, Öl auf Pappelholz.", 1503);
        final POI poi6 = new POI(6L, "Girl with a Pierced Eardrum", "Banksys Hommage an Vermeer, mit modernem Twist.", 2014);
        final POI poi7 = new POI(7L, "At Eternity’s Gate", "Eines der späten Werke van Goghs, das menschliches Leiden ausdrückt.", 1890);
        final POI poi8 = new POI(8L, "Die zwei Fridas", "Ein surrealistisches Doppel-Selbstporträt von Kahlo.", 1939);

        // -- history tour --
        final HistoryTour historyTour = new HistoryTour();
        historyTour.addPOI(poi1);
        historyTour.addPOI(poi3);
        historyTour.addPOI(poi5);
        historyTour.addPOI(poi7);

        historyTour.addPOI(poi1); // FIXME: should throw an exception
        System.out.println("Current history tour POI: " + historyTour.getCurrent());

        historyTour.visitNext();
        System.out.println("Current history tour POI: " + historyTour.getCurrent());

        System.out.println("\nHistory tour before insert: ");
        historyTour.print();

        System.out.println("\nHistory tour after insert: ");
        historyTour.addPOI(poi4); // TODO: should insert the POI properly
        historyTour.print();

        // -- random tour --
        final RandomTour randomTour = new RandomTour();
        randomTour.addPOI(poi2);
        randomTour.addPOI(poi4);
        randomTour.addPOI(poi6);
        randomTour.addPOI(poi8);

        randomTour.addPOI(poi1); // FIXME: should throw an exception
        System.out.println("Current random tour POI: " + randomTour.getCurrent());

        randomTour.visitNext();
        System.out.println("Current oldest random tour POI: " + randomTour.getCurrent());

        System.out.println("Currently youngest POI: " + randomTour.visitYoungest());

        System.out.println("\nRandom tour before insert: ");
        randomTour.print();

        System.out.println("\nRandom tour after insert: ");
        randomTour.addPOI(poi4); // TODO: should insert the POI properly
        randomTour.print();
    }
}
