CREATE TABLE app_log (
  id                BIGINT(20)   AUTO_INCREMENT PRIMARY KEY,
  moduleName              VARCHAR(255) NOT NULL,
  operationType          VARCHAR(255) NOT NULL,
  adminId          VARCHAR (255),
  operationTime DATETIME
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS app_log;