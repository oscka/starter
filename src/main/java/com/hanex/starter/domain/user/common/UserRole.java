package com.hanex.starter.domain.user.common;

/*
권한 Dimension 설명

A (관리항목) - 화주, 채널 등

B (업무) - CSR 그룹, 재고관리 그룹, 계약관리 그룹, 기획 그룹 등

C (기능) - Dashboard, CO, SO, 계약 등
 */
public enum UserRole {

	ADMIN, // 관리자

	PARTNER, // 파트너 (고객사,거래처,실행사,택배사)

	CUSTOMER // 사용자

}
