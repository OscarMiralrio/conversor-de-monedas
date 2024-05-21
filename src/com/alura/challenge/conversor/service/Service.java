package com.alura.challenge.conversor.service;

import com.alura.challenge.conversor.modelos.Converse;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Service {

    public Converse obtineValoresConversion(String baseCode){
        Gson gson = new Gson();

        String apiKey = "22652200d377ea7e3d5df5fd";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCode;
        String json = "";
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();

            System.out.println(json);

            System.out.println(baseCode.toString());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return gson.fromJson(json, Converse.class);
    }

}
