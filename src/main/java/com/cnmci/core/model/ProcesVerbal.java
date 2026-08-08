package com.cnmci.core.model;

import com.cnmci.core.enums.DelaiReglement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
@Table(
        indexes = {
                @Index(name = "entreprise_proces_verbal_id_idx", columnList = "entreprise_id"),
                @Index(name = "artisan_proces_verbal_id_idx", columnList = "artisan_id"),
                @Index(name = "apprenti_proces_verbal_id_idx", columnList = "apprenti_id"),
                @Index(name = "compagnon_proces_verbal_id_idx", columnList = "compagnon_id"),
                @Index(name = "utilisateur_proces_verbal_idx", columnList = "utilisateur_id")
        }
)
public class ProcesVerbal extends AbstractEntity {

    @Enumerated(EnumType.ORDINAL)
    private DelaiReglement delaiReglement;
    private String numeroPv;

    private boolean defautImmatriculation;
    private boolean defautImmatriculationApprenti;
    private boolean defautImmatriculationCompagnon;
    private boolean actif;
    private String codeValidation;
    private OffsetDateTime dateReglement;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_utilisateur_proces_verbal"))
    private Utilisateur utilisateur;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "entreprise_id", nullable = true,
            foreignKey = @ForeignKey(name = "FK_entreprise_proces_verbal"))
    private Entreprise entreprise;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "artisan_id", nullable = true,
            foreignKey = @ForeignKey(name = "FK_artisan_proces_verbal"))
    private Artisan artisan;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "apprenti_id", nullable = true,
            foreignKey = @ForeignKey(name = "FK_apprenti_proces_verbal"))
    private Apprenti apprenti;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "compagnon_id", nullable = true,
            foreignKey = @ForeignKey(name = "FK_compagnon_proces_verbal"))
    private Compagnon compagnon;
}
