package org.example.orem.domain.orem.controller;

import lombok.RequiredArgsConstructor;
import org.example.orem.domain.orem.service.OremService;
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

//    @GetMapping("")
//    public ResponseEntity<> suggestOremAndPlant(
//        @RequestParam(name="month") int month,
//        @RequestParam(name="day") int day
//    ){
//        oremService.suggestOremByBirth();
//    }
}
