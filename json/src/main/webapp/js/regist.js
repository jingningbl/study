function checkUsername(){
    //获得内置对象
    let xhr=getXHR();
//    获得内容
    let username=document.getElementById("username").value;
    let city1={
        "cityName":"wuhan",
        "cityValue":"武汉"
    }
    let city2=new Object();
    city2.cityName="wuhan";
    city2.cityValue="武汉";
    let city3=JSON.stringify(city3);//类似json字符串

    //配置请求
    xhr.open('get','checkUsername?username='+username,true);
//    注册监听器
    xhr.onreadystatechange=function (){
        if (xhr.readyState===4&&xhr.status===200){
            let txt=xhr.responseText;
        //    使用js内置的Json对象解析为json字符串
            let flag=JSON.parse(txt);
            let span=document.getElementById("err-username")
            // if (flag){
            //     span.innerText="可以使用";
            // }else {
            //     span.innerText="不能使用";
            // }
            span.innerText=flag.cityValue;
        }
    };
//    发送请求
    xhr.send(null);
}