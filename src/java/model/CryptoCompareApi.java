package src.java.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static src.java.model.CryptoEnum.*;

public class CryptoCompareApi {

    private final ObjectMapper mapper;
    private final OkHttpClient client;

    CryptoCompareApi() {
        this.mapper = new ObjectMapper();
        this.client = new OkHttpClient();
    }

    List<BankResponse> responses = new ArrayList<>();

    public List<BankResponse> getCryptoRate() {

        String btcUrl = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD";
        Request btcRequest = new Request.Builder()
                .url(btcUrl)
                .build();

        try (
            Response btcResponse = client
                    .newCall(btcRequest)
                    .execute()){
                String btcJson = btcResponse
                        .body()
                        .string();
                JsonNode btcNode = mapper.readTree(btcJson);
                BigDecimal btcPrice = btcNode.get("USD").decimalValue();
            BankResponse btcObject = new BankResponse("CryptoCompare", BTC.getCryptoCompareFirstId(), btcPrice);
                responses.add(btcObject);
            }

        catch (IOException e){
            e.printStackTrace();
        }

        String etcUrl = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=USD";
        Request etcRequest = new Request.Builder()
                .url(etcUrl)
                .build();

        try (
                Response etcResponse = client
                        .newCall(etcRequest)
                        .execute()){
            String etcJson = etcResponse
                    .body()
                    .string();
            JsonNode etcNode = mapper.readTree(etcJson);
            BigDecimal etcPrice = etcNode.get("USD").decimalValue();
            BankResponse etcObject = new BankResponse("CryptoCompare", ETC.getCryptoCompareFirstId(), etcPrice);
            responses.add(etcObject);
        }

        catch (IOException e){
            e.printStackTrace();
        }


        String solUrl = "https://min-api.cryptocompare.com/data/price?fsym=SOL&tsyms=USD";
        Request solRequest = new Request.Builder()
                .url(solUrl)
                .build();

        try (
                Response solResponse = client
                        .newCall(solRequest)
                        .execute()){
            String solJson = solResponse
                    .body()
                    .string();
            JsonNode solNode = mapper.readTree(solJson);
            BigDecimal solPrice = solNode.get("USD").decimalValue();
            BankResponse solObject = new BankResponse("CryptoCompare", SOL.getCryptoCompareFirstId(), solPrice);
            responses.add(solObject);
        }

        catch (IOException e){
            e.printStackTrace();
        }

        return responses;
    }

}
