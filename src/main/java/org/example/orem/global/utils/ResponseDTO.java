package org.example.orem.global.utils;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseDTO<T> {
    private final int code;
    private final T data;

    @Builder
    private ResponseDTO(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public static ResponseDTO<Object> res(final HttpStatus httpStatus) {
        return ResponseDTO.<Object>builder()
            .code(httpStatus.value())
            .build();
    }

    public static <T> ResponseDTO<T> res(final HttpStatus httpStatus, final T data) {
        return ResponseDTO.<T>builder()
            .code(httpStatus.value())
            .data(data)
            .build();
    }
}
