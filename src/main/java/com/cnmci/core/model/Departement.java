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
                @Index(name = "crm_departement_id_idx", columnList = "crm_id")
        }
)
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Departement extends AbstractEntity{

    private String libelle;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "crm_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_crm_departement"))
    private Crm crm;

    @OneToMany(fetch = LAZY, mappedBy = "departement")
    private Collection<SousPrefecture> sousPrefectures;

    @OneToMany(fetch = LAZY, mappedBy = "departement")
    private Collection<Artisan> artisans;

    @OneToMany(fetch = LAZY, mappedBy = "departement")
    private Collection<Entreprise> entreprises;

}
