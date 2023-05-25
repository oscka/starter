package com.hanex.starter.error.exception;


import com.hanex.starter.common.api.ApiResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;

// 권한 없음
@Getter
public class Exception403 extends RuntimeException {
    public Exception403(String message) {
        super(message);
    }

    public ApiResponseDto<?> body(){
        return new ApiResponseDto<>(HttpStatus.FORBIDDEN, "forbidden", getMessage());
    }

    public HttpStatus status(){
        return HttpStatus.FORBIDDEN;
    }
}
