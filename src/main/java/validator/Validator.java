package validator;

import creditcard.CreditCardEntry;

public interface Validator {
    public CreditCardEntry validate(CreditCardEntry ccNumber);
    public void nextHandler(Validator next);
}
