package com.zoozpr.zone;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "zones", schema = "public")
public class Zone extends NamedEntity {
    @OneToMany(mappedBy="zone", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Animal> animals;

    @Override
    public String toString() {
        return "Zone{" +
                "id=" + super.getId() +
                "name=" + super.getName() +
                "animals=" + animals +
                '}';
    }
}
