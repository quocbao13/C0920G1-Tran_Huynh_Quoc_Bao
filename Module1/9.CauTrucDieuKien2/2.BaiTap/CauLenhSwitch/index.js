let thang = document.getElementById("thang");
let traVe;
let hien = document.getElementById("hien");

function tinhNgay() {
    switch (thang.value) {
        case "1":
            traVe = "Tháng " + thang.value + " có 31 ngày";
            break;
        case "2":
            traVe = "Tháng " + thang.value + " có 28 ngày";
            break;
        case "3":
            traVe = "Tháng " + thang.value + " có 31 ngày";
            break;
        case "4":
            traVe = "Tháng " + thang.value + " có 30 ngày";
            break;
        case "5":
            traVe = "Tháng " + thang.value + " có 31 ngày";
            break;
        case "6":
            traVe = "Tháng " + thang.value + " có 30 ngày";
            break;
        case "7":
            traVe = "Tháng " + thang.value + " có 31 ngày";
            break;
        case "8":
            traVe = "Tháng " + thang.value + " có 31 ngày";
            break;
        case "9":
            traVe = "Tháng " + thang.value + " có 30 ngày";
            break;
        case "10":
            traVe = "Tháng " + thang.value + " có 31 ngày";
            break;
        case "11":
            traVe = "Tháng " + thang.value + " có 30 ngày";
            break;
        case "12":
            traVe = "Tháng " + thang.value + " có 31 ngày";
            break;
        default:
            traVe = "Tháng " + thang.value + " không có trong năm";
    }
    hien.innerText = traVe;
}