package src.java.controller;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import src.java.model.Schedule;
import src.java.model.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller extends TelegramLongPollingBot {

    private Keyboard keyboard = new Keyboard();
    private UserService userService = UserService.create();


    @Override
    public String getBotUsername() {
        return "null";
    }

    @Override
    public String getBotToken() {
        return "null";
    }

    @Override
    public void onUpdateReceived(Update update) {         //мониторит ввод в чат (наблюдатель)
        if (update.hasCallbackQuery()){
            handleCallback(update.getCallbackQuery());
        } else if (update.hasMessage()){
            try {
                handleMessage(update.getMessage());
            } catch (TelegramApiException tel) {
                tel.printStackTrace();
            }
        }
    }

        private void handleCallback (CallbackQuery callbackQuery){
            Message message = callbackQuery.getMessage();
            try {
                if (callbackQuery.getData().equals("get_info")) {
                    execute(SendMessage.builder()
                            .text(userService.getInfo(message))
                            .chatId(message.getChatId().toString())
                            .build());
                    execute(SendMessage.builder()
                            .text("Main Menu")
                            .chatId(message.getChatId().toString())
                            .replyMarkup(InlineKeyboardMarkup.builder()
                                    .keyboard(keyboard.getMainMenu())
                                    .build())
                            .build());
                }
                if (callbackQuery.getData().equals("settings")) {
                    execute(SendMessage.builder()
                            .text("Settings")
                            .chatId(message.getChatId().toString())
                            .replyMarkup(InlineKeyboardMarkup.builder()
                                    .keyboard(keyboard.getSettings())
                                    .build())
                            .build());
                }
                if (callbackQuery.getData().equals("decimal digit")) {
                    execute(SendMessage.builder()
                            .text("Enter decimal digit")
                            .chatId(message.getChatId().toString())
                            .replyMarkup(InlineKeyboardMarkup.builder()
                                    .keyboard(keyboard.getDecimalPoint(message))
                                    .build())
                            .build());
                }
                if (callbackQuery.getData().equals("banks")) {
                    execute(SendMessage.builder()
                            .text("Choose bank or platform")
                            .chatId(message.getChatId().toString())
                            .replyMarkup(InlineKeyboardMarkup.builder()
                                    .keyboard(keyboard.getBankMenu(message))
                                    .build())
                            .build());
                }
                if (callbackQuery.getData().equals("currency")) {
                    execute(SendMessage.builder()
                            .text("Choose currency or currencies")
                            .chatId(message.getChatId().toString())
                            .replyMarkup(InlineKeyboardMarkup.builder()
                                    .keyboard(keyboard.getCurrencyMenu(message))
                                    .build())
                            .build());
                }
                if (callbackQuery.getData().equals("schedule")) {
                    execute(SendMessage.builder()
                            .text("Choose Time of Notification")
                            .chatId(message.getChatId().toString())
                            .replyMarkup(InlineKeyboardMarkup.builder()
                                    .keyboard(keyboard.getTimeAlert(message))
                                    .build())
                            .build());
                }
                if (callbackQuery.getData().equals("CAD")){
                    userService.changeCurrencyCAD(message);
                    execute(EditMessageReplyMarkup.builder()
                            .chatId(message.getChatId().toString())
                            .messageId(message.getMessageId())
                            .replyMarkup(InlineKeyboardMarkup.builder()
                                    .keyboard(keyboard.getCurrencyMenu(message))
                                    .build())
                            .build());
                }
                if (callbackQuery.getData().equals("USD")){
                    userService.changeCurrencyUSD(message);
                    execute(EditMessageReplyMarkup.builder()
                            .chatId(message.getChatId().toString())
                            .messageId(message.getMessageId())
                            .replyMarkup(InlineKeyboardMarkup.builder()
                                    .keyboard(keyboard.getCurrencyMenu(message))
                                    .build())
                            .build());
                }
                if (callbackQuery.getData().equals("BTC")){
                    userService.changeCurrencyBtc(message);
                    execute(EditMessageReplyMarkup.builder()
                            .chatId(message.getChatId().toString())
                            .messageId(message.getMessageId())
                            .replyMarkup(InlineKeyboardMarkup.builder()
                                    .keyboard(keyboard.getCurrencyMenu(message))
                                    .build())
                            .build());
                }
                if (callbackQuery.getData().equals("ETC")){
                    userService.changeCurrencyETC(message);
                    execute(EditMessageReplyMarkup.builder()
                            .chatId(message.getChatId().toString())
                            .messageId(message.getMessageId())
                            .replyMarkup(InlineKeyboardMarkup.builder()
                                    .keyboard(keyboard.getCurrencyMenu(message))
                                    .build())
                            .build());
                }
                if (callbackQuery.getData().equals("SOL")){
                    userService.changeCurrencySOL(message);
                    execute(EditMessageReplyMarkup.builder()
                            .chatId(message.getChatId().toString())
                            .messageId(message.getMessageId())
                            .replyMarkup(InlineKeyboardMarkup.builder()
                                    .keyboard(keyboard.getCurrencyMenu(message))
                                    .build())
                            .build());
                }
                List<String> rounding = new ArrayList<>();
                rounding.add("/2");
                rounding.add("/3");
                rounding.add("/4");
                for (int i = 0; i < rounding.size(); i++){
                    if (callbackQuery.getData().equals(rounding.get(i))){
                        userService.changeDecimalDigit(message, Byte.parseByte(rounding.get(i).replaceAll("/", "")));
                        execute(EditMessageReplyMarkup.builder()
                                .chatId(message.getChatId().toString())
                                .messageId(message.getMessageId())
                                .replyMarkup(InlineKeyboardMarkup.builder()
                                        .keyboard(keyboard.getDecimalPoint(message))
                                        .build())
                                .build());
                    }
                }
                List<String> times = new ArrayList<>();
                times.add("07:00");
                times.add("08:00");
                times.add("09:00");
                times.add("10:00");
                times.add("11:00");
                times.add("12:00");
                times.add("13:00");
                times.add("14:00");
                times.add("15:00");
                times.add("16:00");
                times.add("17:00");
                times.add("18:00");
                times.add("19:00");
                times.add("20:00");
                times.add("21:00");
                times.add("22:00");
                times.add("23:00");
                for (int i = 0; i < times.size(); i++){
                    if (callbackQuery.getData().equals(times.get(i))){
                        userService.changeSchedule(message, Byte.parseByte(times.get(i).substring(0,2)));
                        execute(EditMessageReplyMarkup.builder()
                                .chatId(message.getChatId().toString())
                                .messageId(message.getMessageId())
                                .replyMarkup(InlineKeyboardMarkup.builder()
                                        .keyboard(keyboard.getTimeAlert(message))
                                        .build())
                                .build());
                    }
                }
                if(callbackQuery.getData().equals("0")){
                    userService.changeSchedule(message, (byte) 0);
                    execute(EditMessageReplyMarkup.builder()
                            .chatId(message.getChatId().toString())
                            .messageId(message.getMessageId())
                            .replyMarkup(InlineKeyboardMarkup.builder()
                                    .keyboard(keyboard.getTimeAlert(message))
                                    .build())
                            .build());
                }

                if(callbackQuery.getData().equals("/start")){
                    Schedule schedule = new Schedule();
                    schedule.scheduleStart(message);
                    execute(SendMessage.builder()
                            .text("Keep track of the currencies")
                            .chatId(message.getChatId().toString())
                            .replyMarkup(InlineKeyboardMarkup.builder()
                                    .keyboard(keyboard.getMainMenu())
                                    .build())
                            .build());
                }

            } catch (TelegramApiException tel) {
                tel.printStackTrace();
            }
        }

        private void handleMessage(Message message) throws TelegramApiException{
        if (message.hasText() && message.hasEntities()){
            Optional<MessageEntity> commandEntity = message.getEntities().stream()
                    .filter(e -> "bot_command".equals(e.getType()))
                    .findFirst();
            if (commandEntity.isPresent()){
                String command = message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
                if (command.equals("/start")){
                    userService.addUser(message);
                    execute(SendMessage.builder()
                            .text("Keep track of the currencies")
                            .chatId(message.getChatId().toString())
                            .replyMarkup(InlineKeyboardMarkup.builder()
                                    .keyboard(keyboard.getMainMenu())
                                    .build())
                            .build());
                }
            }
        }
        }
    }
