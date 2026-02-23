package at.spengergasse._2xhif;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class CSVTest {
    private static String dir;
    private static String outPath;

    @BeforeAll
    static void setUp() {
        dir = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        outPath = dir + "out.csv";
    }

    @AfterEach
    void tearDown() {
        var file = new File(outPath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void can_process_complete_file() {
        var reader = new CSVReader();
        var writer = new CSVWriter();
        var modifier = new PhoneModifier();

        assertDoesNotThrow(() -> reader.readFile(dir + "Adressen.csv", false));

        var header = reader.getHeader();
        var data = reader.getData();

        var newHeader = modifier.addToHeader(header, false);
        var newData = modifier.addRandomizedToData(data);

        assertDoesNotThrow(() -> writer.writeCSV(outPath, data, header, false));

        var reader2 = new CSVReader();
        assertDoesNotThrow(() -> reader2.readFile(outPath, false));

        assertEquals(newData, reader2.getData());
        assertEquals(newHeader, reader2.getHeader());
    }

}
