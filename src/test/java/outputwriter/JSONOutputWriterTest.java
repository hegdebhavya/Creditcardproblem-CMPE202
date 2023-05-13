package outputwriter;

import creditcard.CreditCardEntry;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSONOutputWriterTest {

    @Test
    void writeOutput() {
        String oFileName = "src/test/testresources/output.json";

        List<CreditCardEntry> validatedRecords = new ArrayList<>();
        CreditCardEntry firstEntry = new CreditCardEntry();
        firstEntry.setCardNumber("5567894523129089");
        firstEntry.setCardExpDate("08/26");
        firstEntry.setCardHolderName("John Doe");
        firstEntry.setCardType("MasterCard");

        validatedRecords.add(firstEntry);

        JSONOutputWriter jsonOutputWriter = new JSONOutputWriter();
        jsonOutputWriter.writeOutput(oFileName, validatedRecords);

        // Verify that the file was created
        File outputFile = new File(oFileName);
        Assertions.assertTrue(outputFile.exists(), "Output file does not exist");

        // Verify the contents of the file
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            StringBuilder jsonStringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }

            String jsonString = jsonStringBuilder.toString();

            // Parse the JSON string and verify its structure
            JSONObject jsonObject = new JSONObject(jsonString);
            Assertions.assertTrue(jsonObject.has("cards"), "Output JSON is missing 'cards' key");

            JSONArray cardsArray = jsonObject.getJSONArray("cards");
            Assertions.assertEquals(1, cardsArray.length(), "Incorrect number of cards in the JSON array");

            // Verify the card objects in the array
            JSONObject card1 = cardsArray.getJSONObject(0);
            Assertions.assertEquals("5567894523129089", card1.getString("cardNumber"), "Incorrect cardNumber value");
            Assertions.assertEquals("MasterCard", card1.getString("cardType"), "Incorrect cardType value");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}