window.onload = function () {
  /** @type {*} */
  var pi = document.getElementById("lst");
  var pic = pi.getElementsByTagName("li");
  //下标
  var index = 0;
  //显示函数
  function showImg() {
    //下标++
    index++;
    //若下标与数组长度相等
    if (index >= pic.length) {
      //下标置为0
      index = 0;
    }
    //遍历图片
    for (let i = 0; i < pic.length; i++) {
      //设置图片隐藏
      pic[i].style.display = "none";
    }
    //设置图片显示
    pic[index].style.display = "block";
  }
  //定时器
  var mytime = setInterval(showImg, 2000);
  //鼠标进入
  pi.onmousemove = function () {
    //关闭定时器
    clearInterval(mytime);
  };
  //鼠标移出
  pi.onmouseout = function () {
    //开启定时器
    mytime = setInterval(showImg, 2000);
  };
  //左按钮
  document.getElementById("left").onclick = function () {
    //下标--
    index--;
    //若下标<0
    if (index < 0) {
      //下标最大
      index = pic.length - 1;
    }
    //遍历图片
    for (let i = 0; i < pic.length; i++) {
      //设置图片隐藏
      pic[i].style.display = "none";
    }
    //设置图片显示
    pic[index].style.display = "block";
  };
  //右按钮
  document.getElementById("right").onclick = function () {
    //下标++
    index++;
    //若下标与数组长度相等
    if (index >= pic.length) {
      //下标置为0
      index = 0;
    }
    //遍历图片
    for (let i = 0; i < pic.length; i++) {
      //设置图片隐藏
      pic[i].style.display = "none";
    }
    //设置图片显示
    pic[index].style.display = "block";
  };
};
