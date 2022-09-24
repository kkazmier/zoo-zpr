package com.zoozpr.animal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AnimalFullInfo {
    private Long id;
    private String animalName;
    private String animalType;
    private String animalTypeName;
    private Integer feedConsumption;
    private String zoneName;
}
