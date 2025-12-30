package com.cnmci.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
public class StatutMatrimonial extends AbstractEntity{
    private String libelle;
    private boolean actif;

    @OneToMany(fetch = LAZY, mappedBy = "statutMatrimonial")
    private Collection<Artisan> artisans;
}
