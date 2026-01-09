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
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Crm extends AbstractEntity{

    private String codeCrm;
    private String label;
    private String abreviation;

    @OneToMany(fetch = LAZY, mappedBy = "crm")
    private Collection<Departement> departements;

    /*@OneToMany(fetch = LAZY, mappedBy = "crm")
    private Collection<Commune> communes;*/

    @OneToMany(fetch = LAZY, mappedBy = "crm")
    private Collection<Artisan> artisans;

    @OneToMany(fetch = LAZY, mappedBy = "crm")
    private Collection<Entreprise> entreprises;

}
