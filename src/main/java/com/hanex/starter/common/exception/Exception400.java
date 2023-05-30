package com.hanex.starter.common.exception;

import com.hanex.starter.common.api.ApiResponseDto;
import com.hanex.starter.common.api.ValidDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;

// 유효성 검사 실패, 잘못된 파라메터 요청
@Getter
public class Exception400 extends RuntimeException {

    private String key;
    private String value;

    public Exception400(String key, String value) {
        super(value);
        this.key = key;
        this.value = value;
    }

    public ApiResponseDto<?> body(){
        ValidDto validDTO = new ValidDto(key, value);
        return new ApiResponseDto<>(HttpStatus.BAD_REQUEST, "badRequest", validDTO);
    }

    public HttpStatus status(){
        return HttpStatus.BAD_REQUEST;
    }
}