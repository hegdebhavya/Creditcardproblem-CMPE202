package creditcard;

public class AmexCC extends CreditCard {

    public AmexCC(String number, String date, String name) {
        super(number, date, name, "AmericanExpress");
    }

    public String toString() {
        return "AmericanExpress ["+super.getCardNumber()+"]";
    }
}
