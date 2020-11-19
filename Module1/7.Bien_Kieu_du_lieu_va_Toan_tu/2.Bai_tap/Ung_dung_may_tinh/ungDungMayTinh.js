

function phepCong() {
    let inputA = document.getElementById("number1").value;
    let inputB = document.getElementById("number2").value;

    let a = parseInt(inputA);
    let b = parseInt(inputB);
    let tinh = a + b;
    alert("Tổng là " + tinh);
}
function phepTru() {
    let inputA = document.getElementById("number1").value;
    let inputB = document.getElementById("number2").value;

    let a = parseInt(inputA);
    let b = parseInt(inputB);
    let tinh = a - b;
    alert("Hiệu là " + tinh);
}
function phepNhan() {
    let inputA = document.getElementById("number1").value;
    let inputB = document.getElementById("number2").value;

    let a = parseInt(inputA);
    let b = parseInt(inputB);
    let tinh = a * b;
    alert("Nhân là " + tinh);
}
function phepChia() {
    let inputA = document.getElementById("number1").value;
    let inputB = document.getElementById("number2").value;

    let a = parseInt(inputA);
    let b = parseInt(inputB);
    let tinh = a / b;
    alert("Thương là " + tinh);
}