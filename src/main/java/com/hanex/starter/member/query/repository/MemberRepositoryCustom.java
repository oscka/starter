package com.hanex.starter.member.query.repository;

import com.hanex.starter.customer.domain.Customer;
import com.hanex.starter.member.query.domain.Member;
import com.hanex.starter.member.query.dto.MemberSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.core.mapping.AggregateReference;


public interface MemberRepositoryCustom {

    Page<Member> findByCustomerIdAndSearchCondition(
            Pageable pageable,
            MemberSearchCondition memberSearchCondition
    );

    boolean updateMemberInfo(String id , Member member);
}
