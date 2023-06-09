package src.java.model;

public enum CryptoEnum {

    BTC("Bitcoin","BTCUSDT", "bitcoin", "USD","BTC"),
    ETC("Ethereum","ETHUSDT", "ethereum", "USD", "ETC"),
    SOL("Solana","SOLUSDT","solana", "USD", "SOL");



    private final String binancePair;
    private final String name;
    private final String geckoFirstId;
    private final String geckoCryptoSecondId;

    private final String cryptoCompareFirstId;
    CryptoEnum(String name,String binancePair, String geckoFirstId, String geckoCryptoSecondId, String cryptoCompareFirstId){
        this.binancePair = binancePair;
        this.name = name;
        this.geckoFirstId = geckoFirstId;
        this.geckoCryptoSecondId = geckoCryptoSecondId;
        this.cryptoCompareFirstId = cryptoCompareFirstId;
    }

    public String getBinancePair() {
        return binancePair;
    }


    public String getName() {
        return name;
    }

    public String getGeckoFirstId() {
        return geckoFirstId;
    }

    public String getGeckoCryptoSecondId() {
        return geckoCryptoSecondId;
    }

    public String getCryptoCompareFirstId() {
        return cryptoCompareFirstId;
    }
}
