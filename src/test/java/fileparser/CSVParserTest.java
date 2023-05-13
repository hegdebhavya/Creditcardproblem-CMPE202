package fileparser;
import creditcard.CreditCardEntry;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVParserTest {
    private final CSVParser csvParser = new CSVParser();
    @Test
    void parseFile() {
        String filePath = "src/test/testresources/csvtest.csv";
        List<CreditCardEntry> result = csvParser.parseFile(filePath);

        // Assert the size of the list
        Assertions.assertEquals(3, result.size(), "Incorrect number of credit card entries");

        // Assert the values of the first credit card entry
        CreditCardEntry firstEntry = result.get(0);
        Assertions.assertEquals("5567894523129089", firstEntry.getCardNumber(), "Incorrect card number");
        Assertions.assertEquals("08/26", firstEntry.getCardExpDate(), "Incorrect expiration date");
        Assertions.assertEquals("John Doe", firstEntry.getCardHolderName(), "Incorrect cardholder name");

        // Assert the values of the second credit card entry
        CreditCardEntry secondEntry = result.get(1);
        Assertions.assertEquals("59012345678901234567890", secondEntry.getCardNumber(), "Incorrect card number");
        Assertions.assertEquals("10/24", secondEntry.getCardExpDate(), "Incorrect expiration date");
        Assertions.assertEquals("Lisa Claire", secondEntry.getCardHolderName(), "Incorrect cardholder name");

        // Assert the values of the third credit card entry
        CreditCardEntry thirdEntry = result.get(2);
        Assertions.assertEquals("4123456789123", thirdEntry.getCardNumber(), "Incorrect card number");
        Assertions.assertEquals("04/26", thirdEntry.getCardExpDate(), "Incorrect expiration date");
        Assertions.assertEquals("Martha Clark", thirdEntry.getCardHolderName(), "Incorrect cardholder name");

    }
}