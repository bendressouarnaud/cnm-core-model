package com.cnmci.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
public class GainEnrolement extends AbstractEntity {

    // Use to TRACK PAYMENT record for SFP and DLEK :
    private int montant;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "partenaire_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_partenaire_gain_enrolement"))
    private Partenaire partenaire;

}
