package validator;

import creditcard.CreditCardEntry;

public class MasterValidator implements Validator {
    private Validator next = null;

    public CreditCardEntry validate(CreditCardEntry record) {
        String ccNumber = record.getCardNumber();
        if (ccNumber.length() >=0 && ccNumber.length() <=19
                && ccNumber.charAt(0) == '5'
                && (ccNumber.charAt(1)-'0') >=1 && (ccNumber.charAt(1)-'0') <=5
                && ccNumber.length() == 16
        ) {
            record.setCardType("MasterCard");
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
