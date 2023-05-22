package com.hanex.starter.service;

import com.hanex.starter.controller.customer.CustomerDto;
import com.hanex.starter.domain.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CustomerService {
    
    private final CustomerRepository customerRepository;
    
    // owner 등록
    public void save(CustomerDto.SaveRequest save){
        customerRepository.save(save.toEntity());
    }

    public void findById(){

    }
}
