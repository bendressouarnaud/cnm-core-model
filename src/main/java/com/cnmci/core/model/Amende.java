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
                @Index(name = "artisan_amende_id_idx", columnList = "artisan_id"),
                @Index(name = "apprenti_amende_id_idx", columnList = "apprenti_id"),
                @Index(name = "compagnon_amende_id_idx", columnList = "compagnon_id"),
                @Index(name = "entreprise_amende_id_idx", columnList = "entreprise_id"),
                @Index(name = "utilisateur_amende_id_idx", columnList = "utilisateur_id")
        }
)
public class Amende extends AbstractEntity{

    private int montant;
    private String commentaire;
    private boolean amendeSolde;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "artisan_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_artisan_amende"))
    private Artisan artisan;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "apprenti_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_apprenti_amende"))
    private Apprenti apprenti;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "compagnon_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_compagnon_amende"))
    private Compagnon compagnon;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "entreprise_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_entreprise_amende"))
    private Entreprise entreprise;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_utilisateur_amende"))
    private Utilisateur utilisateur;
}
