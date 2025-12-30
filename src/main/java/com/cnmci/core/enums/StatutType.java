package com.cnmci.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StatutType {

    ENROLE(0),
    IMMATRICULE(1),
    REJETE(2);

    private final int value;

}
