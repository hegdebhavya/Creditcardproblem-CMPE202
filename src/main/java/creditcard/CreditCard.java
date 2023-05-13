package creditcard;

public class CreditCard {
    private String ccNumber;
    private String ccExpDate;
    private String ccHolderName;
    private String ccType;
    public CreditCard() {
        super();
    }
    public CreditCard(String number, String date, String name, String type){
        this.ccNumber = number;
        this.ccExpDate = date;
        this.ccHolderName = name;
        this.ccType = type;
    };
    public CreditCard(String number, String date, String name){
        this.ccNumber = number;
        this.ccExpDate = date;
        this.ccHolderName = name;
    };

    public String getCardNumber() {
        return ccNumber;
    }
    public String getCardExpDate() {
        return ccExpDate;
    }
    public String getCardHolderName() {
        return ccHolderName;
    }
    public String getCardType() {
        return ccType;
    }


    //Setters
    public void setCardNumber() {
        this.ccNumber = ccNumber;
    }
    public void setCardExpDate() {
        this.ccExpDate= ccExpDate;
    }
    public void setCardHolderName() {
        this.ccHolderName = ccHolderName;
    }
    public void setCardType() {
        this.ccType =  ccType;
    }

}
