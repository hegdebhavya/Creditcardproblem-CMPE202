package outputwriter;

import creditcard.CreditCardEntry;

import java.io.FileNotFoundException;
import java.util.List;

public interface OutputWriter {
        void writeOutput (String oFileName, List<CreditCardEntry> validatedRecords) throws FileNotFoundException;

}
