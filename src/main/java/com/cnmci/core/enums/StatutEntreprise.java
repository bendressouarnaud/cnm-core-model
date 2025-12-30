package com.cnmci.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StatutEntreprise {
    EN_ATTENTE(0),
    ACTIVE(1),
    SUSPENDUE(2);

    private final int value;
}
