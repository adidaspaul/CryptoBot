package java.model;

import org.telegram.telegrambots.meta.api.objects.Message;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static UserService userService;
    private Facade facade = new Facade();

    public static UserService getUserService() {
        return userService;
    }

    public List<User> getUserList() {
        return userList;
    }

    private List<User> userList;

    private UserService() {
        this.userList = new ArrayList<>();
    }

    public static UserService create() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public User getUser(Message message) {
        for (User user : userList) {
            if (user.getChatId().equals(message.getChatId())) {
                return user;
            }
        }
        return null;
    }

    public void addUser(Message message) {
        User userTemp = null;
        for (User user : userList) {
            if (user.getChatId().equals(message.getChatId())) {
                userTemp = user;
            }
        }
        if (userTemp == (null)) {
            userList.add(new User(message.getChatId()));
        }
    }

    public String getInfo(Message message) {
        BigDecimal usdBuy = new BigDecimal("0.0");
        BigDecimal usdSell = new BigDecimal("0.0");
        User user = getUser(message);
        StringBuilder result = new StringBuilder();
        List<BankResponse> bank = facade.getResponseFromBank(getUser(message));
        result.append("Rate is ").append(user.getSelectedBank());
        if (user.isCad()) {
            for (BankResponse bankResponse : bank) {
                if (bankREsponse.getCurrency().equals(CurrencyEnum.CAD.getCodeString())) {
                    result.append("\nCAD/UAH").append("\nBUY: ").append(new BigDecimal(bankResponse.getBuyRate().setScale(user.getDecimalDigit(), RoundingMode.DOWN).toString()))
                            .append("\nSell: ").append(new BigDecimal(bankResponse.getSellRate().setScale(user.getDecimalDigit(), RoundingMode.DOWN).toString()));
                }
            }
        }
        if(user.isBtc()){
            for(BankResponse bankResponse : bank){
                if(bankResponse.getCurrency().equals(CurrencyEnum.BTC.getCodeString())){
                    result.append("\nBTC/CAD").append("\nBUY: ").append(new BigDecimal(bankResponse.getBuyRate().setScale(user.getDecimalDigit(),RoundingMode.DOWN).toString()))
                            .append("\nSell: ").append(new BigDecimal(bankResponse.getSellRate().setScale(user.getDecimalDigit(),RoundingMode.DOWN).toString()));
                }
            }
        }
        if(user.isEther()){
            for(BankResponse bankResponse : bank){
                if(bankResponse.getCurrency().equals(CurrencyEnum.ETC.getCodeString())){
                    result.append("\nETC/CAD").append("\nBuy").append(new BigDecimal(bankResponse.getBuyRate().setScale(user.getDecimalDigit(), RoundingMode.DOWN).toString()))
                            .append("\nSell").append(new BigDecimal(bankResponse.getSellRate().setScale(user.getDecimalDigit(),RoundingMode.DOWN).toString()));
                }
            }
        }
        if(user.isSolana()){
            for(BankResponse bankResponse : bank){
                if(bankResponse.getCurrency().equals(CurrencyEnum.SOL.getCodeString())){
                    result.append("\nSOL/CAD").append("\nBuy: ").append(new BigDecimal(bankResponse.getBuyRate().setScale(user.getDecimalDigit(), RoundingMode.DOWN).toString()))
                            .append("\nSell: ").append(new BigDecimal(bankResponse.getSellRate().setScale(user.getDecimalDigit(),RoundingMode.DOWN).toString()));
                }
            }
        }
        if(user.isUah()){
            for(BankResponse bankResponse : bank){
                if(bankResponse.getCurrency().equals(CurrencyEnum.UAH.getCodeString())){
                    result.append("\nUAH/CAD").append("\nBuy: ").append(new BigDecimal(bankResponse.getBuyRate().setScale(user.getDecimalDigit(), RoundingMode.DOWN).toString()))
                            .append("\nSell: ").append(new BigDecimal(bankResponse.getSellRate().setScale(user.getDecimalDigit(),RoundingMode.DOWN).toString()));
                }
            }
        }
        return result.toString();
    }


    public void changeSchedule(Message message, byte time){
        getUser(message).setNotificationTime(time);
    }

    public void changeCurrencyCAD(Message message){
        if(getUser(message).isCad()){
            getUser(message).setCad(false);
        }
        else if(!getUser(message).isCad()){
            getUser(message).setCad(true);
        }
    }

    public void changeCurrencyUAH(Message message){
        if(getUser(message).isUah()){
            getUser(message).setUah(false);
        }
        else if(!getUser(message).isUah()){
            getUser(message).setUah(true);
        }
    }

    public void changeCurrencyBtc(Message message){
        if(getUser(message).isBtc()){
            getUser(message).setBtc(false);
        }
        else if(!getUser(message).isBtc()){
            getUser(message).setBtc(true);
        }
    }

    public void changeCurrencyETC(Message message){
        if(getUser(message).isEther()){
            getUser(message).setEther(false);
        }
        else if(!getUser(message).isEther()){
            getUser(message).setEther(true);
        }
    }

    public void changeCurrencySOL(Message message){
        if(getUser(message).isSolana()){
            getUser(message).setSolana(false);
        }
        else if(!getUser(message).isSolana()){
            getUser(message).setSolana(true);
        }
    }
}
