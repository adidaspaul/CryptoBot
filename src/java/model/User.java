package java.model;

import java.util.Objects;

public class User {

    private Long chatId;
    private byte decimalDigit;
    private boolean solana;
    private boolean ether;
    private boolean btc;
    private boolean ua;
    private boolean cad;
    private boolean notification;
    private byte notificationTime;

    public User(Long chatId) {
        this.chatId = chatId;
        this.decimalDigit = 2;
        this.btc = true;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public byte getDecimalDigit() {
        return decimalDigit;
    }

    public void setDecimalDigit(byte decimalDigit) {
        this.decimalDigit = decimalDigit;
    }


}
