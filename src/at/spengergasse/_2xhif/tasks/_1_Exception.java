package at.spengergasse._2xhif.tasks;

import at.spengergasse._2xhif.domain.POI;

public class _1_Exception {
    public static void main(String[] args) {
        POI poi = new POI(1L);

        // TODO: create a new exception called DataViolationException in at.spengergasse.2xhif.foundation

        // TODO: implement null checks in ::setTitle and ::setDescription and throw DataViolationException exceptions
        poi.setTitle(null);
        poi.setDescription(null);

        // TODO: make sure that the following calls work properly (i.e. throw no exception)
        poi.setTitle("Der Kuss");
        poi.setDescription("Ein bekanntes Ölgemälde mit aufgelegtem Blattgold von Gustav Klimt.");

        // TODO: print poi to stdout
    }
}
