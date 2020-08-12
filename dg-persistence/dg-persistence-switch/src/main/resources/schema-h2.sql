CREATE SCHEMA IF NOT EXISTS COMMON;
CREATE SCHEMA IF NOT EXISTS CARD;
CREATE SCHEMA IF NOT EXISTS TRANSACTION;

/*==============================================================*/
drop table if exists CARD.SCARD;
drop table if exists COMMON.CUSTOMER;
drop table if exists transaction.request;
drop table if exists transaction.response;
/*==============================================================*/


create table CARD.CARD
(
    UID                DECIMAL(19)        not null AUTO_INCREMENT,
    PAN                DECIMAL(19)        not null,
    ISSUE_DATE         INTEGER            not null,--yyMMdd
    ACTIVE_DATE        INTEGER,
    EXPIRE_DATE        INTEGER            not null,--yyMM
    STATUS             SMALLINT           not null,
    INSERT_DATE        TIMESTAMP(6)       not null,
    MODIFY_DATE        TIMESTAMP(6),
    CUSTOMER_UID       DECIMAL(12)        not null,
    PIN                CHAR(16),
    INCORRECT_PIN1_TRY SMALLINT default 0 not null,
    INCORRECT_PIN2_TRY SMALLINT default 0 not null,
    INCORRECT_CVV1_TRY SMALLINT default 0 not null,
    INCORRECT_CVV2_TRY SMALLINT default 0 not null,
    PIN2               VARCHAR(50),
    primary key (UID)
);



create table COMMON.CUSTOMER
(
    UID           DECIMAL(12) not null AUTO_INCREMENT,
    FIRST_NAME    VARCHAR(100),
    LAST_NAME     VARCHAR(150),
    FIRST_NAME_EN VARCHAR(100),
    LAST_NAME_EN  VARCHAR(150),
    NATIONAL_CODE CHAR(10),
    FATHER_NAME   VARCHAR(100),
    BIRTH_DATE    CHAR(8),
    ID_NUMBER     VARCHAR(30),
    PASSPORT_NO   VARCHAR(30),
    MOBILE_NO     char(15),
    INSERT_DATE   TIMESTAMP,
    MODIFY_DATE   TIMESTAMP,
    STATUS        smallint,
    DEATH_DATE    CHAR(8),
    GENDER        smallint    null,
    primary key (UID)
);
create table transaction.request
(
    TRNO             BIGINT NOT NULL AUTO_INCREMENT,
    AMOUNT           BIGINT,
    CDATE            INTEGER,
    PAN              BIGINT,
    PAN2             BIGINT,
    CTIME            VARCHAR(255),
    REFERENCE_NUMBER DECIMAL(12),
    primary key (trno)
);

create table transaction.response
(
    TRNO  BIGINT NOT NULL,
    CDATE INTEGER,
    IRESP INTEGER,
    RTIME INTEGER,
    CTIME VARCHAR(255),
    PRIMARY KEY (TRNO)
);


commit;