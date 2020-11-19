//Bài tập 1
//Khai báo biến
let invatLy;
let inhoaHoc;
let insinhHoc;

//Lấy thông tin
invatLy = prompt("Nhập điểm môn Vật Lý");
inhoaHoc = prompt("Nhập điểm môn Hóa Học");
insinhHoc = prompt("Nhập điểm môn Sinh Học");

//Đổi dữ liệu thành số nguyên
let vatLy = parseInt(invatLy);
let hoaHoc = parseInt(inhoaHoc);
let sinhHoc = parseInt(insinhHoc);

//Tính điểm trung bình và hiển thị
let tB = (vatLy + hoaHoc + sinhHoc)/3;
document.write("Điểm trung bình: " + tB);
document.write("<br/>");

//Tính tổng điểm và hiển thị
let sum = vatLy + hoaHoc + sinhHoc;
document.write("Tổng điểm: " + sum);