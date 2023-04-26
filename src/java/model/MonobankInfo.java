package src.java.model;

import java.math.BigDecimal;
import java.util.Objects;

public class MonobankInfo {
    private int currencyCodeA;
    private int currencyCodeB;
    private int date;
    private BigDecimal rateCross;
    private BigDecimal rateBuy;
    private BigDecimal rateSell;


    public int getCurrencyCodeA() {
        return currencyCodeA;
    }

    public int getCurrencyCodeB() {
        return currencyCodeB;
    }

    public int getDate() {
        return date;
    }

    public BigDecimal getRateBuy() {
        return rateBuy;
    }

    public BigDecimal getRateSell() {
        return rateSell;
    }

    public BigDecimal getRateCross() {
        return rateCross;
    }

    public void setRateCross(BigDecimal rateCross) {
        this.rateCross = rateCross;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonobankInfo that = (MonobankInfo) o;
        return currencyCodeA == that.currencyCodeA
                && currencyCodeB == that.currencyCodeB
                && date == that.date
                && Objects.equals(rateBuy, that.rateBuy)
                && Objects.equals(rateCross, that.rateCross)
                && Objects.equals(rateSell, that.rateSell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyCodeA, currencyCodeB, date, rateBuy,rateCross, rateSell);
    }

    @Override
    public String toString() {
        return "MonobankInfo{" +
                "currencyCodeA=" + currencyCodeA +
                ", currencyCodeB=" + currencyCodeB +
                ", date=" + date +
                ", rateBuy=" + rateBuy +
                ", rateCross=" + rateCross +
                ", rateSell=" + rateSell +
                '}';
    }
}
