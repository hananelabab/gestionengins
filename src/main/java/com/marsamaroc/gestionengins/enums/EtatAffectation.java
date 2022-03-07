package com.marsamaroc.gestionengins.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EtatAffectation {

    reserve(EtatAffectation.reserve_value),
    enexecution(EtatAffectation.enexecution_value),
    execute(EtatAffectation.execute_value);

    public static final String reserve_value = "reserve";
    public static final String enexecution_value = "enexecution";
    public static final String execute_value = "execute";
    EtatAffectation(String value) {
    }

}
