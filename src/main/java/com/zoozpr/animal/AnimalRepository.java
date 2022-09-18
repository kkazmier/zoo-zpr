package com.zoozpr.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    @Query(value = "select * from animals a where a.name = :name", nativeQuery = true)
    List<Animal> findAllByName(@Param("name") String name);
}
