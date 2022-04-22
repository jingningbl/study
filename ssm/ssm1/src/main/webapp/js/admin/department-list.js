$(function () {
    /**
     * 部门页面,筛选下拉框
     */
    $('.search-bar .dropdown-menu a').click(function () {
        var field = $(this).data('field') || '';
        $('#search-field').val(field);
        $('#search-btn').html($(this).text() + ' <span class="caret"></span>');
    });

    /**
     * 初始化部门列表
     */
    getList()

    /**
     * 获取部门列表
     */
    function getList() {
        $.ajax({
            url: '/department/getList',
            type: 'post',
            async: false,
            cache: false,
            datatype: 'json',
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                if (data.success) {
                    /**
                     * 获取列表数据,进行动态渲染
                     */
                    console.log("部门列表");
                    handleList(data.data)
                } else {
                    //TODO:提醒
                    console.log("获取失败");
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
                + '<td>' + item.name + '</td>'
                + '<td>' + item.address + '</td>'
                + departmentStatus(item.status)
                + '<td>'
                + '<div class="btn-group">'
                + '<a class="btn btn-xs btn-default" href="#!" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>'
                + '<a class="btn btn-xs btn-default" href="#!" title="查看" data-toggle="tooltip"><i class="mdi mdi-eye"></i></a>'
                + updateDepartmentStatus(item.depId, item.status)
                + '</div>'
                + '</td>'
                + '</tr>'
        })
        //替换
        $('.department-wrap').html(html)
    }

    /**
     * 部门状态处理
     * @param status
     */
    function departmentStatus(status) {
        if (status === 1) {
            return '<td><font class="text-success">有效</font></td>'
        }
        return '<td><font class="text-danger">失效</font></td>'
    }

    /**
     * 修改部门状态图标处理
     */
    function updateDepartmentStatus(depId, status) {
        if (status === 1) {
            return '<a class="btn btn-xs btn-default department-status-btn" href="#!" title="修改状态" data-id=' + depId + ' data-status=' + status + ' data-toggle="tooltip"><i class="mdi mdi-toggle-switch"></i></a>'
        }
        return '<a class="btn btn-xs btn-default department-status-btn" href="#!" title="修改状态" data-id=' + depId + ' data-status=' + status + ' data-toggle="tooltip"><i class="mdi mdi-toggle-switch-off"></i></a>'
    }

    /**
     * 对列表中的a标签添加点击事件,定位class为department-status-btn的<a></a>
     * on:监听事件
     * click:点击事件
     * a:对象
     * event(e):事件参数
     * currentTarget:当前目标
     */
    $('.department-wrap').on('click', 'a', function (e) {
        //console.log(e.currentTarget.dataset)
        let target = $(e.currentTarget);
        if (target.hasClass('department-status-btn')) {
            let depId = e.currentTarget.dataset.id
            let status = e.currentTarget.dataset.status
            $.ajax({
                url: '/department/toggleDepartmentStatus',
                type: 'post',
                async: false,
                cache: false,
                datatype: 'json',
                contentType: 'application/json;charset=utf-8',
                data:JSON.stringify({
                    depId:depId,
                    status:status
                }),
                success:function (data) {
                    if (data.success){
                        lightyear.notify('修改成功~', 'success', 500,
                            'mdi mdi-emoticon-happy', 'top', 'center')
                        getList()
                    }else {
                        lightyear.notify('修改失败~', 'danger', 500,
                            'mdi mdi-emoticon-dead', 'top', 'center')
                        getList()
                    }
                }
            })
        }
    })

});
