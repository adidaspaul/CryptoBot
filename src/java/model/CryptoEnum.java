package src.java.model;

public enum CryptoEnum {

    BTC("BTCUSDT", "Bitcoin","bitcoin", "USD","BTC"),
    ETC("ETCUSDT", "Ethereum","ethereum-classic", "USD", "ETC"),
    SOL("SOLUSDT", "Solana","solana", "USD", "SOL");



    private final String binancePair;
    private final String name;
    private final String geckoFirstId;
    private final String geckoCryptoSecondId;

    private final String cryptoCompareFirstId;
    CryptoEnum(String binancePair, String name, String geckoFirstId, String geckoCryptoSecondId, String cryptoCompareFirstId){
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
