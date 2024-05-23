package org.example.orem.domain.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.orem.domain.member.service.MemberService;
import org.example.orem.global.utils.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/register")
    public ResponseEntity<ResponseDTO<String>> register(
        @RequestParam(name = "nickname") String nickname,
        @RequestParam(name = "uuid") String uuid) {
        memberService.register(nickname, uuid);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.res(HttpStatus.OK, "Success"));
    }
}
