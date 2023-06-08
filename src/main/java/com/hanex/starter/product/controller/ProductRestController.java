package com.hanex.starter.product.controller;

import com.hanex.starter.common.api.ApiResponseDto;
import com.hanex.starter.common.security.CustomUser;
import com.hanex.starter.product.dto.ProductDto;
import com.hanex.starter.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "상품 관리 API",description = "고객사 (화주) 가 상품을 관리하는 API")
@RequestMapping("/v1/product")
@RequiredArgsConstructor
@RestController
public class ProductRestController {

	private final ProductService productService;

	@Operation(description = "상품 내역 검색(리스트)",summary = "상품 내역 검색 > 리스트,페이징")
	@GetMapping
	private ApiResponseDto searchProduct(@PageableDefault(size = 50, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable){
		return ApiResponseDto.createOK(productService.searchProduct(pageable));
	}

	@Operation(description = "상품 내역 상세 조회",summary = "상품 내역 상세 조회")
	@GetMapping("/{id}")
	private ApiResponseDto findProductById(@PathVariable Long id){
		return ApiResponseDto.createOK(productService.findProductById(id));
	}


	@Operation(description = "상품 내역 생성",summary = "상품 내역 생성")
	@PostMapping("/{id}")
	private ApiResponseDto createProduct(@RequestBody @Valid ProductDto.SaveRequest save, @AuthenticationPrincipal CustomUser user){
		productService.createProduct(save,user);
		return ApiResponseDto.DEFAULT_OK;
	}

	@Operation(description = "상품 내역 수정",summary = "상품 내역 수정")
	@PutMapping("/{id}")
	private ApiResponseDto updateProduct(@PathVariable Long id,@RequestBody @Valid ProductDto.UpdateRequest update, @AuthenticationPrincipal CustomUser user){
		productService.updateProduct(id,update,user);
		return ApiResponseDto.DEFAULT_OK;
	}

	@Operation(description = "상품 내역 삭제",summary = "상품 내역 삭제")
	@DeleteMapping("/{id}")
	private ApiResponseDto deleteById(@PathVariable Long id,@AuthenticationPrincipal CustomUser user){
		productService.deleteById(id,user);
		return ApiResponseDto.DEFAULT_OK;
	}
}
