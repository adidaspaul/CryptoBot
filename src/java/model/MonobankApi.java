package src.java.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class MonobankApi {

    private final HttpClient CLIENT = HttpClient.newHttpClient();
    private final Gson JAYSON = new Gson();

    String url = "https://api.monobank.ua/bank/currency";

    public List<BankResponse> getActualCurrency() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        List<MonobankInfo> mono = JAYSON.fromJson(response.body(), new TypeToken<List<MonobankInfo>>() {
        }.getType());
        MonobankInfo cad = getCadCurrencyFromList(mono);
        MonobankInfo usd = getUsdCurrencyFromList(mono);
        List<BankResponse> bankResponses = new ArrayList<>();
        bankResponses.add(new BankResponse("Monobank", CurrencyEnum.CAD.getLetterCode(),
                new BigDecimal(String.valueOf(cad.getRateCross()))));
        bankResponses.add(new BankResponse("Monobank", CurrencyEnum.USD.getLetterCode(),
                new BigDecimal(String.valueOf(usd.getRateBuy())), new BigDecimal(String.valueOf(usd.getRateSell()))));
        return bankResponses;
    }

    private MonobankInfo getCadCurrencyFromList(List<MonobankInfo> mono) {
        return mono.stream()
                .filter(e -> CurrencyEnum.CAD.getIntCode() == e.getCurrencyCodeA())
                .findFirst()
                .orElse(null);
    }

    private MonobankInfo getUsdCurrencyFromList(List<MonobankInfo> mono) {
        return mono.stream()
                .filter(e -> CurrencyEnum.USD.getIntCode() == e.getCurrencyCodeA())
                .findFirst()
                .orElse(null);
    }
}
