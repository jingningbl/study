//获取所有Cookie,以;分割
var cookies = document.cookie.split(";");

function findCookie(cookieName) {
    //遍历所有的Cookie
    for (let i = 0; i < cookies.length; i++) {
        //将键值对以=分割
        let obj = cookies[i].split("=");
        if (cookieName === obj[0].trim()) {
            //输入的用户名和Cookie的key相同,返回value
            return obj[1].trim();
        }
    }
    return '';
}

window.onload = function () {
    //用户名
    let username = findCookie("username");
    //密码
    let pwd = findCookie("pwd");
    //记住密码勾选框
    let mycheckbox = findCookie("mycheckbox");
    if (mycheckbox === 'on') {
        //输入框重新赋值
        document.getElementById("username").value = username;
        document.getElementById("password").value = pwd;
        document.getElementById("mycheckbox").checked = mycheckbox;
    }
};