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
public class Partenaire extends AbstractEntity {
    private String denomination;
    private String contact;
    private String email;

    @OneToMany(fetch = LAZY, mappedBy = "partenaire", orphanRemoval = true)
    private Collection<Utilisateur> utilisateurs;

    @OneToMany(fetch = LAZY, mappedBy = "partenaire", orphanRemoval = true)
    private Collection<PartenairePrestation> partenairePrestations;

    @OneToMany(fetch = LAZY, mappedBy = "partenaire", orphanRemoval = true)
    private Collection<GainEnrolement> gainEnrolements;
}
