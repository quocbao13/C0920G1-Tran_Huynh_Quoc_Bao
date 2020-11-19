let login = prompt("Nhập Employee, Director, để trống hoặc bất kì.");
let message = (login === "Employee") ? 'Hello' : (login === "Director") ? 'Greetings' : (login === "") ? 'No login' : '';
alert(message);