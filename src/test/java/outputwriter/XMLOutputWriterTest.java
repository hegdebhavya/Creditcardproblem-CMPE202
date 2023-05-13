package outputwriter;

import creditcard.CreditCardEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XMLOutputWriterTest {

    @Test
    void writeOutput() {
        String oFileName = "src/test/testresources/output.xml";

        List<CreditCardEntry> validatedRecords = new ArrayList<>();
        CreditCardEntry firstEntry = new CreditCardEntry();
        firstEntry.setCardNumber("5567894523129089");
        firstEntry.setCardExpDate("08/26");
        firstEntry.setCardHolderName("John Doe");
        firstEntry.setCardType("MasterCard");

        validatedRecords.add(firstEntry);

        XMLOutputWriter xmlOutputWriter = new XMLOutputWriter();
        xmlOutputWriter.writeOutput(oFileName, validatedRecords);

        // Verify that the file was created
        File outputFile = new File(oFileName);
        Assertions.assertTrue(outputFile.exists(), "Output file does not exist");

        // Verify the contents of the file
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            StringBuilder xmlStringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                xmlStringBuilder.append(line);
            }

            String xmlString = xmlStringBuilder.toString();

            // Parse the XML string and verify its structure
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlString)));

            Element rootElement = document.getDocumentElement();
            Assertions.assertEquals("CARDS", rootElement.getNodeName(), "Incorrect root element");

            NodeList cardList = rootElement.getElementsByTagName("CARD");
            Assertions.assertEquals(1, cardList.getLength(), "Incorrect number of cards");

            // Verify the card elements
            Element card1 = (Element) cardList.item(0);
            Element cardNumber1 = (Element) card1.getElementsByTagName("CARD_NUMBER").item(0);
            Element cardType1 = (Element) card1.getElementsByTagName("CARD_TYPE").item(0);
            Assertions.assertEquals("5567894523129089", cardNumber1.getTextContent(), "Incorrect cardNumber value");
            Assertions.assertEquals("MasterCard", cardType1.getTextContent(), "Incorrect cardType value");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}