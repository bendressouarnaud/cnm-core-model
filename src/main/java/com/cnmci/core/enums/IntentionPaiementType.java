package com.cnmci.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum IntentionPaiementType {
    DEFAULT(0),
    PAYER_IMMEDIATEMENT(1),
    PAYER_SELON_DATE_RDV(2),
    REFUSE(3);

    private final int value;
}
