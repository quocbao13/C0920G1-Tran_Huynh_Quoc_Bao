use furamaresort;

insert into kieuthue (id_kieu_thue, ten_kieu_thue, gia) value
	(1, 'Nam', 100000000),
	(2, 'Thang', 10000000),
	(3, 'Ngay', 1000000),
	(4, 'Gio', 100000);
    
insert into loaidichvu (id_loai_dich_vu, ten_loai_dich_vu) value
	(1, 'Vip'),
	(2, 'Tot'),
	(3, 'Thuong');
    
insert into dichvu 
	(id_dich_vu, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, 
		trang_thai, kieu_thue_id, loai_dich_vu_id) values 
    (1, 'Villa', 500, 2, '4', '20000000', 'Con', 2, 1),
    (2, 'House', 300, 3, '8', '8000000', 'Con', 1, 2),
    (3, 'Room', 100, 1, '4', '1000000', 'Con', 3, 3);
    
