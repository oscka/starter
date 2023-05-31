//package com.hanex.starter.member.query.service;
//
//import com.hanex.starter.common.util.PageResponseDto;
//import com.hanex.starter.member.query.domain.Member;
//import com.hanex.starter.member.query.dto.MemberDto;
//import org.springframework.data.domain.Page;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring")
//public interface MemberMapper {
//
//    List<MemberDto.MemberResponse> membersToMemberResponseDtos(List<Member> members);
//
//    default PageResponseDto memberPageToPageResponseDto(Page<Member> members) {
//        return PageResponseDto.of(
//                membersToMemberResponseDtos(members.getContent()),
//                members
//        );
//    }
//}
