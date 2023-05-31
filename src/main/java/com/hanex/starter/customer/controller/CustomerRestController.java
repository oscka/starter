package com.hanex.starter.customer.controller;

import com.hanex.starter.common.api.ApiResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "고객사 (화주) API",description = "고객사 (화주) API")
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
@RestController
public class CustomerRestController {

    @Operation(description = "고객사 생성",summary = "고객사 생성")
    @PostMapping
    public ApiResponseDto save(){
        return ApiResponseDto.DEFAULT_OK;
    }
}
