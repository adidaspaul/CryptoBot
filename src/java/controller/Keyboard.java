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

    List<List<InlineKeyboardButton>>getMainMenu(){
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


public List<List<InlineKeyboardButton>> getSettings(){
        List<List<InlineKeyboardButton>> settingsMenu = new ArrayList<>();
        settingsMenu.add(
                Arrays.asList(
                        InlineKeyboardButton.builder()
                                .text("Decimal Digits")
                                .callbackData("decimalDigit")
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

public List<List<InlineKeyboardButton>> getDecimalPoint(Message message){
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

public List<List<InlineKeyboardButton>> getBankMenu(Message message){
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
                            .text(userService.getUser(message).isBtc() ? "✅BTC" : "BTC")
                            .callbackData("BTC")
                            .build()
            )
    );
    return menu;
}

}
