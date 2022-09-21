package com.zoozpr.animal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zoozpr.animaltype.AnimalType;
import com.zoozpr.model.NamedEntity;
import com.zoozpr.zone.Zone;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animals", schema = "public")
public class Animal extends NamedEntity {
    public Animal(Integer feedQuantity, Zone zone) {
        this.feedQuantity = feedQuantity;
        this.zone = zone;
    }

    @Column(name = "feed_quantity", nullable = false)
    private Integer feedQuantity;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "animal_type_id", referencedColumnName = "id")
    @JsonIgnore
    private AnimalType animalType;

    @ManyToOne
    @JoinColumn(name="zone_id", nullable = false)
    @JsonIgnore
    private Zone zone;

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + super.getId() +
                "feedQuantity=" + feedQuantity +
                ", animalType=" + animalType +
                ", zone=" + zone +
                '}';
    }
}
