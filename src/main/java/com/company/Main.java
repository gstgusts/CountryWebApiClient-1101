package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CountryService client = new CountryServiceClient();

        for (var country :
                client.getCountries()) {
            System.out.println(country.getCode());
        }

        var country = client.getCountryById(1);

        System.out.println(country.getName());

    }
}
