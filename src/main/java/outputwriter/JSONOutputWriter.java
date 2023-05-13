package outputwriter;
import org.json.JSONArray;
import org.json.JSONObject;
import creditcard.CreditCardEntry;
import fileparser.FileParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import java.io.FileNotFoundException;
import java.util.List;

public class JSONOutputWriter implements OutputWriter {

    public void writeOutput(String oFileName,List<CreditCardEntry> validatedRecords) {
        JSONArray cardsJson = new JSONArray();


        // Convert the card data to JSON objects and add them to the array
        for (CreditCardEntry record : validatedRecords) {
            JSONObject cardJson = new JSONObject();
            cardJson.put("cardNumber", record.getCardNumber());
            cardJson.put("cardType", record.getCardType());
            cardsJson.put(cardJson);
        }

        // Create a JSON object to hold the cards array
        JSONObject outputJson = new JSONObject();
        outputJson.put("cards", cardsJson);

        // Write the output JSON string to a file
        try (FileWriter file = new FileWriter(oFileName)) {
            file.write(outputJson.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}