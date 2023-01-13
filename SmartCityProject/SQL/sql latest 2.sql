drop database if exists test;
create database test;
use test;
drop table if exists users;
drop table if exists theatres;
drop table if exists movies;
drop table if exists shows;
drop table if exists bookings;
create table users(
user_id integer auto_increment,
firstname varchar(20),
lastname varchar(20),
username varchar(15),
email varchar(30),
passwordFld varchar(20),
verify_code integer,
can_login boolean default false,
primary key(user_id)
);
create table theatres(
theatre_id integer auto_increment,
name varchar(25),
location varchar(20),
primary key(theatre_id)
);
create table movies(
movie_id integer auto_increment,
name varchar(15),
theatre_id integer,
primary key(movie_id)
);
create table shows(
show_id integer auto_increment,
show_time varchar(15),
movie_id integer,
no_of_tickets integer default 50,
primary key(show_id)
);
create table bookings(
booking_id integer auto_increment,
user_id integer,
enterprize varchar(15),
lat double,
lon double,
primary key(booking_id)
);
insert into users(firstname,lastname,username,email,passwordFld,verify_code) values("Ruthvik","Garlapati","ruthvikg31","garlapati.r@northeastern.edu","password",123456);
insert into users(firstname,lastname,username,email,passwordFld,verify_code) values("Ruthvik","Garlapati","Kdebruyne17","ruthvik@gmail.com","password",123456);
update users set username = 'Username' where user_id = 1;
update users set can_login = 1 where user_id = 1;
insert into theatres(name,location) values('Prasad IMAX','Boston');
insert into theatres(name,location) values('AMC IMAX','New York');
insert into movies(name,theatre_id) values('Avatar',1);
insert into movies(name,theatre_id) values('Black Panther',1);
insert into movies(name,theatre_id) values('HIT 2',1);
insert into movies(name,theatre_id) values('Love Today',2);
insert into movies(name,theatre_id) values('Black Adam',2);
insert into shows(show_time,movie_id) values("11:00 AM",1);
insert into shows(show_time,movie_id) values("11:15 AM",1);
insert into shows(show_time,movie_id) values("11:30 AM",1);
insert into shows(show_time,movie_id) values("02:00 PM",2);
insert into shows(show_time,movie_id) values("02:15 PM",2);

insert into bookings(user_id,enterprize,lat,lon) values (1,"Movies",42.3410701,-71.0882683);
insert into bookings(user_id,enterprize,lat,lon) values (1,"Movies",42.3432429,-71.0979135);
select * from users;


create Table Hospital(
hospital_id integer auto_increment,
name varchar(25),
location varchar(20),
primary key(hospital_id)
);

create table doctor(
doctor_id integer auto_increment,
name varchar(15),
hospital_id integer,
primary key(doctor_id)
);

create table apttime(
apttime_id integer auto_increment,
apttime_time varchar(15),
doctor_id integer,
primary key(apttime_id)
);
insert into hospital(name,location) values('Mass General Hospital','Downtown');
insert into hospital(name,location) values('Boston Medical Center','Roxbury');
insert into hospital(name,location) values('Masschusetts General ','Huntington');
select * from hospital;
select * from doctor; 
insert into doctor(name,hospital_id) values('Ram',1);
insert into doctor(name,hospital_id) values('Christopher',1);
insert into doctor(name,hospital_id) values('Fun',1);
insert into doctor(name,hospital_id) values('Sara',2);
insert into doctor(name,hospital_id) values('Raj',2);
insert into doctor(name,hospital_id) values('Ruthvik',2);


insert into apttime(apttime_time,doctor_id) values("11:00 AM",1);
insert into apttime(apttime_time ,doctor_id) values("11:15 AM",1);
insert into apttime(apttime_time ,doctor_id) values("11:30 AM",1);
insert into apttime(apttime_time ,doctor_id) values("02:00 PM",2);
insert into apttime(apttime_time ,doctor_id) values("02:15 PM",2);
insert into apttime(apttime_time ,doctor_id) values("03:15 PM",2);

select * from apttime




