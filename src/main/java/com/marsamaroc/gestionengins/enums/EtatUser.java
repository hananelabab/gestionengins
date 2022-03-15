package com.marsamaroc.gestionengins.enums;

public enum EtatUser {

    enable(EtatUser.enable_value),
    disable(EtatUser.disable_value);

    public static final String enable_value = "enable";
    public static final String disable_value = "disable";

    EtatUser(String value) {
    }
}
