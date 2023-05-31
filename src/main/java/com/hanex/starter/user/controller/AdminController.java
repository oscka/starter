package com.hanex.starter.user.controller;

import com.hanex.starter.common.api.ApiResponseDto;
import com.hanex.starter.user.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "관리자",description = "관리자 API")
@RequestMapping("/v1/admin")
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminService adminService;

    @Operation(summary = "관리자", description = "사용자 id 로 상세조회")
    @GetMapping("/{id}")
    public ApiResponseDto findById(UUID id){
        return ApiResponseDto.createOK(adminService.findById(id));
    }

    @Operation(summary = "관리자",description = "사용자 상태 정지")
    @GetMapping("/user-ban/{id}")
    public ApiResponseDto userBan(UUID id){
        adminService.userBan(id);
        return ApiResponseDto.DEFAULT_OK;
    }





}
