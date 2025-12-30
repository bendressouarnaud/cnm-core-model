package com.cnmci.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;
import java.util.Collection;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
@Table(
        indexes = {
                @Index(name = "pays_gerant_id_idx", columnList = "nationalite"),
                @Index(name = "commune_residence_gerant_id_idx", columnList = "commune_residence_id"),
                @Index(name = "commune_naissance_gerant_id_idx", columnList = "commune_naissance_id"),
        }
)
public class Gerant extends AbstractEntity{

    private String civilite;
    private String nom;
    private String prenom;
    private String lieuNaissanceAutre;
    private OffsetDateTime dateNaissance;
    //private String lieuNaissance;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "commune_naissance_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_commune_naissance_gerant"))
    private Commune lieuNaissance;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "nationalite", nullable = true ,foreignKey = @ForeignKey(name = "FK_pays_gerant"))
    private Pays pays;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "statut_matrimonial_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_statut_matrimonial_gerant"))
    private StatutMatrimonial statutMatrimonial;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "type_document_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_type_document_gerant"))
    private TypeDocument typeDocument;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "commune_residence_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_commune_residence_gerant"))
    private Commune communeResidence;

    private String sexe;
    private String numeroPiece;
    private String pieceDelivre;
    private OffsetDateTime dateEmissionPiece;

    private String quartierResidence;
    private String adressePostal;
    private String contact1;
    private String contact2;
    private String email;

    @OneToMany(fetch = LAZY, mappedBy = "gerant", orphanRemoval = true)
    private Collection<Entreprise> entreprises;

}
