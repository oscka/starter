//package com.hanex.starter.error.exception;
//
//import com.hanex.starter.common.api.ApiResponseCode;
//import com.hanex.starter.common.api.ApiResponseDto;
//import lombok.Getter;
//import org.springframework.http.HttpStatus;
//
//// 유효성 검사 실패, 잘못된 파라메터 요청
//@Getter
//public class Exception400 extends RuntimeException {
//
//    private String key;
//    private String value;
//
//    public Exception400(String key, String value) {
//        super(value);
//        this.key = key;
//        this.value = value;
//    }
//
//    public ApiResponseDto<?> body(){
//        ValidDTO validDTO = new ValidDTO(key, value);
//        return new ApiResponseDto<>(ApiResponseCode.BAD_PARAMETER, e.);
//    }
//
//    public HttpStatus status(){
//        return HttpStatus.BAD_REQUEST;
//    }
//}
