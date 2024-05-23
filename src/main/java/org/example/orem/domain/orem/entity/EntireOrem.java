package org.example.orem.domain.orem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class EntireOrem {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Builder
    public EntireOrem(String name) {
        this.name = name;
    }

}
