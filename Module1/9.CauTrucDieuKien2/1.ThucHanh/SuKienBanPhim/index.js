let img = document.getElementById("nobita");
//hướng hình đi lên
function upArrowPressed() {
    img.style.top = parseInt(img.style.top) - 5 + "px";
}
//hướng hình đi xuống
function downArrowPressed() {
    img.style.top = parseInt(img.style.top) + 5 + "px";
}
//hướng hình đi trái
function leftArrowPressed() {
    img.style.left = parseInt(img.style.left) - 5 + "px";
}
//hướng hình đi phải
function rightArrowPressed() {
    img.style.left = parseInt(img.style.left) + 5 + "px";
}
function selection(evt) {
    switch (evt.keyCode) {
        case 37:
            leftArrowPressed();
            break;
        case 39:
            rightArrowPressed();
            break;
        case 38:
            upArrowPressed();
            break;
        case 40:
            downArrowPressed();
            break;
    }
}
function docReady() {
    window.addEventListener('keydown', selection);
}