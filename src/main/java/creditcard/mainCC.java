package creditcard;

import fileparser.FileParser;
import fileparser.FileParserFactory;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import outputwriter.OutputWriter;
import outputwriter.OutputWriterFactory;
import validator.AmexValidator;
import validator.DiscoverValidator;
import validator.MasterValidator;
import validator.VisaValidator;
import validator.Validator;

public class mainCC {
    public static void main(String[] args) {

        String iFileName = args[0];
        String oFileName = args[1];

        //String iFileName = "C:\\Users\\hegde\\Downloads\\input_file-1.csv";
        //String oFileName = "C:\\Users\\hegde\\Downloads\\my_output-file_2.csv";
        List<CreditCardEntry> records = null;
        List<CreditCardEntry> validatedRecords  = new ArrayList<>();;
        //CreditCardEntry record = null;

        System.out.println("Input File Name  : " + iFileName);
        System.out.println("Output File Name : " + oFileName);


        if(iFileName.endsWith("csv")) {
            FileParser inputeFileParser = FileParserFactory.getFileParser("csv");
            try {
                records = inputeFileParser.parseFile(iFileName);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else if(iFileName.endsWith("json")) {
            //Select JSON parser
            FileParser inputeFileParser = FileParserFactory.getFileParser("json");
            try {
                records = inputeFileParser.parseFile(iFileName);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else if(iFileName.endsWith("xml")) {
            //Select XML Parser
            FileParser inputeFileParser = FileParserFactory.getFileParser("xml");
            try {
                records = inputeFileParser.parseFile(iFileName);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        //Check if records enter the program correctly.
        /*
        for (Iterator<CreditCardEntry> iterator = records.iterator(); iterator.hasNext();){
            CreditCardEntry record = iterator.next();
            System.out.println(record);
        }*/

        System.out.println("=================================================================");
        //Iterate through the entries in records list and populate it with the valid and type result;
        Validator visaHandler = new VisaValidator();
        Validator masterHandler = new MasterValidator();
        Validator amexHandler = new AmexValidator();
        Validator discoverHandler = new DiscoverValidator();

        visaHandler.nextHandler(masterHandler);
        masterHandler.nextHandler(amexHandler);
        amexHandler.nextHandler(discoverHandler);


        for (Iterator<CreditCardEntry> iterator = records.iterator(); iterator.hasNext();){
            CreditCardEntry record = iterator.next();
            //System.out.println(record);
            String ccNumber = record.getCardNumber();
            Boolean toProcess = Boolean.TRUE;

            if((!ccNumber.matches("[0-9]+")) && (!ccNumber.equals(""))){
                //System.out.println("IT ENTERED REGEX SECTION!!!!!");
                record.setCardError(": non numeric characters");
                record.setCardValid(Boolean.FALSE);
                record.setCardType("Invalid: non numeric characters");
                toProcess = Boolean.FALSE;
            }
            if(toProcess==Boolean.TRUE && (ccNumber.length()>19) ){
                record.setCardError(": more than 19 characters");
                record.setCardValid(Boolean.FALSE);
                record.setCardType("Invalid: more than 19 characters");
                toProcess = Boolean.FALSE;
            }

            if(ccNumber.equals("")&& (toProcess==Boolean.TRUE)){
                record.setCardError(": empty/null Card number");
                record.setCardValid(Boolean.FALSE);
                record.setCardType("Invalid: empty/null Card number");
                toProcess = Boolean.FALSE;
            }

            if(!ccNumber.equals("") && (toProcess==Boolean.TRUE)){
            record = visaHandler.validate(record);  // Type Validator checks
            }
            if (record.getCardType() == null)
            {
                record.setCardError(": not a possible card");
                record.setCardValid(Boolean.FALSE);
                record.setCardType("Invalid: not a possible card");
            }
            if ((!record.getCardType().matches("Invalid.*")) && (toProcess==Boolean.TRUE))
            {
                record.setCardValid(Boolean.TRUE);
                record.setCardError("No Error");
            }
            //System.out.println("Validation DONE");
            //System.out.println(record.getCardNumber());
            //System.out.println(record.getCardType());


            if(!record.getCardNumber().equals("cardNumber")){
                //System.out.println("Before adding");
                //System.out.println(record.getCardNumber());
                //System.out.println(record.getCardType());
                //System.out.println(record.getCardError());
                validatedRecords.add(record);
            }

        }
        System.out.println("Processed Credit Card details:");
        System.out.println("============================================================");

        for (Iterator<CreditCardEntry> iterator = validatedRecords.iterator(); iterator.hasNext();){
            CreditCardEntry validatedRecord = iterator.next();
            System.out.println(validatedRecord);
        }


        //Call output writer to enter records into desired extension;

        if(oFileName.endsWith("csv")) {
            OutputWriter outputDocWriter = OutputWriterFactory.getOutputWriter("csv");
            try {
                outputDocWriter.writeOutput(oFileName, validatedRecords);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else if(iFileName.endsWith("json")) {
            //Select JSON parser
            OutputWriter outputDocWriter = OutputWriterFactory.getOutputWriter("json");
            try {
                outputDocWriter.writeOutput(oFileName, validatedRecords);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else if(iFileName.endsWith("xml")) {
            //Select XML Parser
            OutputWriter outputDocWriter = OutputWriterFactory.getOutputWriter("xml");
            try {
                outputDocWriter.writeOutput(oFileName, validatedRecords);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        //Generate Credit card objects for valid cards.
        List<CreditCard> FinalCreditCardObjList = new ArrayList<CreditCard>();
        CreditCardFactory factory = new CreditCardFactory();
        for (Iterator<CreditCardEntry> iterator = validatedRecords.iterator(); iterator.hasNext();){
            CreditCardEntry validatedRecord = iterator.next();
            if(validatedRecord.getCardValid()==Boolean.TRUE) {
                CreditCard creditcardobject = factory.createCreditCard(validatedRecord.getCardNumber(), validatedRecord.getCardExpDate(), validatedRecord.getCardHolderName(), validatedRecord.getCardType());
                FinalCreditCardObjList.add(creditcardobject);
            }
        }
        //print out the generated credict card objects.
        System.out.println("================================================================");
        System.out.println("Printing Credit card objects generated from valid entries");
        System.out.println("================================================================");
        for (Iterator<CreditCard> iterator = FinalCreditCardObjList.iterator(); iterator.hasNext();){
            CreditCard creditCardObject = iterator.next();
            System.out.println(creditCardObject.toString());
        }


    }

}
