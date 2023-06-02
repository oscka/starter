package com.hanex.starter.member.query.repository;

import com.hanex.starter.common.util.jdbc.WithInsert;
import com.hanex.starter.customer.repository.CustomerSql;
import com.hanex.starter.member.query.domain.Member;
import com.hanex.starter.user.domain.BaseUser;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MemberRepository extends CrudRepository<Member, String> , MemberRepositoryCustom, WithInsert<Member> {


    // baseUser > loginId 중복 검사
    @Query(MemberSql.SELECT_BY_LOGIN_ID)
    Optional<BaseUser> selectByLoginId(@Param("loginId") String loginId);
}
