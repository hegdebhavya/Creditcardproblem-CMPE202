package creditcard;

public class MasterCC extends CreditCard {

    public MasterCC(String number, String date, String name) {
        super(number, date, name, "MasterCard");
    }

    public String toString() {
        return "MasterCard ["+super.getCardNumber()+"]";
    }
}
