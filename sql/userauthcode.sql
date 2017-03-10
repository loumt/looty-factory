CREATE TABLE user_auth_code(
  id INT(11) AUTO_INCREMENT PRIMARY KEY,
  userId VARCHAR(255) NOT NULL ,
  lastOperationIp VARCHAR(255) NOT NULL ,
  authCode VARCHAR(255) NOT NULL ,
  createDate DATETIME DEFAULT NULL ,
  inValidData DATETIME
)ENGINE=InnoDB DEFAULT CHARSET =utf8;