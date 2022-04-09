function mylogin(){
    //1.获得内置对象xhr
    let xhr=getXHR();
    //2.用户名和密码和表单对象
    let username=document.getElementsByName("username")[0];
    let pwd=document.getElementsByName("password")[0];
    let myform=document.getElementsByTagName("form")[0];
    //3.登录成功才进行跳转,登录失败,则想直接显示用户名或者密码错误
    xhr.open('get','login?username='+username.value+'&pwd='+pwd.value,true);
    //4.注册监听器
    xhr.onreadystatechange=function(){
        if(xhr.readyState===4 && xhr.status===200){
            let txt=xhr.responseText;
            let flag=JSON.parse(txt);
            //获得提示节点
            let span=document.getElementById("err-login");
            if(flag){
                //成功直接跳转main.jsp
                myform.submit();
            }else{
                //失败显示登陆错误
                span.innerText="用户名或者密码错误";
                span.style.color="red";
            }
        }
    };
    //5.发送请求
    xhr.send(null);
}