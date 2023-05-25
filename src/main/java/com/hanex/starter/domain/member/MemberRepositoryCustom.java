package com.hanex.starter.domain.member;

import com.hanex.starter.domain.client.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.UUID;

public interface MemberRepositoryCustom {

    Page<Member> findByClientIdAndSearchCondition(
            AggregateReference<Client, UUID> clientId,
            Pageable pageable
    );
}
