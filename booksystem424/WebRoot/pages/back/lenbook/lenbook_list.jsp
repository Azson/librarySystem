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
    <title>别人家的图书管理系统</title>
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
            	<c:if test="${allLenBooks != null}">
            	<table class="table">
            		<thead>
            			<tr>
            				<th>编号</th>
            				<th>书名儿</th>
            				<th>用户名儿</th>
            				<th>上架时间</th>
            				<th>是否归还</th>
            				<th>归还时间</th>
            				<th>操作</th>
            			</tr>
            		</thead>
            		<tbody>
        				<c:forEach  items="${allLenBooks }" var="lenBook">
        				<tr>
        					<td>${lenBook.leid }</td>
        					<td>${lenBook.book.name }</td>
        					<td>${lenBook.member.name }</td>
        					<td>
        						<c:choose>
        							<c:when test="${lenBook.retdate != null }">已归还</c:when>
        							<c:when test="${lenBook.retdate == null }">未归还</c:when>
        						</c:choose>
        					</td>
        					<td><fmt:formatDate value="${lenBook.credate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        					<td><fmt:formatDate value="${lenBook.retdate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        					<td>
        						<c:if test="${lenBook.retdate == null }">
	        						<a href="pages/back/lenbook/LenBookServlet/updateByRetdate?leid=${lenBook.leid }">归还图书</a>
        						</c:if>
        					</td>
        				</tr>
        				</c:forEach>
            		</tbody>
            	</table>
            	<div class="col-md-5 col-md-offset-5">
            		<jsp:include page="/pages/split_bar.jsp"/>
            	</div>
            	</c:if>
            </div>
        </div>
    </div>

	<jsp:include page="/pages/back/footer.jsp"></jsp:include>
</body>
</html>