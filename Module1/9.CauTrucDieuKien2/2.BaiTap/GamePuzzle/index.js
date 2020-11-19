let imageA = document.getElementById("carA");
let imageB = document.getElementById("carB");
let imageC = document.getElementById("carC");
let imageD = document.getElementById("carD");
let imageE = document.getElementById("carE");
init(1);
init(2);
init(3);
init(4);
init(5);
    function init(i) {
        let randomA = Math.floor(Math.random() * 3 + 1);
        switch (i) {
            case 1:
                switch (randomA) {
                    case 1:
                        imageA.src = "Images/Hinh%201a.png";
                        break;
                    case 2:
                        imageA.src = "Images/Hinh%202a.png";
                        break;
                    case 3:
                        imageA.src = "Images/Hinh%203a.png";
                        break;
                }
                break;
            case 2:
                switch (randomA) {
                    case 1:
                        imageB.src = "Images/Hinh%201b.png";
                        break;
                    case 2:
                        imageB.src = "Images/Hinh%202b.png";
                        break;
                    case 3:
                        imageB.src = "Images/Hinh%203b.png";
                        break;
                }
                break;
            case 3:
                switch (randomA) {
                    case 1:
                        imageC.src = "Images/Hinh%201c.png";
                        break;
                    case 2:
                        imageC.src = "Images/Hinh%202c.png";
                        break;
                    case 3:
                        imageC.src = "Images/Hinh%203c.png";
                        break;
                }
                break;
            case 4:
                switch (randomA) {
                    case 1:
                        imageD.src = "Images/Hinh%201d.png";
                        break;
                    case 2:
                        imageD.src = "Images/Hinh%202d.png";
                        break;
                    case 3:
                        imageD.src = "Images/Hinh%203d.png";
                        break;
                }
                break;
            case 5:
                switch (randomA) {
                    case 1:
                        imageE.src = "Images/Hinh%201e.png";
                        break;
                    case 2:
                        imageE.src = "Images/Hinh%202e.png";
                        break;
                    case 3:
                        imageE.src = "Images/Hinh%203e.png";
                        break;
                }
                break;
        }
    }
    function onchangeImage(num) {
        switch (num) {
            case 1:
                if (imageA.getAttribute("src") === "Images/Hinh%201a.png")
                    imageA.src = "Images/Hinh%202a.png"
                else if (imageA.getAttribute("src") === "Images/Hinh%202a.png") {
                    imageA.src = "Images/Hinh%203a.png"
                } else if (imageA.getAttribute("src") === "Images/Hinh%203a.png") {
                    imageA.src = "Images/Hinh%201a.png"
                }
                checkImage();
                break;
            case 2:
                if (imageB.getAttribute("src") === "Images/Hinh%201b.png")
                    imageB.src = "Images/Hinh%202b.png"
                else if (imageB.getAttribute("src") === "Images/Hinh%202b.png") {
                    imageB.src = "Images/Hinh%203b.png"
                } else if (imageB.getAttribute("src") === "Images/Hinh%203b.png") {
                    imageB.src = "Images/Hinh%201b.png"
                }
                checkImage();
                break;
            case 3:
                if (imageC.getAttribute("src") === "Images/Hinh%201c.png")
                    imageC.src = "Images/Hinh%202c.png"
                else if (imageC.getAttribute("src") === "Images/Hinh%202c.png") {
                    imageC.src = "Images/Hinh%203c.png"
                } else if (imageC.getAttribute("src") === "Images/Hinh%203c.png") {
                    imageC.src = "Images/Hinh%201c.png"
                }
                checkImage();
                break;
            case 4:
                if (imageD.getAttribute("src") === "Images/Hinh%201d.png")
                    imageD.src = "Images/Hinh%202d.png"
                else if (imageD.getAttribute("src") === "Images/Hinh%202d.png") {
                    imageD.src = "Images/Hinh%203d.png"
                } else if (imageD.getAttribute("src") === "Images/Hinh%203d.png") {
                    imageD.src = "Images/Hinh%201d.png"
                }
                checkImage();
                break;
            case 5:
                if (imageE.getAttribute("src") === "Images/Hinh%201e.png")
                    imageE.src = "Images/Hinh%202e.png"
                else if (imageE.getAttribute("src") === "Images/Hinh%202e.png") {
                    imageE.src = "Images/Hinh%203e.png"
                } else if (imageE.getAttribute("src") === "Images/Hinh%203e.png") {
                    imageE.src = "Images/Hinh%201e.png"
                }
                checkImage();
                break;
            default:
                break;
        }
    }
    function checkImage() {
        if (imageA.getAttribute("src") === "Images/Hinh%201a.png" &&
            imageB.getAttribute("src") === "Images/Hinh%201b.png" &&
            imageC.getAttribute("src") === "Images/Hinh%201c.png" &&
            imageD.getAttribute("src") === "Images/Hinh%201d.png" &&
            imageE.getAttribute("src") === "Images/Hinh%201e.png"
        ) {
            alert("Hinh A")
        } else if (imageA.getAttribute("src") === "Images/Hinh%202a.png" &&
            imageB.getAttribute("src") === "Images/Hinh%202b.png" &&
            imageC.getAttribute("src") === "Images/Hinh%202c.png" &&
            imageD.getAttribute("src") === "Images/Hinh%202d.png" &&
            imageE.getAttribute("src") === "Images/Hinh%203e.png"
        ) {
            alert("Hinh B")
        } else if (imageA.getAttribute("src") === "Images/Hinh%203a.png" &&
            imageB.getAttribute("src") === "Images/Hinh%203b.png" &&
            imageC.getAttribute("src") === "Images/Hinh%203c.png" &&
            imageD.getAttribute("src") === "Images/Hinh%203d.png" &&
            imageE.getAttribute("src") === "Images/Hinh%203e.png"
        ) {
            alert("Hinh C")
        }
    }