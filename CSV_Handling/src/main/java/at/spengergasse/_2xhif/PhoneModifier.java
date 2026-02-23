package at.spengergasse._2xhif;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class PhoneModifier {

    private static final int MAX_RAND_INT = 9999999;

    public LinkedHashMap<Integer, String> addToHeader(LinkedHashMap<Integer, String> header, boolean hasHeader) {
        if (hasHeader) {
            header.put(header.size(), "Telefonnummer");
        } else {
            header.put(header.size(), "Header " + header.size());
        }
        return header;
    }

    public ArrayList<ArrayList<String>> addRandomizedToData(ArrayList<ArrayList<String>> data) {
        final Random random = new Random();

        for (ArrayList<String> row : data) {
            row.add("+43 664 " + random.nextInt(MAX_RAND_INT));
        }

        return data;
    }

}
