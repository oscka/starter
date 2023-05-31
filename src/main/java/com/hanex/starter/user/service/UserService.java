package com.hanex.starter.user.service;

import com.hanex.starter.common.annotation.CustomLog;
import com.hanex.starter.common.api.ApiResponseDto;
import com.hanex.starter.common.exception.Exception400;
import com.hanex.starter.common.exception.Exception404;
import com.hanex.starter.user.domain.User;
import com.hanex.starter.user.dto.UserDto;
import com.hanex.starter.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;

	/**
	 * 회원가입
	 * @param save
	 */
	@CustomLog
	public void register(UserDto.SaveRequest save){
		Optional<User> user = userRepository.findByLoginId(save.getLoginId());
		if (user.isPresent()){
			throw new Exception400("loginId", "중복되는 아이디입니다.");
		}
		userRepository.insert(save.toEntity());
	}

	/**
	 * 중복 아이디 Check
	 * @param loginId
	 * @return
	 */
	public boolean existsByLoginId(String loginId){
		return userRepository.existsByLoginId(loginId);
	}

	/**
	 * 회원정보 by loginID
	 * @param loginId
	 * @return
	 */
	@CustomLog
	public UserDto.UserInfoResponse findByLoginId(String loginId){
		User user = userRepository.findByLoginId(loginId).orElseThrow(()->new Exception404("존재하지 않는 계정입니다."));
		log.info(user.getLoginId());
		return user.toDto();
	}

	/**
	 * 회원정보 수정
	 * @param id
	 * @param update
	 */
	@CustomLog
	public void update(UUID id, UserDto.UpdateRequest update){
		User user = userRepository.findById(id).orElseThrow(()->new Exception404("존재하지 않는 계정입니다."));
		userRepository.changeUserInfo(id,update.getName(),update.getEmail(), update.getPhone());
	}


	/**
	 * 회원 탈퇴
	 * @param id
	 */
	@CustomLog
	public void delete(UUID id){
		User account = userRepository.findById(id).orElseThrow(()->new Exception404("존재하지 않는 계정입니다."));
		userRepository.delete(account);
	}

	@CustomLog
	public ApiResponseDto login(UserDto.LoginRequest request){
		return null;
	}

}
