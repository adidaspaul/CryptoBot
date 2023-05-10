package src.java.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import static src.java.model.CryptoEnum.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CoinGeckoApi {

    private final OkHttpClient client;
    private final ObjectMapper mapper;

    public CoinGeckoApi(){
        this.client = new OkHttpClient();
        this.mapper = new ObjectMapper();
    }

    List<CryptoResponse> responses = new ArrayList<>();

    public List<CryptoResponse> getCryptoRate(){
        String btcUrl = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd";
        Request btcRequest = new Request.Builder()
                .url(btcUrl)
                .build();

        try(
                Response btcResponse = client
                        .newCall(btcRequest)
                        .execute()){
            String btcJson = btcResponse
                    .body()
                    .string();
            JsonNode btcNode = mapper.readTree(btcJson);
            BigDecimal btcPrice = btcNode.get("bitcoin").get("price").decimalValue();
            CryptoResponse btcObject = new CryptoResponse("CoinGecko",BTC.getGeckoFirstId(), btcPrice);
            responses.add(btcObject);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        String etcUrl = "https://api.coingecko.com/api/v3/simple/price?ids=ethereum&vs_currencies=usd";
        Request etcRequest = new Request.Builder()
                .url(etcUrl)
                .build();

        try(
                Response etcResponse = client
                        .newCall(etcRequest)
                        .execute()){
            String etcJson = etcResponse
                    .body()
                    .string();
            JsonNode etcNode = mapper.readTree(etcJson);
            BigDecimal etcPrice = etcNode.get("ethereum").get("price").decimalValue();
            CryptoResponse etcObject = new CryptoResponse("CoinGecko",ETC.getGeckoFirstId(), etcPrice);
            responses.add(etcObject);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        String solUrl = "https://api.coingecko.com/api/v3/simple/price?ids=solana&vs_currencies=usd";
        Request solRequest = new Request.Builder()
                .url(solUrl)
                .build();

        try(
                Response solResponse = client
                        .newCall(solRequest)
                        .execute()){
            String solJson = solResponse
                    .body()
                    .string();
            JsonNode solNode = mapper.readTree(solJson);
            BigDecimal solPrice = solNode.get("bitcoin").get("price").decimalValue();
            CryptoResponse solObject = new CryptoResponse("CoinGecko",SOL.getGeckoFirstId(), solPrice);
            responses.add(solObject);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return responses;
    }
}
