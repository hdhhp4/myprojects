<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@include file="../common/common.jsp" %>
    <link rel="stylesheet" href="${ctx}/thirdpart/menu/css/jquery.mCustomScrollbar.min.css"/>
    <link rel="stylesheet" href="${ctx}/thirdpart/menu/css/custom.css">
    <script src="${ctx}/thirdpart/menu/js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="${ctx}/thirdpart/menu/js/custom.js"></script>
    <title>Title</title>
    <style>
        .img-responsive {
            width: 54px;
        }
    </style>
</head>
<body>
<div class="page-wrapper">
    <nav id="sidebar" class="sidebar-wrapper">
        <div class="sidebar-content">
            <a href="#" id="toggle-sidebar"><i class="fa fa-bars"></i></a>
            <div class="sidebar-brand">
                <a href="#">pro sidebar</a>
            </div>
            <div class="sidebar-header">
                <div class="user-pic">
                    <img class="img-responsive img-rounded" src="${ctx}/thirdpart/menu/img/user.jpg" alt="">
                </div>
                <div class="user-info">
                    <span class="user-name">Jhon <strong>Smith</strong></span>
                    <span class="user-role">Administrator</span>
                    <div class="user-status">
                        <a href="#"><span class="badge badge-success">Online</span></a>
                    </div>
                </div>
            </div><!-- sidebar-header  -->
            <div class="sidebar-search">
                <div>
                    <div class="input-group">
                        <input type="text" class="form-control search-menu" placeholder="Search for...">
                        <%--<span class="input-group-addon"><i class="fa fa-search"></i></span>--%>
                    </div>
                </div>
            </div><!-- sidebar-search  -->
            <div class="sidebar-menu">
                <ul>
                    <li class="header-menu"><span>Dropdown  menu</span></li>
                    <li class="sidebar-dropdown">
                        <a href="#"><i class="fa fa-tv"></i><span>Menu 1</span><span
                                class="label label-danger">New</span></a>
                        <div class="sidebar-submenu">
                            <ul>
                                <li><a href="#">submenu 1 <span class="label label-success">10</span></a></li>
                                <li><a href="#">submenu 2</a></li>
                                <li><a href="#">submenu 3</a></li>
                                <li><a href="#">submenu 4</a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="sidebar-dropdown">
                        <a href="#"><i class="fa fa-photo"></i><span>Menu 2</span><span class="badge">3</span></a>
                        <div class="sidebar-submenu">
                            <ul>
                                <li><a href="#">submenu 1 <span class="badge">2</span></a></li>
                                <li><a href="#">submenu 2</a></li>
                                <li><a href="#">submenu 3</a></li>
                                <li><a href="#">submenu 4</a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="sidebar-dropdown">
                        <a href="#"><i class="fa fa-bar-chart-o"></i><span>Menu 3</span></a>
                        <div class="sidebar-submenu">
                            <ul>
                                <li><a href="#">submenu 1</a></li>
                                <li><a href="#">submenu 2</a></li>
                                <li><a href="#">submenu 3</a></li>
                                <li><a href="#">submenu 4</a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="sidebar-dropdown">
                        <a href="#"><i class="fa fa-diamond"></i><span>Menu 4</span></a>
                        <div class="sidebar-submenu">
                            <ul>
                                <li><a href="#">submenu 1</a></li>
                                <li><a href="#">submenu 2</a></li>
                                <li><a href="#">submenu 3</a></li>
                                <li><a href="#">submenu 4</a></li>
                            </ul>
                        </div>
                    </li>
                    <li class="header-menu"><span>Simple menu</span></li>
                    <li><a href="#"><i class="fa fa-tv"></i><span>Menu 1</span></a></li>
                    <li><a href="#"><i class="fa fa-photo"></i><span>Menu 2</span></a></li>
                    <li><a href="#"><i class="fa fa-bar-chart-o"></i><span>Menu 3</span></a></li>
                    <li><a href="#"><i class="fa fa-diamond"></i><span>Menu 4</span></a></li>
                </ul>
            </div><!-- sidebar-menu  -->
        </div><!-- sidebar-content  -->

        <%--<div class="sidebar-footer">--%>
            <%--<a href="#"><i class="fa fa-bell"></i><span class="label label-warning notification">3</span></a>--%>
            <%--<a href="#"><i class="fa fa-envelope"></i><span class="label label-success notification">7</span></a>--%>
            <%--<a href="#"><i class="fa fa-gear"></i></a>--%>
            <%--<a href="#"><i class="fa fa-power-off"></i></a>--%>
        <%--</div>--%>
    </nav><!-- sidebar-wrapper  -->
    <main class="page-content">
        <div class="container-fluid">
            <header class="htmleaf-header">
                <h1>基于jquery和Bootstrap3的隐藏侧边栏 <span>Responsive sidebar template based on bootstrap framwork</span></h1>
                <div class="htmleaf-links">
                    <a class="htmleaf-icon icon-htmleaf-home-outline" href="http://www.htmleaf.com/" title="jQuery之家"
                       target="_blank"><span> jQuery之家</span></a>
                    <a class="htmleaf-icon icon-htmleaf-arrow-forward-outline"
                       href="http://www.htmleaf.com/jQuery/Menu-Navigation/201712154881.html" title="返回下载页"
                       target="_blank"><span> 返回下载页</span></a>
                </div>
            </header>
            <h1 style="text-align:center;">Pro sidebar template</h1>
            <h3 style="text-align:center;">点击左上角的 <i class="fa fa-bars"></i> 按钮来查看侧边栏效果</h3>
        </div>
    </main><!-- page-content" -->
</div><!-- page-wrapper -->
</body>
</html>
