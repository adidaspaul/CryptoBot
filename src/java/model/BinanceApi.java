package src.java.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

import static src.java.model.CryptoEnum.*;


public class BinanceApi {


    private final ObjectMapper mapper;
    private final OkHttpClient client;


    public BinanceApi() {
        this.client = new OkHttpClient();
        this.mapper = new ObjectMapper();
    }


    List<BankResponse> responses = new ArrayList<>();
    public List<BankResponse> getCryptoRate()  {

        String btcUrl = "https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT";
        Request btcRequest = new Request.Builder()
                .url(btcUrl)
                .build();
        try (
                Response btcResponse = client
                        .newCall(btcRequest)
                        .execute()) {
            String btcJson = btcResponse
                    .body()
                    .string();
            JsonNode btcNode = mapper.readTree(btcJson);
            BigDecimal btcPrice = btcNode.get("price").decimalValue();
            BankResponse btcObject = new BankResponse("Binance",BTC.getBinancePair(),btcPrice);
            responses.add(btcObject);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        String ethUrl = "https://api.binance.com/api/v3/ticker/price?symbol=ETHUSDT";
        Request ethRequest = new Request.Builder()
                .url(ethUrl)
                .build();
        try (
                Response ethResponse = client
                        .newCall(btcRequest)
                        .execute()) {
            String ethJson = ethResponse
                    .body()
                    .string();
            JsonNode ethNode = mapper.readTree(ethJson);
            BigDecimal ethPrice = ethNode.get("price").decimalValue();
            BankResponse ethObject = new BankResponse("Binance",ETC.getBinancePair(),ethPrice);
            responses.add(ethObject);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        String solUrl = "https://api.binance.com/api/v3/ticker/price?symbol=SOLUSDT";
        Request solRequest = new Request.Builder()
                .url(solUrl)
                .build();
        try (
                Response solResponse = client
                        .newCall(solRequest)
                        .execute()) {
            String solJson = solResponse
                    .body()
                    .string();
            JsonNode solNode = mapper.readTree(solJson);
            BigDecimal solPrice = solNode.get("price").decimalValue();
            BankResponse solObject = new BankResponse("Binance",SOL.getBinancePair(),solPrice);
            responses.add(solObject);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return responses;

    }


    public BankResponse getBinanceBitcoin(){
        return FindCryptoObject.findByProperty(responses,btc -> BTC.getBinancePair().equals(btc.getCurrency()));
    }

    public BankResponse getBinanceEthereum(){
        return FindCryptoObject.findByProperty(responses,eth -> ETC.getBinancePair().equals(eth.getCurrency()));
    }

    public BankResponse getBinanceSolana(){
        return FindCryptoObject.findByProperty(responses,sol -> SOL.getBinancePair().equals(sol.getCurrency()));
    }

    public static final class FindCryptoObject {
        public static <BankResponse> BankResponse findByProperty(List<BankResponse> resp, Predicate<BankResponse> filter) {
            return resp.stream().filter(filter).findFirst().orElse(null);
        }
    }


}
