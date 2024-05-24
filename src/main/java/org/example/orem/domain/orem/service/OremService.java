package org.example.orem.domain.orem.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.orem.domain.member.entity.Member;
import org.example.orem.domain.member.service.MemberService;
import org.example.orem.domain.orem.dto.OremSimpleInfo;
import org.example.orem.domain.orem.dto.ResponseLikeOrems;
import org.example.orem.domain.orem.dto.ResponseOremAndPlantByBirth;
import org.example.orem.domain.orem.dto.ResponseOremBySeason;
import org.example.orem.domain.orem.entity.EntireOrem;
import org.example.orem.domain.orem.entity.LikeOrem;
import org.example.orem.domain.orem.entity.Orem;
import org.example.orem.domain.orem.repository.EntireOremRepository;
import org.example.orem.domain.orem.repository.LikeOremRepository;
import org.example.orem.domain.orem.repository.OremRepository;
import org.example.orem.domain.plant.dto.PlantResponse;
import org.example.orem.domain.plant.service.PlantService;
import org.example.orem.global.utils.AdjectiveGenerator;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OremService {

    private final OremRepository oremRepository;
    private final EntireOremRepository entireOremRepository;
    private final PlantService plantService;
    private final MemberService memberService;
    private final LikeOremRepository likeOremRepository;

    // 1. 형용사,
    // 2. 식물
    // 3. 오름
    public ResponseOremAndPlantByBirth suggestOremByBirth(int month, int day) {
        int idx = 30 * (month - 1) + day;
        EntireOrem entireOrem = entireOremRepository.findById((long) idx).orElseThrow();
        PlantResponse plantResponse = plantService.getPlantByBirth(month);
        return ResponseOremAndPlantByBirth.builder()
            .adjective(AdjectiveGenerator.get())
            .oremName(entireOrem.getName())
            .plantResponse(plantResponse)
            .build();
    }

    public ResponseOremBySeason recommendedBySeason(String season) {
        List<Orem> orems = oremRepository.findAllBySeason(season);
        int length = orems.size();
        int idx = generateIdx(length);
        Orem orem = orems.get(idx);

        return ResponseOremBySeason.builder()
            .id(orem.getId())
            .name(orem.getName())
            .city(orem.getCity())
            .season(orem.getSeason())
            .placeUrl(orem.getPlaceUrl())
            .keywords(convertToList(orem.getKeyword()))
            .imageUrl(orem.getImageUrl())
            .description(orem.getDescription())
            .build();
    }

    public void likeOrem(Long oremId, String memberUUID) {
        Member member = memberService.getMember(memberUUID);
        Orem orem = oremRepository.findById(oremId).orElseThrow();

        likeOremRepository.save(LikeOrem.builder()
            .member(member)
            .orem(orem)
            .build());
    }

    public ResponseLikeOrems getLikeOremList(String memberUUID) {
        Member member = memberService.getMember(memberUUID);
        List<LikeOrem> likeOrems = likeOremRepository.findAllByMember(member);
        List<OremSimpleInfo> infos = new ArrayList<>();
        likeOrems.forEach(likeOrem -> {
            infos.add(OremSimpleInfo.builder()
                .oremId(likeOrem.getOrem().getId())
                .name(likeOrem.getOrem().getName())
                .season(likeOrem.getOrem().getSeason())
                .build());
        });

        return ResponseLikeOrems.builder()
            .count(likeOrems.size())
            .orems(infos)
            .build();
    }

    public ResponseOremBySeason getDetail(Long oremId) {
        Orem orem = oremRepository.findById(oremId).orElseThrow();
        return ResponseOremBySeason.builder()
            .id(orem.getId())
            .name(orem.getName())
            .city(orem.getCity())
            .placeUrl(orem.getPlaceUrl())
            .keywords(convertToList(orem.getKeyword()))
            .imageUrl(orem.getImageUrl())
            .description(orem.getDescription())
            .season(orem.getSeason())
            .build();
    }

    private List<String> convertToList(String keyword) {
        return Arrays.asList(keyword.split(","));
    }

    private int generateIdx(int maxSize) {
        Random random = new Random();
        return random.nextInt(maxSize);

    }

}
