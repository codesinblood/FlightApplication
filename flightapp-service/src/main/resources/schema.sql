drop table if exists mydb.user_roles;
drop table if exists mydb.appuser;
drop table if exists mydb.hibernate_sequence;
drop table if exists mydb.role;


create table mydb.appuser (appuser_id integer not null, dob DATE, email varchar(200) not null, firstname varchar(200) not null, gender varchar(1), lastname varchar(200), password varchar(255), username varchar(50), primary key (appuser_id));
create table mydb.hibernate_sequence (next_val bigint);
insert into mydb.hibernate_sequence values ( 1 );
create table mydb.role (role_id integer not null auto_increment, name varchar(255), primary key (role_id));
create table mydb.user_roles (appuser_id integer not null, role_id integer not null, primary key (appuser_id, role_id));
alter table mydb.appuser add constraint unique (email);
alter table mydb.appuser add constraint unique (username);
alter table mydb.user_roles add constraint foreign key (role_id) references mydb.role (role_id);
alter table mydb.user_roles add constraint foreign key (appuser_id) references mydb.appuser (appuser_id);