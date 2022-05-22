create table employees (
  employee_id serial primary key,
  citizen_id integer,
  phone_number integer,
  first_name varchar (255),
  last_name varchar (255),
  email varchar (255),
  gender varchar (255),
  province varchar (255),
  district varchar (255),
  birth_date date not null,
  application_date date not null,
  salary integer,
  paid_leave integer,
  absent_day integer,
  position varchar (255)
);

create table accounts (
  account_id serial primary key,
  username varchar (255),
  password varchar (255)
);