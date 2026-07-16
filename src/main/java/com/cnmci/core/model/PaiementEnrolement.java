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
                @Index(name = "entreprise_enrolement_id_idx", columnList = "entreprise_id"),
                @Index(name = "artisan_enrolement_id_idx", columnList = "artisan_id"),
                @Index(name = "apprenti_enrolement_id_idx", columnList = "apprenti_id"),
                @Index(name = "compagnon_enrolement_id_idx", columnList = "compagnon_id"),
                @Index(name = "utilisateur_enrolement_id_idx", columnList = "utilisateur_id"),
                @Index(name = "facture_paiement_enrolement_id_idx", columnList = "facture_id"),
                @Index(name = "facture_ctl_paimnt_enrolement_id_idx", columnList = "facture_controle_id")
        }
)
public class PaiementEnrolement extends AbstractEntity {

    private int montant;
    private int annee;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = true,
            foreignKey = @ForeignKey(name = "FK_utilisateur_paiement_enrolement"))
    private Utilisateur utilisateur;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "frais_enrolement_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_frais_paiement_enrolement"))
    private FraisEnrolement fraisEnrolement;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "entreprise_id", nullable = true,
            foreignKey = @ForeignKey(name = "FK_entreprise_paiement_enrolement"))
    private Entreprise entreprise;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "artisan_id", nullable = true,
            foreignKey = @ForeignKey(name = "FK_artisan_paiement_enrolement"))
    private Artisan artisan;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "apprenti_id", nullable = true,
            foreignKey = @ForeignKey(name = "FK_apprenti_paiement_enrolement"))
    private Apprenti apprenti;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "compagnon_id", nullable = true,
            foreignKey = @ForeignKey(name = "FK_compagnon_paiement_enrolement"))
    private Compagnon compagnon;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "facture_id", nullable = true, foreignKey = @ForeignKey(name = "FK_facture_paiement_enrol"))
    private Facture facture;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "facture_controle_id", nullable = true, foreignKey = @ForeignKey(name = "FK_facture_ctl_paiement_enrol"))
    private Facture factureControle;

}
