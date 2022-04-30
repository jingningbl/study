$(function () {
    //获取所有的有效的部门列表url
    let queryActiveDepartmentListUrl = '/department/queryActiveDepartmentList'
    //获取所有的有效的部门列表url
    let queryActivePositionListUrl = '/position/queryActivePositionList'
    //定义渲染列表条件
    let request_condition = {}
    //是否初始化分页插件
    let flag = true

    //监听某个按键按下事件,回车键的码13
    $('#search-input').keydown(function (e) {
        //初始化分页插件
        flag = true
        request_condition.current = 1
        if (e.keyCode === 13) {
            let keyword = $('#search-input').val();
            request_condition.name = keyword
            getList(request_condition)
        }
    })

    $('#status-switch').change(function () {
        //筛选状态后,重新渲染页面前,让分页插件可以再次初始化
        flag = true
        request_condition.current = 1
        //开关的状态
        if ($('#status-switch').is(':checked')) {
            request_condition.status = 1
            getList(request_condition)
        } else {
            request_condition.status = null
            getList(request_condition)
        }
    })
    /**
     * 初始化员工列表
     */
    getList(request_condition)

    /**
     * 获取部门下拉列表
     */
    $.post(queryActiveDepartmentListUrl, function (data) {
        if (data.success) {
            let activeList = data.data
            let optionHtml = '<option id="option" data-value="">全部</option>'
            activeList.map(function (item, index) {
                optionHtml += '<option id="option" data-value="' + item.depId + '">' + item.name + '</option>'
            })
            $('#department-select').html(optionHtml)
        }
    })
    $('#department-select').change(function (e) {
        let depId = $('#department-select').find('option').not(
            function () {
                return !this.selected
            }
        ).data("value")
        console.log(depId)
        request_condition.depId = depId
        flag = true
        request_condition.current = 1
        getList(request_condition)
    })
    /**
     * 获取职位下拉列表
     */
    $.post(queryActivePositionListUrl, function (data) {
        if (data.success) {
            let activeList = data.data
            let optionHtml = '<option id="option" data-value="">全部</option>'
            activeList.map(function (item, index) {
                optionHtml += '<option id="option" data-value="' + item.positionId + '">' + item.positionName + '</option>'
            })
            $('#position-select').html(optionHtml)
        }
    })
    $('#position-select').change(function (e) {
        let positionId = $('#position-select').find('option').not(
            function () {
                return !this.selected
            }
        ).data("value")
        console.log(positionId)
        flag = true
        request_condition.current = 1
        request_condition.positionId = positionId
        getList(request_condition)
    })

    /**
     * 获取员工列表
     */
    function getList(data) {
        $.ajax({
            url: '/employee/getList',
            type: 'post',
            async: false,
            cache: false,
            datatype: 'json',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(data),
            success: function (data) {
                if (data.success) {
                    /**
                     * 获取列表数据,进行动态渲染
                     */
                    //初始化分页插件
                    if (flag) {
                        getPageInfo(data.data)
                        flag = false
                    }
                    if (data.data.records.length === 0) {
                        lightyear.notify('没有符合条件的员工~', 'danger', 500,
                            'mdi mdi-emoticon-sad', 'top', 'center')
                    }
                    handleList(data.data.records)
                } else {
                    //TODO:提醒
                    lightyear.notify('查询失败~', 'danger', 500,
                        'mdi mdi-emoticon-dead', 'top', 'center')
                }
            }
        })
    }

    /**
     * 渲染列表数据
     * @param data
     */
    function handleList(data) {
        let html = ''
        let i = 1
        //遍历渲染
        data.map(function (item, index) {
            html += '<tr style="margin-left: 5px">'
                + '<td>' + (i++) + '</td>'
                + '<td>' + item.loginName + '</td>'
                + '<td>' + item.name + '</td>'
                + '<td>' + item.department.name + '</td>'
                + '<td>' + item.position.positionName + '</td>'
                + employeeStatus(item.status)
                + '<td>'
                + '<div class="btn-group">'
                + '<a class="btn btn-xs btn-default" href="/employee/goEmployeeEdit?edit=true&emId=' + item.emId + '" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>'
                + '<a class="btn btn-xs btn-default" href="/employee/goEmployee?emId=' + item.emId + '" title="查看" data-toggle="tooltip"><i class="mdi mdi-eye"></i></a>'
                + updateEmployeeStatus(item.emId, item.status)
                + '</div>'
                + '</td>'
                + '</tr>'
        })
        //替换
        $('.employee-wrap').html(html)
    }

    /**
     * 员工状态处理
     * @param status
     */
    function employeeStatus(status) {
        if (status === 1) {
            return '<td><font class="text-success">在职</font></td>'
        }
        return '<td><font class="text-danger">离职</font></td>'
    }

    /**
     * 修改员工状态图标处理
     */
    function updateEmployeeStatus(emId, status) {
        if (status === 1) {
            return '<a class="btn btn-xs btn-default employee-status-btn" href="#!" title="修改状态" data-id=' + emId + ' data-status=' + status + ' data-toggle="tooltip"><i class="mdi mdi-toggle-switch"></i></a>'
        }
        return '<a class="btn btn-xs btn-default employee-status-btn" href="#!" title="修改状态" data-id=' + emId + ' data-status=' + status + ' data-toggle="tooltip"><i class="mdi mdi-toggle-switch-off"></i></a>'
    }

    /**
     * 对列表中的a标签添加点击事件,定位class为employee-status-btn的<a></a>
     * on:监听事件
     * click:点击事件
     * a:对象
     * event(e):事件参数
     * currentTarget:当前目标
     */
    $('.employee-wrap').on('click', 'a', function (e) {
        let target = $(e.currentTarget);
        if (target.hasClass('employee-status-btn')) {
            let emId = e.currentTarget.dataset.id
            let status = e.currentTarget.dataset.status
            if (request_condition.status === 1) {
                flag = true
                request_condition.current = 1
            }
            $.ajax({
                url: '/employee/toggleEmployeeStatus',
                type: 'post',
                async: false,
                cache: false,
                datatype: 'json',
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify({
                    emId: emId,
                    status: status
                }),
                success: function (data) {
                    if (data.success) {
                        lightyear.notify('修改成功~', 'success', 500,
                            'mdi mdi-emoticon-happy', 'top', 'center')
                        getList(request_condition)
                    } else {
                        lightyear.notify('修改失败~', 'danger', 500,
                            'mdi mdi-emoticon-dead', 'top', 'center')
                        getList(request_condition)
                    }
                }
            })
        }
    })

    /**
     * 获取分页信息
     * coping:是否显示首尾页
     */
    function getPageInfo(data) {
        //初始化分页插件
        $('#jq-page').pagination({
            pageCount: data.pages,
            coping: true,
            //触发分页的按钮
            callback: function (e) {
                //获取用户当前点击的页数,作为参数传给getList
                request_condition.current = e.getCurrent()
                getList(request_condition)
            }
        })
    }
});
