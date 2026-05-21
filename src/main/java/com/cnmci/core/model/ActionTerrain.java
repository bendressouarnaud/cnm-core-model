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
                @Index(name = "utilisateur_action_terrain_id_idx", columnList = "utilisateur_id"),
                @Index(name = "commune_action_terrain_id_idx", columnList = "commune_id"),
                @Index(name = "quartier_action_terrain_id_idx", columnList = "quartier_id")
        }
)
public class ActionTerrain extends AbstractEntity {

    private boolean actif;
    private boolean sent;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_utilisateur_action_terrain"))
    private Utilisateur utilisateur;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "commune_id", nullable = false, foreignKey = @ForeignKey(name = "FK_commune_action_terrain"))
    private Commune commune;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "quartier_id", nullable = false, foreignKey = @ForeignKey(name = "FK_quartier_action_terrain"))
    private Quartier quartier;
}
