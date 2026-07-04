package com.cnmci.core.model;

import com.cnmci.core.enums.CategorieEnrolement;
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
                @Index(name = "utilisateur_payment_cp_id_idx", columnList = "utilisateur_id")
        }
)
public class PaymentRequestCopie extends AbstractEntity {
    private String waveId;
    private long requesterId;
    private String requesterType;
    private int montant;
    private int etat; // 0 : Not paid, 1 : paid
    private String launchUrl;
    @Enumerated(EnumType.ORDINAL)
    private CategorieEnrolement categorieEnrolement;
    private int paymentType; // 0 : Frais d'enrôlement, 1 : Frais de livraison

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = true,
            foreignKey = @ForeignKey(name = "FK_utilisateur_payment_request_cp"))
    private Utilisateur utilisateur;
}
