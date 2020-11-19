// viết function truyền dữ liệu vào show
let newNum = false;
function display(value){

    if (value === "="){
        document.getElementById("showOld").innerText = document.getElementById("show").value;
        document.getElementById("show").value = eval(document.getElementById("show").value);
    }else if(document.getElementById("show").value === "0"){
        document.getElementById("show").value = value;
    }else {
        document.getElementById("show").value += value;
    }
}

//tính và hiện kết quả
//xóa dữ liệu
let clear = document.getElementById("c");
clear.addEventListener("click", clear1);
function clear1() {
    document.getElementById("show").value = "";
}
//lui về một giá trị
function xoa1() {
    let value = document.getElementById("show").value ;
    document.getElementById("show").value = value.substr(0, value.length -1);
}
//lấy dữ liệu mới nếu điền số sau khi tính
// if (display(value) === "+" || display(value) === "-" || display(value) === "*" || display(value) === "/"){
//     document.getElementById("show").value += value;
// }else {
//     document.getElementById("show").value = value;
// }