$(function () {
    /**
     * 新增部门
     */
    let addDepartmentUrl = '/department/insertDepartment'
    //启用按钮
    $('#status-on').click(function () {
        console.log("启用按钮")
        $('#status-on').attr('checked', true)
        $('#status-off').removeAttr('checked')
    })
    //禁用按钮
    $('#status-off').click(function () {
        console.log("禁用按钮")
        $('#status-off').attr('checked', true)
        $('#status-on').removeAttr('checked')
    })
    $('#submit').click(function () {
        /**
         * 获取名称,地址,状态
         * 关闭contentType后,需要将processData一同关闭
         * processData:表示会不会序列化data里面的数据
         */
        let department={}
        department.name = $('#dep-name').val()
        department.address = $('#dep-address').val()
        department.status = $('input[name="status"][checked]').val()
        //表单数据对象
        let formData = new FormData();
        //表单数据提交可以理解为键值对,key(input的name属性),value(input框的值)
        formData.append("departmentStr",JSON.stringify(department))

        $.ajax({
            url: addDepartmentUrl,
            type: 'post',
            async: false,
            cache: false,
            datatype: 'json',
            //默认:application/x-www-form-urlencoded(字符串)
            contentType: false,
            processData: false,
            data:formData,
            success: function (data) {
                console.log(data)
            }
        })
    })
})