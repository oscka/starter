package com.hanex.starter.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/product")
@RequiredArgsConstructor
@RestController
public class ProductRestController {

	@GetMapping("/{id}")
	private void findById(){

	}
}
