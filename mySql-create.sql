create table parent (
  id                        integer auto_increment not null,
  name                      varchar(255),
  student_id                integer,
  constraint pk_parent primary key (id))
;

create table student (
  id                        integer auto_increment not null,
  name                      varchar(255),
  age                       integer,
  constraint pk_student primary key (id))
;

alter table parent add constraint fk_parent_student_1 foreign key (student_id) references student (id) on delete restrict on update restrict;
create index ix_parent_student_1 on parent (student_id);


