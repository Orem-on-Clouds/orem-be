package org.example.orem.domain.plant.repository;

import org.example.orem.domain.plant.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {

}
