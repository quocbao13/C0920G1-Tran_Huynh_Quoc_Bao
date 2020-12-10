use furamaresort;

-- 2.tim ten nhan vien co chu h, t, k va toi da 15 ki tu
select *
 from nhanvien
 where ((nhanvien.ho_ten like 'K%') or (nhanvien.ho_ten like 'H%') or (nhanvien.ho_ten like 'T%')) and length(furamaresort.nhanvien.ho_ten) <= 15;
 
-- 3.hien thi ten khach hang cos do tuoi 18-50, cos dia chi da nang hoac quang tri
select * from khachhang 
	where (date_sub(now() , interval 18 year) <= khachhang.ngay_sinh and date_sub(now() , interval 50 year) >= khachhang.ngay_sinh) and (khachhang.diachi like "Da Nang" or khachhang.diachi like "Quang Tri");

-- 4.đếm xem mỗi khách hàng đặt phòng bao nhiêu lần. hiển thị sắp xếp tăng dần theo số phòng. và khác hàng là diamond
select hopdong.khach_hang_id, khachhang.ho_ten, loaikhachhang.ten_loai_khach_hang, count(hopdong.dich_vu_id) as countHopDong 
	from hopdong join khachhang on hopdong.khach_hang_id = khachhang.id_khach_hang
	join loaikhachhang on khachhang.loai_khach_hang_id = loaikhachhang.id_loai_khach_hang 
	where loaikhachhang.ten_loai_khach_hang = "Diamond"
	group by hopdong.khach_hang_id
    order by countHopDong;
    
-- 5. thi tong tien
select khachhang.id_khach_hang, khachhang.ho_ten, loaikhachhang.ten_loai_khach_hang, hopdong.id_hop_dong, 
	dichvu.ten_dich_vu, hopdong.ngay_lam_hop_dong, hopdong.ngay_ket_thuc, 
    (dichvu.chi_phi_thue + dichvudikem.gia * hopdongchitiet.soluong) as tongtien
    from khachhang  left join hopdong on hopdong.khach_hang_id = khachhang.id_khach_hang
		left join loaikhachhang on khachhang.loai_khach_hang_id = loaikhachhang.id_loai_khach_hang
		left join dichvu on hopdong.dich_vu_id = dichvu.id_dich_vu
		left join hopdongchitiet on hopdong.id_hop_dong = hopdongchitiet.hop_dong_id
		left join dichvudikem on hopdongchitiet.dv_di_kem_id = dichvudikem.id_dv_di_kem;
    
-- 6.hiển thị dịch vụ chưa được khách hàng đặt từ quý 1 năm 2019
select dichvu.id_dich_vu, dichvu.ten_dich_vu, dichvu.dien_tich, dichvu.chi_phi_thue, loaidichvu.ten_loai_dich_vu, hopdong.ngay_lam_hop_dong, hopdong.ngay_ket_thuc
	from dichvu join loaidichvu on dichvu.loai_dich_vu_id = loaidichvu.id_loai_dich_vu 
		join hopdong on dichvu.id_dich_vu = hopdong.dich_vu_id
        where not ((year(hopdong.ngay_ket_thuc) = 2019 and month(hopdong.ngay_ket_thuc) < 4)  or (year(hopdong.ngay_ket_thuc) < 2019));
-- 7.Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
	-- cách 1
select distinct khachhang.ho_ten from khachhang;
	-- cách 2
    -- cách 3
    
-- 8.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(hopdong.ngay_lam_hop_dong) as thang, count( distinct khachhang.ho_ten) as soluong_khachhang
    from hopdong join khachhang on hopdong.khach_hang_id = khachhang.id_khach_hang
    where year(hopdong.ngay_lam_hop_dong) = 2020
    group by month(hopdong.ngay_lam_hop_dong);
    
-- 9.Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).
select hopdong.id_hop_dong, hopdong.ngay_lam_hop_dong, hopdong.ngay_ket_thuc, hopdong.tien_da_coc, count(hopdongchitiet.id_hd_chi_tiet)
	from hopdong join hopdongchitiet on hopdong.id_hop_dong = hopdongchitiet.hop_dong_id
    group by hopdong.id_hop_dong;
    
-- 10.Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select dichvudikem.* from dichvudikem 
	join hopdongchitiet on dichvudikem.id_dv_di_kem = hopdongchitiet.dv_di_kem_id
	join hopdong on hopdongchitiet.hop_dong_id = hopdong.id_hop_dong
    join khachhang on hopdong.khach_hang_id = khachhang.id_khach_hang
    join loaikhachhang on khachhang.loai_khach_hang_id = loaikhachhang.id_loai_khach_hang
    where loaikhachhang.ten_loai_khach_hang = 'Diamond' and (khachhang.diachi = 'Vinh' or khachhang.diachi = 'Quảng Ngãi');

-- 11.Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết)
-- , TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
select hopdong.id_hop_dong, nhanvien.ho_ten as ten_nv, khachhang.ho_ten as ten_khach
	, khachhang.sdt, dichvu.ten_dich_vu, count(hopdongchitiet.dv_di_kem_id), hopdong.tien_da_coc
    from khachhang join hopdong on khachhang.id_khach_hang = hopdong.khach_hang_id
    join nhanvien on nhanvien.id_nhan_vien = hopdong.nhan_vien_id
    join hopdongchitiet on hopdongchitiet.hop_dong_id = hopdong.id_hop_dong
    join dichvu on hopdong.dich_vu_id = dichvu.id_dich_vu
    where year(hopdong.ngay_lam_hop_dong) = 2019 and (month(hopdong.ngay_lam_hop_dong) between 10 and 12);

-- 13.Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dichvudikem.*, count(hopdongchitiet.id_hd_chi_tiet) as dem_lan_su_dung 
	from dichvudikem join hopdongchitiet on dichvudikem.id_dv_di_kem = hopdongchitiet.dv_di_kem_id
	group by dichvudikem.id_dv_di_kem
    having dem_lan_su_dung = (select count(dichvudikem.id_dv_di_kem) as count_chi_tiet from dichvudikem
    join hopdongchitiet on dichvudikem.id_dv_di_kem = hopdongchitiet.dv_di_kem_id
    group by dichvudikem.id_dv_di_kem
    order by count_chi_tiet desc
    limit 1);
    
-- 14.Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
select dichvudikem.*, count(hopdongchitiet.dv_di_kem_id) as count_id 
	from dichvudikem join hopdongchitiet on dichvudikem.id_dv_di_kem = hopdongchitiet.dv_di_kem_id
    group by dichvudikem.id_dv_di_kem
    having count_id = 1;

-- 15.Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai,
-- DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019
select nhanvien.id_nhan_vien, nhanvien.ho_ten, trinhdo.ten_trinh_do, bophan.ten_bo_phan, nhanvien.sdt, nhanvien.dia_chi, count(hopdong.nhan_vien_id) as so_hop_dong
	from nhanvien join trinhdo on nhanvien.trinh_do_id = trinhdo.id_trinh_do
    join bophan on nhanvien.bo_phan_id = bophan.id_bo_phan
    join hopdong on nhanvien.id_nhan_vien = hopdong.nhan_vien_id
    where year(hopdong.ngay_lam_hop_dong) > 2017 and year(hopdong.ngay_lam_hop_dong) < 2020
    group by id_nhan_vien having so_hop_dong < 4;
    
-- 16.Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
 SET SQL_SAFE_UPDATES = 0;
    delete
	 FROM nhanvien 
	 WHERE nhanvien.id_nhan_vien 
	  not IN (SELECT hopdong.nhan_vien_id FROM hopdong WHERE year(hopdong.ngay_lam_hop_dong) BETWEEN 2017 and 2019);

-- 17.Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ
UPDATE khachhang
	set khachhang.loai_khach_hang_id = 1
	WHERE khachhang.loai_khach_hang_id = 2 and  khachhang.id_khach_hang IN (
	 SELECT hopdong.khach_hang_id FROM hopdong WHERE hopdong.tong_tien >= 10000000 and year(hopdong.ngay_lam_hop_dong) = 2019
	 );

-- 18.Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
DELETE 
	  FROM khachhang 
	  WHERE khachhang.id_khach_hang in (
	  SELECT hopdong.khach_hang_id 
	  FROM hopdong 
	  WHERE year(hopdong.ngay_lam_hop_dong) < 2016
	  );
    
-- 19.Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
update dichvudikem
	set dichvudikem.gia = dichvudikem.gia * 2
    where (
    select count(hopdongchitiet.dv_di_kem_id) as count_hdct
    from hopdongchitiet join hopdong on hopdongchitiet.hop_dong_id = hopdong.id_hop_dong
    where year(hopdong.ngay_lam_hop_dong) = 2019
    group by hopdongchitiet.dv_di_kem_id
    ) >= 10;
    
-- 20.Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
	CREATE VIEW khach_hang_view as 
	SELECT khachhang.id_khach_hang, khachhang.ho_ten,khachhang.email, khachhang.sdt, khachhang.ngay_sinh, khachhang.diachi
	FROM khachhang;
	SELECT * FROM khach_hang_view;
    
	CREATE VIEW nhan_vien_view as
	SELECT nhanvien.id_nhan_vien,nhanvien.ho_ten,nhanvien.email,nhanvien.sdt,nhanvien.ngay_sinh,nhanvien.dia_chi
	FROM nhanvien;
	SELECT * FROM nhan_vien_view;












    
    