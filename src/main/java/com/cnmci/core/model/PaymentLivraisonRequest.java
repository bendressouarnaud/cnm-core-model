package com.cnmci.core.model;

import com.cnmci.core.enums.CategorieEnrolement;
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
public class PaymentLivraisonRequest extends AbstractEntity {
    private String waveId;
    private long requesterId;
    private String requesterType;
    private int etat; // 0 : Not paid, 1 : paid
    private String launchUrl;
}
