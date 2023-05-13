package validator;

import creditcard.CreditCardEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscoverValidatorTest {

    public void testValidate_ValidDiscoverCard() {
        DiscoverValidator discoverValidator = new DiscoverValidator();

        CreditCardEntry validDiscoverCard = new CreditCardEntry();
        validDiscoverCard.setCardNumber("6011111100007756");
        validDiscoverCard.setCardExpDate("02/24");
        validDiscoverCard.setCardHolderName("John Doe");
        validDiscoverCard.setCardType("Discover");


        CreditCardEntry result = discoverValidator.validate(validDiscoverCard);

        Assertions.assertEquals("Discover", result.getCardType());
    }

    @Test
    public void testValidate_InvalidDiscoverCard() {
        DiscoverValidator discoverValidator = new DiscoverValidator();
        CreditCardEntry invalidDiscoverCard = new CreditCardEntry();
        invalidDiscoverCard.setCardNumber("347856341908126");
        invalidDiscoverCard.setCardExpDate("02/24");
        invalidDiscoverCard.setCardHolderName("John Doe");


        CreditCardEntry result = discoverValidator.validate(invalidDiscoverCard);

        Assertions.assertNull(result.getCardType());
    }
}