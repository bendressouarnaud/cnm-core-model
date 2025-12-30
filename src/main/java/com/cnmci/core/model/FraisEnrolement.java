package com.cnmci.core.model;

import com.cnmci.artisan.enums.CategorieEnrolement;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
public class FraisEnrolement extends AbstractEntity {
    private int montant;
    private boolean actif;

    @Enumerated(EnumType.ORDINAL)
    private CategorieEnrolement categorieEnrolement;
}
