package org.example.orem.domain.orem.repository;

import org.example.orem.domain.orem.entity.EntireOrem;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntireOremRepository extends JpaRepository<EntireOrem, Long> {

}
