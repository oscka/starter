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

@Tag(name = "고객사 API",description = "고객사 API")
@RequestMapping("/v1/member")
@RestController
@RequiredArgsConstructor
public class MemberRestController {

	private final MemberService memberService;

	/**
	 * Member 저장
	 * @param save
	 * @return
	 */
	@PostMapping
	public ApiResponseDto save (@Valid @RequestBody MemberDto.SaveRequest save){
        memberService.save(save);
		return ApiResponseDto.DEFAULT_OK;
	}

	/**
	 * Member List 조회
	 * @param pageable
	 * @param clientId
	 * @return
	 */
	@GetMapping
	private ApiResponseDto findAll(Pageable pageable, @RequestParam UUID clientId){
		return ApiResponseDto.createOK(memberService.findAll(pageable,clientId));
	}

	@Operation()
	@GetMapping("/{id}")
	private ApiResponseDto findById(@PathVariable UUID id){
		return ApiResponseDto.createOK(memberService.findById(id));
	}

	/**
	 * Member 수정
	 * @param id
	 * @param update
	 * @return
	 */
	@PutMapping("/{id}")
	private ApiResponseDto update(@PathVariable UUID id, @Valid @RequestBody MemberDto.UpdateRequest update){
		memberService.update(id, update);
		return ApiResponseDto.DEFAULT_OK;
	}

}
