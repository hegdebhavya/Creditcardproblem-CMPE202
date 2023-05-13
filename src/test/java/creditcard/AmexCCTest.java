package creditcard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmexCCTest {

    @Test
    void testToString() {
        String number = "347856341908126";
        String date = "03/23";
        String name = "Jane S. Dayton";

        AmexCC amexCC = new AmexCC(number, date, name);

        String expectedToString = "AmericanExpress [" + number + "]";
        Assertions.assertEquals(expectedToString, amexCC.toString(), "Incorrect toString representation");

    }
}