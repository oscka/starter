package com.hanex.starter.member.query.service;

import com.hanex.starter.common.exception.Exception404;
import com.hanex.starter.member.query.domain.Member;
import com.hanex.starter.member.query.dto.MemberDto;
import com.hanex.starter.member.query.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;


    public void save(MemberDto.SaveRequest save){
        memberRepository.insert(save.toEntity());
    }

    public MemberDto.MemberResponse findById(String id){
        Member member = memberRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 고객입니다."));
        return member.toDto();
    }


    public Page<MemberDto.MemberResponse> findAll(Pageable pageable,String clientId){
        Page<Member> member = memberRepository.findByClientIdAndSearchCondition(AggregateReference.to(clientId),pageable);
        return null;
    }

    public void update(String id, MemberDto.UpdateRequest update){
        Member member = memberRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 고객입니다."));
        memberRepository.updateMember(id,update.toEntity());
    }

    public void delete(String id){
        Member member = memberRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 고객입니다."));
        memberRepository.delete(member);
    }
}
