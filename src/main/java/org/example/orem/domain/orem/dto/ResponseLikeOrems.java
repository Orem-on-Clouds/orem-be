package org.example.orem.domain.orem.dto;

import java.util.List;
import lombok.Builder;

@Builder
public record ResponseLikeOrems(
    int count,
    List<OremSimpleInfo> orems
) {

}
