package at.spengergasse._2xhif;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class CSVReader {
    private ArrayList<ArrayList<String>> data;
    private LinkedHashMap<Integer, String> header;

    public void readFile(String path, boolean hasHeader) throws IOException {
        header = new LinkedHashMap<>();
        data = new ArrayList<>();

        boolean readHeader = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ArrayList<String> tokens = new ArrayList<>(Arrays.asList(line.split(",")));

                // If we didn't read the header yet, we either...
                // IF (hasHeader = true) read the first line
                // OR simply count the number of columns and create "dummy headers"
                if (!readHeader) {
                    for (int idx = 0; idx < tokens.size(); idx++) {
                        if (hasHeader) {
                            header.put(idx, tokens.get(idx));
                        } else {
                            header.put(idx, "Header " + idx);
                        }
                    }

                    readHeader = true;

                    if (hasHeader) {
                        continue;
                    }
                }

                data.add(tokens);
            }
        }
    }

    public ArrayList<ArrayList<String>> getData() {
        return data;
    }

    public LinkedHashMap<Integer, String> getHeader() {
        return header;
    }
}
