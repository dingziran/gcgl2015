# --- !Ups
CREATE TABLE users (
  id long,
  username varchar(20),
  password varchar(20));

# --- !Downs
DROP TABLE IF EXISTS users;