package com.api.rest.Controller;
import com.api.rest.Model.Currency;
import com.api.rest.Repo.CurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private CurrencyRepo currencyRepo;

    @GetMapping("/")
    public String getPage() {
        return  "Welcome to the currency exchange page.<br><br>" +
                "To get a list of all the available currencies, go to /currencies <br>" +
                "To get the value of 1 euro in a currency, go to /currency/{name} <br>" +
                "To add a currency, go to /new <br>" +
                "To delete a currency, go to /delete/{name} <br>" +
                "To update a currency, go to /update/{name}/{value} <br>";
    }

    @GetMapping("/currencies")
    public List<Currency> getCurrency() {
        return currencyRepo.findAll();
    }

    @GetMapping("/currency/{name}")
    public Currency getCurrencyValue(@PathVariable String name) {
        return currencyRepo.findByName(name);
    }

    @PostMapping("/new")
    public String newFact(@RequestBody Currency currency) {
        currencyRepo.save(currency);
        return "Currency added";
    }

    @PutMapping(value = "/update/{name}/{value}")
    public String updateFact(@PathVariable String name, @PathVariable String value) {
        Currency updateCurrency = currencyRepo.findByName(name);
        updateCurrency.setValue(Double.parseDouble(value));
        currencyRepo.save(updateCurrency);
        return "Currency updated";
    }

    @DeleteMapping(value = "/delete/{name}")
    public String deleteFact(@PathVariable String name) {
        Currency deleteCurrency = currencyRepo.findByName(name);
        currencyRepo.delete(deleteCurrency);
        return "Currency with name: " + name + " deleted";
    }
}
