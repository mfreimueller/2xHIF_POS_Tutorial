package at.spengergasse._2xhif.domain;

import at.spengergasse._2xhif.foundation.exception.DataViolationException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class POITest {

    // "negative testing": ensure that invalid values lead to expected results
    @Test
    void throws_on_null_title() {
        final POI poi = new POI(1L);

        assertThrows(DataViolationException.class, () -> poi.setTitle(null));
    }

    @Test
    void throws_on_empty_title() {
        final POI poi = new POI(1L);

        assertThrows(DataViolationException.class, () -> poi.setTitle(""));
    }

    @Test
    void throws_on_blank_title() {
        final POI poi = new POI(1L);

        assertThrows(DataViolationException.class, () -> poi.setTitle("       "));
    }

    // "positive testing": ensure that everything works as expected given valid data
    @Test
    void accepts_valid_title() throws DataViolationException {
        // arrange - given
        final POI poi = new POI(1L);

        // act - when
        poi.setTitle("Gemälde #2");

        // assert - then
        assertEquals("Gemälde #2", poi.getTitle());
    }

    @Test
    void throws_on_null_description() {
        final POI poi = new POI(1L);

        assertThrows(DataViolationException.class, () -> poi.setDescription(null));
    }

    @Test
    void throws_on_empty_description() {
        final POI poi = new POI(1L);

        assertThrows(DataViolationException.class, () -> poi.setDescription(""));
    }

    @Test
    void throws_on_blank_description() {
        final POI poi = new POI(1L);

        assertThrows(DataViolationException.class, () -> poi.setDescription("       "));
    }

    @Test
    void accepts_valid_description() throws DataViolationException {
        final POI poi = new POI(1L);

        poi.setDescription("Ein schönes Gemälde.");

        assertEquals("Ein schönes Gemälde.", poi.getDescription());
    }

    @Test
    void can_configure_properly() throws DataViolationException {
        final POI poi = new POI(1L);

        poi.setTitle("Gemälde #2");
        poi.setDescription("Ein schönes Gemälde.");

        assertEquals("Gemälde #2", poi.getTitle());
        assertEquals("Ein schönes Gemälde.", poi.getDescription());
    }

}