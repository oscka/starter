package com.hanex.starter.user.controller;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "authFeignClient", url = "any-value/*")
public interface AuthFeignClient {
}
