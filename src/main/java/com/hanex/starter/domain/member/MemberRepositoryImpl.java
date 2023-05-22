package com.hanex.starter.domain.member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.core.convert.EntityRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final NamedParameterJdbcOperations jdbcOperations;
    private final EntityRowMapper<Member> rowMapper;

    public MemberRepositoryImpl(NamedParameterJdbcOperations jdbcOperations, EntityRowMapper<Member> rowMapper) {
        this.jdbcOperations = jdbcOperations;
        this.rowMapper = rowMapper;
    }

    @Override
    public Page<Member> findByClientIdAndSearchCondition(Pageable pageable) {
        return null;
    }
}
