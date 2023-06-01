package src.java.model;


import org.telegram.telegrambots.meta.api.objects.Message;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static UserService userService;
    private Facade facade = new Facade();

    private List<User> userList;

    public static UserService getUserService() {
        return userService;
    }

    public List<User> getUserList() {
        return userList;
    }


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
        List <BankResponse> bank = facade.getResponseFromBank(getUser(message));
        result.append("Rate is ").append(user.getSelectedBank());
        if (user.isCad()) {
            for (BankResponse bankResponse : bank) {
                if (bankResponse.getCurrency().equals(CurrencyEnum.CAD.getLetterCode())) {
                    result.append("\nCAD/UAH").append("\nPrice: ").append(new BigDecimal(bankResponse.getRateCross().setScale(user.getDecimalDigit(), RoundingMode.DOWN).toString()));
                }
            }
        }
        if(user.isBtc()){
            for(BankResponse bankResponse : bank){
                if(bankResponse.getCurrency().equals(CryptoEnum.BTC.getName())){
                    result.append("\nBTC/USD").append("\nPrice: ").append(new BigDecimal(bankResponse.getBuyRate().setScale(user.getDecimalDigit(),RoundingMode.DOWN).toString()));
                }
            }
        }
        if(user.isEther()){
            for(BankResponse bankResponse : bank){
                if(bankResponse.getCurrency().equals(CryptoEnum.ETC.getName())){
                    result.append("\nETC/USD").append("\nPrice").append(new BigDecimal(bankResponse.getBuyRate().setScale(user.getDecimalDigit(), RoundingMode.DOWN).toString()));
                }
            }
        }
        if(user.isSolana()){
            for(BankResponse bankResponse : bank){
                if(bankResponse.getCurrency().equals(CryptoEnum.SOL.getName())){
                    result.append("\nSOL/CAD").append("\nBuy: ").append(new BigDecimal(bankResponse.getBuyRate().setScale(user.getDecimalDigit(), RoundingMode.DOWN).toString()));
                }
            }
        }
        return result.toString();
    }

    public void changeCurrencyCAD(Message message){
        if(getUser(message).isCad()){
            getUser(message).setCad(false);
        }
        else if(!getUser(message).isCad()){
            getUser(message).setCad(true);
        }
    }

    public void changeCurrencyUSD(Message message){
        if(getUser(message).isUsd()){
            getUser(message).setUsd(false);
        }
        else if(!getUser(message).isUsd()){
            getUser(message).setUsd(true);
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

    public void changeSchedule(Message message,byte time){
        getUser(message).setNotificationTime(time);
    }

    public void changeDecimalDigit(Message message,byte digit){
        getUser(message).setDecimalDigit(digit);
    }
}
