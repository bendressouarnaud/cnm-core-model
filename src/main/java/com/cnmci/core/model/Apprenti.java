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
                @Index(name = "pays_apprenti_id_idx", columnList = "nationalite"),
                @Index(name = "commune_residence_apprenti_id_idx", columnList = "commune_residence_id"),

                @Index(name = "commune_naissance_apprenti_id_idx", columnList = "commune_naissance_id"),

                @Index(name = "utilisateur_apprenti_id_idx", columnList = "utilisateur_id"),
                @Index(name = "metier_apprenti_id_idx", columnList = "metier_id")
        }
)
public class Apprenti extends AbstractEntity{

    private UUID numeroIdentification;
    private String numeroImmatriculation;
    private String lieuNaissanceAutre;
    private String civilite;
    private String nom;
    private String prenom;
    private OffsetDateTime dateNaissance;
    //private String lieuNaissance;

    private OffsetDateTime dateEmission;
    private OffsetDateTime dateExpiration;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "commune_naissance_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_commune_naissance_apprenti"))
    private Commune lieuNaissance;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "nationalite", nullable = true ,foreignKey = @ForeignKey(name = "FK_pays_apprenti"))
    private Pays pays;

    private String sexe;

    @Enumerated(EnumType.ORDINAL)
    private StatutType statutType;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "type_document_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_type_document_apprenti"))
    private TypeDocument typeDocument;

    private String numeroPiece;
    private String pieceDelivre;
    private OffsetDateTime dateEmissionPiece;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "niveau_etude_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_niveau_etude_apprenti"))
    private NiveauEtude niveauEtude;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "metier_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_metier_apprenti"))
    private Metier metier;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "classe_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_classe_apprenti"))
    private Classe classe;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "diplome_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_diplome_apprenti"))
    private Diplome diplome;

    private OffsetDateTime dateDebutApprentissage;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "commune_residence_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_commune_residence_apprenti"))
    private Commune communeResidence;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_utilisateur_apprenti"))
    private Utilisateur utilisateur;

    private String quartierResidence;
    private String adressePostal;
    private String contact1;
    private String contact2;
    private String email;

    private String photoApprenti;
    private String photoCniRecto;
    private String photoCniVerso;

    private int statutKyc;
    private int statutPaiement;
    private Double longitude;
    private Double latitude;
    private int print;

    private boolean aSuiviFormation;
    private String centreFormationMetier;
    private String intituleFormationMetier;
    private boolean formationMetierTerminee;
    private String diplomeObtenuMetier;
    private String cnps;
    private String cmu;

    @OneToMany(fetch = LAZY, mappedBy = "apprenti", orphanRemoval = true)
    private Collection<ArtisanApprenti> artisanApprentis;

    @OneToMany(fetch = LAZY, mappedBy = "apprenti", orphanRemoval = true)
    private Collection<EntrepriseApprenti> entrepriseApprentis;

    @OneToMany(fetch = LAZY, mappedBy = "apprenti", orphanRemoval = true)
    private Collection<PaiementEnrolement> paiementEnrolements;

    @OneToMany(fetch = LAZY, mappedBy = "apprenti", orphanRemoval = true)
    private Collection<Amende> amendes;

    @OneToMany(fetch = LAZY, mappedBy = "apprenti", orphanRemoval = true)
    private Collection<CommentaireEnrolement> commentaireEnrolements;
}
