package org.example.orem.domain.orem.repository;

import java.util.List;
import org.example.orem.domain.orem.entity.Orem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OremRepository extends JpaRepository<Orem, Long> {

    List<Orem> findAllBySeason(String season);
}
