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
                @Index(name = "entreprise_apprenti_id_idx", columnList = "entreprise_id"),
                @Index(name = "apprenti_entreprise_id_idx", columnList = "apprenti_id")
        }
)
public class EntrepriseApprenti extends AbstractEntity{

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "entreprise_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_entreprise_apprenti"))
    private Entreprise entreprise;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "apprenti_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_apprenti_entreprise"))
    private Apprenti apprenti;

}
