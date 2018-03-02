insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (1, 1, '性别', '男');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (2, 1, '性别', '女');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (3, 2, '用工形式', '正式员工');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (4, 2, '用工形式', '临时员工');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (5, 3, '民族', '满族');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (6, 3, '民族', '汉族');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (7, 3, '民族', '壮族');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (8, 4, '人员来源', '校园招聘');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (9, 4, '人员来源', '社会招聘');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (10, 5, '政治面貌', '党员');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (11, 5, '政治面貌', '预备党员');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (12, 5, '政治面貌', '团员');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (13, 6, '血型', 'A型');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (14, 6, '血型', 'B型');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (15, 6, '血型', 'AB型');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (16, 6, '血型', 'O型');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (17, 7, '婚姻状况', '未婚');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (18, 7, '婚姻状况', '已婚');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (19, 7, '婚姻状况', '丧偶');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (20, 7, '婚姻状况', '离婚');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (21, 8, '最高学历', '高中及以下');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (22, 8, '最高学历', '大专');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (23, 8, '最高学历', '本科');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (24, 8, '最高学历', '研究生');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (25, 9, '最高学位', '无学位');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (26, 9, '最高学位', '学士');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (27, 9, '最高学位', '双学士');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (28, 9, '最高学位', '硕士');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (29, 9, '最高学位', '博士');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (30, 9, '最高学位', '博士后');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (31, 10, '考核结果', '转正');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (32, 10, '考核结果', '延期');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (33, 10, '考核结果', '试用期未通过');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (34, 11, '离职类型', '主动离职');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (35, 11, '离职类型', '辞退');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (36, 11, '离职类型', '退休');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (37, 11, '离职类型', '开除');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (38, 11, '离职类型', '试用期未通过');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (39, 12, '部门类型', '公司');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (40, 12, '部门类型', '部门');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (45, 14, '调转类型', '主动调动');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (46, 14, '调转类型', '被动调动');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (47, 14, '调转类型', '数据错误');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (48, 15, '岗位类型', '技术');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (49, 15, '岗位类型', '管理');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (50, 15, '岗位类型', '销售');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (54, 17, '调转类型', '升职');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (55, 17, '调转类型', '降职');
insert into CODE (ID, TYPE_ID, CODE_NAME, CODE_VALUE)
values (56, 17, '调转类型', '数据错误');
commit;
prompt 49 records loaded
prompt Enabling triggers for CODE...
alter table CODE enable all triggers;
set feedback on
set define on
prompt Done.
