//获得ajax对象
//获得内置对象,针对不同的浏览器
function getXHR() {
    //常规浏览器里面XmlHttpRequest,//ie的低版本则不一样
    var xhr = null;
    if ((typeof XMLHttpRequest) != 'undefined') {
        xhr = new XMLHttpRequest();
    } else {
        //如果没有内置对象,则说明浏览器是低版本的
        xhr = new ActiveXObject('Microsoft.XMLHttp');
    }
    return xhr;
}

function checkUsername() {
//    1.获得内置对象
    let xhr = getXHR();
//    2.配置get请求的发送方式:此时并没有发送
//     xhr.open(请求类型get/post,请求地址?参数,是否异步asyn);
    let username = document.getElementById("username").value;
    xhr.open('get', 'checkUsername?username=' + username, true);
//    3.注册监听器:xhr的状态发生了变化:readystatechange事件
//    监听会由一个函数去处理,可以在函数中判定是否获取到了响应的xml/文本
    xhr.onreadystatechange = function () {
        //    xhr.readyState的状态信息
        //    0:XMLHttpRequest对象未完成初始化
        //    1:XMLHttpRequest对象开始发送请求
        //    2:XMLHttpRequest对象发送请求完成
        //    3:XMLHttpRequest对象开始读取响应xml/文本数据
        //    4:XMLHttpRequest对象读取数据结束
        //    xhr的http状态码:200 服务器正确响应
        if (xhr.readyState === 4 && xhr.status === 200) {
            //    5.获取服务器响应的数据
            //     let txt=xhr.responseXML;响应的xml---->可以使用json替代
            let txt = Number.parseInt(xhr.responseText);
            let span = document.getElementById("err-us");
            //    将内容显示
            if (txt === 0) {
                span.innerText = "用户名已注册";
                span.style.color = 'red';
            } else {
                span.innerText = "可以使用";
                span.style.color = 'green';
            }
        }
    };
//    4.发送请求
    xhr.send(null)

}