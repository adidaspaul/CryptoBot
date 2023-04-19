package src.java.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CashService {
    private CopyOnWriteArrayList<BankResponse> monobankResponse = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<BankResponse> binanceResponse = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<BankResponse> geckoResponse = new CopyOnWriteArrayList<>();
    private ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(3);

    private boolean monobankRateIsValid = false;
    private boolean binanceRateIsValid = false;
    private boolean gecjoRareIsValid = false;


    private void monobankFlush(){
        monobankResponse.clear();
        monobankRateIsValid = false;
    }

    public List<BankResponse> getCashMonoBankCurrency(){
        MonobankApi monoApi = new MonobankApi();
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
            poolExecutor.schedule(monobankRateFlushRunnable,5,TimeUnit.MINUTES);
        }
        ArrayList<BankResponse> bankResponse = new ArrayList<>();
        bankResponse.addAll(monobankResponse);
        return bankResponse;
    }

}
