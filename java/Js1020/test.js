//创建数组
var ary = new Array();
//添加数据
ary.push(1);
ary.push("A");
ary.push(true);
ary.push("哈哈");
//输出数据类型
console.log(typeof ary[0]);
console.log(typeof ary[1]);
console.log(typeof ary[2]);
console.log(typeof ary[3]);
for(i=0;i<ary.length;i++){
    console.log(ary[i])
}
