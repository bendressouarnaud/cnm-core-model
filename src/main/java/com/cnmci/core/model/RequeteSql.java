package com.cnmci.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
public class RequeteSql extends AbstractEntity {
    private String phrase;
    @Column(length = 300)
    private String requete;
}
