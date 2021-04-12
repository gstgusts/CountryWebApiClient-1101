package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;
import java.util.List;

public class CountryServiceClient implements CountryService {

    private final String baseUrl  = "http://localhost:8080/api";

    @Override
    public List<Country> getCountries() {
        ObjectMapper mapper = new ObjectMapper();

        List<Country> result = null;

        var type = new TypeReference<List<Country>>(){};

        try {
            URL url = new URL(baseUrl + "/countries");
            result = mapper.readValue(url, type);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Country getCountryById(int id) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            URL url = new URL(baseUrl + "/countries/"+id);
            return mapper.readValue(url, Country.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
