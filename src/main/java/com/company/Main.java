package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        List<Country> result = null;

        var type = new TypeReference<List<Country>>(){};

        try {
            URL url = new URL("http://localhost:8080/api/countries");
            result = mapper.readValue(url, type);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (var country :
                result) {
            System.out.println(country.getCode());
        }

    }
}
