package at.spengergasse._2xhif;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PhoneModifierTest {

    @Test
    void can_add_to_headers() {
        LinkedHashMap<Integer, String> header = new LinkedHashMap<>();
        header.put(1, "A");
        header.put(2, "B");

        var modifier = new PhoneModifier();

        var newHeader = modifier.addToHeader(header, false);

        assertEquals(3, newHeader.size());
    }

    @Test
    void can_add_to_data() {
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        ArrayList<String> row = new ArrayList<>();
        row.add("1");
        row.add("2");
        data.add(row);

        var modifier = new PhoneModifier();

        var newData = modifier.addRandomizedToData(data);

        assertEquals(1, data.size());
        assertEquals(3, data.get(0).size());
    }

}