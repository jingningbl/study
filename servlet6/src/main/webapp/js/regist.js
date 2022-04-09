//三个全局变量,方便后面做页面的验证
var flag_username=false;
var flag_pwd=false;
var flag_repwd=false;
window.onload=function(){
    //1.获得username的对象
    let usernameObj=document.getElementById("username");
    //2.构建onblur属性
    usernameObj.onblur=function(){
      //3.输入框的正则表达式和判断是否被注册
        let reg=/^[a-zA-Z][a-zA-Z0-9]{2,7}$/;
        //获得输入框的内容
        let username=usernameObj.value;
        //获得错误提示span对象
        let span=document.getElementById("err-username");
        //判定
        if(!reg.test(username)){
            flag_username=false;
            span.innerText="格式错误!3-8数字字母首字符为字母"
            span.style.color="red";
        }else{
            //ajax判定是否被注册
            let xhr=getXHR();
            //定义请求
            xhr.open('get','findByUsername?username='+username,true);
            //注册监听器
            xhr.onreadystatechange=function (){
                if(xhr.readyState===4 && xhr.status===200){
                    let txt=xhr.responseText;
                    let txtStr=JSON.parse(txt);
                    if(txtStr){
                        flag_username=true;
                        span.innerText="输入合法"
                        span.style.color="green";
                    }else{
                        flag_username=false;
                        span.innerText="用户名被占用"
                        span.style.color="red";
                    }
                }
            };
            //发送请求
            xhr.send(null);
        }
    };

    //密码验证
    let pwdObj=document.getElementsByName("password")[0];
    //构建onblur属性,设置自定义检查
    pwdObj.onblur=function (){
        let reg=/^[a-zA-Z0-9]{6,18}$/;
        let span=document.getElementById("err-pwd");
        if(reg.test(pwdObj.value)){
            flag_pwd=true;
            span.innerText="输入合法";
            span.style.color="green"
        }else{
            flag_pwd=false;
            span.innerText="格式错误";
            span.style.color="red"
        }
    };
    //判断是否一致
    //1.获得输入框对象
    //2.获得上面的密码值
    //3.获得自己的值
    //4.比较

    //form表单的onsubmit事件
    let myform=document.getElementsByTagName("form")[0];
    myform.onsubmit=function(){
        return flag_username && flag_pwd;
    };


    //如果使用异步是无法刷新整个页面的,但是可以调用表单对象的submit()方法完成表单提交刷新
    // let xhr=getXHR();
    // let username=usernameObj.value;
    // let pwd=pwdObj.value;
    // xhr.open('get','regist?username='+username+'&pwd='+pwd,true);
    // xhr.onreadystatechange=function(){
    //     if(xhr.readyState==4 && xhr.status==200){
    //         let txt=JSON.parse(xhr.responseText);
    //         if(txt){
    //             location.href="login.html";
    //         }
    //     }
    // };
    // if(flag_username && flag_pwd){
    //     xhr.send(null);
    // }




}