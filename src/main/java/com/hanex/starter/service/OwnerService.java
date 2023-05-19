package com.hanex.starter.service;

import com.hanex.starter.controller.owner.OwnerDto;
import com.hanex.starter.domain.owner.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class OwnerService {
    
    private final OwnerRepository ownerRepository;
    
    // owner 등록
    public void save(OwnerDto.SaveRequest save){
        ownerRepository.save(save.toEntity());
    }

    public void findById(){

    }
}
