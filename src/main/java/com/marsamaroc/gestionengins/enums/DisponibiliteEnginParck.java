package com.marsamaroc.gestionengins.enums;

public enum DisponibiliteEnginParck {
    indisponible(DisponibiliteEnginParck.indisponible_value),
    disponible(DisponibiliteEnginParck.disponible_value);
    public static final String indisponible_value = "indisponible";
    public static final String disponible_value = "disponible";
    DisponibiliteEnginParck(String value) {
    }
}
