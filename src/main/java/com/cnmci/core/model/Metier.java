package com.cnmci.core.model;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Metier extends AbstractEntity{
    private String libelle;

    @OneToMany(fetch = LAZY, mappedBy = "metierPrincipale", orphanRemoval = true)
    private Collection<Activite> activitesPrincipale;

    @OneToMany(fetch = LAZY, mappedBy = "metierSecondaire", orphanRemoval = true)
    private Collection<Activite> activitesSecondaire;

    @OneToMany(fetch = LAZY, mappedBy = "activitePrincipale", orphanRemoval = true)
    private Collection<Entreprise> entreprisesPrincipales;

    @OneToMany(fetch = LAZY, mappedBy = "activiteSecondaire", orphanRemoval = true)
    private Collection<Entreprise> entreprisesSecondaires;

    @OneToMany(fetch = LAZY, mappedBy = "metier", orphanRemoval = true)
    private Collection<Artisan> artisans;

    @OneToMany(fetch = LAZY, mappedBy = "metier", orphanRemoval = true)
    private Collection<Apprenti> apprentis;

    @OneToMany(fetch = LAZY, mappedBy = "metier", orphanRemoval = true)
    private Collection<Compagnon> compagnons;
}
