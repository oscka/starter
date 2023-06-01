package com.hanex.starter.member.query.controller;

import com.hanex.starter.common.api.ApiResponseDto;
import com.hanex.starter.common.security.CustomUser;
import com.hanex.starter.member.query.dto.MemberDto;
import com.hanex.starter.member.query.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Tag(name = "사용자 (거래처,실행사,택배사) API",description = "사용자 (거래처,실행사,택배사) API")
@RequestMapping("/v1/member")
@RestController
@RequiredArgsConstructor
public class MemberRestController {

	private final MemberService memberService;

	@Operation(summary = "사용자 생성", description = "Customer (고객사) 가 사용자를 생성")
	@PostMapping
	public ApiResponseDto save (@Valid @RequestBody MemberDto.SaveRequest save
							, @AuthenticationPrincipal CustomUser securityUser){
		// TODO AuthenticationPrincipal 은 jwt 에서 가져오므로 swagger 에 입력안해도 되는데 request example data 로 뜨고 있음
		// TODO swagger 에서 AuthenticationPrincipal request example 없애기
		// TODO 해당 security context 이용할 방법 찾기
		log.info("securityUser : {}",securityUser.getUsername(),securityUser.getPassword());
        memberService.save(save);
		return ApiResponseDto.DEFAULT_OK;
	}


	@Operation(summary = "사용자 리스트 조회", description = "Customer (고객사) 가 사용자 리스트 조회")
	@GetMapping
	public ApiResponseDto findAll(Pageable pageable, @RequestParam String clientId){
		return ApiResponseDto.createOK(memberService.findAll(pageable,clientId));
	}

	@Operation(summary = "사용자 단건 조회", description = "Customer (고객사) 가 사용자를 조회")
	@GetMapping("/{id}")
	public ApiResponseDto findById(@PathVariable String id){
		return ApiResponseDto.createOK(memberService.findById(id));
	}


	@Operation(summary = "사용자 수정", description = "Customer (고객사) 가 사용자를 수정")
	@PutMapping("/{id}")
	public ApiResponseDto update(@PathVariable String id, @Valid @RequestBody MemberDto.UpdateRequest update){
		memberService.update(id, update);
		return ApiResponseDto.DEFAULT_OK;
	}

	@Operation(summary = "사용자 삭제", description = "Customer (고객사) 가 사용자를 삭제")
	@DeleteMapping("/{id}")
	public ApiResponseDto delete(@PathVariable String id){
		memberService.delete(id);
		return ApiResponseDto.DEFAULT_OK;
	}

}
