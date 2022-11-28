package com.example.mscountry.service;
import com.example.mscountry.model.CountryResponse;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    public List<CountryResponse> getAvailableCountries(String currency) {
        if (currency.equals("USD")) {
            return List.of(new CountryResponse("USA", BigDecimal.valueOf(5000)),
                    new CountryResponse("Ger", BigDecimal.TEN));
        }
        return new ArrayList<>();
    }
}
