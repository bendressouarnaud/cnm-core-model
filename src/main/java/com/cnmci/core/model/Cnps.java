package com.cnmci.core.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Entity
public class Cnps extends AbstractEntity{
    private Long artisanId;
    private Long apprentiId;
    private Long compagnonId;
}
