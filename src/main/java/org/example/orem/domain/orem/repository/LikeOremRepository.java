package org.example.orem.domain.orem.repository;

import java.util.List;
import org.example.orem.domain.member.entity.Member;
import org.example.orem.domain.orem.entity.LikeOrem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeOremRepository extends JpaRepository<LikeOrem, Long> {

    List<LikeOrem> findAllByMember(Member member);
}
