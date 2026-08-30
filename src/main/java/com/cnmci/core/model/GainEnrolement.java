package com.cnmci.core.model;

import jakarta.persistence.*;
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
@Table(
        indexes = {
                @Index(name = "facture_gain_id_idx", columnList = "facture_id")
        }
)
public class GainEnrolement extends AbstractEntity {

    // Use to TRACK PAYMENT record for SFP and DLEK :
    private int montant;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "partenaire_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_partenaire_gain_enrolement"))
    private Partenaire partenaire;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "facture_id", nullable = true, foreignKey = @ForeignKey(name = "FK_facture_gain"))
    private Facture facture;

    @Column(nullable = true)
    private long requesterId;
    @Column(length = 3, nullable = true)
    private String requesterType;
}
