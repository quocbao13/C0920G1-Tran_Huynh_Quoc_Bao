let value = prompt("Nhập năm của bạn: ");
if (value % 4 === 0){
    if (value % 100 === 0){
        if (value % 400 === 0){
            alert(value + " là năm nhuận");
        }else {
            alert(value + " không là năm nhuận");
        }
    }else {
        alert(value + " là năm nhuận");
    }
}else {
    alert(value + " không là năm nhuận");
}