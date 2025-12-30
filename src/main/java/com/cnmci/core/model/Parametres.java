package com.cnmci.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Parametres {

    @Id
    private Long id;

    //@Column(name = "byte_array")
    private byte[] byteArray;

    private boolean envoiMail;
}
