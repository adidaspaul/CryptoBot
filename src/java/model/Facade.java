package java.model;

import java.model.User;
import java.model.CashService;

public class Facade {

    CashService cashService = new CashService();

    public List <BankResponse> getResponseFromBank(User user){
        return cashService.getCashMonoBankCurrency();
    }
}
