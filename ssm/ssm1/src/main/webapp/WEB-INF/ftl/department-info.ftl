<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>部门详情</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/materialdesignicons.min.css" rel="s
    tylesheet">
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
                                    <div class="form-group col-md-12">
                                        <label for="dep-name">部门名称</label>
                                        <input type="text" class="form-control" id="dep-name" name="dep-name" value=""
                                               placeholder="请输入部门名称" disabled/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="dep-address">部门地址</label>
                                        <input type="text" class="form-control" id="dep-address" name="dep-address"
                                               value="" placeholder="请输入部门地址" disabled/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="status">状态</label>
                                        <div class="clearfix">
                                            <label class="lyear-radio radio-inline radio-primary">
                                                <input type="radio" id="status-off" name="status" value="0" disabled><span>禁用</span>
                                            </label>
                                            <label class="lyear-radio radio-inline radio-primary">
                                                <input type="radio" id="status-on" name="status" value="1" checked="checked" disabled><span>启用</span>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-12">
<#--                                        <button id="submit" class="btn btn-primary">确 定</button>-->
                                        <button type="button" class="btn btn-primary"
                                                onclick="javascript:history.back(-1);return false;">返 回
                                        </button>
                                    </div>
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