//Khai báo biến
let inputWidth;
let inputHeight;

//Lấy dữ liệu từ người dùng
inputWidth = prompt("Nhập chiều dài");
inputHeight = prompt("Nhập chiều rộng");

//Chuyển dữ liệu thành số nguyên
let width = parseInt(inputWidth);
let height = parseInt(inputHeight);

//Tính diện tích hình CHữ nhật
let area = width*height;

//Hiển thị kết quả ra màn hình
document.write("Diện tịch hình chữ nhật là " + area);