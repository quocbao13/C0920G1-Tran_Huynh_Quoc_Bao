use furamaresort;

-- tim ten nhan vien co chu h, t, k va toi da 15 ki tu
select *
 from nhanvien
 where (nhanvien.ho_ten like '%H%' or '%T%' or '%K%') and length(furamaresort.nhanvien.ho_ten) <= 15;
 
-- hien thi ten khach hang cos do tuoi 18-50, cos dia chi da nang hoac quang tri
select * from khachhang 
	where (ngay_sinh >= 18 and ngay_sinh <= 50) and (diachi like '%Da Nang%' or '%Quang Tri%');

-- đếm xem mỗi khách hàng đặt phòng bao nhiêu lần. hiển thị sắp xếp tăng dần theo số phòng. và khác hàng là diamond
select hopdong.khach_hang_id, khachhang.ho_ten, loaikhachhang.ten_loai_khach_hang, count(hopdong.dich_vu_id) as countHopDong 
	from hopdong 
		join khachhang 
			on hopdong.khach_hang_id = khachhang.id_khach_hang
		join loaikhachhang 
			on khachhang.loai_khach_hang_id = loaikhachhang.id_loai_khach_hang 
	where loaikhachhang.ten_loai_khach_hang = "Diamond"
	group by hopdong.khach_hang_id
    order by countHopDong;
    
    
    
    