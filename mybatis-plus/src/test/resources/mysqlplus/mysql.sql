
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for plus_user
-- ----------------------------
DROP TABLE IF EXISTS user_plus;
CREATE TABLE user_plus (
  test_id               bigint(20)        NOT NULL,
  user_name             varchar(30)       COLLATE utf8_bin DEFAULT NULL,
  age                   int(11)           DEFAULT NULL,
  test_type             int(11)           DEFAULT '0',
  phone                 varchar(64)       COLLATE utf8_bin DEFAULT NULL,
  price                 DECIMAL(10,2)     NULL DEFAULT NULL,
  version               INT(5)            NULL DEFAULT NULL,
  PRIMARY KEY (test_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;

