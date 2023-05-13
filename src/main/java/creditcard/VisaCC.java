package creditcard;

public class VisaCC extends CreditCard {

    public VisaCC(String number, String date, String name) {
        super(number, date, name, "Visa");
    }

    public String toString() {
        return "Visa ["+super.getCardNumber()+"]";
    }
}
