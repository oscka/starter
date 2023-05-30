package com.hanex.starter.member.command.repository;

import com.hanex.starter.customer.domain.Customer;
import com.hanex.starter.member.command.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.UUID;

public interface MemberRepositoryCustom {

    Page<Member> findByClientIdAndSearchCondition(
            AggregateReference<Customer, UUID> clientId,
            Pageable pageable
    );
}