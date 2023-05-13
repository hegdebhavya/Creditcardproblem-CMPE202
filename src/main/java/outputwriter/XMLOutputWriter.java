package outputwriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import creditcard.CreditCardEntry;
import fileparser.FileParser;

import java.io.FileNotFoundException;
import java.util.List;

public class XMLOutputWriter implements OutputWriter {

    public void writeOutput(String oFileName,List<CreditCardEntry> validatedRecords) {


        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Create the root element <CARDS>
            Element rootElement = doc.createElement("CARDS");
            doc.appendChild(rootElement);

            // Create a <CARD> element for each card in the list and add it to the root element
            for (CreditCardEntry record : validatedRecords) {
                Element cardElement = doc.createElement("CARD");
                rootElement.appendChild(cardElement);

                // Add a <CARD_NUMBER> element with the card number as its text content
                Element cardNumberElement = doc.createElement("CARD_NUMBER");
                cardNumberElement.appendChild(doc.createTextNode(record.getCardNumber()));
                cardElement.appendChild(cardNumberElement);

                // Add a <CARD_TYPE> element with the card type as its text content
                Element cardTypeElement = doc.createElement("CARD_TYPE");
                cardTypeElement.appendChild(doc.createTextNode(record.getCardType()));
                cardElement.appendChild(cardTypeElement);
            }

            // Write the XML document to a file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(oFileName));
            transformer.transform(source, result);

            System.out.println("XML file created successfully!");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }

    }

}