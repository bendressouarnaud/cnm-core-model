package com.cnmci.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Collection;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@SuperBuilder
@Entity
@Table(
        indexes = {
                @Index(name = "departement_sousprefecture_id_idx", columnList = "departement_id")
        }
)
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class SousPrefecture extends AbstractEntity{

    private String libelle;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "departement_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_departement_sousprefecture"))
    private Departement departement;

    @OneToMany(fetch = LAZY, mappedBy = "sousPrefecture")
    private Collection<Commune> communes;

    @OneToMany(fetch = LAZY, mappedBy = "sousPrefecture")
    private Collection<Artisan> artisans;

    @OneToMany(fetch = LAZY, mappedBy = "sousPrefecture")
    private Collection<Entreprise> entreprises;

}
