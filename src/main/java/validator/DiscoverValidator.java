package validator;

import creditcard.CreditCardEntry;

public class DiscoverValidator implements Validator {
    private Validator next = null;

    public CreditCardEntry validate(CreditCardEntry record) {
        String ccNumber = record.getCardNumber();
        if (ccNumber.length() >=0 && ccNumber.length() <=19
                &&	ccNumber.substring(0, 4).equals("6011")
                && ccNumber.length() == 16
        ) {
            record.setCardType("Discover");
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
