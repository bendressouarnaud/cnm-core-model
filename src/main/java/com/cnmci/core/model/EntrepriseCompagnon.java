package com.cnmci.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
@Table(
        indexes = {
                @Index(name = "entreprise_compagnon_id_idx", columnList = "entreprise_id"),
                @Index(name = "compagnon_entreprise_id_idx", columnList = "compagnon_id")
        }
)
public class EntrepriseCompagnon extends AbstractEntity{

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "entreprise_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_entreprise_compagnon"))
    private Entreprise entreprise;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "compagnon_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_compagnon_entreprise"))
    private Compagnon compagnon;

}