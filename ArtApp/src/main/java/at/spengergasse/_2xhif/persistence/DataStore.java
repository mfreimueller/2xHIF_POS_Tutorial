package at.spengergasse._2xhif.persistence;

import at.spengergasse._2xhif.domain.POI;
import at.spengergasse._2xhif.foundation.POIReader;
import at.spengergasse._2xhif.foundation.exception.MalformedFileException;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class DataStore {

    private final String dataPath;
    private List<POI> poiList;

    public DataStore(String dataPath) {
        this.dataPath = dataPath;
    }

    public void load() throws IOException, MalformedFileException {
        POIReader poiReader = POIReader.createReader(dataPath);
        poiList = poiReader.readAll();

        // option #1: lambda
//        poiList.sort((a, b) -> {
//            if (a.getYear() != b.getYear())
//                return b.getYear() - a.getYear();
//
//            return a.getTitle().compareTo(b.getTitle());
//        });

        // option #2: anonymous class
//        poiList.sort(new Comparator<POI>() {
//            @Override
//            public int compare(POI a, POI b) {
//                if (a.getYear() != b.getYear())
//                    return b.getYear() - a.getYear();
//
//                return a.getTitle().compareTo(b.getTitle());
//            }
//        });

        // option #3: class
        poiList.sort(new POIComparator());
    }

    public List<POI> getPoiList() {
        return poiList;
    }

    private class POIComparator implements Comparator<POI> {
        @Override
        public int compare(POI a, POI b) {
            // 1900 != 2000 -> (2000 - 1900)=100 -> a rechts von b
            // 2000 != 1900 -> (1900 - 2000)=-100 -> a links von b
            if (a.getYear() != b.getYear())
                return b.getYear() - a.getYear();

            return a.getTitle().compareTo(b.getTitle());
        }
    }
}
