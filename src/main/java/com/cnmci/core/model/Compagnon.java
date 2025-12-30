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
                @Index(name = "pays_compagnon_id_idx", columnList = "nationalite"),
                @Index(name = "commune_residence_compagnon_id_idx", columnList = "commune_residence_id"),
                @Index(name = "commune_naissance_compagnon_id_idx", columnList = "commune_naissance_id"),
                @Index(name = "utilisateur_compagnon_id_idx", columnList = "utilisateur_id"),
                @Index(name = "metier_compagnon_id_idx", columnList = "metier_id")
        }
)
public class Compagnon extends AbstractEntity{

    private UUID numeroIdentification;
    private String numeroImmatriculation;
    private String lieuNaissanceAutre;
    private String civilite;
    private String nom;
    private String prenom;
    private OffsetDateTime dateNaissance;
    //private String lieuNaissance;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "commune_naissance_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_commune_naissance_compagnon"))
    private Commune lieuNaissance;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "nationalite", nullable = true ,foreignKey = @ForeignKey(name = "FK_pays_compagnon"))
    private Pays pays;

    private String sexe;

    @Enumerated(EnumType.ORDINAL)
    private StatutType statutType;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "type_document_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_type_document_compagnon"))
    private TypeDocument typeDocument;

    private String numeroPiece;
    private String pieceDelivre;
    private OffsetDateTime dateEmissionPiece;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "niveau_etude_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_niveau_etude_compagnon"))
    private NiveauEtude niveauEtude;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "metier_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_metier_compagnon"))
    private Metier metier;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "classe_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_classe_compagnon"))
    private Classe classe;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "diplome_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_diplome_compagnon"))
    private Diplome diplome;

    private OffsetDateTime dateDebutCompagnonage;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "commune_residence_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_commune_residence_compagnon"))
    private Commune communeResidence;

    private String quartierResidence;
    private String adressePostal;
    private String contact1;
    private String contact2;
    private String email;
    private String cnps;
    private String cmu;

    private String photoCompagnon;
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

    @OneToMany(fetch = LAZY, mappedBy = "compagnon", orphanRemoval = true)
    private Collection<ArtisanCompagnon> artisanCompagnons;

    @OneToMany(fetch = LAZY, mappedBy = "compagnon", orphanRemoval = true)
    private Collection<EntrepriseCompagnon> entrepriseCompagnons;

    @OneToMany(fetch = LAZY, mappedBy = "compagnon", orphanRemoval = true)
    private Collection<PaiementEnrolement> paiementEnrolements;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_utilisateur_compagnon"))
    private Utilisateur utilisateur;

    @OneToMany(fetch = LAZY, mappedBy = "compagnon", orphanRemoval = true)
    private Collection<Amende> amendes;

    @OneToMany(fetch = LAZY, mappedBy = "compagnon", orphanRemoval = true)
    private Collection<CommentaireEnrolement> commentaireEnrolements;
}
