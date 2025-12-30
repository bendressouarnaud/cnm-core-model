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
                @Index(name = "artisan_compagnon_id_idx", columnList = "artisan_id"),
                @Index(name = "compagnon_artisan_id_idx", columnList = "compagnon_id")
        }
)
public class ArtisanCompagnon extends AbstractEntity{

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "artisan_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_artisan_compagnon"))
    private Artisan artisan;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "compagnon_id", nullable = true ,
            foreignKey = @ForeignKey(name = "FK_compagnon_artisan"))
    private Compagnon compagnon;

}