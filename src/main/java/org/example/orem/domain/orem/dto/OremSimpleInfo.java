package org.example.orem.domain.orem.dto;

import lombok.Builder;

@Builder
public record OremSimpleInfo(
    Long oremId,
    String name
) {

}
