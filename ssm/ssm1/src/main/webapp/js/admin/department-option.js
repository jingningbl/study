$(function () {
    /**
     * 新增部门
     */
        //添加部门
    let addDepartmentUrl = '/department/insertDepartment'
    //查询部门
    let queryDepartmentUrl = '/department/queryDepartment'
    //修改部门
    let editDepartmentUrl = '/department/editDepartment'

    let dep_id = getQueryParam('depId')
    let is_edit = getQueryParam("edit")
    /**
     * 如果可以从url获取depId,用户不是在查看,就是在编辑
     */
    if (dep_id) {
        //需要从后端获取depId对应信息,并渲染前端页面
        $.post(queryDepartmentUrl, {departmentId: dep_id}, function (data) {
            if (data.success) {
                let department = data.data
                $('#dep-name').val(department.name)
                $('#dep-address').val(department.address)
                if (department.status === 1) {
                    $('#status-on').attr('checked', true)
                    $('#status-off').removeAttr('checked')
                } else {
                    $('#status-off').attr('checked', true)
                    $('#status-on').removeAttr('checked')
                }
            }
        })
    }
    //启用按钮
    $('#status-on').click(function () {
        $('#status-on').attr('checked', true)
        $('#status-off').removeAttr('checked')
    })
    //禁用按钮
    $('#status-off').click(function () {
        $('#status-off').attr('checked', true)
        $('#status-on').removeAttr('checked')
    })
    $('#submit').click(function () {
        /**
         * 获取名称,地址,状态
         * 关闭contentType后,需要将processData一同关闭
         * processData:表示会不会序列化data里面的数据
         */
        let department = {}
        department.name = $('#dep-name').val()
        department.address = $('#dep-address').val()
        department.status = $('input[name="status"][checked]').val()
        if (is_edit) {
            department.depId = dep_id
        }
        //表单数据对象
        let formData = new FormData();
        //表单数据提交可以理解为键值对,key(input的name属性),value(input框的值)
        formData.append("departmentStr", JSON.stringify(department))

        $.ajax({
            url: is_edit ? editDepartmentUrl : addDepartmentUrl,
            type: 'post',
            async: false,
            cache: false,
            datatype: 'json',
            //默认:application/x-www-form-urlencoded(字符串)
            contentType: false,
            processData: false,
            data: formData,
            success: function (data) {
                if (data.success) {
                    lightyear.notify('修改成功~', 'success', 500,
                        'mdi mdi-emoticon-happy', 'top', 'center', '/department/toList')
                } else {
                    lightyear.notify('修改失败~', 'danger', 500,
                        'mdi mdi-emoticon-dead', 'top', 'center')
                }
            }
        })
    })
})