package org.example.orem.domain.orem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.orem.domain.member.entity.Member;

@Entity
@Getter
@NoArgsConstructor
public class LikeOrem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "orem_id")
    private Orem orem;

    @Builder
    public LikeOrem(Member member, Orem orem) {
        this.member = member;
        this.orem = orem;
    }
}
