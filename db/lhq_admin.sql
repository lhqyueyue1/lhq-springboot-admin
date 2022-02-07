CREATE TABLE t_user(
	id CHAR(19) PRIMARY KEY,
	username VARCHAR(20) NOT NULL,
	PASSWORD VARCHAR(100) NOT NULL,
	nick_name VARCHAR(50),
	salt VARCHAR(255),
	token VARCHAR(100),
	gmt_create DATETIME,
	gmt_modified DATETIME
	
);

CREATE TABLE t_user_role(
	id CHAR(19) PRIMARY KEY,
	role_id CHAR(19) NOT NULL,
	user_id CHAR(19) NOT NULL,
	gmt_create DATETIME,
	gmt_modified DATETIME
);

CREATE TABLE t_role(
	id CHAR(19) PRIMARY KEY,
	role_name VARCHAR(20) NOT NULL,
	remark VARCHAR(255),
	gmt_create DATETIME,
	gmt_modified DATETIME
	
);

SELECT * FROM t_role WHERE id=(SELECT role_id FROM t_user_role WHERE user_id='admin')

SELECT * FROM t_role WHERE id NOT IN (SELECT role_id FROM t_user_role WHERE user_id='admin')