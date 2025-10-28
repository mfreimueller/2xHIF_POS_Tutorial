package at.spengergasse._2xhif.domain;

/**
 * Tour uses a linked lists to store a list of POIs that visitors are to visit.
 * This class only supports moving from POI to POI in the given order.
 * POIs are sorted by their year, where the oldest POI is visited first and the youngest last.
 */
public class HistoryTour implements Tour {

    @Override
    public void addPOI(POI poi) {
    }

    @Override
    public POI getCurrent() {
        return null;
    }

    @Override
    public POI visitNext() {
        return null;
    }

    @Override
    public void print() {

    }
}
