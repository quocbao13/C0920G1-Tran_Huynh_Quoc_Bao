/*Create new db = homework*/
create database homework;
use homework;
create table Categories(
	id int not null primary key,
    `name` varchar(50),
    `description` varchar(500)
);

insert into categories (id, `name`, `description`) value
	(1,'Phone', 'Good'),
	(2,'Laptop', 'Normal'),
	(3,'PC', 'Good'),
	(4,'Head phone', 'Normal'),
	(5,'Mouse', 'Normal');

create table Suppliers(
	id int not null primary key,
    `name` varchar(100),
    email varchar(50),
    phone_number varchar(50),
    address varchar(500)
);

insert into suppliers (id, `name`, email, phone_number, address) value
	(1,'Apple', 'apple@apple.com', '0412344433', 'America'),
	(2,'Apple', 'samsung@samsung.com', '0412344433', 'Korian'),
	(3,'Apple', 'nokia@nokia.com', '0412344433', 'Vietnam');

create table Customers(
	id varchar(50) not null primary key,
    first_name varchar(50),
    last_name varchar(50),
    phone_number varchar(50),
    address varchar(500),
    email varchar(50),
    birth_day date
);

create table Employees(
	id varchar(50) not null primary key,
    first_name varchar(50),
    last_name varchar(50),
    phone_number varchar(50),
    address varchar(500),
    email varchar(50),
    birth_day date
);

create table Products(
	id int not null primary key,
    `name` varchar(100),
    image_url varchar(1000),
    price int,
    discount int,
    stock int,
    category_id int,
    constraint product_category foreign key (category_id) references categories(id),
    supplier_id int,
	constraint product_supplier foreign key (supplier_id) references suppliers(id),
    `discription` varchar(1000)
);

create table Orders(
	id int not null primary key,
    create_date date,
    shipped_date date,
    `status` varchar(50),
    `discription` varchar(1000),
    shipping_address varchar(500),
    payment_type varchar(20),
    customer_id varchar(50),
    constraint order_customer foreign key (customer_id) references customers(id),
    employee_id varchar(50),
    constraint order_employee foreign key (employee_id) references employees(id)
);

create table OrderDetails(
	id int not null primary key,
    order_id int,
    constraint orderdetail_order foreign key (order_id) references orders(id),
    product_id int,
    constraint orderdetail_product foreign key (product_id) references products(id)
)