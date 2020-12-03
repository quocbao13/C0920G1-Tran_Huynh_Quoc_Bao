drop database if exists furamaresort;

-- create db
create database furamaresort;
use furamaresort;
-- create table
-- drop table if exists hopdong;
create table hopdong(
	id_hop_dong int primary key,
	ngay_lam_hop_dong date,
    ngay_ket_thuc date,
    tien_da_coc int,
    tong_tien int
);

create table dichvu(
	id_dich_vu int primary key,
    ten_dich_vu varchar(45),
    dien_tich int,
    so_tang int,
    so_nguoi_toi_da varchar(45),
    chi_phi_thue varchar(45),
    trang_thai varchar(45)
);

create table kieuthue(
	id_kieu_thue int primary key,
    ten_kieu_thue varchar(45),
    gia int
);

create table loaidichvu(
	id_loai_dich_vu int primary key,
    ten_loai_dich_vu varchar(45)
);

alter table dichvu
	add kieu_thue_id int,
    add foreign key (kieu_thue_id) references kieuthue(id_kieu_thue),
    add loai_dich_vu_id int,
    add foreign key (loai_dich_vu_id) references loaidichvu(id_loai_dich_vu);
    
create table khachhang(
	id_khach_hang int primary key,
    ho_ten varchar(45),
    ngay_sinh date,
    so_cmnd varchar(45),
    sdt varchar(45),
    email varchar(45),
    diachi varchar(45)
);

create table loaikhachhang(
	id_loai_khach_hang int primary key,
    ten_loai_khach_hang varchar(45)
);

alter table khachhang
	add loai_khach_hang_id int,
    add foreign key (loai_khach_hang_id) references loaikhachhang(id_loai_khach_hang);
    
create table nhanvien(
	id_nhan_vien int primary key,
    ho_ten varchar(45),
    ngay_sinh date,
    so_cmnd varchar(45),
    luong varchar(45),
    sdt varchar(45),
    email varchar(45),
    dia_chi varchar(45)
);

create table vitri(
	id_vi_tri int primary key,
    ten_vi_tri varchar(45)
);

create table trinhdo(
	id_trinh_do int primary key,
    ten_trinh_do varchar(45)
);

create table bophan(
	id_bo_phan int primary key,
    ten_bo_phan varchar(45)
);

alter table nhanvien
	add vi_tri_id int,
    add foreign key (vi_tri_id) references vitri(id_vi_tri),
	add trinh_do_id int,
    add foreign key (trinh_do_id) references trinhdo(id_trinh_do),
	add bo_phan_id int,
    add foreign key (bo_phan_id) references bophan(id_bo_phan);
    
alter table hopdong
	add dich_vu_id int,
    add foreign key (dich_vu_id) references dichvu(id_dich_vu),
    add khach_hang_id int,
    add foreign key (khach_hang_id) references khachhang(id_khach_hang),
    add nhan_vien_id int,
    add foreign key (nhan_vien_id) references nhanvien(id_nhan_vien);
    
create table dichvudikem(
	id_dv_di_kem int primary key,
    ten_dv_di_kem varchar(45),
    gia int,
    donvi int,
    trang_thai_kha_dung varchar(45)
);
-- drop table if exists hopdongchitiet;
create table hopdongchitiet(
	id_hd_chi_tiet int primary key,
    hop_dong_id int,
    dv_di_kem_id int,
    foreign key (hop_dong_id) references hopdong(id_hop_dong),
    foreign key (dv_di_kem_id) references dichvudikem(id_dv_di_kem),
    soluong int
)