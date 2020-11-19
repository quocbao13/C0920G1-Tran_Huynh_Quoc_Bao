//Bài tập ứng dụng chuyển đổi tiền tệ
function chuyenTien() {
    let nhap = document.getElementById("nhap").value;
    var from = document.getElementById("from").value;
    var to = document.getElementById("to").value;
    var tinhTien;
    var nhapSo = parseInt(nhap);
    //xét dữ liệu
    //khi 2 dữ liệu bằng nhau
    if (from === to){
        //tính kết quả
        tinhTien = nhapSo;
    }
    //Chuyển đổi từ tiền Việt Nam
    if (from === "VN" && to === "M"){
        tinhTien = nhapSo / 23000;
    }
    if (from === "VN" && to === "P"){
        tinhTien = nhapSo / 4000;
    }
    //Chuyển đổi từ tiền Mỹ
    if (from === "M" && to === "VN"){
        tinhTien = nhapSo * 23000;
    }
    if (from === "M" && to === "P"){
        tinhTien = nhapSo  * 5;
    }
    //Chuyển đổi từ tiền Mỹ
    if (from === "P" && to === "VN"){
        tinhTien = nhapSo * 4000;
    }
    if (from === "P" && to === "M"){
        tinhTien = nhapSo / 5;
    }
    alert("Đổi tiền " + from + " = " + nhapSo + " sang tiền " + to + " là " + tinhTien);
}