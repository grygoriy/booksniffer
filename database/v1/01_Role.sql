create table Role (
    RoleId smallint not null auto_increment,
    Authority varchar(50) not null,
    Name varchar(50) not null,

    primary key (RoleId)

) engine=InnoDB default charset=utf8;

insert into Role (RoleId, Authority, Name) values (1, 'ROLE_ADMINISTRATOR', 'Administrator');
insert into Role (RoleId, Authority, Name) values (2, 'ROLE_STUDENT', 'Student');
