package at.spengergasse.bufferedreader;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ShakespeareReaderTest {

    private static final String CORRECT = "All the world’s a stage, \n" +
            "And all the men and women merely players; \n" +
            "They have their exits and their entrances; \n" +
            "And one man in his time plays many parts,";

    @Test
    void ensure_that_not_existing_file_throws() {
        assertThrows(FileNotFoundException.class, () -> ShakespeareReader.readShakespeare("doesntexist.txt"));
    }

    @Test
    void ensure_that_is_read_correctly() throws IOException {
        // ACT
        String content = ShakespeareReader.readShakespeare("shakespear.txt");

        // ASSERT
        assertEquals(CORRECT, content);
        // assert CORRECT == content;
    }

}