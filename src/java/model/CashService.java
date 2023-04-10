package java.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CashService {
    private CopyOnWriteArrayList<BankResponse> monobankResponse = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<BankResponse> binanceResponse = new CopyOnWriteArraySet<>();
    private CopyOnWriteArrayList<BankResponse> geckoResponse = new CopyOnWriteArraySet<>();
    private ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(3);

    private boolean monobankResponse = false;
    private boolean binanceResponse = false;
    private boolean gecjoResponse = false;


    private void monobankFLush(){
        monobankResponse.clear();
        monobankRateIsValid = false;
    }




}
