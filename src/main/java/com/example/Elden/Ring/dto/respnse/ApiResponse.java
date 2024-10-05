package com.example.Elden.Ring.dto.respnse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiResponse<T> {
    private int code = 1000;
    private String message;
    private T result;

}
