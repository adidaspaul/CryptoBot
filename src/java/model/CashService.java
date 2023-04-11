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

    public List<BankResponse> getCashMonoBankCurrency(){
        MonobankApi monoApi = new MonobakApi();
        if(monobankRateIsValid == false | monobankResponse.size() == 0);{
            monobankRateIsValid = true;
            try{
                monobankResponse.addAll(monoApi.getActualCurrency());
            } catch (IOException e){
                e.printStackTrace();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            Runnable monobankRateFlushRunnable = () -> monobankFlush();
            if(poolExecutor.getActiveCount() !=0){
                poolExecutor.shutdownNow();
            }
            poolExecutor.schedule(monobankFLush(),5,TimeUnit.MINUTES);
        }
        ArrayList<BankResponse> bankResponse = new ArrayList<>();
        bankResponse.addAll(monobankResponse);
        return bankResponse;
    }


}
