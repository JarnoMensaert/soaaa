package com.api.rest.Repo;

import com.api.rest.Model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyRepo extends JpaRepository<Currency, Long> {
    Currency findByName(String name);
}
