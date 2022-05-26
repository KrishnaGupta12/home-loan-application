DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

create table users (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);

 insert into users(username, password, enabled)values('sagar','sagar',true);
 insert into authorities(username,authority)values('sagar','ROLE_ADMIN');
 
 insert into users(username, password, enabled)values('vinod','vin1234',true);
 insert into authorities(username,authority)values('vinod','ROLE_PAYMENT');
 
 insert into users(username, password, enabled)values('tejas','tejas1234',true);
 insert into authorities(username,authority)values('tejas','ROLE_USER');
 insert into authorities(username,authority)values('sagar','ROLE_PAYMENT');
 insert into authorities(username,authority)values('sagar','ROLE_ADMIN');