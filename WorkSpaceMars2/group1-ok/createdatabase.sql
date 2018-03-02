--------------------------------------------
-- Export file for user SCOTT             --
-- Created by ttc on 2009-12-16, 13:31:38 --
--------------------------------------------

spool group1.log

prompt
prompt Creating table CODE
prompt ===================
prompt
create table CODE
(
  ID         NUMBER(5) not null,
  TYPE_ID    NUMBER(5),
  CODE_NAME  VARCHAR2(20),
  CODE_VALUE VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table CODE
  add constraint CODE_ID_PK primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table DEPT
prompt ===================
prompt
create table DEPT
(
  ID           NUMBER(5) not null,
  DEPT_NUMBER  NUMBER(5) not null,
  DEPT_NAME    VARCHAR2(20) not null,
  DEPT_TYPE    NUMBER(5) not null,
  DEPT_TEL     VARCHAR2(20) not null,
  DEPT_FAX     VARCHAR2(20),
  DEPT_SUPER   NUMBER(5),
  DEPT_DESC    VARCHAR2(50),
  DEPT_SETDATE DATE not null,
  SITUATION    NUMBER(2) default 1 not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DEPT
  add constraint DEPT_ID_PK primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table DEPT_CHANGE
prompt ==========================
prompt
create table DEPT_CHANGE
(
  ID            NUMBER(5) not null,
  EM_ID         NUMBER(5),
  DEPT_BEFORE   NUMBER(5),
  DEPT_AFTER    NUMBER(5),
  DEPT_CHTYPE   NUMBER(5) not null,
  DEPT_CHREASON VARCHAR2(20) not null,
  DEPT_CHDATE   DATE not null,
  DEPT_CHEXTRA  VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DEPT_CHANGE
  add constraint DEPTC_ID_PK primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table DOMISSION
prompt ========================
prompt
create table DOMISSION
(
  ID       NUMBER(5) not null,
  LZ_TYPE  NUMBER(20),
  LZ_DATE  DATE not null,
  LZ_EXTRA VARCHAR2(20) not null,
  LZ_GO    VARCHAR2(20) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table DOMISSION
  add constraint DOMISSION_ID_PK primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table EMPLOYEE
prompt =======================
prompt
create table EMPLOYEE
(
  ID            NUMBER(5),
  EM_NUMBER     NUMBER(5) not null,
  EM_NAME       VARCHAR2(20) not null,
  EM_BIRTH      DATE not null,
  SEX           NUMBER(5) not null,
  EM_FORMAT     NUMBER(5) not null,
  EM_SOURCE     NUMBER(5) not null,
  EM_POLITY     NUMBER(5) not null,
  EM_FOLK       NUMBER(5) not null,
  EM_ID         VARCHAR2(20) not null,
  EM_INDATE     DATE not null,
  EM_WORKTIME   DATE not null,
  EM_BIRTHPLACE VARCHAR2(20),
  EM_PHONE      VARCHAR2(20),
  EM_MAIL       VARCHAR2(20),
  EM_BLOOD      NUMBER(5),
  EM_WEDLOCK    NUMBER(5),
  EM_STATURE    VARCHAR2(20),
  DEPT_NUMBER   NUMBER(20),
  JOB_NUMBER    NUMBER(20),
  EM_SEAT       VARCHAR2(20),
  EM_LEARN      NUMBER(5),
  EM_DEGREE     NUMBER(5),
  EM_GRADUATE   VARCHAR2(20),
  EM_SPECIALTY  VARCHAR2(20),
  EM_GRADATE    DATE,
  EM_HOMEPLACE  VARCHAR2(20),
  SITUATION     NUMBER(2) default 1 not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table JOB
prompt ==================
prompt
create table JOB
(
  ID         NUMBER(5) not null,
  JOB_NUMBER NUMBER(5) not null,
  JOB_NAME   VARCHAR2(20) not null,
  JOB_TYPE   VARCHAR2(20) not null,
  JOB_MAX    NUMBER(5),
  JOB_MAN    NUMBER(5) default 0,
  SITUATION  NUMBER(2) default 1
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table JOB
  add constraint JOB_ID_PK primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table JOB_CH
prompt =====================
prompt
create table JOB_CH
(
  EMP_NUMBER   NUMBER(5) not null,
  EMP_NAME     VARCHAR2(20) not null,
  JOB_CHNAME   VARCHAR2(20) not null,
  JOB_CHREASON VARCHAR2(20),
  JOB_CHTYPE   VARCHAR2(20),
  JOB_CHDATE   DATE not null,
  JOB_CHEXTRA  VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PROBATION
prompt ========================
prompt
create table PROBATION
(
  ID           NUMBER(5) not null,
  EM_ID        NUMBER(5),
  PROB_REVIEWS VARCHAR2(50),
  PROB_RESULTS VARCHAR2(20),
  PROB_DATA    DATE,
  PROB_NOTES   VARCHAR2(50),
  PROB_START   DATE not null,
  PROB_END     DATE not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table PROBATION
  add constraint PROBATION_ID_PK primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence DEPTCHANGEID
prompt ==============================
prompt
create sequence DEPTCHANGEID
minvalue 1
maxvalue 999999999999999999999999999
start with 4
increment by 1
nocache;

prompt
prompt Creating sequence DEPTID
prompt ========================
prompt
create sequence DEPTID
minvalue 1
maxvalue 999999999999999999999999999
start with 8
increment by 1
nocache;

prompt
prompt Creating sequence EMPID
prompt =======================
prompt
create sequence EMPID
minvalue 1
maxvalue 99999999999999999999
start with 19
increment by 1
nocache;

prompt
prompt Creating sequence JOB_ID
prompt ========================
prompt
create sequence JOB_ID
minvalue 1
maxvalue 999999999999999999999999999
start with 28
increment by 1
nocache;

prompt
prompt Creating sequence PROBID
prompt ========================
prompt
create sequence PROBID
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
nocache;


spool off
