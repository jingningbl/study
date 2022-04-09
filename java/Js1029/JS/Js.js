//减货函数
function reduce(obj) {
  //获取数量
  let numObj = obj.nextElementSibling;
  //转换为数字
  let num = Number.parseInt(numObj.value);
  //数量>=1
  if (num >= 1) {
    //数量-1
    numObj.value = num - 1;
    //小计
    let xjObj = obj.parentElement.nextElementSibling;
    //单价
    let priceObj = obj.parentElement.previousElementSibling;
    //单价转数字
    let price = Number.parseInt(priceObj.innerText);
    //计算小计
    xjObj.innerText = price * (num - 1);
  } else {
    //数量<1,即=0,禁用按钮
    obj.disabled = true;
  }
  //调用函数统计
  sumGoods();
}
//加货函数
function add(obj) {
  //数量
  let numObj = obj.previousElementSibling;
  //转为数字
  let num = Number.parseInt(numObj.value);
  //数量+1
  numObj.value = num + 1;
  //启用已禁用的减货按钮
  obj.previousElementSibling.previousElementSibling.disabled = false;
  //小计
  let xjObj = obj.parentElement.nextElementSibling;
  //单价
  let priceObj = obj.parentElement.previousElementSibling;
  //转数字
  let price = Number.parseInt(priceObj.innerText);
  //计算小计
  xjObj.innerText = price * (num + 1);
  //统计
  sumGoods();
}
//删除货物信息
function dete(obj) {
  //获取行并删除
  obj.parentElement.parentElement.remove();
  //统计
  sumGoods();
  //获取表格
  let ta = document.getElementsByTagName("table")[0];
  //获取所有行
  let trs = ta.getElementsByTagName("tr");
  //遍历所有行
  for (let i = 1; i < trs.length - 1; i++) {
    //重新标号
    trs[i].children[0].innerText = i;
  }
}
//添加货物信息
function addGood(obj) {
  //获取表格
  let ta = document.getElementsByTagName("table")[0];
  //获取所有行
  let trs = ta.getElementsByTagName("tr");
  //获取添加的信息
  let tr = obj.parentElement.parentElement;
  //克隆信息
  let t = tr.cloneNode(true);
  //获取添加位置并添加
  trs[trs.length - 2].after(t);
  //更改按钮
  t.children[5].innerHTML =
    "<input type='button' value='删除' onclick='dete(this)'>";
  //重新获取所有行
  let trsNew = ta.getElementsByTagName("tr");
  //遍历所有行
  for (let i = 1; i < trsNew.length - 1; i++) {
    //重新标号
    trsNew[i].children[0].innerText = i;
  }
  //统计
  sumGoods();
}
//统计函数
function sumGoods() {
  //获取第一个表格
  let ta = document.getElementsByTagName("table")[0];
  //获取所有行
  let trs = ta.getElementsByTagName("tr");
  //总计
  let sum = 0;
  //遍历得到的行
  for (let i = 1; i < trs.length - 1; i++) {
    //获取该行的小计
    let xjObj = trs[i].children[4];
    //转数字
    let price = Number.parseInt(xjObj.innerText);
    //总和
    sum += price;
  }
  //显示结果
  document.getElementById("count").innerText = sum;
}
