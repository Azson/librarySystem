<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.shawn.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://www.shawn.com/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>">
	
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Shawn图书管理系统</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/basic.css" rel="stylesheet" />
    <link href="assets/css/custom.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <script src="assets/js/jquery-1.10.2.js"></script>
    <script src="assets/js/bootstrap.js"></script>
    <script src="assets/js/jquery.metisMenu.js"></script>
    <script src="assets/js/custom.js"></script>
</head>
<body>
    <div id="wrapper">
        <jsp:include page="/pages/back/header.jsp"></jsp:include>

        <!-- 此处编写内容  -->
        <div id="page-wrapper">
            <div id="page-inner">
            	<c:if test="${allBook != null}">
            	<table class="table">
            		<thead>
            			<tr>
            				<th>编号</th>
            				<th>图书类别</th>
            				<th>书名</th>
            				<th>上架日期</th>
            				<th>图书状态</th>
            				<th>简介</th>
            				<th>管理员ID</th>
            			</tr>
            		</thead>
            		<tbody>
        				<c:forEach  items="${allBook }" var="book">
        				<tr>
        					<td>${book.bid }</td>
        					<td>${book.item.name }</td>
        					<td>${book.name }</td>
        					<td><fmt:formatDate value="${book.credate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        					<td>
        						<c:choose>
        							<c:when test="${book.status == 1 }">上架</c:when>
        							<c:otherwise>下架</c:otherwise>
        						</c:choose>
        					</td>
        					<td>${book.note }</td>
        					<td>${book.admin.aid }</td>
        				</tr>
        				</c:forEach>
            		</tbody>
            	</table>
            	<div class="col-md-5 col-md-offset-3">
            		<jsp:include page="/pages/split_bar.jsp"/>
            	</div>
            	</c:if>
            </div>
        </div>
    </div>

	<jsp:include page="/pages/back/footer.jsp"></jsp:include>
</body>
</html>