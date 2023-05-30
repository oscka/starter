package com.hanex.starter.member.command.service;

import com.hanex.starter.member.command.dto.MemberDto;
import com.hanex.starter.member.command.repository.MemberRepository;
import com.hanex.starter.member.command.domain.Member;
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
        memberRepository.insert(save.toEntity());
    }

    public MemberDto.MemberInfoResponse findById(UUID id){
        Member member = memberRepository.findById(id).orElseThrow(()-> new RuntimeException("존재하지 않는 고객입니다."));
        return member.toDto();
    }


    public Page<MemberDto.MemberInfoResponse> findAll(Pageable pageable,UUID clientId){
        Page<Member> member = memberRepository.findByClientIdAndSearchCondition(AggregateReference.to(clientId),pageable);
        return null;
    }

    public boolean update(UUID id, MemberDto.UpdateRequest update){
        return memberRepository.changeMemberInfo(id,update.toEntity());
    }
}
