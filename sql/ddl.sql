-- starter ddl.sql

/*
고객사 client
거래처,실행사 member_tb
로그인 login_tb

고객사 권한 매핑 client_auth
권한 auth_mgmt
그룹 group_mgmt

계약 contract_tb
주문 order_tb
상품 product_tb

postgres 예약어일경우 >> 테이블명 + '_tb'
예약어 확인 : https://postgresql.kr/docs/10/sql-keywords-appendix.html
*/

-- group_mgmt : 그룹 관리 (고객사)
CREATE TABLE `group_mgmt` (
  `code` varchar(20) primary key,
  `name` varchar(100),
  `upper_code` varchar(20),
  `unit` char(7),
  `use_yn` char(1),
  `sort_seq` int(11),
  `memo` varchar(4000),
  `created_by` varchar(30),
  `created_at` timestamp,
  `updated_by` varchar(30),
  `updated_at` timestamp
);

-- auth_mgmt : 권한 관리
CREATE TABLE `auth_mgmt` (
  `id` varchar(32) primary key,
  `auth_code` varchar(20) ,
  `auth_name` varchar(20) ,
  `sort_seq` int(11),
  `created_by` varchar(30),
  `created_at` timestamp,
  `updated_by` varchar(30),
  `updated_at` timestamp
);

-- client_auth: 고객사 권한매핑
CREATE TABLE `client_auth` (
  `id` varchar(32)  primary key,
  `client_id` varchar(32) ,
  `auth_code` varchar(20) ,
  `group_code` varchar(20) ,
  `auth_id` varchar(32)  NOT NULL,
  `created_by` varchar(30),
  `created_at` timestamp,
  `updated_by` varchar(30),
  `updated_at` timestamp
);


-- client: 고객사
CREATE TABLE `client` (
  `id` varchar(32) primary key,
  `auth_id` varchar(30) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `memo` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `created_by` varchar(30),
  `created_at` timestamp,
  `updated_by` varchar(30),
  `updated_at` timestamp
);


-- member_tb : 거래처,실행사
CREATE TABLE `member_tb` (
  `id` varchar(32)  primary key,
  `client_id` varchar(30) NOT NULL,
  `auth_id` varchar(30) NOT NULL,
  `member_code` varchar(30) NOT NULL,
  `member_type` varchar(30) NOT NULL,
  `manager_name` varchar(255) NOT NULL,
  `ceo_name` varchar(255) ,
  `registration_number` varchar(255) ,
  `phone` varchar(255) NOT NULL,
  `memo` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `created_by` varchar(30),
  `created_at` timestamp,
  `updated_by` varchar(30),
  `updated_at` timestamp
);

-- tb_login: 로그인
CREATE TABLE `tb_login` (
  `user_id` varchar(100) PRIMARY KEY,
  `login_id` varchar(100) NOT NULL,
  `password` varchar(100),
  `created_by` varchar(30),
  `created_at` timestamp,
  `updated_by` varchar(30),
  `updated_at` timestamp
);

-- tb_menu : 메뉴 관리
CREATE TABLE `menu_mgmt` (
  `code` varchar(20) PRIMARY KEY,
  `menu_name` varchar(100),
  `menu_url` varchar(50),
  `upper_menu_code` varchar(20),
  `sort_seq` int(11),
  `created_by` varchar(30),
  `created_at` timestamp,
  `updated_by` varchar(30),
  `updated_at` timestamp
);

-- menu_auth : 메뉴 권한 관리
CREATE TABLE `menu_auth` (
  `menu_auth_id` varchar(32) PRIMARY KEY,
  `menu_code` varchar(20) NOT NULL,
  `auth_id` varchar(32) NOT NULL,
  `use_yn` char(1),
  `inq_auth` varchar(20),
  `inq_yn` char(1),
  `insert_yn` char(1),
  `update_yn` char(1),
  `delete_yn` char(1),
  `excel_up_yn` char(1),
  `excel_down_yn` char(1),
  `created_by` varchar(30),
  `created_at` timestamp,
  `updated_by` varchar(30),
  `updated_at` timestamp
);