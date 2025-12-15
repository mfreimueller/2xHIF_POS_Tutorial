package at.spengergasse._2xhif.tasks;

import at.spengergasse._2xhif.domain.Exhibition;
import at.spengergasse._2xhif.domain.POI;

import java.util.ArrayList;

public class _3_List {
    public static void main(final String[] args) {
        final POI poi1 = new POI(1L, "Mona Lisa", "Porträtgemälde von Lisa del Giocondo, Öl auf Pappelholz.", 1503);
        final POI poi2 = new POI(2L, "Girl with a Pierced Eardrum", "Banksys Hommage an Vermeer, mit modernem Twist.", 2014);
        final  POI poi3 = new POI(3L, "At Eternity’s Gate", "Eines der späten Werke van Goghs, das menschliches Leiden ausdrückt.", 1890);
        final POI poi4 = new POI(4L, "Die zwei Fridas", "Ein surrealistisches Doppel-Selbstporträt von Kahlo.", 1939);

        final Exhibition exhibitionA = new Exhibition();
        exhibitionA.addPOI(poi1);
        exhibitionA.addPOI(poi2);
        exhibitionA.addPOI(poi3);

        try {
            exhibitionA.addPOI(poi1);
            throw new IllegalStateException("This should not happen... you shouldn't be able to add a POI twice.");
        } catch (Exception e) {
            System.out.println("Correctly prevented adding a POI twice!");
        }

        System.out.println("Exhibition A: ");
        exhibitionA.print();

        final Exhibition exhibitionB = new Exhibition();
        exhibitionB.addPOI(poi2);
        exhibitionB.addPOI(poi3);
        exhibitionB.addPOI(poi4);

        System.out.println("\nExhibition B: ");
        exhibitionB.print();

        POI poiWithId2 = exhibitionA.findPOI(2L);
        System.out.println("\nPOI with ID 2: " + poiWithId2);

        boolean removed = exhibitionA.removePOI(1L);
        System.out.println("Successfully removed POI with ID 1 (expected true): " + removed);

        System.out.println("\n#POIs in exhibition A: " + exhibitionA.getCount());
        System.out.println("#POIs in exhibition B: " + exhibitionB.getCount());

        System.out.println("\nIntersecting exhibition A and B:");
        ArrayList<POI> common = (ArrayList<POI>)exhibitionA.intersect(exhibitionB);
         for (POI poi : common) {
            System.out.println("- " + poi.getTitle());
        }

        System.out.println("\nDifference between exhibition B and A:");
        ArrayList<POI> diff = (ArrayList<POI>)exhibitionB.difference(exhibitionA);
        for (POI poi : diff) {
            System.out.println("- " + poi.getTitle());
        }

        boolean removed99 = exhibitionA.removePOI(99L);
        System.out.println("\nSuccessfully removed POI with ID 99 (expected false): " + removed99);

        exhibitionA.addPOI(poi4);

        System.out.println("\nNew intersect (A ∩ B):");
        ArrayList<POI> newCommon = (ArrayList<POI>)exhibitionA.intersect(exhibitionB);
        for (POI poi : newCommon) {
            System.out.println("- " + poi.getTitle());
        }
    }
}
