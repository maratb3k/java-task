package com.example.demo.services.exchangeRate;

import com.example.demo.entities.ExchangeRate;
import com.example.demo.entities.MaxLimit;
import com.example.demo.repositories.ExchangeRateRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ExchangeRateServiceImpl {

    private final RestTemplate restTemplate;
    private final ExchangeRateRepository exchangeRateRepository;
    private static final AtomicInteger count = new AtomicInteger(0);

    @Autowired
    public ExchangeRateServiceImpl(RestTemplate restTemplate, ExchangeRateRepository exchangeRateRepository) {
        this.restTemplate = restTemplate;
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public ExchangeRate getFromExternalApi() {
        String jsonString = restTemplate.getForObject(
                "https://api.twelvedata.com/time_series?symbol=USD/KZT&interval=1min&apikey=b9e2e880afd340879ef758ce6291f64c",
                String.class);
        JSONObject obj = new JSONObject(jsonString);
        String symbolVar = obj.getJSONObject("meta").getString("symbol");
        JSONArray values = obj.getJSONArray("values");

        String datetime = values.getJSONObject(0).getString("datetime");
        String close = values.getJSONObject(0).getString("close");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime datetimeVar = LocalDateTime.parse(datetime, formatter);
        double closeVar = Double.parseDouble(close);
        ExchangeRate exchangeRate = new ExchangeRate(count.incrementAndGet(), symbolVar, datetimeVar, closeVar);
        return exchangeRateRepository.save(exchangeRate);
    }

    public ExchangeRate getExchangeRate(long id) {
        return exchangeRateRepository.findById(id).orElse(null);
    }

    public List<ExchangeRate> getExchangeRates() {
        return exchangeRateRepository.findAll();
    }
}
