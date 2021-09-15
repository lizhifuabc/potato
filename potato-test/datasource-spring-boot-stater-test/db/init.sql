create schema `potato-db-01`;
create schema `potato-db-02`;

INSERT INTO potato.base_datasource (datasource_id, datasource_name, user_name, password, url) VALUES (201, '01', 'yfyf_dev', 'T%F4eoBPQu3Ne', 'jdbc:mysql://rm-2zeochgmp1srpq166.mysql.rds.aliyuncs.com:3306/potato-db-01?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8');
INSERT INTO potato.base_datasource (datasource_id, datasource_name, user_name, password, url) VALUES (202, '02', 'yfyf_dev', 'T%F4eoBPQu3Ne', 'jdbc:mysql://rm-2zeochgmp1srpq166.mysql.rds.aliyuncs.com:3306/potato-db-02?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8');

drop table if exists `potato-db-01`.`table01`;
create table `potato-db-01`.`table01` (
     id  bigint(20)      not null auto_increment    comment '主键',
     value varchar(36) comment '数据',
     primary key (id)
) engine=innodb auto_increment=200 comment = 'table01';

drop table if exists `potato-db-02`.`table01`;
create table `potato-db-02`.`table01` (
    id  bigint(20)      not null auto_increment    comment '主键',
    value varchar(36) comment '数据',
    primary key (id)
) engine=innodb auto_increment=200 comment = 'table01';