create table trade_msg(
  id BIGINT(20) AUTO_INCREMENT PRIMARY KEY ,
  tradeId BIGINT(20),
  userId BIGINT(20),
  itemId BIGINT(20),
  createDate TIMESTAMP
)ENGINE =InnoDB DEFAULT CHARSET=utf8;