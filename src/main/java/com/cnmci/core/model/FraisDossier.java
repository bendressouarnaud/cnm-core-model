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
                @Index(name = "facture_fraisdossier_id_idx", columnList = "facture_id")
        }
)
public class FraisDossier extends AbstractEntity {

    // Use to TRACK PAYMENT record for SFP and DLEK :
    private int montant;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "partenaire_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_partenaire_frais_dossier"))
    private Partenaire partenaire;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "facture_id", nullable = true, foreignKey = @ForeignKey(name = "FK_facture_fraisdossier"))
    private Facture facture;

}
