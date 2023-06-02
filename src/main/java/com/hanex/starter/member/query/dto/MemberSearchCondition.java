package com.hanex.starter.member.query.dto;

import com.hanex.starter.common.enums.MemberType;
import com.hanex.starter.common.enums.UserStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;

@Schema(description = "사용자 (거래처,실행사) 등록 요청 DTO")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberSearchCondition {

    @Schema(description = "고객사 고유번호 > 고객사가 사용자를 추가", nullable = false, example = "7de5eb3f-fe59-453e-a0c1-f1f497ceee5c")
    private String customerId;

    @Schema(description = "관리자 이름", nullable = false, example = "홍길동")
    private String managerName;

    @Schema(description = "사용자 분류", nullable = false, example = "CLIENT")
    @NotNull
    private MemberType memberType;

    @Schema(description = "사용자 상태", nullable = false, example = "ACTIVE")
    private UserStatus memberStatus;

}
