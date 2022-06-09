create schema taskmaster;

set search_path to taskmaster;

create table users (
   id              varchar primary key,
   first_name      varchar not null,
   last_name       varchar not null,
   email           varchar not null unique,
   username        varchar unique check (length(username) > 2),
   password        varchar check (length(password) > 7)
);

create table tasks (
   id              varchar primary key,
   title           varchar check (length(title) < 51),
   description     varchar not null,
   point_value     int check (point_value > 0 AND point_value < 100),
   creator_id      varchar not null,
   assignee_id     varchar,
   label           varchar not null,

   constraint task_creator_fk
   foreign key (creator_id)
   references users (id),

   constraint task_assignee_fk
   foreign key (assignee_id)
   references users (id)

);