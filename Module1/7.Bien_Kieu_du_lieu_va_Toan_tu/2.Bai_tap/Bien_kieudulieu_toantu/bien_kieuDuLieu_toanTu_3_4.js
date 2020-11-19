/*
Bài tập 3
Tính diện tích hình tròn cần số pi
pi là hằng số
khai báo pi bằng const
 */


//Hiền thị kết quả
function dtHinhTron(){
    const PI = 3.14;
    var r = document.getElementById("banKinh").value;
    var dienTich = r * r * PI;
    alert("Diện tích hình tròn là " + dienTich);
}
function cvHinhTron(){
    PI = 3.14;
    r = document.getElementById("banKinh").value;
    var chuVi = r * 2 * PI;
    alert("Diện tích hình tròn là " + chuVi);
}
function banKinh(){
    var d = document.getElementById("dKinh").value;
    var banKinh = d/2;
    alert("Bán kính hình tròn là " + banKinh);
}
