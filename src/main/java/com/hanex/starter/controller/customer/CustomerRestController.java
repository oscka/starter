package com.hanex.starter.controller.customer;

import com.hanex.starter.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/v1/owner")
@RestController
@RequiredArgsConstructor
public class CustomerRestController {

	private final CustomerService customerService;

	@PostMapping
	public ResponseEntity<Void> save (@Valid @RequestBody CustomerDto.SaveRequest save){
		customerService.save(save);
		return ResponseEntity.ok().build();
	}


	@PutMapping("/{id}")
	private ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody CustomerDto.SaveRequest update){
		return ResponseEntity.ok().build();
	}

}
