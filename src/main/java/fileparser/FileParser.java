package fileparser;

import creditcard.CreditCardEntry;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileParser {
    List<CreditCardEntry> parseFile (String iFileName) throws FileNotFoundException;
}
