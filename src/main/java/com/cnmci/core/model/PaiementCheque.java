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
                @Index(name = "cheque_paiement_id_idx", columnList = "cheque_id"),
                @Index(name = "cheque_artisan_id_idx", columnList = "artisan_id"),
                @Index(name = "cheque_apprenti_id_idx", columnList = "apprenti_id"),
                @Index(name = "cheque_compagnon_id_idx", columnList = "compagnon_id"),
        }
)
public class PaiementCheque extends AbstractEntity {

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "cheque_id", nullable = false, foreignKey = @ForeignKey(name = "FK_paiement_cheque"))
    private Cheque cheque;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "artisan_id", nullable = true, foreignKey = @ForeignKey(name = "FK_paiement_cheque_artisan"))
    private Artisan artisan;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "apprenti_id", nullable = true, foreignKey = @ForeignKey(name = "FK_paiement_cheque_apprenti"))
    private Apprenti apprenti;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "compagnon_id", nullable = true, foreignKey = @ForeignKey(name = "FK_paiement_cheque_compagnon"))
    private Compagnon compagnon;

}
