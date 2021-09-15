-- ----------------------------
-- 数据源
-- ----------------------------
drop table if exists base_datasource;
create table base_datasource (
    datasource_id       bigint(20)      not null auto_increment    comment '主键',
    datasource_name     varchar(100)    not null                   comment '数据库名称',
    user_name           varchar(100)    not null                   comment '用户名',
    password            varchar(100)    not null                   comment '密码',
    url                 varchar(255)    not null                   comment '数据库URL',
    primary key (datasource_id)
) engine=innodb auto_increment=200 comment = '数据源';

INSERT INTO potato.base_datasource (datasource_id, datasource_name, user_name, password, url) VALUES (200, '默认', 'yfyf_dev', 'T%F4eoBPQu3Ne', 'jdbc:mysql://rm-2zeochgmp1srpq166.mysql.rds.aliyuncs.com:3306/xi?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8');