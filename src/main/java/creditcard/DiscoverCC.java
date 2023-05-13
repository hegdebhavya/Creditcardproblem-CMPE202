package creditcard;

public class DiscoverCC extends CreditCard {

    public DiscoverCC(String number, String date, String name) {
        super(number, date, name, "Discover");
    }

    public String toString() {
        return "Discover ["+super.getCardNumber()+"]";
    }
}
