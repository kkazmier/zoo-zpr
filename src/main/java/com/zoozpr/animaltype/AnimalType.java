package com.zoozpr.animaltype;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zoozpr.animal.Animal;
import com.zoozpr.model.NamedEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animal_types", schema = "public")
public class AnimalType extends NamedEntity {
    @Column(name = "type")
    String type;

    @OneToMany(mappedBy = "animalType")
    @JsonIgnore
    List<Animal> animals;
}
