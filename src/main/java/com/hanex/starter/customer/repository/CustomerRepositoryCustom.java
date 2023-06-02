package com.hanex.starter.customer.repository;

import com.hanex.starter.customer.dto.CustomerDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerRepositoryCustom {

    List<CustomerDto.CustomerInfoResponse> searchCustomer(Pageable pageable);
}
