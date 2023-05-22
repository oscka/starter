package com.hanex.starter.controller.member;

import com.hanex.starter.service.MemberService;
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

	@PostMapping
	public ResponseEntity<Void> save (@Valid @RequestBody MemberDto.SaveRequest save){
        memberService.save(save);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	private ResponseEntity<Page<MemberDto.MemberInfoResponse>> findAll(Pageable pageable){
		return ResponseEntity.ok(memberService.findAll(pageable));
	}


	@GetMapping("/{id}")
	private ResponseEntity<MemberDto.MemberInfoResponse> findById(@PathVariable UUID id){
		return ResponseEntity.ok(memberService.findById(id));

	}

	@PutMapping("/{id}")
	private ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody MemberDto.SaveRequest update){
		return ResponseEntity.ok().build();
	}

}
