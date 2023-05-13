package validator;

import creditcard.CreditCardEntry;

public class VisaValidator implements Validator {
    private Validator next = null;
    public CreditCardEntry validate(CreditCardEntry record){
        String ccNumber = record.getCardNumber();
        if (ccNumber == null){
            record.setCardError("Invalid Card Number");
            return record;
        }

        try {
            if (ccNumber.length() >= 0 && ccNumber.length() <= 19
                    && ccNumber.charAt(0) == '4'
                    && (ccNumber.length() == 13 || ccNumber.length() == 16)
            ) {
                record.setCardType("Visa");
                return record;
            } else {
                if (next != null) {
                    return next.validate(record);
                }
            }

        }
        catch (Exception e){ };
        return record;
    }
    public void nextHandler(Validator next){
        this.next = next;
    }
}
