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
                @Index(name = "utilisateur_eff_livraison_id_idx", columnList = "utilisateur_id"),
                @Index(name = "entreprise_eff_livraison_id_idx", columnList = "entreprise_id"),
                @Index(name = "artisan_eff_livraison_id_idx", columnList = "artisan_id"),
                @Index(name = "apprenti_eff_livraison_id_idx", columnList = "apprenti_id"),
                @Index(name = "compagnon_eff_livraison_id_idx", columnList = "compagnon_id"),
        }
)
public class EffectuerLivraison extends AbstractEntity{
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_utilisateur_effectuer_livraison"))
    private Utilisateur utilisateur;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "entreprise_id", nullable = true,
            foreignKey = @ForeignKey(name = "FK_entreprise_effectuer_livraison"))
    private Entreprise entreprise;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "artisan_id", nullable = true,
            foreignKey = @ForeignKey(name = "FK_artisan_effectuer_livraison"))
    private Artisan artisan;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "apprenti_id", nullable = true,
            foreignKey = @ForeignKey(name = "FK_apprenti_effectuer_livraison"))
    private Apprenti apprenti;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "compagnon_id", nullable = true,
            foreignKey = @ForeignKey(name = "FK_compagnon_effectuer_livraison"))
    private Compagnon compagnon;
}
