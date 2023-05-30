package com.hanex.starter.member.command.controller;

import com.hanex.starter.member.command.dto.MemberDto;
import com.hanex.starter.member.command.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

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
	public ResponseEntity<Void> save (@Valid @RequestBody MemberDto.SaveRequest save){
        memberService.save(save);
		return ResponseEntity.ok().build();
	}

	/**
	 * Member List 조회
	 * @param pageable
	 * @param clientId
	 * @return
	 */
	@GetMapping
	private ResponseEntity<Page<MemberDto.MemberInfoResponse>> findAll(Pageable pageable, @RequestParam UUID clientId){
		return ResponseEntity.ok(memberService.findAll(pageable,clientId));
	}

	/**
	 * Member 정보 조회
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	private ResponseEntity<MemberDto.MemberInfoResponse> findById(@PathVariable UUID id){
		return ResponseEntity.ok(memberService.findById(id));

	}

	/**
	 * Member 수정
	 * @param id
	 * @param update
	 * @return
	 */
	@PutMapping("/{id}")
	private ResponseEntity<Boolean> update(@PathVariable UUID id, @Valid @RequestBody MemberDto.UpdateRequest update){
		return ResponseEntity.ok(memberService.update(id, update));
	}

}
