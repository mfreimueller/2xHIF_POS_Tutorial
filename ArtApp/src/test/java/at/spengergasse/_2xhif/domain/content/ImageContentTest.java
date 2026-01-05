package at.spengergasse._2xhif.domain.content;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ImageContentTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void calls_load_properly() {
        // given
        ImageContent imageContent = new ImageContent(1L, "ein Bild", "toller Titel", "mein/pfad.png");

        // when
        imageContent.load();

        // then
        assertEquals(256, imageContent.getWidth());
        assertEquals(128, imageContent.getHeight());
        assertEquals("Loading file: mein/pfad.png", outputStream.toString().trim());
    }

    @Test
    void calls_present_properly() {
        // given
        ImageContent imageContent = new ImageContent(1L, "ein Bild", "toller Titel", "mein/pfad.png");

        // when
        imageContent.present();

        // then
        assertEquals("Displaying image: mein/pfad.png", outputStream.toString().trim());
    }

}