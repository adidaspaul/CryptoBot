package src.java.model;



import src.java.model.User;
import java.util.List;

public class Facade {

    CashService cashService = new CashService();

    public List<BankResponse> getResponseFromBank(User user){
        return switch (user.getSelectedBank()) {
            case "MonoBank" -> cashService.getCashMonoBankCurrency();
            case "Binance" -> cashService.getBinanceCrypto();
            case "Coingecko" -> cashService.getGeckoCrypto();
            case "CryptoCompare" -> cashService.getCompareCrypto();
            default -> cashService.getBinanceCrypto();
        };
    }
}
