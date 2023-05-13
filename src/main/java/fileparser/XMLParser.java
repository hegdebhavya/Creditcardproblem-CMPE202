package fileparser;

import creditcard.CreditCardEntry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser implements FileParser {
    public List<CreditCardEntry> parseFile(String iFileName) throws FileNotFoundException {
        List<CreditCardEntry> preProcessCC = new ArrayList<CreditCardEntry>();
        File file = new File(iFileName);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            document = factory.newDocumentBuilder().parse(inputStream);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

        NodeList cardList = document.getElementsByTagName("CARD");


        for (int i = 0; i < cardList.getLength(); i++) {
            Node cardNode = cardList.item(i);
            if (cardNode.getNodeType() == Node.ELEMENT_NODE) {
                Element cardElement = (Element) cardNode;
                String cardNumber = cardElement.getElementsByTagName("CARD_NUMBER").item(0).getTextContent();
                String expirationDate = cardElement.getElementsByTagName("EXPIRATION_DATE").item(0).getTextContent();
                String cardHolderName = cardElement.getElementsByTagName("CARD_HOLDER_NAME").item(0).getTextContent();
                CreditCardEntry cc = new CreditCardEntry();
                cc.setCardNumber(cardNumber);
                cc.setCardExpDate(expirationDate);
                cc.setCardHolderName(cardHolderName);
                preProcessCC.add(cc);

            }
        }

        for (CreditCardEntry cardData : preProcessCC) {
            System.out.println(cardData.toString());
        }

    return preProcessCC;
    }}



