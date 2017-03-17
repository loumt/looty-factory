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
        <!-- search form (Optional) -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="icon-search"></i>
                </button>
              </span>
            </div>
        </form>
        <!-- /.search form -->

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
            <li class="header">HEADER</li>
            <%--用户模块--%>
            <li class="active">
                <a href="${basePath}/manage/user/toIndex">
                    <i class="icon-user"></i>
                    <span>用户模块</span>
                </a>
            </li>
            <%--角色模块--%>
            <li>
                <a href="#">
                    <i class="icon-user-md"></i>
                    <span>角色模块</span>
                </a>
            </li>
            <%--权限模块--%>
            <li>
                <a href="#">
                    <i class="icon-key"></i>
                    <span>权限模块</span>
                </a>
            </li>
            <%--系统管理--%>
            <li class="treeview">
                <a href="#">
                    <i class="icon-cogs"></i>
                    <span>系统管理</span>
                    <span class="pull-right-container">
                        <i class="icon-plus"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="#">Link in level 2</a></li>
                    <li><a href="#">Link in level 2</a></li>
                </ul>
            </li>

        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>