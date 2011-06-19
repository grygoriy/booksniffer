
create table UserRole (
    UserId bigint(20) not null,
    RoleId smallint not null,

    primary key (UserId, RoleId)

) engine=InnoDB default charset=utf8;


insert into UserRole(UserId, RoleId) values (1, 1);
