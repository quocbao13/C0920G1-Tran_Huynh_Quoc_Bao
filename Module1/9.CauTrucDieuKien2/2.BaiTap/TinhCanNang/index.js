let canNang = prompt("Nhập cân nặng: ");
let chieuCao = prompt("Nhập chiều cao: ");
let bmi = parseInt(canNang) / (parseInt(chieuCao) ^ 2);
if (bmi < 18) {
    document.write("Underweight");
}else if (bmi < 25.0){
    document.write("Normal");
}else if (bmi < 30.0) {
    document.write("Overweight");
}else {
    document.write("Obese");
}