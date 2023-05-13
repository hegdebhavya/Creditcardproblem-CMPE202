package outputwriter;

import creditcard.CreditCardEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVOutputWriterTest {

    @Test
    void writeOutput() {
        String oFileName = "src/test/testresources/output.csv";

        List<CreditCardEntry> validatedRecords = new ArrayList<>();
        CreditCardEntry firstEntry = new CreditCardEntry();
        firstEntry.setCardNumber("5567894523129089");
        firstEntry.setCardExpDate("08/26");
        firstEntry.setCardHolderName("John Doe");
        firstEntry.setCardType("MasterCard");

        validatedRecords.add(firstEntry);

        CSVOutputWriter csvOutputWriter = new CSVOutputWriter();
        csvOutputWriter.writeOutput(oFileName, validatedRecords);

        // Verify that the file was created
        File outputFile = new File(oFileName);
        Assertions.assertTrue(outputFile.exists(), "Output file does not exist");

        // Verify the contents of the file
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            int lineNumber = 0;
            String[] expectedHeader = { "cardNumber", "cardType" };
            String[] expectedRow1 = { "5567894523129089", "MasterCard" };

            // Verify the header
            line = reader.readLine();
            line = line.replaceAll("\"", "");
            lineNumber++;
            Assertions.assertEquals(String.join(",", expectedHeader), line, "Incorrect header at line " + lineNumber);


            // Verify the first row
            line = reader.readLine();
            line = line.replaceAll("\"", "");
            lineNumber++;
            Assertions.assertEquals(String.join(",", expectedRow1), line, "Incorrect row at line " + lineNumber);

            // Verify no additional lines
            line = reader.readLine();
            lineNumber++;
            Assertions.assertNull(line, "Unexpected extra line at line " + lineNumber);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}