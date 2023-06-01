package com.hanex.starter.customer.service;

import com.hanex.starter.common.exception.Exception400;
import com.hanex.starter.common.exception.Exception404;
import com.hanex.starter.customer.domain.Customer;
import com.hanex.starter.customer.dto.CustomerDto;
import com.hanex.starter.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequestMapping("/v1/customer")
@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerDto.CustomerInfoResponse> searchCustomer(Pageable pageable){
        return null;
    }

    public CustomerDto.CustomerInfoResponse findById (String id){
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 고객사 입니다."));
        return customer.toDto();
    }

    public void save(CustomerDto.SaveRequest save){
        // TODO 중복로그인 추가 > BaseUser 를 가져오는 방법?
//        Optional<Customer> customer = customerRepository.findByBaseUser(save.getLoginId());
//        if (customer.isPresent()){
//            throw new Exception400("loginId","중복되는 로그인 아이디 입니다.");
//        }
            customerRepository.save(save.toEntity());
    }

    public void update(String id,CustomerDto.UpdateRequest update){
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 고객사 입니다."));


    }

    public void delete (String id){
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 고객사 입니다."));
        customerRepository.delete(customer);
    }


}
