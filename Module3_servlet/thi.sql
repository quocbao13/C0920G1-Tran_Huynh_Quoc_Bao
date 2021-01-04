create database benhan;
use benhan;
create table benhan(
	benhan_id int primary key auto_increment not null,
    ngaynhapvien date,
    ngayravien date,
    lydonhapvien varchar(100),
    benhnhan_id int,
    foreign key(benhnhan_id) references benhnhan(benhnhan_id)
);
create table benhnhan(
	benhnhan_id int primary key auto_increment not null,
    tenbenhnhan varchar(45)
);