//tạo biết lưu tên người dùng khi hỏi
let userName = prompt("Who's there?", '');
if (userName === 'admin') {
    alert("Your user name are " + userName)
} else if (userName == null) {
    alert('Canceled');
} else {
    alert("I don't know you");
}

let pass = prompt('Password?', '');
if (pass === 'TheMaster') {
    alert('Welcome!');
} else if (pass == null) {
    alert('Canceled.');
} else {
    alert('Wrong password');
}