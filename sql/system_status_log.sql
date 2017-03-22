CREATE TABLE system_status_log(
  id BIGINT(20) PRIMARY  KEY AUTO_INCREMENT,
  statusAction VARCHAR (255) DEFAULT "",
  serverInfo VARCHAR (255) DEFAULT "",
  contextName VARCHAR (255) DEFAULT "",
  operationTime TIMESTAMP
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


  DROP TABLE IF EXISTS system_status_log;