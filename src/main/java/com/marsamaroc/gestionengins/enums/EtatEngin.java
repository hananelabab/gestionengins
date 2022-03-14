package com.marsamaroc.gestionengins.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
public enum EtatEngin {
    indisponible(EtatEngin.indisponible_value),
    enpagne(EtatEngin.enpagne_value),
    occupee(EtatEngin.occupee_value),
    disponible(EtatEngin.disponible_value);

    public static final String indisponible_value = "indisponible";
    public static final String enpagne_value = "enpanne";
    public static final String occupee_value = "occupee";
    public static final String disponible_value = "disponible";

    EtatEngin(String value) {
    }
}
