// biến lấy dữ liệu
let name = document.getElementById("name");
let bDay = document.getElementById("bDay");
let cmnd = document.getElementById("cmnd");
let email = document.getElementById("email");
let address = document.getElementById("address");
let cusKind = document.getElementById("cusKind");
let sale = document.getElementById("sale");
let num = document.getElementById("num");
let rent = document.getElementById("rent");
let serKind = document.getElementById("serKind");
let room = document.getElementById("room");
// biến xuất dữ liệu
let name1 = document.getElementById("name1");
let bDay1 = document.getElementById("bDay1");
let cmnd1 = document.getElementById("cmnd1");
let email1 = document.getElementById("email1");
let address1 = document.getElementById("address1");
let cusKind1 = document.getElementById("cusKind1");
let sale1 = document.getElementById("sale1");
let num1 = document.getElementById("num1");
let rent1 = document.getElementById("rent1");
let serKind1 = document.getElementById("serKind1");
let room1 = document.getElementById("room1");
let pay = document.getElementById("pay");
let checkVali = false;
//giảm giá theo địa chỉ
let saleAdd;
switch (address.value) {
    case "Đà Nẵng":
        saleAdd = 20;
        break;
    case "Huế":
        saleAdd = 10;
        break;
    case "Quảng Nam":
        saleAdd = 5;
        break;
    default:
        saleAdd = 0;
}
//giảm giá theo số ngày
let saleRent;
switch ((parseInt(rent.value) > 7) ? 1
        : (parseInt(rent.value) >= 5 && parseInt(rent.value) <= 7) ? 2
            : (parseInt(rent.value) >= 2 && parseInt(rent.value) <= 4) ? 3
                : 4) {
    case 1:
        saleRent = 30;
        break;
    case 2:
        saleRent = 20;
        break;
    case 3:
        saleRent = 10;
        break;
    case 4:
        saleRent = 0;
        break;
}
//giảm giá theo loại khách hàng
let saleCus;
switch (cusKind.value) {
    case "Diamond":
        saleCus = 15;
        break;
    case "Platinum":
        saleCus = 10;
        break;
    case "Gold":
        saleCus = 5;
        break;
    case "Silver":
        saleCus = 2;
        break;
    case "Member":
        saleCus = 0;
        break;
}
let allGia;
//tính giá trị của giảm giá
allGia = saleRent + saleCus + saleAdd;
//kiểm tra lỗi từng phần tử
function checkEnter() {
    email1.innerText = email.value;
    let filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    //nếu email sai định dạng thì báo lỗi
    if (!filter.test(email1.innerText)) {
        document.getElementById("mesMail").innerText = "Please provide a valid email address";
        email.focus;
    }
    //nếu cmnd sai định dạng thì báo lỗi
    cmnd1.innerText = cmnd.value;
    if(!Number.isInteger(parseInt(cmnd1.innerText) )) {
        document.getElementById("mesCmnd").innerText = "Please only enter numeric characters! (Allowed input:0-9)";
    }
    if (parseInt(cmnd1.innerText) < 10000000 || parseInt(cmnd1.innerText) > 99999999){
        document.getElementById("mesCmnd").innerText = "Please only enter 8 numeric characters! (Allowed input:0-9)";
    }
    //nếu số người đi cùng sai định dạng thì báo lỗi
    num1.innerText = num.value;
    if (!Number.isInteger(parseInt(num1.innerText))){
        document.getElementById("mesNum").innerText = "Please only enter numeric characters! (Allowed input:0-9)";
    }
    //nếu số ngày thuê sai định dạng thì báo lỗi
    rent1.innerText = rent.value;
    if (!Number.isInteger(parseInt(rent1.innerText))){
        document.getElementById("mesRent").innerText = "Please only enter numeric characters! (Allowed input:0-9)";
    }
    //định dạng ngày tháng năm
    let dateReg = /^\d{2}[/]\d{2}[/]\d{4}$/;
    bDay1.innerText = bDay.value;
    if (!dateReg.test(bDay1.innerText)){
        document.getElementById("mesDay").innerText = "Please only enter DD/MM/YYYY! (Allowed input:0-9)";
    }
    //nếu đúng hêt định dạng thì sẽ lưu
    if (filter.test(email1.innerText)
        && Number.isInteger(parseInt(cmnd1.innerText))
        && Number.isInteger(parseInt(num1.innerText))
        && Number.isInteger(parseInt(rent1.innerText))
        && dateReg.test(bDay1.innerText)){
        enter();
        document.getElementById("mesMail").innerText = "";
        document.getElementById("mesCmnd").innerText = "";
        document.getElementById("mesRent").innerText = "";
        document.getElementById("mesNum").innerText = "";
        document.getElementById("mesDay").innerText = "";
    }
}
//nhập thông tin người dùng
function  enter(){
    document.getElementById("create").style.display = "none";
    document.getElementById("show").style.display = "block";
    document.getElementById("titleName").textContent = "Thông Tin Khách Hàng";
    let trimName = name.value;
    let tempName = "";
    trimName = trimName.trim().toLowerCase();
    for (let i = 0; i < trimName.length; i++){
        if (trimName.charAt(i) === " " && trimName.charAt(i + 1) === " "){
            continue;
        }
        if (i === 0 || trimName.charAt(i - 1) === " "){
            tempName += trimName.charAt(i).toUpperCase();
            continue;
        }
        tempName += trimName.charAt(i);
    }
    name1.innerText = tempName;
    bDay1.innerText = bDay.value;
    cmnd1.innerText = cmnd.value;
    email1.innerText = email.value;
    address1.innerText = address.value;
    cusKind1.innerText = cusKind.value;
    sale1.innerText = sale.value;
    num1.innerText = num.value;
    rent1.innerText = rent.value;
    serKind1.innerText = serKind.value;
    room1.innerText = room.value;
    let sl = parseInt(sale.value);
    let rentD = parseInt(rent.value);
    let outPay;
    switch (serKind.value) {
        case "Villa" :
            outPay = 500 * rentD * ( 1 - sl/100) - allGia;
            break;
        case "House" :
            outPay = 300 * rentD * ( 1 - sl/100) - allGia;
            break;
        case "Room" :
            outPay = 100 * rentD * ( 1 - sl/100) - allGia;
            break;
    }
    pay.innerText = outPay;
}
//chuyển tới sửa dữ liệu
function edit() {
    document.getElementById("create").style.display = "block";
    document.getElementById("show").style.display = "none";
    document.getElementById("titleName").textContent = "Nhập Thông Tin Khách Hàng";
}
