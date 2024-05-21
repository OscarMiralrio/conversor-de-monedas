package com.alura.challenge.conversor;

import com.alura.challenge.conversor.modelos.Converse;
import com.alura.challenge.conversor.service.Service;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Service service = new Service();
        Scanner teclado = new Scanner(System.in);

        while (true) {
            String menu = """
                    1) Dólar            --> Peso Argentino
                    2) Peso Argentino   --> Dólar
                    3) Dólar            --> Real Brasileño
                    4) Real Brasileño   --> Dólar
                    5) Dólar            --> Peso Colombiano
                    6) Peso Colombiano  --> Dólar
                    7) Salir
                    """;

            System.out.println("********************************************\n");
            System.out.println("Sea bienvenid@ al conversor de de Monedas :D\n");
            System.out.println(menu);
            System.out.println("********************************************");
            System.out.println("Elije una opción de conversión:");

            try {
                int opcion = teclado.nextInt();
                if (opcion == 7) {
                    break;
                }
                service.conversion(opcion);
            } catch (Exception e) {
                System.out.println("Ingresa una opción valida del menu.");
                break;
            }
        }

    }
}
