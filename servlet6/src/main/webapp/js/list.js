function mydownload(songName,singer){
    let myname="d://upload_02//"+singer+"//"+songName;
    console.log(singer);
    location.href="download?name="+myname;
}

function mydetails(id){
    location.href="detailSong?id="+id;
}
//删除
function myDelete(uid,sid,obj){
    let flag=confirm("确认删除么?");
    if(flag){
        //异步发送删除请求
        let xhr=getXHR();
        //name=encodeURI("张三");//默认就是utf-8
        xhr.open('get','deleteSong?sid='+sid+'&uid='+uid,true);
        xhr.onreadystatechange=function(){
            //判定获得回调数据
            if(xhr.readyState===4 && xhr.status===200){
                let flag=JSON.parse(xhr.responseText);
                if(flag){
                    //根据回调数据重置对应的表格数据
                    delTr(obj);
                }else{
                    alert("删除失败!");
                }
            }
        };
        xhr.send(null);

    }
}
//封装删除当前的tr
function delTr(obj){
    //获得当前的tr
    let tr=obj.parentElement.parentElement;
    //获得table对象里面的所有tr
    let trs=tr.parentElement.children;
    //获得删除行的序号值
    let num=Number.parseInt(tr.children[1].innerText);
    //循环修改当前行下面的所有行的序号值
    for(let i=num+1;i<trs.length;i++){
        trs[i].children[1].innerText=i-1;
    }

    tr.remove();

}
