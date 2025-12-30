package com.cnmci.core.model;

import com.cnmci.artisan.enums.CategorieEnrolement;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
public class PaymentRequest extends AbstractEntity {
    private String waveId;
    private long requesterId;
    private String requesterType;
    private int montant;
    private int etat; // 0 : Not paid, 1 : paid
    private String launchUrl;
    @Enumerated(EnumType.ORDINAL)
    private CategorieEnrolement categorieEnrolement;
}
