package com.hanex.starter.product.controller;

import com.hanex.starter.common.api.ApiResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "상품 API",description = "고객사 (화주) 가 상품을 관리하는 API")
@RequestMapping("/v1/product")
@RequiredArgsConstructor
@RestController
public class ProductRestController {

	@Operation(description = "상품 생성",summary = "상품 생성")
	@PostMapping("/{id}")
	private ApiResponseDto save(){
		return ApiResponseDto.DEFAULT_OK;
	}
}
