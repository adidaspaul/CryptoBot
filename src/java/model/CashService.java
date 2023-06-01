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
    private CopyOnWriteArrayList<BankResponse> cryptoCompareResponse = new CopyOnWriteArrayList<>();
    private ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(3);

    private boolean monobankRateIsValid = false;
    private boolean binanceRateIsValid = false;
    private boolean geckoRateIsValid = false;
    private boolean cryptoCompareIsValid = false;


    private void monobankFlush(){
        monobankResponse.clear();
        monobankRateIsValid = false;
    }

    private void binanceFlush(){
        binanceResponse.clear();
        binanceRateIsValid = false;
    }

    private void geckoFlush(){
        geckoResponse.clear();
        geckoRateIsValid = false;
    }

    private void cryptoCompareFlush(){
        cryptoCompareResponse.clear();
        cryptoCompareIsValid = false;
    }

    public List<BankResponse> getBinanceCrypto(){
        BinanceApi binanceApi = new BinanceApi();
        if(!binanceRateIsValid | binanceResponse.size() == 0);{
            binanceRateIsValid = true;
            try{
                binanceResponse.addAll(binanceApi.getCryptoRate());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Runnable binanceRateFlushRunnable = this::binanceFlush;
            if(poolExecutor.getActiveCount() !=0){
                poolExecutor.shutdownNow();
            }
            poolExecutor.schedule(binanceRateFlushRunnable,5,TimeUnit.MINUTES);
        }
        return new ArrayList<>(binanceResponse);
    }

    public List<BankResponse> getGeckoCrypto(){
        CoinGeckoApi geckoApi = new CoinGeckoApi();
        if(!geckoRateIsValid | geckoResponse.size() == 0);{
            geckoRateIsValid = true;
            try{
                geckoResponse.addAll(geckoApi.getCryptoRate());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Runnable geckoFlushRunnable = this::geckoFlush;
            if(poolExecutor.getActiveCount() !=0){
                poolExecutor.shutdownNow();
            }
            poolExecutor.schedule(geckoFlushRunnable,5,TimeUnit.MINUTES);
        }
        return new ArrayList<>(geckoResponse);
    }

    public List<BankResponse> getCompareCrypto(){
        CryptoCompareApi compareApi = new CryptoCompareApi();
        if(!cryptoCompareIsValid | cryptoCompareResponse.size() == 0);{
            cryptoCompareIsValid = true;
            try{
                cryptoCompareResponse.addAll(compareApi.getCryptoRate());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Runnable compareFlushRunnable = this::cryptoCompareFlush;
            if(poolExecutor.getActiveCount() !=0){
                poolExecutor.shutdownNow();
            }
            poolExecutor.schedule(compareFlushRunnable,5,TimeUnit.MINUTES);
        }
        return new ArrayList<>(cryptoCompareResponse);
    }


    public List<BankResponse> getCashMonoBankCurrency(){
        MonobankApi monoApi = new MonobankApi();
        if(!monobankRateIsValid | monobankResponse.size() == 0);{
            monobankRateIsValid = true;
            try{
                monobankResponse.addAll(monoApi.getActualCurrency());
            } catch (IOException | InterruptedException e){
                e.printStackTrace();
            }
            Runnable monobankRateFlushRunnable = this::monobankFlush;
            if(poolExecutor.getActiveCount() !=0){
                poolExecutor.shutdownNow();
            }
            poolExecutor.schedule(monobankRateFlushRunnable,5,TimeUnit.MINUTES);
        }
        return new ArrayList<>(monobankResponse);
    }





}
