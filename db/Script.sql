#用户表
CREATE TABLE IF NOT EXISTS T_EXAMINEE (
    USER_PHONE VARCHAR(255) NOT NULL,
	ID_CARD VARCHAR(255),
    USER_NAME VARCHAR(255) NOT NULL,
    USER_SEX INT,
    USER_PROFESSION VARCHAR(255),
    LOGIN_PASSWORD VARCHAR(255) NOT NULL,
    PAY_PASSWORD VARCHAR(255), # 考虑
    USER_PHOTO VARCHAR(255),
    RESIDENTIAL_ADDRESS VARCHAR(255),
    EMAIL_ADDRESS VARCHAR(255),
    USER_BALANCE INT,
    LAST_LOGIN_TIME DATETIME,
    PRIMARY KEY (`USER_PHONE`)
);

alter table t_examinee add IDENTIFY_CODE varchar(8);

ALTER TABLE t_examinee DROP IDENTIFY_CODE;

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


#考试表
CREATE TABLE IF NOT EXISTS T_EXAM_MANAGEMENT (
	EXAM_ID VARCHAR(255) not null PRIMARY KEY,
	EXAM_NAME VARCHAR(255) NOT NULL,
	EXAM_TYPE VARCHAR(40),
	COST INT,
	MAX_NUM INT,
	EXAM_PLACE VARCHAR(255),
	EXAM_TIME_PERIOD1 VARCHAR(40),
	EXAM_TIME_PERIOD2 VARCHAR(40),
	EXAM_TIME_PERIOD3 VARCHAR(40),
	REG_TIME_FROM VARCHAR(12),
	REG_TIME_TO VARCHAR(12),
	EXAM_INTRODUCE VARCHAR(255),
	REGIST_NUM INT,
	PASE_SCORE INT,
	TOTAL_SCORE INT,
	IS_CERTIFICATE VARCHAR(2),
	IS_ENTRY INT default 0,
	HALL_NUM INT
);

alter table T_EXAM_MANAGEMENT add IS_ENTRY INT default 0;

select * from oerts.T_EXAM_MANAGEMENT;

drop table oerts.T_EXAM_MANAGEMENT;

insert into T_EXAM_MANAGEMENT
(EXAM_ID, EXAM_NAME, COST, MAX_NUM, EXAM_PLACE, EXAM_TIME_FROM, EXAM_TIME_TO, REG_TIME_FROM, REG_TIME_TO)
values
('1000001','2018年上半年CET-4', 30, 500, '', now(), now(), now(), now())

insert into T_EXAM_MANAGEMENT
(EXAM_ID, EXAM_NAME, COST, MAX_NUM, EXAM_PLACE, EXAM_TIME_FROM, EXAM_TIME_TO, REG_TIME_FROM, REG_TIME_TO)
values
('1000002','2018年上半年CET-6', 35, 400, '', now(), now(), now(), now())

insert into T_EXAM_MANAGEMENT
(EXAM_ID, EXAM_NAME, COST, MAX_NUM, EXAM_PLACE, EXAM_TIME_FROM, EXAM_TIME_TO, REG_TIME_FROM, REG_TIME_TO)
values
('1000003','2018年上半年软考-初级', 140, 100, '', now(), now(), now(), now())

insert into T_EXAM_MANAGEMENT
(EXAM_ID, EXAM_NAME, COST, MAX_NUM, EXAM_PLACE, EXAM_TIME_FROM, EXAM_TIME_TO, REG_TIME_FROM, REG_TIME_TO)
values
('1000004','2018年上半年软考-中级', 140, 50, '', now(), now(), now(), now())

insert into T_EXAM_MANAGEMENT
(EXAM_ID, EXAM_NAME, COST, MAX_NUM, EXAM_PLACE, EXAM_TIME_FROM, EXAM_TIME_TO, REG_TIME_FROM, REG_TIME_TO)
values
('1000005','2018年上半年软考-高级', 140, 10, '', now(), now(), now(), now())

SELECT
    		EXAM_ID
    	FROM
    		T_EXAM_MANAGEMENT
    	ORDER BY EXAM_ID DESC
    	LIMIT 1
    	
select * from T_EXAM_MANAGEMENT where TO_DAYS(NOW()) - TO_DAYS(REG_TIME_TO) < 0;

#报名表
CREATE TABLE IF NOT EXISTS T_EXAM_REGISTRATION (
	ID_CARD VARCHAR(255) not null,
	EXAM_ID VARCHAR(255) not null,
	ADMISSION_TICKET VARCHAR(255),
	ID_CARD_FRONT VARCHAR(255),
	ID_CARD_BACK VARCHAR(255),
	STATUS VARCHAR(2),
	SCORE int,
	ROOM_NUM INT default 0,
	SET_NUM INT default 0,
	PRIMARY KEY (`ID_CARD`, `EXAM_ID`)
);

drop table T_EXAM_REGISTRATION;

INSERT INTO T_EXAM_REGISTRATION VALUES('111','111','111','11',0)

select 
*
from T_EXAM_REGISTRATION TER
left join T_EXAM_MANAGEMENT TEM
on TER.EXAM_ID = TEM.EXAM_ID
where TER.ID_CARD = '320582199602088511'


SELECT
ID_CARD, EXAM_ID
FROM
T_EXAM_REGISTRATION
WHERE STATUS = '00'


select
	TEM.EXAM_ID,
	TEM.EXAM_NAME,
	TEM.COST,
	TEM.EXAM_TIME_FROM,
	TEM.EXAM_TIME_TO,
	TEM.REG_TIME_TO
from
	T_EXAM_REGISTRATION TER
left join T_EXAM_MANAGEMENT TEM on
	TER.EXAM_ID = TEM.EXAM_ID
where
	TER.ID_CARD = '320582199602088511'
	and TER.STATUS = '10'


SELECT
    		TER.ID_CARD,
    		TER.EXAM_ID,
    		TER.ID_CARD_FRONT,
    		TER.ID_CARD_BACK,
    		TE.USER_NAME
    	FROM
    		T_EXAM_REGISTRATION TER
    	LEFT JOIN T_EXAMINEE TE
    		ON TE.ID_CARD = TER.ID_CARD
    	WHERE TER.STATUS = '00'


#问答表
CREATE TABLE IF NOT EXISTS T_QUESTION_MANAGEMENT (
	QUESTION_ID varchar(10) not null primary key,
	QUESTION_CONTENT varchar(255),
	QUESTION_ANSWER varchar(700),
	QUESTION_KEY varchar(255),
	QUESTION_CLICK_RATE int
);

drop table T_QUESTION_MANAGEMENT

SELECT
    		QUESTION_CONTENT, QUESTION_ANSWER
    	FROM
    		T_QUESTION_MANAGEMENT
    	ORDER BY QUESTION_CLICK_RATE DESC
    	LIMIT 3
    	
    	
#管理员表
CREATE TABLE IF NOT EXISTS T_ADMINISTRATOR(
    ACCOUNT_NAME VARCHAR(255) NOT null primary KEY,
    LOGIN_PASSWORD VARCHAR(255) NOT NULL,
    USER_NAME VARCHAR(255) NOT NULL
);

drop table T_ADMINISTRATOR


select
	TE.USER_NAME,
	TE.USER_PHONE,
	TER.ADMISSION_TICKET,
	TER.SCORE,
	TER.EXAM_ID
from
	T_EXAM_REGISTRATION TER
left join T_EXAMINEE TE on 
	TE.ID_CARD = TER.ID_CARD
where
	TER.EXAM_ID = '1000001' and TER.STATUS = '20'
	
update T_EXAM_REGISTRATION set SCORE = 600 where ADMISSION_TICKET = '11111';
update T_EXAM_REGISTRATION set SCORE = 700 where ADMISSION_TICKET = '22222';


select TO_DAYS(substring(EXAM_TIME_PERIOD1,1,10)) from oerts.t_exam_management 


#考试地址表
CREATE TABLE IF NOT EXISTS T_EXAM_PLACE_MANAGEMENT(
	PLACE_ID int auto_increment primary key not null,
    CITY varchar(20) not null,
    DISTRICT varchar(20) not null,
    PLACE varchar(50) not null
);

insert into T_EXAM_PLACE_MANAGEMENT (CITY,DISTRICT,PLACE)
values ('南京','玄武区','龙蟠路159号南京林业大学教五楼')
insert into T_EXAM_PLACE_MANAGEMENT (CITY,DISTRICT,PLACE)
values ('南京','玄武区','龙蟠路159号南京林业大学教主楼')


select CITY from T_EXAM_PLACE_MANAGEMENT group by CITY

SELECT 
--     		TER.ROOM_NUM,
--     		TER.SET_NUM,
--     		TEM.HALL_NUM	
count(*)
    	FROM T_EXAM_REGISTRATION TER
    	LEFT JOIN T_EXAM_MANAGEMENT TEM 
    		ON TER.EXAM_ID = TEM.EXAM_ID
    	WHERE TEM.EXAM_ID = '1000001' AND TER.STATUS = '10'
    	order by TER.ROOM_NUM DESC, TER.SET_NUM desc limit 1

    	
select 
	TE.USER_NAME,
	TER.ADMISSION_TICKET,
	TER.ID_CARD,
	TEM.EXAM_NAME,
	TEM.EXAM_TYPE,
	TEM.EXAM_PLACE,
    TER.ROOM_NUM,
    TER.SET_NUM,
    TEM.EXAM_TIME_PERIOD1,
	TEM.EXAM_TIME_PERIOD2,
	TEM.EXAM_TIME_PERIOD3
from  T_EXAMINEE TE
left join T_EXAM_REGISTRATION TER
	on TE.ID_CARD = TER.ID_CARD
left join T_EXAM_MANAGEMENT TEM
	on TER.EXAM_ID = TEM.EXAM_ID
where TER.ID_CARD = '320582199602088511' and TER.EXAM_ID = '1000001'

SELECT
    		COUNT(*)
    	FROM
			T_EXAM_REGISTRATION TER
		LEFT JOIN T_EXAM_MANAGEMENT TEM ON 
			TER.EXAM_ID = TEM.EXAM_ID
		WHERE
			TER.EXAM_ID = '1000001' AND TER.STATUS = '20' AND TER.SCORE >= TEM.PASE_SCORE
			
			
UPDATE T_EXAM_REGISTRATION SET SCORE = 500 WHERE ADMISSION_TICKET = '10000013205821996020885121089'; 
UPDATE T_EXAM_REGISTRATION SET SCORE = 200 WHERE ADMISSION_TICKET = '10000013205821996020885119628';

UPDATE T_EXAM_REGISTRATION
    SET STATUS = '21'
WHERE STATUS <> '20' AND EXAM_ID IN (
		SELECT EXAM_ID FROM T_EXAM_MANAGEMENT WHERE TO_DAYS(NOW()) - TO_DAYS(REG_TIME_TO) > 0
)

















