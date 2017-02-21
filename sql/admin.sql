CREATE TABLE admin (
  id                BIGINT(20)   AUTO_INCREMENT PRIMARY KEY,
  userId            VARCHAR(255) NOT NULL,
  role              VARCHAR(255) NOT NULL,
  username          VARCHAR(255) NOT NULL,
  password          VARCHAR(255) NOT NULL,
  realName          VARCHAR(255) DEFAULT "",
  createTime        DATETIME     DEFAULT NULL,
  lastOperationTime DATETIME     DEFAULT NULL,
  authTop           INT(8)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*超级管理员*/
INSERT INTO admin VALUES (1, 'super', 'admin', 'admin', '超级管理员', now(), now());

DROP TABLE IF EXISTS admin;