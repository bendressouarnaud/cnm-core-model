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

import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Profil extends AbstractEntity{
    private String libelle;
    private String description;
    private String code;
    private boolean actif;

    @OneToMany(fetch = EAGER, mappedBy = "profil")
    private Collection<Utilisateur> utilisateurs;
}
