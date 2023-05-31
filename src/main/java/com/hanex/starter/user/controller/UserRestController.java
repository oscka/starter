package com.hanex.starter.user.controller;

import com.hanex.starter.common.api.ApiResponseDto;
import com.hanex.starter.user.service.UserService;
import com.hanex.starter.user.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Tag(name = "users > JWT 토큰 발급용 사용자",description = "사용자 API")
@RequestMapping("/v1/users")
@RequiredArgsConstructor
@RestController
public class UserRestController {

	private final UserService userService;

	@Operation(summary = "사용자", description = "회원가입")
	@PostMapping("/register")
	public ResponseEntity<Void> register(@RequestBody @Valid UserDto.SaveRequest save){
		userService.register(save);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "사용자", description = "로그인 아이디로 사용자 단건 조회")
	@GetMapping("/{loginId}")
	public ApiResponseDto findByLoginId(@PathVariable String loginId){
		return new ApiResponseDto<>(userService.findByLoginId(loginId));
	}

	@Operation(summary = "사용자",description = "사용자 정보 수정")
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable UUID id,@Valid @RequestBody UserDto.UpdateRequest update){
		userService.update(id,update);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "사용자",description = "회원 탈퇴")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id){
		userService.delete(id);
		return ResponseEntity.ok().build();
	}

}
