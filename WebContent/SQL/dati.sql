drop table impiegato cascade constraints;
drop table utente cascade constraints;
drop sequence imp_seq;

create table impiegato(
id int,
nome varchar2(30) not null,
stipendio number(7,2) not null,
reparto varchar2(50) not null,
img_url varchar(30) default 'resources/dummy.png',
constraint p_idimp primary key(id)
);

create table utente(
nome varchar2(30) not null,
cognome varchar2(30) not null,
email varchar2(30) not null,
password varchar2(30) not null,
username varchar2(30),
constraint p_usern primary key(username)
);

create sequence imp_seq;