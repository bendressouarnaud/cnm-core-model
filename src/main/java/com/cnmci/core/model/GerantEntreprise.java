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
                @Index(name = "gerant_entreprise_co_id_idx", columnList = "co_gerant_id"),
                @Index(name = "gerant_entreprise_ent_id_idx", columnList = "entreprise_id")
        }
)
public class GerantEntreprise extends AbstractEntity {

    private boolean actif;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "co_gerant_id", nullable = false ,
            foreignKey = @ForeignKey(name = "FK_cogerant_entreprise_gerant"))
    private CoGerant coGerant;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "entreprise_id", nullable = false ,
            foreignKey = @ForeignKey(name = "FK_cogerant_entreprise_entreprise"))
    private Entreprise entreprise;
}
