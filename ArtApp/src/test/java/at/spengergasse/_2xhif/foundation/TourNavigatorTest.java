package at.spengergasse._2xhif.foundation;

import at.spengergasse._2xhif.domain.POI;
import at.spengergasse._2xhif.foundation.exception.EmptyTourException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TourNavigatorTest {

    private final POI poi1 = new POI(1L, "Die Nachtwache", "Ein großes Ölgemälde von Rembrandt van Rijn.", 1642);
    private final POI poi2 = new POI(2L, "Self-Portrait with Cropped Hair", "Ein Selbstporträt Kahlos nach der Trennung von Rivera.", 1940);

    @Test
    void throws_on_empty_tour_and_go_back() {
        final TourNavigator tourNavigator = new TourNavigator();

        // assertThrows(EmptyTourException.class, () -> tourNavigator.goBack());
        assertThrows(EmptyTourException.class, tourNavigator::goBack);
    }

    @Test
    void returns_current_poi() {
        final TourNavigator tourNavigator = new TourNavigator();

        tourNavigator.visit(poi1);
        tourNavigator.visit(poi2);

        final POI currentPoi = tourNavigator.getCurrentLocation();
        assertEquals(poi2, currentPoi);
    }

    @Test
    void throws_on_current_location_when_empty() {
        final TourNavigator tourNavigator = new TourNavigator();

        assertThrows(EmptyTourException.class, tourNavigator::getCurrentLocation);
    }

    @Test
    void returns_topmost_poi_when_going_back() {
        final TourNavigator tourNavigator = new TourNavigator();

        tourNavigator.visit(poi1);
        tourNavigator.visit(poi2);

        final POI currentPoi = tourNavigator.goBack();
        assertEquals(poi2, currentPoi);
    }

    @Test
    void returns_correct_poi_after_going_back_and_calling_current_location() {
        final TourNavigator tourNavigator = new TourNavigator();

        tourNavigator.visit(poi1);
        tourNavigator.visit(poi2);

        tourNavigator.goBack();

        final POI currentPoi = tourNavigator.getCurrentLocation();
        assertEquals(poi1, currentPoi);
    }

    @Test
    void doesnt_throw_on_end_tour_while_empty() {
        final TourNavigator tourNavigator = new TourNavigator();
        assertDoesNotThrow(tourNavigator::endTour);
    }

    @Test
    void throws_after_ending_tour_and_calling_current_location() {
        final TourNavigator tourNavigator = new TourNavigator();

        tourNavigator.visit(poi1);
        tourNavigator.visit(poi2);

        assertDoesNotThrow(tourNavigator::endTour);
        assertThrows(EmptyTourException.class, tourNavigator::getCurrentLocation);
    }

}