package org.example.orem.domain.orem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.orem.domain.orem.repository.OremRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OremService {
    private final OremRepository oremRepository;

    public void suggestOremByBirth(){
        int month;
        int day;
    }

    private String makeSuggestSentence(String adjective, String plantName, String oremName){
        return "당신은 " + adjective + " " + plantName + "이(가) 자라나고 있는 " + oremName + "이에요.";
    }
}
