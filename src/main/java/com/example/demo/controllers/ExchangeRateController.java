package com.example.demo.controllers;

import com.example.demo.entities.ExchangeRate;
import com.example.demo.entities.MaxLimit;
import com.example.demo.services.exchangeRate.ExchangeRateServiceImpl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/exchangeRates/")
public class ExchangeRateController {

    private final ExchangeRateServiceImpl exchangeRateService;

    @Autowired
    public ExchangeRateController(ExchangeRateServiceImpl exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("getCurrent/")
    public ExchangeRate getСurrencyExchangeRate() {
        return exchangeRateService.getFromExternalApi();
    }

    @GetMapping
    public List<ExchangeRate> findAllExchangeRates() {
        return exchangeRateService.getExchangeRates();
    }

    @GetMapping(path = "/{id}")
    public ExchangeRate findExchangeRateByID(@PathVariable long id) {
        return exchangeRateService.getExchangeRate(id);
    }
}
