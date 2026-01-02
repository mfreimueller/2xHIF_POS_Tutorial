package at.spengergasse._2xhif.foundation;

import at.spengergasse._2xhif.domain.POI;
import at.spengergasse._2xhif.foundation.exception.DataViolationException;
import at.spengergasse._2xhif.foundation.exception.MalformedFileException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class POIReader {

    // factory method: create a new valid object of type POIReader
    public static POIReader createReader(String filePath) throws FileNotFoundException {
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("filePath must not be null or blank!");
        }

        FileReader fis = new FileReader(filePath);
        return new POIReader(fis);
    }

    /*
    NOTE: I decided to directly store the BufferedReader as member variable, because this way I can
    keep track of the line count (via the new method: readNext), which increments which each line.
    This way we can give the user more detailed error messages.
     */
    private final BufferedReader reader;
    private int lineCount;

    private POIReader(FileReader fileReader) {
        this.reader = new BufferedReader(fileReader);
    }

    public List<POI> readAll() throws IOException, MalformedFileException {
        List<POI> allPois = new ArrayList<>();

        String read = readNext();
        while (read != null) {
            long id;
            try {
                id = Long.parseLong(read);
            } catch (NumberFormatException nfe) {
                throw new MalformedFileException("id", lineCount, nfe);
            }

            POI poi = new POI(id);

            String title = readNext();
            try {
                poi.setTitle(title);
            } catch (DataViolationException e) {
                throw new MalformedFileException("title", lineCount, e);
            }

            String description = readNext();
            try {
                poi.setDescription(description);
            } catch (DataViolationException e) {
                throw new MalformedFileException("description", lineCount, e);
            }

            read = readNext();
            int year;

            try {
                year = Integer.parseInt(read);
                poi.setYear(year);
            } catch (NumberFormatException nfe) {
                throw new MalformedFileException("year", lineCount, nfe);
            }

            allPois.add(poi);

            read = readNext();
        }

        return allPois;
    }

    /**
     * Reads the next line from the underlying buffered reader and increments the
     * lineCount iff the line is not null.
     * @return The next line.
     */
    private String readNext() throws IOException {
        final String line = reader.readLine();

        if (line != null) {
            lineCount++;
        }

        return line;
    }

}
