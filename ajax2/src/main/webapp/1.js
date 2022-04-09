$(function () {
//    获得输入框对象
    let $obj = $("input[name='username']");
//    绑定事件
    $obj.blur(function () {
        //    建议提前做一些正则的验证
        $.ajax({
            url: "findUsername",
            type: "get",
            data: {"username": $obj.val()},
            dataType: "json",
            success: function (msg) {
                if (msg) {
                    $("#err-username").text("可以使用").css({"color": "green", "fontSize": "10pt"});
                } else {
                    $("#err-username").text("无法使用").css({"color": "red", "fontSize": "10pt"});
                }
            }
        });
    });
});