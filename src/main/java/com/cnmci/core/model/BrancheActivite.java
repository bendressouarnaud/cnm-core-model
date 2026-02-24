package com.cnmci.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
public class BrancheActivite extends AbstractEntity{

    private String libelle;

    @OneToMany(fetch = LAZY, mappedBy = "brancheActivite", orphanRemoval = true)
    private Collection<Metier> metiers;
}
