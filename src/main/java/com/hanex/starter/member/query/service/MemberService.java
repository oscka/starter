package com.hanex.starter.member.query.service;

import com.hanex.starter.member.query.domain.Member;
import com.hanex.starter.member.query.dto.MemberDto;
import com.hanex.starter.member.query.repository.MemberRepository;
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

    public MemberDto.MemberResponse findById(UUID id){
        Member member = memberRepository.findById(id).orElseThrow(()-> new RuntimeException("존재하지 않는 고객입니다."));
        return member.toDto();
    }


    public Page<MemberDto.MemberResponse> findAll(Pageable pageable,UUID clientId){
        Page<Member> member = memberRepository.findByClientIdAndSearchCondition(AggregateReference.to(clientId),pageable);
        return null;
    }

    public void update(UUID id, MemberDto.UpdateRequest update){

        memberRepository.updateMember(id,update.toEntity());
    }
}
