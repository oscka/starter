package com.hanex.starter.order.controller;

import com.hanex.starter.common.api.ApiResponseDto;
import com.hanex.starter.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "출고 API" ,description = "OMS 출고")
@RequestMapping("/v1/order")
@RequiredArgsConstructor
@RestController
public class OrderRestController {

    private final OrderService orderService;

    @Operation(summary = "출고 생성",description = "출고 생성")
    @PostMapping
    public ApiResponseDto createOrder(){

        orderService.createOrder();
        return ApiResponseDto.DEFAULT_OK;
    }



}
