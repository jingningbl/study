<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title></title>
  <link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
  <script type="text/javascript" src="js/jquery-3.2.1.js" ></script>
  <script type="text/javascript" src="layer/layer.js" ></script>
  <script>
    $(function(){
      //实现选择音乐按钮效果
      $('#select_file').on('click',function(){
        //打开文件选择框
        $('#file').click();
      })
      //对歌曲风格的标签绑定点击事件
      $('.music_style>span').css('cursor','pointer')
              .on('click',function(){
                //获取当前被点击的标签中的文本
                var style = $(this).text();
                //将获取到的文本写入到歌曲风格的输入框中
                $('#style').val(style);
              })

      //为文件选择的按钮绑定内容改变事件
      $('#file').on('change',function(){
        //获取选择内容的路径
        var path = $(this).val();
        //判断文件是否是mp3文件
        if(path.toLowerCase().endsWith('.mp3')){
          //将文件路径写入到指定的位置
          $('.file_path').text(path);
          //将文件名截取出来并填写到歌曲名称的输入框中
          //获取最后一个\出现的索引
          var index = path.lastIndexOf('\\');
          //从路径的最后一个\开始截取,一直截取到最后包含文件的后缀
          var music_name = path.substring(index+1);
          //去除文件的后缀(如果需要去掉就写)
          music_name = music_name.split('\.')[0];
          //将截取好的歌曲名写入到歌曲名称的输入框中
          $('#music_name').val(music_name);

        }else{
          //传入的文件不是mp3文件
          layer.msg('骚年，请选择正确的mp3文件');
          //将前面的内容清空
          $('#music_name').val('');
          $('.file_path').text('');
          $('#file').val('');
        }
      })
    })

  </script>
</head>
<body>
<!-- 路径导航 -->
<ol class="breadcrumb">
  <li><a href="">音乐详情</a></li>
</ol>
<!-- 面板 -->
<div class="panel panel-primary">
  <div class="panel-heading">音乐详情</div>
  <div class="panel-body">
    <form action="updateSong" class="form-horizontal">

<%--      将id的数据隐藏起来,方便后面传给更新serlvlet.但是不显示到页面上--%>
      <input value="1" name="id" type="hidden" value="${s.id}">


      <div class="form-group form-group-sm">
        <label class="col-sm-2 col-md-1 control-label">歌曲名称</label>
        <div class="col-sm-5 col-md-6">
          <input type="text" class="form-control" name="name" id="music_name" value="${s.name}">
        </div>
      </div>
      <div class="form-group form-group-sm">
        <label class="col-sm-2 col-md-1 control-label">歌手名称</label>
        <div class="col-sm-5 col-md-6">
          <input type="text" class="form-control" name="singer" id="artist" value="${s.singer}">
        </div>
      </div>
      <div class="form-group form-group-sm">
        <label class="col-sm-2 col-md-1 control-label">专辑名称</label>
        <div class="col-sm-5 col-md-6">
          <input type="text" class="form-control" id="ablum" name="album" value="${s.album}">
        </div>
      </div>

      <div class="form-group form-group-sm">
        <label class="col-sm-2 col-md-1 control-label">歌曲风格</label>
        <div class="col-sm-5 col-md-6 music_style">
          <input type="text" class="form-control" id="style" name="style" value="${s.style}"/>
        </div>
      </div>

      <div class="form-group form-group-sm">
        <label class="col-sm-2 col-md-1 control-label">歌曲大小</label>
        <div class="col-sm-5 col-md-6 music_style">
          <input type="text" class="form-control" id="size" name="size" value="${s.size}"
                 readonly/>
        </div>
      </div>

      <div class="form-group form-group-sm">
        <label class="col-sm-2 col-md-1 control-label">存放位置</label>
        <div class="col-sm-5 col-md-6 music_style">
          <input type="text" class="form-control" id="address" name="location" value="${s.location}"
           readonly/>
        </div>
      </div>

      <div class="form-group form-group-sm">
        <label class="col-sm-2 col-md-1 control-label">上传时间</label>
        <div class="col-sm-5 col-md-6 music_style">
          <input type="text" class="form-control" id="mytime" name="uploadTime"  value="${s.uploadTime}"
                 readonly/>
        </div>
      </div>


      <div class="form-group">
        <div class="col-sm-3 col-md-4 col-sm-offset-4">
          <button id="btn" type="submit" class="btn btn-primary btn-block">确认修改</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>
