package com.hanex.starter.domain.member;

import com.hanex.starter.domain.client.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.core.convert.EntityRowMapper;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;
import org.springframework.data.relational.core.mapping.RelationalPersistentEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final NamedParameterJdbcOperations jdbcOperations;
    private final EntityRowMapper<Member> rowMapper;

    public MemberRepositoryImpl(NamedParameterJdbcOperations jdbcOperations,
                                RelationalMappingContext mappingContext,
                                JdbcConverter jdbcConverter) {

        this.jdbcOperations = jdbcOperations;
        this.rowMapper = new EntityRowMapper<>(
                (RelationalPersistentEntity<Member>) mappingContext.getRequiredPersistentEntity(Member.class),
                jdbcConverter);
    }

    @Override
    public Page<Member> findByClientIdAndSearchCondition(
            AggregateReference<Client,Long> clientId,
            Pageable pageable
            ) {
        return null;
    }
}
