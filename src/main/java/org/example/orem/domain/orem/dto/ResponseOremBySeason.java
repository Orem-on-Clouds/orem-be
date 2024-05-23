package org.example.orem.domain.orem.dto;

import java.util.List;
import lombok.Builder;

@Builder
public record ResponseOremBySeason(
    String name,
    String city,
    String placeUrl,
    List<String> keywords,
    String imageUrl,
    String description
) {

}
