<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.shawn.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://www.shawn.com/jstl/fmt" %>
<nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
            <span class="sr-only">Shawn图书管理系统</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="pages/back/index.jsp">Shawn图书管理系统</a>
    </div>
    <!--顶部-->
    <div class="header-right">
        <a href="pages/back/AdminServlet/logout" class="btn btn-danger" title="Logout"> 退出系统</a>
    </div>
</nav>
<!-- 导航 -->
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li>
                <div class="user-img-div">
                    <img src="assets/img/user.png" class="img-thumbnail" />

                    <div class="inner-text">
                        管理员:<c:if test="${aid != null}" >${aid }</c:if>
                    <br />
                        <small>上次登录日期:<fmt:formatDate value="${lastdate }" pattern="yyyy-MM-dd HH:mm:ss"/></small>
                    </div>
                </div>
            </li>

            <li>
                <a class="active-menu" href="pages/back/index.jsp"><i class="fa fa-dashboard "></i>导航</a>
            </li>
            <c:if test="${flag == 1 }"><!-- 管理员flag为1 -->
            <!--超级管理员操作-->
            <li>
                <a href="#"><i class="fa fa-desktop "></i>超级管理员操作 <span class="fa arrow"></span></a>
                 <ul class="nav nav-second-level">
                    <li>
                        <a href="pages/back/admin/admin_insert.jsp"><i class="fa fa-toggle-on"></i>增加管理员</a>
                    </li>
                </ul>
            </li>
            </c:if>
            
            <!--用户信息-->
            <li>
                <a href="#"><i class="fa fa-desktop "></i>用户管理 <span class="fa arrow"></span></a>
                 <ul class="nav nav-second-level">
                    <li>
                        <a href="pages/back/member/member_insert.jsp"><i class="fa fa-toggle-on"></i>用户录入</a>
                    </li>
                </ul>
            </li>
            <!--图书分类管理-->
             <li>
                <a href="#"><i class="fa fa-yelp "></i>图书分类管理 <span class="fa arrow"></span></a>
                 <ul class="nav nav-second-level">
                    <li>
                        <a href="pages/back/item/item_insert.jsp"><i class="fa fa-coffee"></i>增加分类</a>
                    </li>
                    <li>
                        <a href="pages/back/item/ItemServlet/list"><i class="fa fa-flash "></i>类别列表</a>
                    </li>
                </ul>
            </li>
            <!--图书信息-->
             <li>
                <a href="#"><i class="fa fa-yelp "></i>图书管理 <span class="fa arrow"></span></a>
                 <ul class="nav nav-second-level">
                    <li>
                        <a href="pages/back/book/BookServlet/insertPro"><i class="fa fa-coffee"></i>增加图书</a>
                    </li>
                    <li>
                        <a href="pages/back/book/BookServlet/listSplit"><i class="fa fa-flash "></i>图书列表</a>
                    </li>
                </ul>
            </li>
           <!--借书登记-->
             <li>
                <a href="#"><i class="fa fa-bicycle "></i>借书登记 <span class="fa arrow"></span></a>
                 <ul class="nav nav-second-level">
                    <li>
                        <a href="pages/back/lenbook/LenBookServlet/insertPro"><i class="fa fa-desktop "></i>借书信息录入 </a>
                    </li>
                    <li>
                        <a href="pages/back/lenbook/LenBookServlet/listSplit"><i class="fa fa-desktop "></i>借书信息列表 </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>