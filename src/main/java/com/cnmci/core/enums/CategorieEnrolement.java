package com.cnmci.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CategorieEnrolement {
    ENTREPRISE(0),
    ARTISAN(1),
    APPRENTI(2),
    COMPAGNON(3);

    private final int value;
}
