package org.example.orem.domain.orem.controller;

import lombok.RequiredArgsConstructor;
import org.example.orem.domain.orem.dto.ResponseLikeOrems;
import org.example.orem.domain.orem.dto.ResponseOremAndPlantByBirth;
import org.example.orem.domain.orem.dto.ResponseOremBySeason;
import org.example.orem.domain.orem.service.OremService;
import org.example.orem.global.utils.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orem")
public class OremController {

    private final OremService oremService;

    @GetMapping("/recommend/birthday")
    public ResponseEntity<ResponseDTO<ResponseOremAndPlantByBirth>> suggestOremAndPlant(
        @RequestParam(name = "month", defaultValue = "1") int month,
        @RequestParam(name = "day", defaultValue = "1") int day
    ) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(ResponseDTO.res(HttpStatus.OK, oremService.suggestOremByBirth(month, day)));
    }

    @GetMapping("/recommend")
    public ResponseEntity<ResponseDTO<ResponseOremBySeason>> recommendedBySeason(
        @RequestParam(name = "season", defaultValue = "봄") String season
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.res(HttpStatus.OK,
            oremService.recommendedBySeason(season)));
    }

    @GetMapping("/scrap")
    public ResponseEntity<ResponseDTO<String>> scrapOrem(
        @RequestParam(name = "oremId") Long oremId,
        @RequestParam(name = "uuid") String memberUUID
    ) {
        oremService.likeOrem(oremId, memberUUID);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.res(HttpStatus.OK, "Success"));
    }

    @GetMapping("/scraplist")
    public ResponseEntity<ResponseDTO<ResponseLikeOrems>> getScrapedOrems(
        @RequestParam(name = "uuid") String memberUUID
    ) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(ResponseDTO.res(HttpStatus.OK, oremService.getLikeOremList(memberUUID)));

    }
}
