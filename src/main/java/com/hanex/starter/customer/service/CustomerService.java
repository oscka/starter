package com.hanex.starter.customer.service;

import com.hanex.starter.common.exception.Exception404;
import com.hanex.starter.customer.domain.Customer;
import com.hanex.starter.customer.dto.CustomerDto;
import com.hanex.starter.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@RequestMapping("/v1/customer")
@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerDto.CustomerInfoResponse> searchCustomer(Pageable pageable){
        return null;
    }

    public CustomerDto.CustomerInfoResponse findById (UUID id){
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 고객사 입니다."));
        return customer.toDto();
    }

    public void save(CustomerDto.SaveRequest save){
        customerRepository.save(save.toEntity());
    }

    public  void update(UUID id,CustomerDto.UpdateRequest update){
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 고객사 입니다."));


    }

    public void delete (UUID id){
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 고객사 입니다."));
        customerRepository.delete(customer);
    }


}
