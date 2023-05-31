package com.hanex.starter.member.command.controller;

import com.hanex.starter.common.api.ApiResponseDto;
import com.hanex.starter.member.command.dto.MemberDto;
import com.hanex.starter.member.command.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Tag(name = "사용자 (거래처,실행사,택배사) API",description = "사용자 (거래처,실행사,택배사) API")
@RequestMapping("/v1/member")
@RestController
@RequiredArgsConstructor
public class MemberRestController {

	private final MemberService memberService;

	@Operation(summary = "사용자 생성", description = "Customer (고객사) 가 사용자를 생성")
	@PostMapping
	public ApiResponseDto save (@Valid @RequestBody MemberDto.SaveRequest save){
        memberService.save(save);
		return ApiResponseDto.DEFAULT_OK;
	}


	@Operation(summary = "사용자 리스트 조회", description = "Customer (고객사) 가 사용자 리스트 조회")
	@GetMapping
	private ApiResponseDto findAll(Pageable pageable, @RequestParam UUID clientId){
		return ApiResponseDto.createOK(memberService.findAll(pageable,clientId));
	}

	@Operation(summary = "사용자 단건 조회", description = "Customer (고객사) 가 사용자를 조회")
	@GetMapping("/{id}")
	private ApiResponseDto findById(@PathVariable UUID id){
		return ApiResponseDto.createOK(memberService.findById(id));
	}


	@Operation(summary = "사용자 수정", description = "Customer (고객사) 가 사용자를 수정")
	@PutMapping("/{id}")
	private ApiResponseDto update(@PathVariable UUID id, @Valid @RequestBody MemberDto.UpdateRequest update){
		memberService.update(id, update);
		return ApiResponseDto.DEFAULT_OK;
	}

}
