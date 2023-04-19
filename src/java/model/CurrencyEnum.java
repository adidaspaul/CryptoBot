package src.java.model;

public enum CurrencyEnum {

    CAD(124, "CAD"),

    USD(840,"USD");

    private final int intCode;
    private final String letterCode;

    public int getIntCode() {
        return intCode;
    }

    public String getLetterCode() {
        return letterCode;
    }

    CurrencyEnum(int intCode, String letterCode) {
        this.intCode = intCode;
        this.letterCode = letterCode;
    }



}
