package org.example.orem.domain.member.repository;

import java.util.Optional;
import org.example.orem.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUuid(String uuid);
    boolean existsByUuid(String uuid);

}
