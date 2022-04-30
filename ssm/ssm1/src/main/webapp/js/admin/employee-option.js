$(function () {
    /**
     * 新增员工
     */
        //添加员工
    let addEmployeeUrl = '/employee/insertEmployee'
    //查询员工
    let queryEmployeeUrl = '/employee/queryEmployee'
    //修改员工
    let editEmployeeUrl = '/employee/editEmployee'
    //获取所有的有效的部门列表url
    let queryActiveDepartmentListUrl = '/department/queryActiveDepartmentList'
    //获取所有的有效的部门列表url
    let queryActivePositionListUrl = '/position/queryActivePositionList'

    let em_id = getQueryParam('emId')
    let is_edit = getQueryParam("edit")

    /**
     * 如果可以从url获取depId,用户不是在查看,就是在编辑
     */
    if (em_id) {
        //需要从后端获取depId对应信息,并渲染前端页面
        $.post(queryEmployeeUrl, {employeeId: em_id}, function (data) {
            if (data.success) {
                let employee = data.data.employee
                $('#em-name').val(employee.name)
                $('#em-loginName').val(employee.loginName)
                if (employee.status === 1) {
                    $('#status-on').attr('checked', true)
                    $('#status-off').removeAttr('checked')
                } else {
                    $('#status-off').attr('checked', true)
                    $('#status-on').removeAttr('checked')
                }
                let depHtml = ''
                let isDepartmentSelected = ''
                data.data.departmentList.map(function (item, index) {
                    isDepartmentSelected = employee.depId === item.depId ? 'selected' : ''
                    depHtml += '<option data-value="' + item.depId + '"' + isDepartmentSelected + '>' + item.name + '</option>'
                })
                $('#department-select').html(depHtml)
                let positionHtml = ''
                let isPositionSelected = ''
                data.data.positionList.map(function (item, index) {
                    isPositionSelected = employee.positionId === item.positionId ? 'selected' : ''
                    positionHtml += '<option data-value="' + item.positionId + '"' + isPositionSelected + '>' + item.positionName + '</option>'
                })
                $('#position-select').html(positionHtml)
            }
        })
    } else {
        /**
         * 获取部门下拉列表
         */
        $.post(queryActiveDepartmentListUrl, function (data) {
            if (data.success) {
                let activeDepartmentList = data.data
                let optionHtml = '<option id="option" data-value="">全部</option>'
                activeDepartmentList.map(function (item, index) {
                    optionHtml += '<option id="option" data-value="' + item.depId + '">' + item.name + '</option>'
                })
                $('#department-select').html(optionHtml)
            }
        })
        $('#department-select').change(function (e) {
            $('#department-select').find('option').not(
                function () {
                    return !this.selected
                }
            ).data("value")
        })
        /**
         * 获取职位下拉列表
         */
        $.post(queryActivePositionListUrl, function (data) {
            if (data.success) {
                let activePositionList = data.data
                let optionHtml = '<option id="option" data-value="">全部</option>'
                activePositionList.map(function (item, index) {
                    optionHtml += '<option id="option" data-value="' + item.positionId + '">' + item.positionName + '</option>'
                })
                $('#position-select').html(optionHtml)
            }
        })
        $('#position-select').change(function (e) {
            $('#position-select').find('option').not(
                function () {
                    return !this.selected
                }
            ).data("value")
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
        let employee = {}
        employee.name = $('#em-name').val()
        employee.loginName = $('#em-loginName').val()
        employee.depId = $('#department-select').find('option').not(function () {
            return !this.selected
        }).data("value")
        employee.positionId = $('#position-select').find('option').not(function () {
            return !this.selected
        }).data("value")
        employee.status = $('input[name="status"][checked]').val()
        if (is_edit) {
            employee.emId = em_id
        }
        //表单数据对象
        let formData = new FormData();
        //表单数据提交可以理解为键值对,key(input的name属性),value(input框的值)
        formData.append("employeeStr", JSON.stringify(employee))

        $.ajax({
            url: is_edit ? editEmployeeUrl : addEmployeeUrl,
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
                        'mdi mdi-emoticon-happy', 'top', 'center', '/employee/toList')
                } else {
                    lightyear.notify(data.errMsg, 'danger', 500,
                        'mdi mdi-emoticon-dead', 'top', 'center')
                }
            }
        })
    })
})