package fileparser;
import org.json.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import creditcard.CreditCardEntry;

import java.util.List;
import java.util.ArrayList;

public class JSONParser implements FileParser {
    public List<CreditCardEntry> parseFile(String iFileName) {
        List<CreditCardEntry> preProcessCC = new ArrayList<CreditCardEntry>();

        try(BufferedReader reader = new BufferedReader(new FileReader(iFileName))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            String jsonString = sb.toString();
            System.out.println(jsonString);

            // Parse JSON string
            System.out.println("It reaches here");
            JSONObject jsonObj = new JSONObject(jsonString);

            JSONArray cardsArr = jsonObj.getJSONArray("cards");

            System.out.println("It reaches here");
            // Process JSON array
            for (int i = 0; i < cardsArr.length(); i++) {
                JSONObject cardObject =cardsArr.getJSONObject(i);
                System.out.println(cardObject);
                String ccNumber = cardObject.optString("cardNumber");
                String ccExpDate = cardObject.optString("expirationDate");
                String ccName = cardObject.optString("cardHolderName");
                CreditCardEntry cc = new CreditCardEntry();
                cc.setCardNumber(ccNumber);
                cc.setCardExpDate(ccExpDate);
                cc.setCardHolderName(ccName);
                System.out.println(ccNumber);
                System.out.println(ccExpDate);
                System.out.println(ccName);
                preProcessCC.add(cc);
            }


        }catch(Exception e){System.out.println(e);}

        return preProcessCC;
    }


}
