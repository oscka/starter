package com.hanex.starter.user;

import com.hanex.starter.common.api.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/v1/users")
@RequiredArgsConstructor
@RestController
public class UserRestController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<Void> register(@RequestBody @Valid UserDto.SaveRequest save){
		userService.register(save);
		return ResponseEntity.ok().build();
	}


	@GetMapping("/{loginId}")
	public ApiResponseDto findByLoginId(@PathVariable String loginId){
		return new ApiResponseDto<>(userService.findByLoginId(loginId));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable UUID id,@Valid @RequestBody UserDto.UpdateRequest update){
		userService.update(id,update);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id){
		userService.delete(id);
		return ResponseEntity.ok().build();
	}



}
