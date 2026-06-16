package com.cnmci.core.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
public class ArtisanOld extends AbstractEntity{

    private String nom; // 3
    private String prenom; // 4
    private OffsetDateTime dateNaissance; // 5
    private String lieuNaissance; // 6
    private String contact1; // 11
    private String email; // 12
    private String numeroPieceIdentite; // 15
    private String specialite; // 18
    private String raisonSociale; // 33
    private String numeroRegistre; // 76
    private OffsetDateTime dateFinValidite; // 161

}
