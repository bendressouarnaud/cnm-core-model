package com.cnmci.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CanalPrefereType {
    SMS(0),
    EMAIL(1),
    WHATSAPP(2);

    private final int value;
}
