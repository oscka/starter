package com.hanex.starter.member.query.repository;

import com.hanex.starter.common.util.jdbc.WithInsert;
import com.hanex.starter.member.query.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends CrudRepository<Member, String> , MemberRepositoryCustom, WithInsert<Member> {



}
