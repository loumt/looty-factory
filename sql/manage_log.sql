
CREATE TABLE `manage_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `moduleName` varchar(255) NOT NULL,
  `operationType` int(8) NOT NULL,
  `adminId` varchar(255) DEFAULT NULL,
  `operationTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
