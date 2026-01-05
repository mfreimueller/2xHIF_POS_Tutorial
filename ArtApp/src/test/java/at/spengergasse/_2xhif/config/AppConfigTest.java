package at.spengergasse._2xhif.config;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AppConfigTest {

    @Test
    void can_load_existing_property_file() {
        assertDoesNotThrow(() -> AppConfig.getInstance("config.properties"));
    }

    @Test
    void can_load_valid_properties_file_and_retrieve_values() throws IOException {
        // given & when
        AppConfig config = AppConfig.getInstance("config.properties");

        // then
        assertEquals("RandomTour", config.getSupportedTourType());
        assertTrue(config.isPublic());
        assertEquals(10, config.getMaxPOIs());
    }

    @Test
    void throws_on_non_existing_property_file() {
        assertThrows(FileNotFoundException.class, () -> AppConfig.getInstance("404.properties"));
    }

    @Test
    void supplies_default_values_for_missing_properties() throws IOException {
        // given & when
        AppConfig config = AppConfig.getInstance("incomplete.properties");

        // then
        assertEquals("HistoryTour", config.getSupportedTourType());
        assertFalse(config.isPublic());
        assertEquals(0, config.getMaxPOIs());
    }

}