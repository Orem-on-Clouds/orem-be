package org.example.orem.domain.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestRestController {
    @GetMapping("/test")
    public ResponseEntity<?> pingTest() {
        return ResponseEntity.ok(true);
    }
}
