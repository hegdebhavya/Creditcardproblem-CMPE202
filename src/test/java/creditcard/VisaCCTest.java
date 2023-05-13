package creditcard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisaCCTest {

    @Test
    void testToString() {
        String number = "347856341908126";
        String date = "03/23";
        String name = "Jane S. Dayton";

        VisaCC visaCC = new VisaCC(number, date, name);

        String expectedToString = "Visa [" + number + "]";
        Assertions.assertEquals(expectedToString, visaCC.toString(), "Incorrect toString representation");
    }
}