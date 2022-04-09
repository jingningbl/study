// 获得内置对象
function getXHR() {
    var xhr = null;
    if ((typeof XMLHttpRequest) != 'undefined') {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject('Microsoft.XMLHttp');
    }
    return xhr;
}

function checkUsername() {
//    1.获得内置对象
    let xhr = getXHR();
    //获得用户名
    let username = document.getElementById("username").value;
    //配置请求的发送
    xhr.open('post', 'findUsername', true);
    //    设置post请求头
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
//    配置监听器
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // //获得文本内容
            // let txt = xhr.responseText;
            // //转化为数字
            // let num = Number.parseInt(txt);
            // let span = document.getElementById("err-username");
            // if (num === 0) {
            //     //数字为0,显示为红色的用户名已注册
            //     span.innerText = "用户名已注册";
            //     span.style.color = 'red';
            // } else {
            //     span.innerText = "可以使用";
            //     span.style.color = 'green';
            // }
            let flag = JSON.parse(xhr.responseText);
            let span = document.getElementById("err-username");
            if (flag) {
                span.innerText = "用户已注册";
                span.style.color = "red";
            } else {
                span.innerText = "可以使用";
                span.style.color = "green";
            }
        }
    };
//    发送请求
    xhr.send("username=" + username);
}

function changeImage() {
//    获得图片对象
    let img = document.getElementById("myimg");
    img.src = "showImage?+time=" + new Date().getTime();
}

var flag = false;

function checkCode() {
    //获取内置对象
    let xhr = getXHR();
    //获取用户输入验证码的值
    let code2 = document.getElementById("code").value;
    // xhr.open(method,url,async);
    //配置发送请求
    xhr.open('get', 'code?code2=' + code2, true);
    //配置监听器
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // let txt = xhr.responseText;
            // let num = Number.parseInt(txt);
            // let span = document.getElementById("err-code");
            // if (num === 1) {
            //     span.innerText = "输入一致";
            //     span.style.color = 'green';
            //     flag = true;
            // } else {
            //     span.innerText = "验证码错误";
            //     span.style.color = 'red';
            //     flag = false;
            // }
            flag = JSON.parse(xhr.responseText);
            let span = document.getElementById("err-code");
            if (flag) {
                span.innerText = "输入一致";
                span.style.color = "green";
            } else {
                span.innerText = "验证码错误";
                span.style.color = "red";
            }
        }
    };
    xhr.send(null);
}

//表单提交事件
function f1() {
    return flag;
}


