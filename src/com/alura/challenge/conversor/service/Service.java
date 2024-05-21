package com.alura.challenge.conversor.service;

import com.alura.challenge.conversor.modelos.Converse;
import com.alura.challenge.conversor.utilerias.EventLogger;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.logging.Logger;

public class Service {

    public Converse obtieneConversion(String baseCode, String targetCode, double amount){
        Gson gson = new Gson();

        String apiKey = "22652200d377ea7e3d5df5fd";
        String url = "https://v6.exchangerate-api.com/v6/" +
                apiKey +
                "/pair/" +
                baseCode + "/" +
                targetCode + "/" +
                amount;
        String json = "";
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return gson.fromJson(json, Converse.class);
    }

    public void conversion(int opcion){

        Converse conversion = null;
        Scanner teclado = new Scanner(System.in);
        double valor = 0.0;

        switch (opcion){
            case 1:
                System.out.println("Ingresa el valor que deseas convertir: ");
                valor = teclado.nextDouble();
                conversion = obtieneConversion("USD","ARS",valor);
                break;
            case 2:
                System.out.println("Ingresa el valor que deseas convertir: ");
                valor = teclado.nextDouble();
                conversion = obtieneConversion("ARS","USD",valor);
                break;
            case 3:
                System.out.println("Ingresa el valor que deseas convertir: ");
                valor = teclado.nextDouble();
                conversion = obtieneConversion("USD","BRL",valor);
                break;
            case 4:
                System.out.println("Ingresa el valor que deseas convertir: ");
                valor = teclado.nextDouble();
                conversion = obtieneConversion("BRL","USD",valor);
                break;
            case 5:
                System.out.println("Ingresa el valor que deseas convertir: ");
                valor = teclado.nextDouble();
                conversion = obtieneConversion("USD","COP",valor);
                break;
            case 6:
                System.out.println("Ingresa el valor que deseas convertir: ");
                valor = teclado.nextDouble();
                conversion = obtieneConversion("COP","USD",valor);
                break;
            default:
                System.out.println("Opcion Invalida del Menu.");
                return;
        }

        EventLogger.logEvent(conversion.toString());

        System.out.println("El valor " + valor + " ["+conversion.base_code()+"] " +
                "corresponde al valor de --> " + conversion.conversion_result() +
                " [" + conversion.target_code() + "]");

    }

}
