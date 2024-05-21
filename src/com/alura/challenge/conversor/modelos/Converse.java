package com.alura.challenge.conversor.modelos;

import java.util.Map;

public record Converse(String base_code, Map<String, Double> conversion_rates) {
}
