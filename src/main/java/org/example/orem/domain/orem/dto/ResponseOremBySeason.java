package org.example.orem.domain.orem.dto;

import java.util.List;
import lombok.Builder;

@Builder
public record ResponseOremBySeason(
    Long id,
    String name,
    String city,
    String placeUrl,
    List<String> keywords,
    String imageUrl,
    String description,
    String season
) {

}
