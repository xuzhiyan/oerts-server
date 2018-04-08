CREATE TABLE IF NOT EXISTS T_EXAMINEE (
    USER_PHONE VARCHAR(255) NOT NULL,
	ID_CARD VARCHAR(255),
    USER_NAME VARCHAR(255) NOT NULL,
    USER_SEX INT,
    USER_PROFESSION VARCHAR(255),
    LOGIN_PASSWORD VARCHAR(255) NOT NULL,
    PAY_PASSWORD VARCHAR(255),
    USER_PHOTO VARCHAR(255),
    RESIDENTIAL_ADDRESS VARCHAR(255),
    EMAIL_ADDRESS VARCHAR(255),
    USER_BALANCE INT DEFAULT 0,
    LAST_LOGIN_TIME DATETIME,
    PRIMARY KEY (`USER_PHONE`)
);

drop table t_examinee;

select * from T_EXAMINEE;

insert into T_EXAMINEE 
(USER_PHONE,ID_CARD,USER_NAME,USER_SEX,USER_PROFESSION,LOGIN_PASSWORD,PAY_PASSWORD,USER_PHOTO,RESIDENTIAL_ADDRESS,EMAIL_ADDRESS,USER_BALANCE,LAST_LOGIN_TIME)
values
('18086709628','320582199602088511','徐至彦',1,'学生','111111','','','','664025900@qq.com',0,now());

insert into T_EXAMINEE 
(USER_PHONE,ID_CARD,USER_NAME,USER_SEX,USER_PROFESSION,LOGIN_PASSWORD,PAY_PASSWORD,USER_PHOTO,RESIDENTIAL_ADDRESS,EMAIL_ADDRESS,USER_BALANCE,LAST_LOGIN_TIME)
values
('15751861052','','徐至彦',1,'学生','111111','','','','664025900@qq.com',0,now());

SELECT COUNT(1) FROM T_EXAMINEE WHERE USER_PHONE = '18086709628' AND LOGIN_PASSWORD = '1111111'