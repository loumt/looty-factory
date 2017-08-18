create TABLE "user" (
    id bigint(20) not null,
    userId varchar(255) not null,
    roleCode varchar(255) not null,
    username varchar(255) not null,
    password varchar(255) not null,
    realName varchar(255) default '',
    createTime datetime,
    lastOperationTime datetime,
    authTop int(8),
    PRIMARY KEY (id)
)ENGINE =InnoDB DEFAULT CHARSET=utf8;