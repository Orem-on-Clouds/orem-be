package org.example.orem.domain.orem.controller;

import lombok.RequiredArgsConstructor;
import org.example.orem.domain.orem.dto.ResponseOremAndPlantByBirth;
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
@RequestMapping("/orem")
public class OremController {

    private final OremService oremService;

    @GetMapping("/recommend/birthday")
    public ResponseEntity<ResponseDTO<ResponseOremAndPlantByBirth>> suggestOremAndPlant(
        @RequestParam(name="month", defaultValue = "1") int month,
        @RequestParam(name="day", defaultValue = "1") int day
    ){
        ResponseOremAndPlantByBirth response = oremService.suggestOremByBirth(month, day);
        return ResponseEntity.status(HttpStatus.OK)
            .body(ResponseDTO.res(HttpStatus.OK, response));
    }
}
