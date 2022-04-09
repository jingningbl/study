function addOp(){
//    用户输入城市添加
    let cityName=prompt("请输入城市缩写");
    let cityValue=prompt("请输入城市名全称");
//    获得内置对象
    let xhr=getXHR();
//    配置请求
    xhr.open('post','addCity',true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
//    配置监听器
    xhr.onreadystatechange=function (){
        if (xhr.readyState===4&&xhr.status===200){
            let txt=JSON.parse(xhr.responseText);
            let province=document.getElementById("province");
            let obj=document.createElement("option")
            //直接获取脚本的输入内容
            // obj.innerText=cityValue;
            //通过异步的方式获得服务器响应回阿里的JSON字符串
            obj.innerText=txt.cityValue;
            obj.value=txt.cityName;
            province.appendChild(obj);
        }
    };
//    发送请求
    let myCity={"cityName":cityName,"cityValue":cityValue};
    let cityStr=JSON.stringify(myCity);
    xhr.send("myCity="+cityStr);
}