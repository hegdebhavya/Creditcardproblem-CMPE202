package validator;
import validator.Validator;
import creditcard.CreditCardEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmexValidatorTest {

    @Test
    public void testValidate_ValidAmexCard() {
        AmexValidator amexValidator = new AmexValidator();
        //CreditCardEntry validAmexCard = new CreditCardEntry("378282246310005", "");

        CreditCardEntry validAmexCard = new CreditCardEntry();
        validAmexCard.setCardNumber("347856341908126");
        validAmexCard.setCardExpDate("03/23");
        validAmexCard.setCardHolderName("Jane S. Dayton");
        validAmexCard.setCardType("AmericanExpress");


        CreditCardEntry result = amexValidator.validate(validAmexCard);

        Assertions.assertEquals("AmericanExpress", result.getCardType());
    }

    @Test
    public void testValidate_InvalidAmexCard() {
        AmexValidator amexValidator = new AmexValidator();
        //CreditCardEntry invalidAmexCard = new CreditCardEntry("4111111111111111", "");

        CreditCardEntry invalidAmexCard = new CreditCardEntry();
        invalidAmexCard.setCardNumber("75431111111111111");
        invalidAmexCard.setCardExpDate("03/23");
        invalidAmexCard.setCardHolderName("Jane S. Dayton");




        CreditCardEntry result = amexValidator.validate(invalidAmexCard);

        Assertions.assertNull(result.getCardType());
    }




}