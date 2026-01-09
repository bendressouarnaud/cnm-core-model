package com.cnmci.core.model;

import com.cnmci.core.enums.StatutType;
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
@NoArgsConstructor
@Table(
        indexes = {
                @Index(name = "pays_artisan_id_idx", columnList = "nationalite"),
                @Index(name = "commune_residence_artisan_id_idx", columnList = "commune_residence_id"),

                @Index(name = "commune_naissance_artisan_id_idx", columnList = "commune_naissance_id"),

                @Index(name = "utilisateur_artisan_id_idx", columnList = "utilisateur_id"),
                @Index(name = "metier_artisan_id_idx", columnList = "metier_id"),

                @Index(name = "crm_artisan_id_idx", columnList = "crm_id"),
                @Index(name = "departement_artisan_id_idx", columnList = "departement_id"),
                @Index(name = "sous_prefecture_artisan_id_idx", columnList = "sous_prefecture_id")
        }
)
public class Artisan extends AbstractEntity{

    private UUID numeroIdentification;
    private String numeroRegistre;
    private String lieuNaissanceAutre;
    private String civilite;
    private String nom;
    private String prenom;
    private OffsetDateTime dateNaissance;
    //private String lieuNaissance;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "commune_naissance_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_commune_naissance_artisan"))
    private Commune lieuNaissance;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "nationalite", nullable = true ,foreignKey = @ForeignKey(name = "FK_pays_artisan"))
    private Pays pays;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "statut_matrimonial_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_statut_matrimonial_artisan"))
    private StatutMatrimonial statutMatrimonial;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "type_document_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_type_document_artisan"))
    private TypeDocument typeDocument;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "niveau_etude_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_niveau_etude_artisan"))
    private NiveauEtude niveauEtude;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "formation_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_formation_artisan"))
    private Formation formation;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "classe_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_classe_artisan"))
    private Classe classe;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "diplome_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_diplome_artisan"))
    private Diplome diplome;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "commune_residence_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_commune_residence_artisan"))
    private Commune communeResidence;

    @OneToOne
    @JoinColumn(name = "activite_id", foreignKey = @ForeignKey(name = "FK_artisan_activite"))
    private Activite activite;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = true, foreignKey = @ForeignKey(name = "FK_utilisateur_artisan"))
    private Utilisateur utilisateur;

    @Enumerated(EnumType.ORDINAL)
    private StatutType statutType;

    private String sexe;
    private String numeroPiece;
    private String pieceDelivre;
    private OffsetDateTime dateEmissionPiece;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "metier_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_metier_artisan"))
    private Metier metier;

    //private String specialite;
    private String quartierResidence;
    private String adressePostal;
    private String contact1;
    private String contact2;
    private String email;
    private String photoArtisan;
    private String photoCniRecto;
    private String photoCniVerso;
    private String photoDiplome;
    private boolean declarationMaitriseMetier;
    private boolean declarationCondamnation;

    private OffsetDateTime dateExpirationCarte;
    private int statutKyc;
    private int statutPaiement;
    private Double longitude;
    private Double latitude;
    private int print;

    private boolean regimeSocial;
    private boolean regimeTravailleur;
    private boolean regimeImpositionTaxeCommunale;
    private boolean regimeImpositionMicroEntreprise;
    private int comptabilite;

    private long chiffreAffaire;
    private String cnps;
    private String cmu;
    private boolean presenceCompteBancaire;

    private OffsetDateTime dateEmission;
    private OffsetDateTime dateExpiration;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "compte_bancaire_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_compte_bancaire_artisan"))
    private TypeCompteBancaire typeCompteBancaire;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "classe_artisan_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_classe_artisan_artisan"))
    private ClasseArtisan classeArtisan;

    @OneToMany(fetch = LAZY, mappedBy = "artisan", orphanRemoval = true)
    private Collection<ArtisanApprenti> artisanApprentis;

    @OneToMany(fetch = LAZY, mappedBy = "artisan", orphanRemoval = true)
    private Collection<ArtisanCompagnon> artisanCompagnons;

    @OneToMany(fetch = LAZY, mappedBy = "artisan", orphanRemoval = true)
    private Collection<PaiementEnrolement> paiementEnrolements;

    /**   CRM de l'ARTISAN   **/
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "crm_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_crm_artisan"))
    private Crm crm;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "departement_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_departement_artisan"))
    private Departement departement;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "sous_prefecture_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_sous_prefecture_artisan"))
    private SousPrefecture sousPrefecture;

    @OneToMany(fetch = LAZY, mappedBy = "artisan", orphanRemoval = true)
    private Collection<Amende> amendes;

    @OneToMany(fetch = LAZY, mappedBy = "artisan", orphanRemoval = true)
    private Collection<CommentaireEnrolement> commentaireEnrolements;

}
