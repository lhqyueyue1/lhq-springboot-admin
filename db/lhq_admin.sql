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