package com.hanex.starter.common.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanex.starter.common.api.ApiResponseDto;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterResponseUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void unAuthorized(HttpServletResponse response, Exception e) throws IOException {

        ApiResponseDto<?> apiResponseDto = new ApiResponseDto<>(HttpStatus.UNAUTHORIZED, "unAuthorized", e.getMessage());
        String responseBody = mapper.writeValueAsString(apiResponseDto);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().println(responseBody);
    }

    public static void forbidden(HttpServletResponse response, Exception e) throws IOException {

        ApiResponseDto<?> apiResponseDto = new ApiResponseDto<>(HttpStatus.FORBIDDEN, "forbidden", e.getMessage());
        String responseBody = mapper.writeValueAsString(apiResponseDto);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().println(responseBody);
    }
}
