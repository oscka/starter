package com.hanex.starter.user.service;

import com.hanex.starter.common.annotation.CustomLog;
import com.hanex.starter.common.exception.Exception404;
import com.hanex.starter.user.domain.User;
import com.hanex.starter.user.dto.UserDto;
import com.hanex.starter.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final UserRepository userRepository;

    @CustomLog
    public UserDto.UserInfoResponse findById(UUID id){
        return userRepository.findById(id).orElseThrow(()
                -> new Exception404("존재하지 않는 계정입니다.")).toDto();
    }

    @CustomLog
    public void userBan(UUID id){
        User user = userRepository.findById(id).orElseThrow(()->new Exception404("존재하지 않는 계정입니다."));
        user.ban();
        userRepository.save(user);
    }

}
