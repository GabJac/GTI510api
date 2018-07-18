# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

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

drop table utilisateur cascade constraints purge;
drop sequence utilisateur_seq;

