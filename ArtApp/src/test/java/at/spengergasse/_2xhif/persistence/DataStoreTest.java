package at.spengergasse._2xhif.persistence;

import at.spengergasse._2xhif.domain.POI;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DataStoreTest {

    @Test
    void sorts_list_of_pois_correctly() {
        // given
        String path = Thread.currentThread().getContextClassLoader().getResource("correct.txt").getPath();
        DataStore dataStore = new DataStore(path);

        // when
        assertDoesNotThrow(dataStore::load);
//        assertDoesNotThrow(() -> dataStore.load());

        // then
        List<POI> pois = dataStore.getPoiList();

        assertEquals(9, pois.getLast().getId()); // 1486 - earliest

        // 1889 - Sonnenblumen vor Sternennacht
        int idxSonnenblumen = 0, idxSternennacht = 0;
        for (int idx = 0; idx < pois.size(); idx++) {
            if (pois.get(idx).getId() == 5) {
                idxSonnenblumen = idx;
            } else if (pois.get(idx).getId() == 4) {
                idxSternennacht = idx;
            }
        }

        assertTrue(idxSonnenblumen < idxSternennacht);
    }

}