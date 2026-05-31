package com.cnmci.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ContactEtabliType {
    DEFAULT(0),
    OUI_REPONDU(1),
    OUI_REPONDEUR(2),
    NON_INJOIGNABLE(3),
    NUMERO_INVALIDE(4);

    private final int value;
}
