package com.hanex.starter.customer.controller;

import com.hanex.starter.common.api.ApiResponseDto;
import com.hanex.starter.customer.dto.CustomerDto;
import com.hanex.starter.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Tag(name = "고객사 (화주) API",description = "고객사 (화주) API")
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
@RestController
public class CustomerRestController {

    private final CustomerService customerService;

    @Operation(description = "고객사 상세 조회",summary = "고객사 고유번호로 상세 조회")
    @GetMapping("/{id}")
    public ApiResponseDto findById (UUID id){
        return ApiResponseDto.createOK(customerService.findById(id));
    }

    @Operation(description = "고객사 검색",summary = "고객사 검색")
    @GetMapping
    public ApiResponseDto searchCustomer(Pageable pageable){
        return ApiResponseDto.createOK(customerService.searchCustomer(pageable));
    }

    @Operation(description = "고객사 생성",summary = "고객사 생성")
    @PostMapping
    public ApiResponseDto save(@Valid @RequestBody CustomerDto.SaveRequest save){
        customerService.save(save);
        return ApiResponseDto.DEFAULT_OK;
    }


    @Operation(description = "고객사 수정",summary = "고객사 수정")
    @PutMapping("/{id}")
    public ApiResponseDto update(@PathVariable UUID id, @Valid @RequestBody CustomerDto.UpdateRequest updateRequest){
        customerService.update(id,updateRequest);
        return ApiResponseDto.DEFAULT_OK;
    }


    @Operation(description = "고객사 삭제",summary = "고객사 삭제")
    @DeleteMapping("/{id}")
    public ApiResponseDto delete(@PathVariable UUID id){
        customerService.delete(id);
        return ApiResponseDto.DEFAULT_OK;
    }


}
