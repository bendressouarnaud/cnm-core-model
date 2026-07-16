package com.cnmci.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
@Table(
        indexes = {
                @Index(name = "utilisateur_facture_id_idx", columnList = "utilisateur_id"),
                @Index(name = "partenaire_facture_id_idx", columnList = "partenaire_id")
        }
)
public class Facture extends AbstractEntity{
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = true, foreignKey = @ForeignKey(name = "FK_utilisateur_facture"))
    private Utilisateur utilisateur;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "partenaire_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_partenaire_facture"))
    private Partenaire partenaire;

    private boolean paid;
    private String fichier;

    private int typeFacture;
}
