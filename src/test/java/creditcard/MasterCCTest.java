package creditcard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MasterCCTest {

    @Test
    void testToString() {
        String number = "347856341908126";
        String date = "03/23";
        String name = "Jane S. Dayton";

        MasterCC masterCC = new MasterCC(number, date, name);

        String expectedToString = "MasterCard [" + number + "]";
        Assertions.assertEquals(expectedToString, masterCC.toString(), "Incorrect toString representation");

    }
}