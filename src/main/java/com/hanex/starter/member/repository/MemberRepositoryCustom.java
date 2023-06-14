package com.hanex.starter.member.repository;

import com.hanex.starter.member.domain.Member;
import com.hanex.starter.member.dto.MemberSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MemberRepositoryCustom {

    Page<Member> findByCustomerIdAndSearchCondition(
            Pageable pageable,
            MemberSearchCondition memberSearchCondition
    );

    boolean updateMemberInfo(String id , Member member);
}
