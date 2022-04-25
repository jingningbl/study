$(function () {
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
            request_condition.positionName = keyword
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
     * 初始化部门列表
     */
    getList(request_condition)

    /**
     * 获取职位列表
     */
    function getList(data) {
        $.ajax({
            url: '/position/getList',
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
                    handleList(data.data.records)
                    if (data.data.records.length === 0) {
                        lightyear.notify('没有符合条件的部门~', 'danger', 500,
                            'mdi mdi-emoticon-sad', 'top', 'center')
                    }
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
                + '<td>' + item.positionName + '</td>'
                //data-toggle="tooltip" title=' + item.address鼠标悬停显示信息
                + '<td>' + item.createTime + '</td>'
                + positionStatus(item.status)
                + '<td>'
                + '<div class="btn-group">'
                + '<a class="btn btn-xs btn-default" href="/position/goPositionEdit?edit=true&positionId=' + item.positionId + '" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>'
                + '<a class="btn btn-xs btn-default" href="/position/goPosition?positionId=' + item.positionId + '" title="查看" data-toggle="tooltip"><i class="mdi mdi-eye"></i></a>'
                + updatePositionStatus(item.positionId, item.status)
                + '</div>'
                + '</td>'
                + '</tr>'
        })
        //替换
        $('.position-wrap').html(html)
    }

    /**
     * 职位状态处理
     * @param status
     */
    function positionStatus(status) {
        if (status === 1) {
            return '<td><font class="text-success">有效</font></td>'
        }
        return '<td><font class="text-danger">失效</font></td>'
    }

    /**
     * 修改职位状态图标处理
     */
    function updatePositionStatus(positionId, status) {
        if (status === 1) {
            return '<a class="btn btn-xs btn-default position-status-btn" href="#!" title="修改状态" data-id=' + positionId + ' data-status=' + status + ' data-toggle="tooltip"><i class="mdi mdi-toggle-switch"></i></a>'
        }
        return '<a class="btn btn-xs btn-default position-status-btn" href="#!" title="修改状态" data-id=' + positionId + ' data-status=' + status + ' data-toggle="tooltip"><i class="mdi mdi-toggle-switch-off"></i></a>'
    }

    /**
     * 对列表中的a标签添加点击事件,定位class为department-status-btn的<a></a>
     * on:监听事件
     * click:点击事件
     * a:对象
     * event(e):事件参数
     * currentTarget:当前目标
     */
    $('.position-wrap').on('click', 'a', function (e) {
        //console.log(e.currentTarget.dataset)
        let target = $(e.currentTarget);
        if (target.hasClass('position-status-btn')) {
            let positionId = e.currentTarget.dataset.id
            let status = e.currentTarget.dataset.status
            if (request_condition.status === 1) {
                flag = true
                request_condition.current = 1
            }
            $.ajax({
                url: '/position/togglePositionStatus',
                type: 'post',
                async: false,
                cache: false,
                datatype: 'json',
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify({
                    positionId: positionId,
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
