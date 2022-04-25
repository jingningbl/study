$(function () {
    /**
     * 新增职位
     */
        //添加职位
    let addPositionUrl = '/position/insertPosition'
    //查询职位
    let queryPositionUrl = '/position/queryPosition'
    //修改职位
    let editPositionUrl = '/position/editPosition'

    let position_id = getQueryParam('positionId')
    let is_edit = getQueryParam("edit")
    /**
     * 如果可以从url获取depId,用户不是在查看,就是在编辑
     */
    if (position_id) {
        //需要从后端获取depId对应信息,并渲染前端页面
        $.post(queryPositionUrl, {positionId: position_id}, function (data) {
            if (data.success) {
                let position = data.data
                $('#position-name').val(position.positionName)
                // $('#dep-address').val(position.address)
                if (position.status === 1) {
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
        let position = {}
        position.positionName = $('#position-name').val()
        // position.address = $('#dep-address').val()
        position.status = $('input[name="status"][checked]').val()
        if (is_edit) {
            position.positionId = position_id
        }
        //表单数据对象
        let formData = new FormData();
        //表单数据提交可以理解为键值对,key(input的name属性),value(input框的值)
        formData.append("positionStr", JSON.stringify(position))

        $.ajax({
            url: is_edit ? editPositionUrl : addPositionUrl,
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
                    lightyear.notify('操作成功~', 'success', 500,
                        'mdi mdi-emoticon-happy', 'top', 'center', '/position/toList')
                } else {
                    lightyear.notify('操作失败~', 'danger', 500,
                        'mdi mdi-emoticon-dead', 'top', 'center')
                }
            }
        })
    })
})