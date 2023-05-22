--------------------------------------
-- auth_mgmt insert
--------------------------------------
INSERT INTO auth_mgmt
(auth_id, auth_code, auth_name, sort_seq, created_by, created_at, updated_by, updated_at)
VALUES('215939fc7d5349738c8ec4a320a1dd02', 'ROLE_0', '시스템관리자', 0, 'SADMIN', NULL, 'SADMIN', NULL);
INSERT INTO auth_mgmt
(auth_id, auth_code, auth_name, sort_seq, created_by, created_at, updated_by, updated_at)
VALUES('a436d3593e3a47f2aa85b521ce1f97a9', 'ROLE_2', '본사직원', 2, 'SADMIN', NULL, 'SADMIN', NULL);
INSERT INTO auth_mgmt
(auth_id, auth_code, auth_name, sort_seq, created_by, created_at, updated_by, updated_at)
VALUES('d2d5cce3d3324df9a26c9a0f8da8572b', 'ROLE_99', '퇴사자', 99, 'SADMIN', NULL, SADMIN, NULL);
INSERT INTO auth_mgmt
(auth_id, auth_code, auth_name, sort_seq, created_by, created_at, updated_by, updated_at)
VALUES('d844ee481095455eadf84981f83394ef', 'ROLE_3', '팀장', 3, 'SADMIN', NULL, 'SADMIN', NULL);
INSERT INTO auth_mgmt
(auth_id, auth_code, auth_name, sort_seq, created_by, created_at, updated_by, updated_at)
VALUES('f0b97eda8e514bd2b01e79b25a8f31dd', 'ROLE_1', '관리자', 1, 'SADMIN', NULL, 'SADMIN', NULL);


--------------------------------------
-- group_mgmt insert
--------------------------------------
INSERT INTO group_mgmt
(code, name, upper_code, unit, use_yn, sort_seq, memo, created_by, created_at, updated_by, updated_at)
VALUES('GRP001', '경영팀', NULL, '1', 'Y', 10, '경영팀 memo' ,'SADMIN', NULL, 'SADMIN', NULL);
INSERT INTO group_mgmt
(code, name, upper_code, unit,  use_yn, sort_seq, memo, created_by, created_at, updated_by, updated_at)
VALUES('GRP002', '재무팀', 'GRP001', '2', 'Y', 20, '재무팀 memo', 'SADMIN', NULL, 'SADMIN', NULL);
INSERT INTO group_mgmt
(code, name, upper_code, unit, use_yn, sort_seq, memo, created_by, created_at, updated_by, updated_at)
VALUES('GRP003', '재고팀', 'GRP001', '2', 'Y', 30, '재고팀 memo', 'SADMIN', NULL, 'SADMIN', NULL);
INSERT INTO group_mgmt
(code, name, upper_code, unit, use_yn, sort_seq, memo, created_by, created_at, updated_by, updated_at)
VALUES('GRP004', '업무1팀', 'GRP001', '2', 'Y', 40, ' 업무1팀 memo', 'SADMIN', NULL, 'SADMIN', NULL);
INSERT INTO group_mgmt
(code, name, upper_code, unit, use_yn, sort_seq, memo, created_by, created_at, updated_by, updated_at)
VALUES('GRP005', '기획팀', 'GRP001', '2', 'Y', 50, '기획팀 memo', 'SADMIN', NULL, 'SADMIN', NULL);
INSERT INTO group_mgmt
(code, name, upper_code, unit, use_yn, sort_seq, memo, created_by, created_at, updated_by, updated_at)
VALUES('GRP007', 'CSR팀', 'GRP005', '3',  'N', 70, '기획 > CSR팀  memo', 'SADMIN', NULL, 'SADMIN', NULL);


