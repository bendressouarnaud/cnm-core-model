package com.cnmci.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
public class Utilisateur extends AbstractEntity{

    private String nom;
    private String prenom;
    private String contact;
    private String email;
    private String pwd;
    private String code;
    private boolean actif;
    private String fcm;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "crm_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_crm_utilisateur"))
    private Crm crm;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "profil_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_profil_utilisateur"))
    private Profil profil;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "partenaire_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_partenaire_utilisateur"))
    private Partenaire partenaire;

    @OneToMany(fetch = LAZY, mappedBy = "utilisateur", orphanRemoval = true)
    private Collection<Artisan> artisans;

    @OneToMany(fetch = LAZY, mappedBy = "utilisateur", orphanRemoval = true)
    private Collection<Apprenti> apprentis;

    @OneToMany(fetch = LAZY, mappedBy = "utilisateur", orphanRemoval = true)
    private Collection<Compagnon> compagnons;

    @OneToMany(fetch = LAZY, mappedBy = "utilisateur", orphanRemoval = true)
    private Collection<Entreprise> entreprises;

    @OneToMany(fetch = LAZY, mappedBy = "utilisateur", orphanRemoval = true)
    private Collection<Amende> amendes;

    @OneToMany(fetch = LAZY, mappedBy = "utilisateur", orphanRemoval = true)
    private Collection<CommentaireEnrolement> commentaireEnrolements;

    @OneToMany(fetch = LAZY, mappedBy = "utilisateur", orphanRemoval = true)
    private Collection<PaiementEnrolement> paiementEnrolements;
}
