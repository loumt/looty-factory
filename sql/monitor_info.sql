create TABLE monitor_info (
    id int(11) not null,
    totalMemory mediumtext,
    freeMemory mediumtext,
    totalThread int(6) not null,
    availableProcessors int(6) not null,
    osName varchar(255),
    hostAddress varchar(255),
    userDomain varchar(255),
    javaVersion varchar(255),
    javaHome varchar(255),
    javaVmName varchar(255),
    createDate timestamp not null default 'CURRENT_TIMESTAMP',
    PRIMARY KEY (id)
);