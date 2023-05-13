package creditcard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscoverCCTest {

    @Test
    void testToString() {
        String number = "347856341908126";
        String date = "03/23";
        String name = "Jane S. Dayton";

        DiscoverCC discoverCC = new DiscoverCC(number, date, name);

        String expectedToString = "Discover [" + number + "]";
        Assertions.assertEquals(expectedToString, discoverCC.toString(), "Incorrect toString representation");

    }
}