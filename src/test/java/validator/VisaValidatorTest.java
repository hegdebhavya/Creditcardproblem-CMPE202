package validator;

import creditcard.CreditCardEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisaValidatorTest {

    public void testValidate_ValidVisa() {
        VisaValidator VisaValidator = new VisaValidator();

        CreditCardEntry validVisa = new CreditCardEntry();
        validVisa.setCardNumber("4123456789123");
        validVisa.setCardExpDate("04/26");
        validVisa.setCardHolderName("Martha Clark");
        validVisa.setCardType("Visa");


        CreditCardEntry result = VisaValidator.validate(validVisa);

        Assertions.assertEquals("Visa", result.getCardType());
    }

    @Test
    public void testValidate_InvalidVisa() {
        VisaValidator VisaValidator = new VisaValidator();
        CreditCardEntry invalidVisa = new CreditCardEntry();
        invalidVisa.setCardNumber("347856341908126");
        invalidVisa.setCardExpDate("02/24");
        invalidVisa.setCardHolderName("John Doe");


        CreditCardEntry result = VisaValidator.validate(invalidVisa);

        Assertions.assertNull(result.getCardType());
    }
}