package com.hanex.starter.common.security;

import com.hanex.starter.common.api.ApiResponseDto;
import com.hanex.starter.common.util.CustomObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class FilterResponseUtil {


    public static void unAuthorized(HttpServletResponse response, Exception e)  {

        ApiResponseDto<?> apiResponseDto = new ApiResponseDto<>(HttpStatus.UNAUTHORIZED, "unAuthorized", e.getMessage());
        try (OutputStream os = response.getOutputStream()) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            new CustomObjectMapper().writeValue(os,apiResponseDto);
        } catch (IOException exception){
            //exception.printStackTrace();
        }

    }

    public static void forbidden(HttpServletResponse response, Exception e) {

        ApiResponseDto<?> apiResponseDto = new ApiResponseDto<>(HttpStatus.FORBIDDEN, "forbidden", e.getMessage());
        try (OutputStream os = response.getOutputStream()) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            new CustomObjectMapper().writeValue(os,apiResponseDto);
        } catch (IOException exception){
            //exception.printStackTrace();
        }
    }
}
