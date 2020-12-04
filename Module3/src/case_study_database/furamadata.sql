use furamaresort;

insert into kieuthue (id_kieu_thue, ten_kieu_thue, gia) values
	(1, 'Nam', 100000000),
	(2, 'Thang', 10000000),
	(3, 'Ngay', 1000000),
	(4, 'Gio', 100000);
    
insert into loaidichvu (id_loai_dich_vu, ten_loai_dich_vu) values
	(1, 'Vip'),
	(2, 'Tot'),
	(3, 'Thuong');
    
insert into dichvu 
	(id_dich_vu, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, 
		trang_thai, kieu_thue_id, loai_dich_vu_id) values
    (1, 'Villa', 500, 2, '4', '20000000', 'Con', 2, 1),
    (2, 'House', 300, 3, '8', '8000000', 'Con', 1, 2),
    (3, 'Room', 100, 1, '4', '1000000', 'Con', 3, 3);
      
insert into loaikhachhang (id_loai_khach_hang, ten_loai_khach_hang) values
	(1, 'Diamond'),
	(2, 'Platinium'),
	(3, 'Gold'),
	(4, 'Silver'),
	(5, 'Member');
	
insert into khachhang (id_khach_hang, ho_ten, ngay_sinh, so_cmnd, sdt, email, diachi, loai_khach_hang_id) values
	(1, 'Trang', '1997-11-20', '812364873', '0123456789', 'trang@gmail.com', 'Dien bien phu', 2),
	(2, 'Anh', '1995-04-09', '812364873', '0123456789', 'trang@gmail.com', 'Dien bien phu', 1),
	(3, 'Nhan', '1993-12-13', '812364873', '0123456789', 'trang@gmail.com', 'Dien bien phu', 3);
    
insert into vitri (id_vi_tri, ten_vi_tri) values
	(1, 'Le tan'),
	(2, 'Phuc vu'),
	(3, 'Chuyen vien'),
	(4, 'Giam sat'),
	(5, 'Quan ly'),
	(6, 'Giam doc');
    
insert into trinhdo values
	(1, 'Trung cap'),
	(2, 'Cao dang'),
	(3, 'Dai hoc'),
	(4, 'Co kinh nghiem');
    
insert into bophan values 
	(1, 'Sale-Maketing'),
    (2, 'Hanh chinh'),
	(3, 'Phuc vu'),
    (4, 'Quan ly');
    
insert into nhanvien values
	(1, 'Khang', '1998-10-28', '68761234', '8000000', '0432874655', 'khang@gmail.com', 'Hoa khanh', 3, 3, 2),
	(2, 'Bao', '1997-09-24', '68761234', '8000000', '0432874655', 'bao@gmail.com', 'Hoa khanh', 5, 3, 4),
	(3, 'Thinh', '2003-10-28', '68761234', '8000000', '0432874655', 'thinh@gmail.com', 'Hoa khanh', 4, 3, 1);
    
insert into hopdong values
	(1, '2020-12-04', '2020-12-25', 30000000, 60000000, 1, 2, 2),
	(2, '2020-12-14', '2021-01-05', 20000000, 40000000, 2, 1, 3),
	(3, '2020-12-24', '2021-01-01', 3000000, 6000000, 3, 2, 1);
    
insert into dichvudikem values
	(1, 'Massage', 500000, 2, 'Con'),
	(2, 'Karaoke', 300000, 5, 'Con'),
	(3, 'Food', 200000, 10, 'Con'),
	(4, 'Drink', 100000, 20, 'Con'),
	(5, 'Car', 150000, 10, 'Con');
    
insert into hopdongchitiet values
	(1, 2, 3, 2),
	(2, 3, 4, 3),
	(3, 1, 1, 2);
    