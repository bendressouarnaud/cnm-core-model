package com.cnmci.core.model;

import com.cnmci.core.enums.StatutEntreprise;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@SuperBuilder
@Entity
@Table(
        indexes = {
                @Index(name = "commune_entreprise_id_idx", columnList = "commune_id"),
                @Index(name = "activite_principale_entreprise_id_idx", columnList = "activite_principale_id"),
                @Index(name = "activite_secondaire_entreprise_id_idx", columnList = "activite_secondaire_id"),
                @Index(name = "utilisateur_entreprise_id_idx", columnList = "utilisateur_id"),
                @Index(name = "gerant_entreprise_id_idx", columnList = "gerant_id"),

                @Index(name = "crm_entreprise_id_idx", columnList = "crm_id"),
                @Index(name = "departement_entreprise_id_idx", columnList = "departement_id"),
                @Index(name = "sous_prefecture_entreprise_id_idx", columnList = "sous_prefecture_id")
        }
)
@NoArgsConstructor
public class Entreprise extends AbstractEntity{

    private UUID numeroIdentification;
    private String raisonSociale;
    private String numeroRea;
    private String sigle;
    private String objetSocial;
    private OffsetDateTime dateCreation;
    private String rccm;
    private OffsetDateTime dateRccm;
    private Long capitalSocial;
    private String regimeFiscal;
    private int nombreAssocies;
    private int dureePersonneMorale;
    private String numeroCnps;
    private String compteContribuable;
    private String ilotLot;
    private String contact;
    private String adresse;
    private String quartier;

    @Enumerated(EnumType.ORDINAL)
    private StatutEntreprise statut;

    private int statutKyc;
    private int statutPaiement;
    private Double longitude;
    private Double latitude;
    private int print;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_utilisateur_entreprise"))
    private Utilisateur utilisateur;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "commune_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_commune_entreprise"))
    private Commune commune;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "forme_juridique_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_forme_juridique_entreprise"))
    private FormeJuridique formeJuridique;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "activite_principale_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_activite_principale_entreprise"))
    private Metier activitePrincipale;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "activite_secondaire_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_activite_secondaire_entreprise"))
    private Metier activiteSecondaire;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "gerant_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_gerant_entreprise"))
    private Gerant gerant;

    // NEW ONES
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "crm_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_crm_entreprise"))
    private Crm crm;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "departement_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_departement_entreprise"))
    private Departement departement;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "sous_prefecture_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_sous_prefecture_entreprise"))
    private SousPrefecture sousPrefecture;
    //

    @OneToMany(fetch = LAZY, mappedBy = "entreprise", orphanRemoval = true)
    private Collection<EntrepriseApprenti> entrepriseApprentis;

    @OneToMany(fetch = LAZY, mappedBy = "entreprise", orphanRemoval = true)
    private Collection<EntrepriseCompagnon> entrepriseCompagnons;

    @OneToMany(fetch = LAZY, mappedBy = "entreprise", orphanRemoval = true)
    private Collection<PaiementEnrolement> paiementEnrolements;

    @OneToMany(fetch = LAZY, mappedBy = "entreprise", orphanRemoval = true)
    private Collection<Amende> amendes;

    @OneToMany(fetch = LAZY, mappedBy = "entreprise", orphanRemoval = true)
    private Collection<CommentaireEnrolement> commentaireEnrolements;

}
