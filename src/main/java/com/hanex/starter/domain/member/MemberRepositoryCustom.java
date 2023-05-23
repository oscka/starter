package com.hanex.starter.domain.member;

import com.hanex.starter.domain.client.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

public interface MemberRepositoryCustom {

    Page<Member> findByClientIdAndSearchCondition(
            AggregateReference<Client,Long> clientId,
            Pageable pageable
    );
}
