package at.spengergasse._2xhif;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class CSVWriter {
    private static final String LINE_BREAK = "\n";
    private static final String DELIMITER = ",";

    public void writeCSV(String path, ArrayList<ArrayList<String>> data, LinkedHashMap<Integer, String> header, boolean writeHeader) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            if (writeHeader) {
                ArrayList<String> headerCols = new ArrayList<>(header.sequencedValues());
                writeLine(headerCols, writer);
            }

            for (ArrayList<String> row : data) {
                writeLine(row, writer);
            }
        }
    }

    private void writeLine(ArrayList<String> data, BufferedWriter writer) throws IOException {
        writer.write(String.join(DELIMITER, data) + LINE_BREAK);
    }

}
