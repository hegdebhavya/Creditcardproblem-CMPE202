package validator;

import creditcard.CreditCardEntry;

public class AmexValidator implements Validator {
    private Validator next = null;

    public CreditCardEntry validate(CreditCardEntry record) {
        String ccNumber = record.getCardNumber();
        if (    ccNumber.length() >=0 && ccNumber.length() <=19
                && ccNumber.charAt(0) == '3'
                && (ccNumber.charAt(1) =='4'|| ccNumber.charAt(1) == '7')
                && ccNumber.length() == 15
        ) {
            record.setCardType("AmericanExpress");
            return record;
        } else {
            if (next != null) {
                return next.validate(record);
            }
        }
        return record;
    }
    public void nextHandler(Validator next) {
        this.next = next;
    }
}
