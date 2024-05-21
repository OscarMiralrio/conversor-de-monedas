package com.alura.challenge.conversor;

import com.alura.challenge.conversor.modelos.Converse;
import com.alura.challenge.conversor.service.Service;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {
    public static void main(String[] args) {

        Service service = new Service();

        System.out.println(service.obtineValoresConversion(""));

    }
}
