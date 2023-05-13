package creditcard;

public class CreditCardEntry {
    private String ccNumber;
    private String ccExpDate;
    private String ccHolderName;
    private String ccType;
    private Boolean ccValid;
    private String ccError;

    //Getters
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
    public Boolean getCardValid() {
        return ccValid;
    }
    public String getCardError() {
        return ccError;
    }

    //Setters
    public void setCardNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }
    public void setCardExpDate(String ccExpDate) {
        this.ccExpDate= ccExpDate;
    }
    public void setCardHolderName(String ccHolderName) {
        this.ccHolderName = ccHolderName;
    }
    public void setCardType(String ccType) {
        this.ccType =  ccType;
    }
    public void setCardValid(Boolean ccValid) {
        this.ccValid = ccValid;
    }
    public void setCardError(String ccError) {
        this.ccError = ccError;
    }

    //override the default toString
    public String toString() {
        String s = "Credit Card Number = " + ccNumber + ", Card Type = " + ccType + ", Card Validity = " + ccValid;
        if (ccError == null){
            return s; }
        else {
            return (s + " , Error = " + ccError +" "); }
        }
}

