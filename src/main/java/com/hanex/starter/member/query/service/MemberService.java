package com.hanex.starter.member.query.service;

import com.hanex.starter.common.exception.Exception400;
import com.hanex.starter.common.exception.Exception404;
import com.hanex.starter.member.query.domain.Member;
import com.hanex.starter.member.query.dto.MemberDto;
import com.hanex.starter.member.query.dto.MemberSearchCondition;
import com.hanex.starter.member.query.repository.MemberRepository;
import com.hanex.starter.user.domain.BaseUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public MemberDto.MemberResponse findById(String id){
        Member member = memberRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 고객입니다."));
        return member.toDto();
    }

    @Transactional(readOnly = true)
    public Page<MemberDto.MemberResponse> findByCustomerIdAndSearchCondition(Pageable pageable, MemberSearchCondition memberSearchCondition){
        Page<Member> member = memberRepository.findByCustomerIdAndSearchCondition(pageable,memberSearchCondition);
        return member.map(Member::listToDto);
    }

    @Transactional
    public String save(MemberDto.SaveRequest save){

        // baseUser > loginId 중복 검사
        Optional<BaseUser> baseUser = memberRepository.selectByLoginId(save.getLoginId());
        if (baseUser.isPresent()){
            throw new Exception400("loginId","중복되는 로그인 아이디 입니다.");
        }

        Member member = memberRepository.insert(save.toEntity());
        return member.getId();
    }


    @Transactional
    public void update(String id, MemberDto.UpdateRequest update){
        Member member = memberRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 고객입니다."));
        memberRepository.updateMemberInfo(id,update.toEntity());
    }

    @Transactional
    public void delete(String id){
        Member member = memberRepository.findById(id).orElseThrow(()-> new Exception404("존재하지 않는 고객입니다."));
        // 실제 ROW 삭제 (HARD DELETE)
        memberRepository.delete(member);
    }
}
