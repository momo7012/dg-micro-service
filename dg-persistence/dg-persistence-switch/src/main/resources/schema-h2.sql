CREATE SCHEMA IF NOT EXISTS COMMON;
CREATE SCHEMA IF NOT EXISTS CARD;
CREATE SCHEMA IF NOT EXISTS TRANSACTION;
CREATE SCHEMA IF NOT EXISTS REPORT;

/*==============================================================*/
drop table if exists CARD.CARD;
drop table if exists COMMON.CUSTOMER;
drop table if exists transaction.request;
drop table if exists transaction.response;
drop table if exists REPORT.TRANSACTION_SUM_COUNT_PER_DATE;
/*==============================================================*/


create table CARD.CARD
(
    UID                DECIMAL(19)        not null AUTO_INCREMENT,
    PAN                DECIMAL(19)        not null,
    ISSUE_DATE         INTEGER           ,
    ACTIVE_DATE        INTEGER,
    EXPIRE_DATE        INTEGER           ,
    STATUS             SMALLINT          ,
    INSERT_DATE        TIMESTAMP(6)      ,
    MODIFY_DATE        TIMESTAMP(6),
    CUSTOMER_UID       DECIMAL(12)       ,
    PIN                CHAR(16),
    INCORRECT_PIN1_TRY SMALLINT default 0,
    INCORRECT_PIN2_TRY SMALLINT default 0,
    INCORRECT_CVV1_TRY SMALLINT default 0,
    INCORRECT_CVV2_TRY SMALLINT default 0,
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



create table  REPORT.TRANSACTION_SUM_COUNT_PER_DATE
(
    PAN                   DECIMAL(19),
    SCUSTOMER_UID         DECIMAL(19),
    SCARD_UID             DECIMAL(19),
    CDATE                 INTEGER,
    COUNNT_success        DECIMAL(12),
    COUNNT_UNsuccess      DECIMAL(12),
    AMOUNT_success        DECIMAL(12),
    AMOUNT_UNsuccess      DECIMAL(12)
);
commit;
