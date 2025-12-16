package _2xhif.tasks;

import at.spengergasse._2xhif.domain.POI;
import at.spengergasse._2xhif.foundation.POICache;

public class _5_HashMap {
    static void main() {
        final POI poi1 = new POI(1L, "Balloon Girl", "Stencil-Graffiti eines jungen Mädchens mit einem roten Herzballon.", 2002);
        final POI poi2 = new POI(2L, "Self-Portrait with Cropped Hair", "Ein Selbstporträt Kahlos nach der Trennung von Rivera.", 1940);
        final POI poi3 = new POI(3L, "Die Beständigkeit der Erinnerung", "Berühmtes surrealistisches Werk mit schmelzenden Uhren.", 1931);

        final POICache cache = new POICache();

        cache.addPOI(poi1);
        cache.addPOI(poi2);
        cache.addPOI(poi3);

        // we expect the next line to throw an exception
        try {
            cache.addPOI(poi1);
            System.err.println("cache.addPOI didn't detect the duplicated POI!");
        } catch (Exception ex) {
            System.out.println("cache.addPOI correctly detected the duplicated POI.");
        }

        final POI foundPOI = cache.findById(1L);
        if (foundPOI == null) {
            System.err.println("cache.findById failed to find the POI with ID 1.");
        } else {
            System.out.println("cache.findById correctly found the POI with ID 1.");
        }

        POI notFoundPOI = cache.findById(4L);
        if (notFoundPOI != null) {
            System.err.println("cache.findById failed to not find the POI with ID 4.");
        } else {
            System.out.println("cache.findById correctly failed to find the POI with ID 4.");
        }

        final boolean couldRemove = cache.removeById(3L);
        if (!couldRemove) {
            System.err.println("cache.removeById failed to remove the POI with ID 3.");
        } else {
            System.out.println("cache.removeById correctly removed the POI with ID 3.");
        }

        final boolean failedToRemove = cache.removeById(3L);
        if (!failedToRemove) {
            System.out.println("cache.removeById successfully failed to remove the POI with ID 3.");
        } else {
            System.err.println("cache.removeById removed the POI with ID 3 again!");
        }

        notFoundPOI = cache.findById(3L);
        if (notFoundPOI == null) {
            System.out.println("cache.findById successfully failed to find the POI with ID 3.");
        } else {
            System.err.println("cache.findById failed by returning a POI with ID 3!");
        }

        cache.clear();
        notFoundPOI = cache.findById(1L);
        if (notFoundPOI == null) {
            System.out.println("cache.findById successfully failed to find the POI with ID 1.");
        } else {
            System.err.println("cache.findById failed by returning a POI with ID 1!");
        }
    }

}
