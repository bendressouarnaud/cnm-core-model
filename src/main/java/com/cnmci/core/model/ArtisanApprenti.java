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
                @Index(name = "artisan_apprenti_id_idx", columnList = "artisan_id"),
                @Index(name = "apprenti_artisan_id_idx", columnList = "apprenti_id")
        }
)
public class ArtisanApprenti extends AbstractEntity{

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "artisan_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_artisan_apprenti"))
    private Artisan artisan;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "apprenti_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_apprenti_artisan"))
    private Apprenti apprenti;

}
