package at.spengergasse._2xhif.foundation;

import at.spengergasse._2xhif.domain.POI;
import at.spengergasse._2xhif.foundation.exception.MalformedFileException;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class POIReaderTest {

    private String rootPath;

    @BeforeEach
    void setUp() {
        rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }

    @Test
    void throws_on_invalid_path() {
        assertThrows(FileNotFoundException.class, () -> POIReader.createReader("404.txt"));
    }

    @Test
    void throws_on_null_path() {
        assertThrows(IllegalArgumentException.class, () -> POIReader.createReader(null));
    }

    @Test
    void throws_on_empty_path() {
        assertThrows(IllegalArgumentException.class, () -> POIReader.createReader(""));
    }

    @Test
    void throws_on_blank_path() {
        assertThrows(IllegalArgumentException.class, () -> POIReader.createReader("   "));
    }

    @Test
    void can_open_with_valid_path() {
        assertDoesNotThrow(() -> POIReader.createReader(rootPath + "correct.txt"));
    }

    @Test
    void correctly_reads_list_of_valid_pois() throws IOException, MalformedFileException {
        POIReader poiReader = POIReader.createReader(rootPath + "correct.txt");

        List<POI> pois = poiReader.readAll();
        assertEquals(14, pois.size());
    }

    @Test
    void throws_on_reading_malformed_file() throws IOException {
        POIReader poiReader = POIReader.createReader(rootPath + "malformed.txt");

        assertThrows(MalformedFileException.class, poiReader::readAll);
    }

    @Test
    void throws_on_reading_empty_title() throws IOException {
        POIReader poiReader = POIReader.createReader(rootPath + "emptyTitle.txt");

        assertThrows(MalformedFileException.class, poiReader::readAll);
    }

}