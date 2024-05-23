package org.example.orem.domain.plant.repository;

import java.util.List;
import java.util.Optional;
import org.example.orem.domain.plant.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {

    Optional<Plant> findByBloomingSeason(int bloomingSeason);

    List<Plant> findAllByBloomingSeason(int bloomingSeason);
}
