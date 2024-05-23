package org.example.orem.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.example.orem.domain.member.entity.Member;
import org.example.orem.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member getMember(String memberUUID) {
        return memberRepository.findByUuid(memberUUID).orElseThrow();
    }

    public void register(String nickname, String uuid) {
        if (memberRepository.existsByUuid(uuid)) {
            return;
        }
        memberRepository.save(Member.builder()
            .nickname(nickname)
            .uuid(uuid)
            .build());
    }
}
