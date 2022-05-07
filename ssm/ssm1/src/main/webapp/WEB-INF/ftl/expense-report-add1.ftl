<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>新增报销单</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/materialdesignicons.min.css" rel="stylesheet">
    <!--标签插件-->
    <#--    <link rel="stylesheet" href="/js/jquery-tags-input/jquery.tagsinput.min.css">-->
    <link href="/css/style.min.css" rel="stylesheet">
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
        <#include "side.ftl"/>
        <!--End 左侧导航-->

        <!--头部信息-->
        <#include "top.ftl"/>
        <!--End 头部信息-->

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div class="container-fluid">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <#--                                    <div class="form-group col-md-12">-->
                                    <#--                                        <label for="type">栏目</label>-->
                                    <#--                                        <div class="form-controls">-->
                                    <#--                                            <select name="type" class="form-control" id="type">-->
                                    <#--                                                <option value="1">小说</option>-->
                                    <#--                                                <option value="2">古籍</option>-->
                                    <#--                                                <option value="3">专辑</option>-->
                                    <#--                                                <option value="4">自传</option>-->
                                    <#--                                            </select>-->
                                    <#--                                        </div>-->
                                    <#--                                    </div>-->
                                    <div class="divider text-uppercase">报销原因</div>
                                    <div class="form-group col-lg-12">
                                        <#--                                        <label for="expense-cause">报销原因</label>-->
                                        <input type="text" class="form-control" id="expense-cause" name="expense-cause"
                                               value=""
                                               placeholder="请输入报销原因"/>
                                    </div>
                                    <div class="divider text-uppercase">报销明细</div>
                                    <div class="form-control col-lg-12">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th >选择</th>
                                                <th >费用项目</th>
                                                <th>费用说明</th>
                                                <th >报销金额</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>
                                                    <a class="btn btn-default" id="deleteItem">x</a>
                                                </td>
                                                <td>
                                                    <#--                                                        <input type="text" class="form-control" id="item-select">-->
                                                    <select class="form-control" id="item-select" name="item-select">
                                                        <option value="0">请选择</option>
                                                        <option value="1">1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                    </select>
                                                </td>
                                                <td>
                                                    <input type="text" class="form-control" id="item-descript"
                                                           placeholder="费用说明"/>
                                                </td>
                                                <td>
                                                    <input type="text" class="form-control" id="item-descript"
                                                           placeholder="报销金额"/>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
<#--                                    <div class="col-md-2">-->
<#--                                        <label>总金额</label>-->
<#--                                        <div class="input-group m-b-10">-->
<#--                                            <a class="btn btn-default input-group-addon">+</a>-->
<#--                                            <input type="text" class="form-control" disabled>-->
<#--                                            <span class="input-group-addon">元</span>-->
<#--                                        </div>-->
<#--                                    </div>-->
                                    <#--                                    <div class="form-group col-md-12">-->
                                    <#--&lt;#&ndash;                                        <label for="dep-address">报销明细</label>&ndash;&gt;-->
                                    <#--                                        <input type="text" class="form-control" id="dep-address" name="dep-address"-->
                                    <#--                                               value="" placeholder="请输入报销明细"/>-->
                                    <#--                                    </div>-->
                                    <#--                                    <div class="form-group col-md-12">-->
                                    <#--                                        <label for="status">状态</label>-->
                                    <#--                                        <div class="clearfix">-->
                                    <#--                                            <label class="lyear-radio radio-inline radio-primary">-->
                                    <#--                                                <input type="radio" id="status-off" name="status" value="0"><span>禁用</span>-->
                                    <#--                                            </label>-->
                                    <#--                                            <label class="lyear-radio radio-inline radio-primary">-->
                                    <#--                                                <input type="radio" id="status-on" name="status" value="1" checked="checked"><span>启用</span>-->
                                    <#--                                            </label>-->
                                    <#--                                        </div>-->
                                    <#--                                    </div>-->
                                    <#--                                    <div class="form-group col-md-12">-->
                                    <#--                                        <button id="submit" class="btn btn-primary">确 定</button>-->
                                    <#--                                        <button type="button" class="btn btn-default"-->
                                    <#--                                                onclick="javascript:history.back(-1);return false;">返 回-->
                                    <#--                                        </button>-->
                                    <#--                                    </div>-->
                                </div>

                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/perfect-scrollbar.min.js"></script>
<!--标签插件-->
<#--<script src="/js/jquery-tags-input/jquery.tagsinput.min.js"></script>-->
<#--消息通知-->
<script type="text/javascript" src="/js/bootstrap-notify.min.js"></script>
<script type="text/javascript" src="/js/lightyear.js"></script>
<script type="text/javascript" src="/js/main.min.js"></script>
<script type="text/javascript" src="/js/admin/common.js"></script>
<script type="text/javascript" src="/js/admin/department-option.js"></script>
</body>
</html>