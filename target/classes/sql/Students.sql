create table grade(
gid int primary key,
gname varchar(32) not null,
gdesc varchar(128) not null
);
create table student(
sid int primary key,
sname varchar(32) not null,
sex char(2),
gid int
);

alter table student add constraint fk_student_id foreign key (gid)
references grede(gid);