CREATE DATABASE IF NOT EXISTS potato_config DEFAULT CHARACTER SET = utf8;
Use potato_config;

-- ----------------------------
-- 客户端信息
-- ----------------------------
DROP TABLE IF EXISTS oauth_client_details;
CREATE TABLE oauth_client_details  (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  client_id varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用标识',
  resource_ids varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源限定串(逗号分割)',
  client_secret varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '应用密钥(bcyt) 加密',
  client_secret_str varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '应用密钥(明文)',
  scope varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '范围',
  authorized_grant_types varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)',
  web_server_redirect_uri varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回调地址 ',
  authorities varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  access_token_validity int(11) NULL DEFAULT NULL COMMENT 'access_token有效期',
  refresh_token_validity int(11) NULL DEFAULT NULL COMMENT 'refresh_token有效期',
  additional_information varchar(4096) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '{}' COMMENT '{}',
  autoapprove char(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'true' COMMENT '是否自动授权 是-true',
  create_time datetime(0) NULL DEFAULT NULL,
  update_time datetime(0) NULL DEFAULT NULL,
  client_name varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '应用名称',
  support_id_token tinyint(1) DEFAULT 1 COMMENT '是否支持id_token',
  id_token_validity int(11) DEFAULT 60 COMMENT 'id_token有效期',
  PRIMARY KEY (id) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- 初始化数据
-- ----------------------------
INSERT INTO oauth_client_details VALUES (2, 'app', NULL, '$2a$10$i3F515wEDiB4Gvj9ym9Prui0dasRttEUQ9ink4Wpgb4zEDCAlV8zO', 'app', 'app', 'authorization_code,password,refresh_token', 'http://127.0.0.1:8081/callback.html', NULL, 3600, NULL, '{}', 'true', NULL, NULL, '移动端', 1, 60);