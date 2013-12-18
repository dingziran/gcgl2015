# --- !Ups
create table users (
  username varchar(128) not null,
  id bigint primary key not null auto_increment,
  password varchar(128) not null
);


# --- !Downs
DROP TABLE IF EXISTS users;