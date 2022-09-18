package com.zoozpr.animaltype;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zoozpr.animal.Animal;
import com.zoozpr.model.NamedEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "animal_types", schema = "public")
public class AnimalType extends NamedEntity {
    @Column(name = "type")
    String type;

    @OneToOne(mappedBy = "animalType")
    @JsonIgnore
    Animal animal;
}
