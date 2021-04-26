CREATE TABLE todolist (
	id serial not null primary key,
	description varchar not null,
	due_date date not null default CURRENT_DATE,
	status char(1));
	
insert into todolist (description,status) values ('test the todo list',1);
insert into todolist (description,status) values ('take out the trash',0);
insert into todolist (description,status) values ('walk the dogs',0);
insert into todolist (description,status) values ('mow the lawn',1);
insert into todolist (description,status) values ('complete this project',0);
insert into todolist (description,status) values ('study for QC',0);
insert into todolist (description,status) values ('make dinner',0);
insert into todolist (description,status) values ('think of more to do list items',0);
