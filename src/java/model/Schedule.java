package java.model;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.controller.Application;

import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Schedule {

    private ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(10);

    public void scheduleStart(Message message) {

        Calendar calendar = new GregorianCalendar();

        for (User user : UserService.getService().getUserList()) {
            if (user.getNotificationTime() != 0) {
                calendar.set(Calendar.HOUR_OF_DAY, user.getNotificationTime());
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                Date date = calendar.getTime();
                long delay = date.getTime() - System.currentTimeMillis();
                if (delay < 0) {
                    delay = delay + 24 * 60 * 60 * 1000;
                }
            }

            Runnable runnable = () -> {
                try {
                    Application.getBot().execute(SendMessage.builder()
                            .text(UserService.getUserService().getInfo(message))
                            .chatId(user.getChatId().toString())
                            .build());
                }
            }
        }
    }

}
