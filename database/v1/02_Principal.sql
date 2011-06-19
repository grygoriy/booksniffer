create table User (
    UserId bigint(20) not null auto_increment,
    UserName varchar(250) not null,
    FirstName varchar(250),
    LastName varchar(250),
    Password varchar(250) not null,
    Enabled bit not null,
    AccountExpired bit not null,
    AccountLocked bit not null,
    PasswordExpired bit not null,

    primary key (UserId),
    unique key UQ_Username (UserName)
) engine=InnoDB default charset=utf8;


insert into User(UserName, Password, Enabled, AccountExpired, AccountLocked, PasswordExpired, FirstName, LastName) values
('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 1, 0, 0, 0, 'Admin', 'Istrator'); -- password: admin
