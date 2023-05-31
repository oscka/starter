package com.hanex.starter.member.query.repository;

import com.hanex.starter.common.util.jdbc.WithInsert;
import com.hanex.starter.member.query.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberRepository extends CrudRepository<Member, UUID> , MemberRepositoryCustom, WithInsert<Member> {



}
