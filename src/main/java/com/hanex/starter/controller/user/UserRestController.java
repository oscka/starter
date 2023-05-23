package com.hanex.starter.controller.user;

import com.hanex.starter.service.UserService;
import lombok.RequiredArgsConstructor;
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
	private ResponseEntity<Void> register(@RequestBody @Valid UserDto.SaveRequest save){
		userService.register(save);
		return ResponseEntity.ok().build();
	}


	@GetMapping("/{loginId}")
	private UserDto.UserInfoResponse findByLoginId(@PathVariable String loginId){
		return userService.findByLoginId(loginId);
	}

	@PutMapping("/{id}")
	private ResponseEntity<Void> update(@PathVariable UUID id,@Valid @RequestBody UserDto.UpdateRequest update){
		userService.update(id,update);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<Void> delete(@PathVariable UUID id){
		userService.delete(id);
		return ResponseEntity.ok().build();
	}



}
