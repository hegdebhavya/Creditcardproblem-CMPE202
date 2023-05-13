package validator;

import creditcard.CreditCardEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MasterValidatorTest {
    public void testValidate_ValidMasterCard() {
        MasterValidator MasterValidator = new MasterValidator();

        CreditCardEntry validMasterCard = new CreditCardEntry();
        validMasterCard.setCardNumber("5567894523129089");
        validMasterCard.setCardExpDate("08/26");
        validMasterCard.setCardHolderName("John Doe");
        validMasterCard.setCardType("MasterCard");


        CreditCardEntry result = MasterValidator.validate(validMasterCard);

        Assertions.assertEquals("MasterCard", result.getCardType());
    }

    @Test
    public void testValidate_InvalidMasterCard() {
        MasterValidator MasterValidator = new MasterValidator();
        CreditCardEntry invalidMasterCard = new CreditCardEntry();
        invalidMasterCard.setCardNumber("347856341908126");
        invalidMasterCard.setCardExpDate("02/24");
        invalidMasterCard.setCardHolderName("John Doe");


        CreditCardEntry result = MasterValidator.validate(invalidMasterCard);

        Assertions.assertNull(result.getCardType());
    }
}