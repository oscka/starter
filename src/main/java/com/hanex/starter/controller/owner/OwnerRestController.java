package com.hanex.starter.controller.owner;

import com.hanex.starter.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/owner")
@RestController
@RequiredArgsConstructor
public class OwnerRestController {

	private final OwnerService ownerService;

	@GetMapping
	public ResponseEntity<Void> save (@Valid @RequestBody OwnerDto.SaveRequest save){
		ownerService.save(save);
		return ResponseEntity.ok().build();
	}

}
