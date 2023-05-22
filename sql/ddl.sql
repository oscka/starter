-- starter ddl.sql

/*
고객사 client
거래처,실행사 customer
로그인 login_tb

고객사 권한 매핑 client_auth
권한 auth_mgmt
그룹 group_mgmt

내부 직원  account
계약 tb_contract
주문 tb_order
상품 tb_product
*/


-- group_mgmt : 그룹 관리 (고객사)
CREATE TABLE `group_mgmt` (
  `code` varchar(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `upper_code` varchar(20) DEFAULT NULL,
  `unit` char(7) DEFAULT NULL,
  `is_used` char(1) DEFAULT NULL,
  `sort_seq` int(11) DEFAULT NULL,
  `memo` varchar(4000) DEFAULT NULL,
  `created_by` varchar(30) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`code`)
);

-- auth_mgmt : 권한 관리
CREATE TABLE `auth_mgmt` (
  `id` varchar(32)  NOT NULL,
  `auth_code` varchar(20)  DEFAULT NULL,
  `auth_name` varchar(20)  DEFAULT NULL,
  `sort_seq` int(11) DEFAULT NULL,
  `created_by` varchar(30) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`auth_id`)
);

-- client: 고객사
CREATE TABLE `client` (


);

-- tb_login: 로그인
CREATE TABLE `tb_login` (
  `login_id` varchar(32) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `auth_id` varchar(30) NOT NULL,
  `created_by` varchar(30) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`login_id`)
);

-- client_auth: 고객사 권한매핑
CREATE TABLE `client_auth` (
  `id` varchar(32)  NOT NULL,
  `client_id` varchar(32)  DEFAULT NULL,
  `auth_code` varchar(20)  DEFAULT NULL,
  `group_code` varchar(20)  DEFAULT NULL,
  `auth_id` varchar(32)  NOT NULL,
  `created_by` varchar(30) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`user_auth_id`)
);

-- tb_menu : 메뉴 관리
CREATE TABLE `menu_mgmt` (
  `code` varchar(20) NOT NULL,
  `menu_name` varchar(100) DEFAULT NULL,
  `menu_url` varchar(50) DEFAULT NULL,
  `upper_menu_code` varchar(20) DEFAULT NULL,
  `sort_seq` int(11) DEFAULT NULL,
  `created_by` varchar(30) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`code`)
);

-- menu_auth : 메뉴 권한 관리
CREATE TABLE `menu_auth` (
  `auth_id` varchar(32) NOT NULL,
  `menu_auth_id` varchar(32) NOT NULL,
  `use_yn` char(1) DEFAULT NULL,
  `inq_auth` varchar(20) DEFAULT NULL,
  `inq_yn` char(1) DEFAULT NULL,
  `insert_yn` char(1) DEFAULT NULL,
  `update_yn` char(1) DEFAULT NULL,
  `delete_yn` char(1) DEFAULT NULL,
  `excel_up_yn` char(1) DEFAULT NULL,
  `excel_down_yn` char(1) DEFAULT NULL,
  `menu_code` varchar(20) NOT NULL,
  `created_by` varchar(30) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`menu_auth_id`)
);