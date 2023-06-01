package com.hanex.starter.member.query.repository;

import com.hanex.starter.customer.domain.Customer;
import com.hanex.starter.member.query.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.core.convert.EntityRowMapper;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;
import org.springframework.data.relational.core.mapping.RelationalPersistentEntity;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

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
            AggregateReference<Customer, String> clientId,
            Pageable pageable
            ) {
        // SORT property 는 entity property 명으로 변경되야 한다.
        // (https://github.com/spring-projects/spring-data-jdbc/pull/210)
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("clientId", clientId.getId())
                .addValue("offset", pageable.getOffset())
                .addValue("pageSize", pageable.getPageSize());

        List<Member> members = this.jdbcOperations.query(
                MemberSql.SELECT_BY_ID_WITH_CLIENT(pageable.getSort()),
                parameterSource,
                this.rowMapper);

        return PageableExecutionUtils.getPage(members, pageable, () ->
                this.jdbcOperations.queryForObject(MemberSql.COUNT_BY_ID_WITH_CLIENT()
                        ,parameterSource
                        , Long.class));
    }

    public boolean updateMember(String id , Member member) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("memberType", member.getMemberType())
                .addValue("ceoName", member.getCeoName())
                .addValue("registrationNumber", member.getRegistrationNumber())
                .addValue("phone", member.getPhone())
                .addValue("memo", member.getMemo());
        int affected = jdbcOperations.update(MemberSql.UPDATE, parameterSource);
        return affected == 1;
    }
}
