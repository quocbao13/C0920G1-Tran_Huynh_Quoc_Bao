/*
Bài tập 1
Đặt biến, gán dữ liệu cho biến
Hiển thị kết quả
 */
let i = 10;
let f = 20.5;
let b = true;
let s = "Hà Nội";

document.write("i = " + i);
document.write("<br/>");
document.write("f = " + f);
document.write("<br/>");
document.write("b = "+ b);
document.write("<br/>");
document.write("s = "+ s);

/*
Bài tập 2
Sử dụng toán tử
Tính diện tích hình chữ nhật
 */
let width = 20;
let height = 10;
let area = width * height;
document.write("<br/>");
document.write('Area = ' + area);

/*
Bài tập 3
 */

let a = prompt("Nhập a: ");
let c = prompt("Nhập b: ");
if (a % b == 0){
    alert("a là bội số của b");
}else {
    alert("a không phải là bội số của b");
}
