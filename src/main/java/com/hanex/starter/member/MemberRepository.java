package com.hanex.starter.member;

import com.hanex.starter.common.util.jdbc.WithInsert;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberRepository extends CrudRepository<Member, UUID> , MemberRepositoryCustom , WithInsert<Member> {

    @Modifying
    @Query("""
   			UPDATE member_tb m
   			SET  m.name = member.name
   				, m.email = member.email
   			WHERE id = id
			""")
    boolean changeMemberInfo(UUID id, Member member);

}
