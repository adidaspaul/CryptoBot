package src.java.model;

import java.math.BigDecimal;

public class CryptoResponse {

    private String platformName;
    private String crypto;
    private BigDecimal usdRate;

    public CryptoResponse(String platformName, String crypto, BigDecimal usdRate) {
        this.platformName = platformName;
        this.crypto = crypto;
        this.usdRate = usdRate;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getCrypto() {
        return crypto;
    }

    public void setCrypto(String crypto) {
        this.crypto = crypto;
    }

    public BigDecimal getUsdRate() {
        return usdRate;
    }

    public void setUsdRate(BigDecimal usdRate) {
        this.usdRate = usdRate;
    }
}
