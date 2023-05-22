package com.hanex.starter.domain.member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRepositoryCustom {

    Page<Member> findByClientIdAndSearchCondition(Pageable pageable);
}
