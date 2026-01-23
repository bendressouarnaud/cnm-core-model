package com.cnmci.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
@Table(
    indexes = {
        @Index(name = "commune_quartier_id_idx", columnList = "commune_id"),
    }
)
public class Quartier extends AbstractEntity {
    private String libelle;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "commune_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_commune_quartier"))
    private Commune commune;

    // ARTISAN
    @OneToMany(fetch = LAZY, mappedBy = "quartierResidenceId")
    private Collection<Artisan> artisans;
    @OneToMany(fetch = LAZY, mappedBy = "quartierSiegeId")
    private Collection<Activite> activites;
    @OneToMany(fetch = LAZY, mappedBy = "quartierSiegeId")
    private Collection<Entreprise> entreprises;
}
