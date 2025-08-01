package src.java.model;

import java.math.BigDecimal;
import java.util.Objects;

public class CryptoReponseObject {

    private BigDecimal price;

    public CryptoReponseObject(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CryptoReponseObject that = (CryptoReponseObject) o;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return "CryptoReponseObject{" +
                "price in USD=" + price +
                '}';
    }
}
