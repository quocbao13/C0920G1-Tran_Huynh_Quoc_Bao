function yesClick() {
    alert("Oke! Now, you are girl friend");
}
function noClick() {
    let y = Math.round(Math.random() * window.innerHeight);
    let x = Math.round(Math.random() * window.innerWidth);
    let noCl = document.getElementById("noCl");
    noCl.style.left =  x + "px";
    noCl.style.top =  y + "px";

}