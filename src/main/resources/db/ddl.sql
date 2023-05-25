CREATE TABLE group_mgmt (
  code varchar(20),
  name varchar(100),
  upper_code varchar(20),
  unit char(7),
  use_yn char(1),
  sort_seq int(11),
  memo varchar(4000),
  created_by varchar(30),
  created_at timestamp,
  updated_by varchar(30),
  updated_at timestamp,
  PRIMARY KEY(code)
);

CREATE TABLE auth_mgmt (
  id varchar(32) ,
  auth_code varchar(20) ,
  auth_name varchar(20) ,
  sort_seq int(11),
  created_by varchar(30),
  created_at timestamp,
  updated_at timestamp,
  PRIMARY KEY(id)
);

CREATE TABLE client_auth (
  id varchar(32) ,
  client_id varchar(32) ,
  auth_code varchar(20) ,
  group_code varchar(20) ,
  auth_id varchar(32)  NOT NULL,
  created_by varchar(30),
  created_at timestamp,
  updated_by varchar(30),
  updated_at timestamp,
  PRIMARY KEY(id)
);


CREATE TABLE client (
  id varchar(32) ,
  auth_id varchar(30) NOT NULL,
  name varchar(255) NOT NULL,
  phone varchar(255) NOT NULL,
  memo varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  created_by varchar(30),
  created_at timestamp,
  updated_by varchar(30),
  updated_at timestamp,
  PRIMARY KEY(id)
);


CREATE TABLE member_tb (
  id uuid ,
  client_id varchar(30) NOT NULL,
  auth_id varchar(30) NOT NULL,
  member_type varchar(30) NOT NULL,
  manager_name varchar(255) NOT NULL,
  ceo_name varchar(255) ,
  registration_number varchar(255) ,
  phone varchar(255) NOT NULL,
  memo varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  created_by varchar(30),
  created_at timestamp,
  updated_by varchar(30),
  updated_at timestamp,
  PRIMARY KEY(id)
);

CREATE TABLE tb_login (
  user_id varchar(100) ,
  login_id varchar(100) NOT NULL,
  password varchar(100),
  created_by varchar(30),
  created_at timestamp,
  updated_by varchar(30),
  updated_at timestamp,
  PRIMARY KEY(user_id)
);

CREATE TABLE menu_mgmt (
  code varchar(20),
  menu_name varchar(100),
  menu_url varchar(50),
  upper_menu_code varchar(20),
  sort_seq int(11),
  created_by varchar(30),
  created_at timestamp,
  updated_by varchar(30),
  updated_at timestamp,
  PRIMARY KEY(code)
);

CREATE TABLE menu_auth (
  menu_auth_id varchar(32),
  menu_code varchar(20) NOT NULL,
  auth_id varchar(32) NOT NULL,
  use_yn char(1),
  inq_auth varchar(20),
  inq_yn char(1),
  insert_yn char(1),
  update_yn char(1),
  delete_yn char(1),
  excel_up_yn char(1),
  excel_down_yn char(1),
  created_by varchar(30),
  created_at timestamp,
  updated_by varchar(30),
  updated_at timestamp,
  PRIMARY KEY(menu_auth_id)
);