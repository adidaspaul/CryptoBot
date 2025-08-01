package src.java.controller;


import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import src.java.model.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Keyboard {

    UserService userService = UserService.create();

    List<List<InlineKeyboardButton>> getMainMenu() {
        List<List<InlineKeyboardButton>> menu = new ArrayList<>();
        menu.add(Arrays.asList(
                InlineKeyboardButton.builder()
                        .text("Get Info")
                        .callbackData("get_info")
                        .build()));
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Settings")
                                .callbackData("settings")
                                .build()));
        return menu;
    }

    public List<List<InlineKeyboardButton>> getSettings() {
        List<List<InlineKeyboardButton>> settingsMenu = new ArrayList<>();
        settingsMenu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Decimal Digits")
                                .callbackData("decimal_digit")
                                .build()));

        settingsMenu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Banks")
                                .callbackData("banks")
                                .build()));

        settingsMenu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Currencies")
                                .callbackData("currency")
                                .build()));

        settingsMenu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Notification Time")
                                .callbackData("schedule")
                                .build()));

        settingsMenu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Main Menu")
                                .callbackData("/start")
                                .build()));
        return settingsMenu;
    }

    public List<List<InlineKeyboardButton>> getDecimalPoint(Message message) {
        List<List<InlineKeyboardButton>> menu = new ArrayList<>();
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).getDecimalDigit() == (byte) 2 ? "✅2" : "2")
                                .callbackData("/2")
                                .build()));

        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).getDecimalDigit() == (byte) 3 ? "✅3" : "3")
                                .callbackData("/3")
                                .build()));

        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).getDecimalDigit() == (byte) 4 ? "✅4" : "4")
                                .callbackData("/4")
                                .build()));

        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Main Menu")
                                .callbackData("/start")
                                .build()));

        return menu;
    }

    public List<List<InlineKeyboardButton>> getBankMenu(Message message) {
        List<List<InlineKeyboardButton>> menu = new ArrayList<>();
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton
                                .builder()
                                .text(userService.getUser(message).getSelectedBank().equalsIgnoreCase("Monobank") ? "✅Monobank" : "Monobank")
                                .callbackData("Monobank")
                                .build()));

        menu.add(
                Arrays.asList(
                        InlineKeyboardButton
                                .builder()
                                .text(userService.getUser(message).getSelectedBank().equalsIgnoreCase("Binance") ? "✅Binance" : "Binannce")
                                .callbackData("Binance")
                                .build()));

        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).getSelectedBank().equalsIgnoreCase("CoinGecko") ? "✅Coingecko" : "Coingecko")
                                .callbackData("Coingecko")
                                .build()));

        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).getSelectedBank().equalsIgnoreCase("Crypto Compare") ? "✅Crypto Compare" : "Crypto Compare")
                                .callbackData("CryptoCompare")
                                .build()));

        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Main Menu")
                                .callbackData("/start")
                                .build()));

        return menu;

    }

    public List<List<InlineKeyboardButton>> getCurrencyMenu(Message message) {
        List<List<InlineKeyboardButton>> menu = new ArrayList<>();
        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).isCad() ? "✅CAD" : "CAD")
                                .callbackData("CAD")
                                .build()));

        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).isUsd() ? "✅USD" : "USD")
                                .callbackData("USD")
                                .build()));

        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).isBtc() ? "✅BTC" : "BTC")
                                .callbackData("BTC")
                                .build()));

        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).isEther() ? "✅ETC" : "ETC")
                                .callbackData("ETC")
                                .build()));

        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text(userService.getUser(message).isSolana() ? "✅SOL" : "SOL")
                                .callbackData("SOL")
                                .build()));

        menu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Main Menu")
                                .callbackData("/start")
                                .build()));
        return menu;
    }

    public List<List<InlineKeyboardButton>> getTimeAlert(Message message) {

        byte time = userService.getUser(message).getNotificationTime();
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();


        InlineKeyboardButton button14 = new InlineKeyboardButton();
        button14.setText(time == 7 ? "✅07:00" : "07:00");
        button14.setCallbackData("07:00");

        InlineKeyboardButton button13 = new InlineKeyboardButton();
        button13.setText(time == 8 ? "✅08:00" : "08:00");
        button13.setCallbackData("08:00");

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(time == 9 ? "✅09:00" : "09:00");
        button1.setCallbackData("09:00");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText(time == 10 ? "✅10:00" : "10:00");
        button2.setCallbackData("10:00");

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText(time == 11 ? "✅11:00" : "11:00");
        button3.setCallbackData("11:00");

        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setText(time == 12 ? "✅12:00" : "12:00");
        button4.setCallbackData("12:00");

        InlineKeyboardButton button5 = new InlineKeyboardButton();
        button5.setText(time == 13 ? "✅13:00" : "13:00");
        button5.setCallbackData("13:00");

        InlineKeyboardButton button6 = new InlineKeyboardButton();
        button6.setText(time == 14 ? "✅14:00" : "14:00");
        button6.setCallbackData("14:00");

        InlineKeyboardButton button7 = new InlineKeyboardButton();
        button7.setText(time == 15 ? "✅15:00" : "15:00");
        button7.setCallbackData("15:00");

        InlineKeyboardButton button8 = new InlineKeyboardButton();
        button8.setText(time == 16 ? "✅16:00" : "16:00");
        button8.setCallbackData("16:00");

        InlineKeyboardButton button9 = new InlineKeyboardButton();
        button9.setText(time == 17 ? "✅17:00" : "17:00");
        button9.setCallbackData("17:00");

        InlineKeyboardButton button10 = new InlineKeyboardButton();
        button10.setText(time == 18 ? "✅18:00" : "18:00");
        button10.setCallbackData("18:00");

        InlineKeyboardButton button11 = new InlineKeyboardButton();
        button11.setText(time == 19 ? "✅19:00" : "19:00");
        button11.setCallbackData("19:00");

        InlineKeyboardButton button12 = new InlineKeyboardButton();
        button12.setText(time == 20 ? "✅20:00" : "20:00");
        button12.setCallbackData("20:00");

       InlineKeyboardButton button15 = new InlineKeyboardButton();
        button15.setText(time == 21 ? "✅21:00" : "21:00");
        button15.setCallbackData("21:00");

        InlineKeyboardButton button16 = new InlineKeyboardButton();
        button16.setText(time == 22 ? "✅22:00" : "22:00");
        button16.setCallbackData("22:00");

        InlineKeyboardButton button17 = new InlineKeyboardButton();
        button14.setText(time == 0 ? "✅Notifications off" : "Notifications off");
        button14.setCallbackData("0");

        InlineKeyboardButton button18 = new InlineKeyboardButton();
        button14.setText("Main menu");
        button14.setCallbackData("/start");

        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        buttonRow1.add(button14);
        buttonRow1.add(button13);
        buttonRow1.add(button1);

        List<InlineKeyboardButton> buttonRow2 = new ArrayList<>();
        buttonRow2.add(button2);
        buttonRow2.add(button3);
        buttonRow2.add(button4);

        List<InlineKeyboardButton> buttonRow3 = new ArrayList<>();
        buttonRow3.add(button5);
        buttonRow3.add(button6);
        buttonRow3.add(button7);

        List<InlineKeyboardButton> buttonRow4 = new ArrayList<>();
        buttonRow4.add(button8);
        buttonRow4.add(button9);
        buttonRow4.add(button10);

        List<InlineKeyboardButton> buttonRow5 = new ArrayList<>();
        buttonRow5.add(button11);
        buttonRow5.add(button12);
        buttonRow5.add(button15);

        List<InlineKeyboardButton> buttonRow6 = new ArrayList<>();
        buttonRow6.add(button16);
        buttonRow6.add(button17);
        buttonRow6.add(button18);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(buttonRow1);
        rowList.add(buttonRow2);
        rowList.add(buttonRow3);
        rowList.add(buttonRow4);
        rowList.add(buttonRow5);
        rowList.add(buttonRow6);

        return rowList;

    }


}
