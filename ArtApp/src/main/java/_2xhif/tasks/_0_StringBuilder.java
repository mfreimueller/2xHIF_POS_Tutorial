package _2xhif.tasks;

import at.spengergasse._2xhif.domain.POI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _0_StringBuilder {
    public static void main(String[] args) {
        POI poi = new POI(1L, "Balloon Girl", "Stencil-Graffiti eines jungen Mädchens mit einem roten Herzballon.", 2002);

        System.out.println("POI: " + poi);

        final ArrayList<POI> pois = new ArrayList<POI>(List.of(new POI[]{
                new POI(1L, "Mona Lisa", "Porträtgemälde von Lisa del Giocondo, Öl auf Pappelholz.", 1503),
                new POI(2L, "Girl with a Pierced Eardrum", "Banksys Hommage an Vermeer, mit modernem Twist.", 2014),
                new POI(3L, "At Eternity’s Gate", "Eines der späten Werke van Goghs, das menschliches Leiden ausdrückt.", 1890),
                new POI(4L, "Die zwei Fridas", "Ein surrealistisches Doppel-Selbstporträt von Kahlo.", 1939),
        }));

        final StringBuilder sb = new StringBuilder();

        /*for (int idx = 0; idx < pois.size(); idx++) {
            final POI p = pois.get(idx);
            sb.append("\n- ").append(p).append(',');
        }*/

        /*Iterator<POI> it = pois.iterator();
        while (it.hasNext()) {
            final POI p = it.next();
            sb.append("\n- ").append(p).append(',');
        }*/

        for (final POI p : pois) {
            sb.append("\n- ").append(p).append(',');
            // pois.remove(p); -- don't do this!
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println("All POIS: " + sb);
    }
}
