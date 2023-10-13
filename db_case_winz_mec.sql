drop database win_z_mec;
create database win_z_mec;

use win_z_mec;

create table positions(
id int primary key not null auto_increment,
`name` varchar(45),
is_delete bit default 0
);

insert into positions(`name`) values("Bác sĩ");
insert into positions(`name`) values("Y tá");
insert into positions(`name`) values("Điều dưỡng");

create table departments(
id int primary key not null auto_increment,
`name` varchar(45),
is_delete bit default 0
);

insert into departments(`name`) values("Khoa nhi");
insert into departments(`name`) values("Khoa thần kinh");
insert into departments(`name`) values("Khoa tim");
insert into departments(`name`) values("Khoa gan");
insert into departments(`name`) values("Khoa mắt");
insert into departments(`name`) values("Khoa tai mũi họng");

create table education_degrees(
id int primary key not null auto_increment,
`name` varchar(45),
is_delete bit default 0
);

insert into education_degrees(`name`) values("Tiến sĩ");
insert into education_degrees(`name`) values("Thạc sĩ");
insert into education_degrees(`name`) values("Cao Học");
insert into education_degrees(`name`) values("Đại học");
insert into education_degrees(`name`) values("Cao Đẳng");
insert into education_degrees(`name`) values("Trung cấp");


create table customer_types(
id int primary key not null auto_increment,
`name` varchar(45),
is_delete bit default 0
);

insert into customer_types(`name`) values ("Bảo hiểm y tế");
insert into customer_types(`name`) values ("Không có bảo hiểm y tế");

create table users(
id int primary key not null auto_increment,
user_name varchar(45),
`password` varchar(45),
is_delete bit default 0
);

insert into users(user_name,`password`) values("admin","admin");
insert into users(user_name,`password`) values("dat","dat");
insert into users(user_name,`password`) values("thinh","thinh");
insert into users(user_name,`password`) values("thang","thang");
insert into users(user_name,`password`) values("phuc","phuc");
insert into users(user_name,`password`) values("nhan","nhan");
insert into users(user_name,`password`) values("kiet","kiet"); 

create table roles(
id int primary key not null auto_increment,
`name` varchar(45),
is_delete bit default 0
);

insert into roles(`name`) values("Admin");
insert into roles(`name`) values("Customer");
insert into roles(`name`) values("Employees");

create table user_roles(
role_id int,
user_id int,
is_delete bit default 0,
FOREIGN KEY (role_id) REFERENCES roles (id),
FOREIGN KEY (user_id) REFERENCES users (id)
);
insert into user_roles(role_id,user_id) values(2,1);
insert into user_roles(role_id,user_id) values(3,5);

create table admins(
id int primary key not null auto_increment,
`name` varchar(45),
is_delete bit default 0,
user_id int,
foreign key (user_id) REFERENCES users(id)
);

insert into admins(`name`,user_id) values("dat09",1);

create table customers(
id int primary key not null auto_increment,
`name` varchar(45),
gender varchar(10),
date_of_birth varchar(45),
id_card varchar(20),
phone_number varchar(20),
email varchar(45),
address varchar(45),
is_delete bit default 0,
customer_type_id int,
user_id int,
foreign key (customer_type_id) REFERENCES customer_types(id),
foreign key (user_id) REFERENCES users(id)
);
 
insert into customers(`name`,gender,date_of_birth,id_card,phone_number,email,address,customer_type_id,user_id) 
values("Lữ Bố","nam","1997-12-19","723481","82364876","lubo@gmail.com","Bến tre",1,2);
insert into customers(`name`,gender,date_of_birth,id_card,phone_number,email,address,customer_type_id,user_id) 
values("Triệu Vân","nam","2002-12-08","827634","98123468","trieuvan@gmail.com","Long An",2,3);
insert into customers(`name`,gender,date_of_birth,id_card,phone_number,email,address,customer_type_id,user_id) 
values("Đổng Trác","nam","2000-12-01","72364","324986581","dongtrac@gmail.com","Bến tre",1,4);
insert into customers(`name`,gender,date_of_birth,id_card,phone_number,email,address,customer_type_id,user_id) 
values("Điêu Thuyền","nữ","1995-01-02","124346","123432354","dieuthuyen@gmail.com","Hậu Giang",1,7);
insert into customers(`name`,gender,date_of_birth,id_card,phone_number,email,address,customer_type_id,user_id) 
values("Chu Du","nam","2001-09-09","43589798","23287345","chudu@gmail.com","Kiên Giang",2,5);
insert into customers(`name`,gender,date_of_birth,id_card,phone_number,email,address,customer_type_id,user_id) 
values("Tôn Linh Lung","nữ","2006-12-15","1233451","4124234","tonglinhlung@gmail.com","Cần Thơ",2,2);
insert into customers(`name`,gender,date_of_birth,id_card,phone_number,email,address,customer_type_id,user_id) 
values("Đại Kiều","nữ","1995-01-26","723481","82364876","daikieu@gmail.com","Cà Mau",2,4);
insert into customers(`name`,gender,date_of_birth,id_card,phone_number,email,address,customer_type_id,user_id) 
values("Quan Vũ","nam","2001-05-24","2134","23451q","quanvu@gmail.com","Sóc Trăng",1,3);
insert into customers(`name`,gender,date_of_birth,id_card,phone_number,email,address,customer_type_id,user_id) 
values("Gia Cát Lượng","nam","2000-02-28","2341234","34512343","giacatluong@gmail.com","Trà Vinh",1,2);
insert into customers(`name`,gender,date_of_birth,id_card,phone_number,email,address,customer_type_id,user_id) 
values("Trương Phi","nam","1996-02-19","653452","34254756","truongphi@gmail.com","Nha Trang",1,6);
insert into customers(`name`,gender,date_of_birth,id_card,phone_number,email,address,customer_type_id,user_id) 
values("Tào Tháo","nam","1997-12-27","723481","82364876","taothao@gmail.com","Vũng Tàu",2,7);

create table employees(
id int primary key not null auto_increment,
`name` varchar(45),
gender varchar(10),
date_of_birth varchar(45),
id_card varchar(20),
phone_number varchar(20),
email varchar(45),
address varchar(45),
salary double,
is_delete bit default 0,
position_id int,
department_id int,
education_degree_id int,
user_id int,
foreign key (position_id) references positions(id),
foreign key (department_id) references departments(id),
foreign key (education_degree_id) references education_degrees(id),
foreign key (user_id) references users(id)
);

insert into employees(`name`,gender,date_of_birth,id_card,phone_number,email,address,salary,position_id,department_id,education_degree_id,user_id) 
values("Tào Nhân","nam","1998-01-08","7346523","82364876","taonhan@gmail.com","Hà Nội",2000000,1,2,1,4);
insert into employees(`name`,gender,date_of_birth,id_card,phone_number,email,address,salary,position_id,department_id,education_degree_id,user_id) 
values("Hoàng Trung","nam","2010-02-20","7346523","82364876","hoangtrung@gmail.com","Sơn La",1000000,2,2,1,5);
insert into employees(`name`,gender,date_of_birth,id_card,phone_number,email,address,salary,position_id,department_id,education_degree_id,user_id) 
values("Hoàng Thượng","nam","1998-01-29","7346523","82364876","hoangthuong@gmail.com","Đà Lạt",1500000,2,3,6,2);
insert into employees(`name`,gender,date_of_birth,id_card,phone_number,email,address,salary,position_id,department_id,education_degree_id,user_id) 
values("Bàng Thống","nam","1998-01-17","7346523","82364876","bangthong@gmail.com","Đắk lắk",900000,3,4,6,3);
insert into employees(`name`,gender,date_of_birth,id_card,phone_number,email,address,salary,position_id,department_id,education_degree_id,user_id) 
values("Mã Siêu","nam","1998-01-27","7346523","82364876","masieu@gmail.com","Cam Ranh",2100000,2,6,4,4);
insert into employees(`name`,gender,date_of_birth,id_card,phone_number,email,address,salary,position_id,department_id,education_degree_id,user_id) 
values("Cam Ninh","nam","1999-01-19","7346523","82364876","camninh@gmail.com","Phan Thiết",4100000,3,5,3,2);
insert into employees(`name`,gender,date_of_birth,id_card,phone_number,email,address,salary,position_id,department_id,education_degree_id,user_id) 
values("Công Tôn Toản","nam","1995-05-13","7346523","82364876","congtontoan@gmail.com","Hạ Long",5000000,1,1,2,3);
insert into employees(`name`,gender,date_of_birth,id_card,phone_number,email,address,salary,position_id,department_id,education_degree_id,user_id) 
values("Giả Cơ","nữ","1999-11-18","7346523","82364876","giaco@gmail.com","Cần Giuộc",9000000,2,5,1,5);

create table bookings(
id int primary key not null auto_increment,
book_time varchar(100),
`status` varchar(45),
is_delete bit default 0,
customer_id int,
employee_id int,
foreign key (customer_id) references customers(id),
foreign key (employee_id) references employees(id)
);

insert into bookings(book_time,`status`,customer_id,employee_id)
values("2023-01-08 11-25-00","còn",1,4);
insert into bookings(book_time,`status`,customer_id,employee_id)
values("2023-09-21 12-40-00","hết",1,2);