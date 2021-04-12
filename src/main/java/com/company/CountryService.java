package com.company;

import java.util.List;

public interface CountryService {
    List<Country> getCountries();
    Country getCountryById(int id);
}
