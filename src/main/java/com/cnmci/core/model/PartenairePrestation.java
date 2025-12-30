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
                @Index(name = "partenaire_prestation_pp_idx", columnList = "partenaire_id"),
                @Index(name = "prestation_partenaire_pp_idx", columnList = "prestation_id")
        }
)
public class PartenairePrestation extends AbstractEntity {

    private int valeur;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "remuneration_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_remuneration_partenaire_prestation"))
    private Remuneration remuneration;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "partenaire_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_partenaire_prestation_pp"))
    private Partenaire partenaire;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "prestation_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_prestation_partenaire_pp"))
    private Prestation prestation;
}
