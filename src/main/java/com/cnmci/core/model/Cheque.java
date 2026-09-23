package com.cnmci.core.model;

import jakarta.persistence.*;
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
@Table(
    indexes = {
        @Index(name = "utilisateur_cheque_id_idx", columnList = "utilisateur_id"),
        @Index(name = "numero_cheque_id_idx", columnList = "numero_cheque"),
    }
)
public class Cheque extends AbstractEntity{

    @Column(length = 70)
    private String nomDeposant;
    @Column(length = 40)
    private String libelleBanque;
    @Column(length = 30)
    private String numeroCheque;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = true, foreignKey = @ForeignKey(name = "FK_utilisateur_cheque"))
    private Utilisateur utilisateur;

    @OneToMany(fetch = LAZY, mappedBy = "cheque", orphanRemoval = true)
    private Collection<PaiementCheque> paiementCheques;
}
