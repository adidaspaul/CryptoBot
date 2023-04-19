package src.java.model;



import java.model.User;
import java.util.List;

public class Facade {

    CashService cashService = new CashService();

    public List<BankResponse> getResponseFromBank(User user){
        return cashService.getCashMonoBankCurrency();
    }
}
