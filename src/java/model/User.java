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

    public boolean isCad(){
        return cad;
    }

    public void setCad(boolean cad){
        this.cad = cad;
    }

    public boolean isUa() {
        return ua;
    }

    public void setUa(boolean ua) {
        this.ua = ua;
    }

    public boolean isBtc() {
        return btc;
    }

    public void setBtc(boolean btc) {
        this.btc = btc;
    }

    public boolean isEther() {
        return ether;
    }

    public void setEther(boolean ether) {
        this.ether = ether;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    public boolean isSolana() {
        return solana;
    }

    public void setSolana(boolean solana) {
        this.solana = solana;
    }

    public byte getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(byte notificationTime) {
        this.notificationTime = notificationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return decimalDigit == user.decimalDigit && solana == user.solana && ether == user.ether && btc == user.btc && ua == user.ua && cad == user.cad && notification == user.notification && notificationTime == user.notificationTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, decimalDigit, solana, ether, btc, ua, cad, notification, notificationTime);
    }

    @Override
    public String toString() {
        return "User{" +
                "chatId=" + chatId +
                ", decimalDigit=" + decimalDigit +
                ", solana=" + solana +
                ", ether=" + ether +
                ", btc=" + btc +
                ", ua=" + ua +
                ", cad=" + cad +
                ", notification=" + notification +
                ", notificationTime=" + notificationTime +
                '}';
    }
}
