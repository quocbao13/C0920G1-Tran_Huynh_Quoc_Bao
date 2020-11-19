let show = document.getElementById("show");
let temp=false;
function nhap(duLieu) {
    if (temp){
        if (show.value === "+" ||show.value === "-" ||show.value === "*" ||show.value === "/" ){
            show.value += duLieu;
        }else {
            show.value = duLieu;
        }
    }else {
        show.value += duLieu;
    }
    temp = false;
}
function tinh() {
    show.value = eval(show.value);
    temp = true;
}
function clearNum() {
    show.value = "";
    temp = false;
}