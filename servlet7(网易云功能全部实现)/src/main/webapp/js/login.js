window.onload=function(){
    //判定
    let usernameObj=$("#username");
    let pwdObj=fbd('pwd');
    let rembObj=$("#remb").get(0);
    //赋值
    let username=findByCookieName('username');
    let pwd=findByCookieName('pwd');
    let remb=findByCookieName('remb');
    if(remb.val()==='on'){
        usernameObj.val(username);
        pwdObj.value=pwd;
        rembObj.checked='checked';
    }
};//根据k得到v
// k1=v1;k2=v2
//获得cookie
let cookies=document.cookie.split(";");
function findByCookieName(msg){
    //['username=fanfan', ' pwd=123456', ' remb=on']
    for(let i=0;i<cookies.length;i++){
        //获得每一项,继续拆分[k,v]
        let obj=cookies[i].split("=");
        if(obj[0].trim()===msg){
            return obj[1].trim();
        }
    }
    return '';
}



// function mylogin(){
//     //1.获得内置对象xhr
//     let xhr=getXHR();
//     //2.用户名和密码和表单对象
//     let username=document.getElementsByName("username")[0];
//     let pwd=document.getElementsByName("password")[0];
//     let myform=document.getElementsByTagName("form")[0];
//     //获得是否选中的状态值
//     let remb=document.getElementById("remb").value;
//     //3.登录成功才进行跳转,登录失败,则想直接显示用户名或者密码错误
//     xhr.open('get',
//         'login?username='+username.value+'&pwd='+pwd.value+'&remb='+remb,
//         true);
//     //4.注册监听器
//     xhr.onreadystatechange=function(){
//         if(xhr.readyState===4 && xhr.status===200){
//             let txt=xhr.responseText;
//             let flag=JSON.parse(txt);
//             //获得提示节点
//             let span=document.getElementById("err-login");
//             if(flag){
//                 //成功直接跳转main.jsp
//                 myform.submit();
//             }else{
//                 //失败显示登陆错误
//                 span.innerText="用户名或者密码错误";
//                 span.style.color="red";
//             }
//         }
//     };
//     //5.发送请求
//     xhr.send(null);
//
// }
let $myLogin=$(".btn-login");
$myLogin.blur(function (){
    let $username=$("#username");
    let $pwd=$("#pwd");
    let $myForm=$("#form");
    let $remb=$("#remb").val();
    $.ajax({
        url:"login",
        type:"get",
        data:{"username":$username.val(),"pwd":$pwd.val(),"remb":$remb.val()},
        dataType:"json",
        success: function (msg){
            let $span=$("#err-login");
            if (msg){
                $myForm.submit();
            }else {
                $span.text("用户名或者密码错误").css({"color":"red"});
            }
        }
    });
});
function fbd(id){
    return document.getElementById(id);
}