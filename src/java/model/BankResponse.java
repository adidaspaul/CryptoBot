package src.java.model;

import java.math.BigDecimal;

public class BankResponse {

private String bankName;
private String currency;
private BigDecimal buyRate;
private BigDecimal sellRate;

    public BankResponse(String bankName, String currency, BigDecimal buyRate, BigDecimal sellRate) {
        this.bankName = bankName;
        this.currency = currency;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
    }

    public String getBankName() {
        return bankName;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getBuyRate() {
        return buyRate;
    }

    public BigDecimal getSellRate() {
        return sellRate;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setBuyRate(BigDecimal buyRate) {
        this.buyRate = buyRate;
    }

    public void setSellRate(BigDecimal sellRate) {
        this.sellRate = sellRate;
    }
}
