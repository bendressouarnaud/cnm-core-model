package com.cnmci.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
@Table(
        indexes = {
                @Index(name = "metier_principale_activite_id_idx", columnList = "metier_principale_id"),
                @Index(name = "metier_secondaire_activite_id_idx", columnList = "metier_secondaire_id"),
                @Index(name = "quartier_activite_id_idx", columnList = "quartier_siege_id")
        }
)
public class Activite extends AbstractEntity{

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "commune_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_commune_activite"))
    private Commune commune;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "metier_principale_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_activite_principale"))
    private Metier metierPrincipale;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "metier_secondaire_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_activite_secondaire"))
    private Metier metierSecondaire;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "quartier_siege_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_quartier_activite"))
    private Quartier quartierSiegeId;

    private String raisonSocial;
    private String sigle;
    private String rccm;
    private OffsetDateTime dateCreation;

    private String quartier;
    private String niveauEquipement;
    private int salarieHomme;
    private int salarieFemme;
    private int auxiliaireHomme;
    private int auxiliaireFemme;
    private int apprentiHomme;
    private int apprentiFemme;

}
