package com.cnmci.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DelaiReglement {
    JOUR_7(0),
    JOUR_15(1),
    JOUR_22(2),
    JOUR_30(3);

    private final int value;
}
