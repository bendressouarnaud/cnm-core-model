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
                @Index(name = "sous_prefecture_commune_id_idx", columnList = "sous_prefecture_id")
        }
)
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Commune extends AbstractEntity{

    private String libelle;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "sous_prefecture_id", nullable = true ,foreignKey = @ForeignKey(name = "FK_sous_prefecture_commune"))
    private SousPrefecture sousPrefecture;

    @OneToMany(fetch = LAZY, mappedBy = "commune")
    private Collection<Entreprise> entreprises;

    // ARTISAN
    @OneToMany(fetch = LAZY, mappedBy = "communeResidence")
    private Collection<Artisan> artisansResidence;
    @OneToMany(fetch = LAZY, mappedBy = "lieuNaissance")
    private Collection<Artisan> artisansNaissance;

    // APPRENTI
    @OneToMany(fetch = LAZY, mappedBy = "communeResidence")
    private Collection<Apprenti> apprentisResidence;
    @OneToMany(fetch = LAZY, mappedBy = "lieuNaissance")
    private Collection<Apprenti> apprentisNaissance;

    // COMPAGNON
    @OneToMany(fetch = LAZY, mappedBy = "communeResidence")
    private Collection<Compagnon> compagnonsResidence;
    @OneToMany(fetch = LAZY, mappedBy = "lieuNaissance")
    private Collection<Compagnon> compagnonsNaissance;

    // GERANT
    @OneToMany(fetch = LAZY, mappedBy = "communeResidence")
    private Collection<Gerant> gerantsResidence;
    @OneToMany(fetch = LAZY, mappedBy = "lieuNaissance")
    private Collection<Gerant> gerantsNaissance;

}
