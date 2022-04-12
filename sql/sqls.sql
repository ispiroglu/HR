
create type address as (
  zip_code integer,
  country varchar,
  city varchar,
  street varchar
);

create table candidates (
  candidate_id serial primary key,
  citizen_id integer,
  phone_number integer,
  first_name varchar (255),
  last_name varchar (255),
  email varchar (255),
  gender varchar(255),
  my_adress address,
  birth_date date not null,
  application_date date not null
);


create table employees (
  employee_id serial primary key,
  citizen_id integer,
  phone_number integer,
  first_name varchar (255),
  last_name varchar (255),
  email varchar (255),
  gender varchar(255),
  my_adress address,
  birth_date date not null,
  application_date date not null,
  salary integer,
  paid_leave integer,
  absent_day integer
);