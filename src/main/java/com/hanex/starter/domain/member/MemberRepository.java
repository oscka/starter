package com.hanex.starter.domain.member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberRepository extends CrudRepository<Member, UUID> , MemberRepositoryCustom{
}
