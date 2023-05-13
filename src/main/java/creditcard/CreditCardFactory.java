package creditcard;

public class CreditCardFactory {
    public CreditCard createCreditCard(String number, String date, String name, String type) {
        if (type.equalsIgnoreCase("AmericanExpress")) {
            return new AmexCC(number, date, name);
        } else if (type.equalsIgnoreCase("Discover")) {
            return new DiscoverCC(number, date, name);
        } else if (type.equalsIgnoreCase("MasterCard")) {
            return new MasterCC(number, date, name);
        }else if (type.equalsIgnoreCase("Visa")) {
            return new VisaCC(number, date, name);
        }else {
            return new CreditCard(number, date, name, "Unknown");
        }
    }
}
