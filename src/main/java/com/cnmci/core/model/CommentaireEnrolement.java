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
@Table(
        indexes = {
                @Index(name = "utilisateur_commentaire_enrol_id_idx", columnList = "utilisateur_id"),
                @Index(name = "artisan_commentaire_enrol_id_idx", columnList = "artisan_id"),
                @Index(name = "apprenti_commentaire_enrol_id_idx", columnList = "apprenti_id"),
                @Index(name = "compagnon_commentaire_enrol_id_idx", columnList = "compagnon_id"),
                @Index(name = "entreprise_commentaire_enrol_id_idx", columnList = "entreprise_id"),
        }
)
@NoArgsConstructor
public class CommentaireEnrolement extends AbstractEntity {

    private String commentaire;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false ,foreignKey = @ForeignKey(name = "FK_utilisateur_commentaire_enrol"))
    private Utilisateur utilisateur;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "artisan_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_artisan_commentaire_enrol"))
    private Artisan artisan;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "apprenti_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_apprenti_commentaire_enrol"))
    private Apprenti apprenti;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "compagnon_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_compagnon_commentaire_enrol"))
    private Compagnon compagnon;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "entreprise_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_entreprise_commentaire_enrol"))
    private Entreprise entreprise;

}
