<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left info">
                <p>Alexander Pierce</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <%--用户模块--%>
            <li class="active">
                <a href="${basePath}/manage/user/toIndex">
                    <i class="icon-user"></i>
                    <span>用户</span>
                </a>
            </li>
            <%--角色模块--%>
            <li>
                <a href="${basePath}/manage/role/toIndex">
                    <i class="icon-user-md"></i>
                    <span>角色</span>
                </a>
            </li>
            <%--权限模块--%>
            <li>
                <a href="${basePath}/manage/permission/authCode/toIndex">
                    <i class="icon-key"></i>
                    <span>权限</span>
                </a>
            </li>
            <%--系统管理--%>
            <li>
                <a href="#">
                    <i class="icon-cogs"></i>
                    <span>系统</span>
                    <span class="pull-right-container">
                        <i class="icon-plus"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${basePath}/manage/system/monitorInfo/toIndex">状态</a></li>
                    <li><a href="${basePath}/manage/system/config/toIndex">配置</a></li>
                </ul>
            </li>
            <%--日志管理--%>
            <li>
                <a href="#">
                    <i class="icon-pinterest"></i>
                    <span>日志</span>
                    <span class="pull-right-container">
                        <i class="icon-plus"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${basePath}/manage/log/system/toIndex">系统状态</a></li>
                    <li><a href="${basePath}/manage/log/manage/toIndex">管理工具</a></li>
                </ul>
            </li>
            <%--微博热搜--%>
            <li>
                <a href="${basePath}/manage/weibo/hot/toIndex">
                    <i class="icon-user-md"></i>
                    <span>微博热搜</span>
                </a>
            </li>
            <%--笔记记录--%>
            <li>
                <a href="#">
                    <i class="icon-pinterest"></i>
                    <span>资源</span>
                    <span class="pull-right-container">
                        <i class="icon-plus"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${basePath}/manage/note/resource/toAdd">添加资源</a></li>
                    <li><a href="${basePath}/manage/note/resource/toIndex">资源列表</a></li>
                    <li><a href="${basePath}/manage/note/noteResource/toIndex">笔记列表</a></li>
                    <li><a href="${basePath}/manage/note/noteResource/toWrite">写笔记</a></li>
                </ul>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>