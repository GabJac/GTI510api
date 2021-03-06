# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table commentaires (
  comment_id                    number(10) not null,
  comments                      varchar2(255),
  user_id                       number(10),
  previous_comment_id           number(10),
  article_id                    number(10),
  creation_date                 timestamp,
  constraint pk_commentaires primary key (comment_id)
);
create sequence commentaires_seq;

create table comments (
  id                            number(10) not null,
  comments                      varchar2(255),
  user_id                       number(10),
  previous_comment_id           number(10),
  article_id                    number(10),
  creation_date                 timestamp,
  constraint pk_comments primary key (id)
);
create sequence CUST_SEQ;

create table utilisateur (
  user_id                       number(10) not null,
  nom                           varchar2(255),
  prenom                        varchar2(255),
  email                         varchar2(255),
  admin                         number(1),
  password                      varchar2(255),
  statut                        varchar2(255),
  constraint pk_utilisateur primary key (user_id)
);
create sequence utilisateur_seq;


# --- !Downs

drop table commentaires cascade constraints purge;
drop sequence commentaires_seq;

drop table comments cascade constraints purge;
drop sequence CUST_SEQ;

drop table utilisateur cascade constraints purge;
drop sequence utilisateur_seq;

