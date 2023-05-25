package com.hanex.starter.service;

import com.hanex.starter.controller.member.MemberDto;
import com.hanex.starter.domain.member.Member;
import com.hanex.starter.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

import java.util.UUID;


@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberDto.SaveRequest save){
        memberRepository.save(save.toEntity());
    }

    public MemberDto.MemberInfoResponse findById(Long id){
        Member member = memberRepository.findById(id).orElseThrow(()-> new RuntimeException("존재하지 않는 고객입니다."));
        return member.toDto();
    }


    public Page<MemberDto.MemberInfoResponse> findAll(Pageable pageable,Long clientId){
        Page<Member> member = memberRepository.findByClientIdAndSearchCondition(AggregateReference.to(clientId),pageable);
        return null;
    }
}
