package outputwriter;

import creditcard.CreditCardEntry;
import fileparser.FileParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.io.FileWriter;
import com.opencsv.CSVWriter;
public class CSVOutputWriter implements OutputWriter {

    public void writeOutput(String oFileName, List<CreditCardEntry> validatedRecords) {
        String csvFile = oFileName;
        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter(csvFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] header = { "cardNumber", "cardType" };
        writer.writeNext(header);

        for (Iterator<CreditCardEntry> iterator = validatedRecords.iterator(); iterator.hasNext();){
            CreditCardEntry validatedRecord = iterator.next();
            //System.out.println(validatedRecord);
            String[] row = { validatedRecord.getCardNumber(), validatedRecord.getCardType() };
            writer.writeNext(row);
        }

        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("CSV file written successfully!");

    }

}