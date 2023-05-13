package fileparser;

import creditcard.CreditCardEntry;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
public class CSVParser implements FileParser {
    public List<CreditCardEntry> parseFile(String iFileName) {
        String COMMA_DELIMITER = ",";
        String NEW_LINE_SEPARATOR = "\n";
        List<CreditCardEntry> preProcessCC = new ArrayList<CreditCardEntry>();
        try (BufferedReader br = new BufferedReader(new FileReader(iFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                //cardNumber,expirationDate,cardHolderName
                System.out.println("ENTRY FROM CSV : 0:"+values[0] +  "   1:" + values[1] + "   2:" + values[2]);
                //VALIDATE AND ADD
                CreditCardEntry cc = new CreditCardEntry();
                cc.setCardNumber(values[0]);
                cc.setCardExpDate(values[1]);
                cc.setCardHolderName(values[2]);
                preProcessCC.add(cc);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return preProcessCC;

    }


}
