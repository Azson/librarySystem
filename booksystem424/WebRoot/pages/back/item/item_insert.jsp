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
    <%-- <script type="text/javascript" src="validate/js/jquery-1.11.3.min.js"></script>  --%>
    <script type="text/javascript" src="validate/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="validate/js/additional-methods.min.js"></script>
    <script type="text/javascript" src="validate/js/jquery.metadata.js"></script>
    <script type="text/javascript" src="validate/js/Message_zh_CN.js"></script>
    <script type="text/javascript" src="validate/member_insert.js"></script>
</head>
<body>
    <div id="wrapper">
        <jsp:include page="/pages/back/header.jsp"></jsp:include>

        <!-- 此处编写内容  -->
        <div id="page-wrapper">
            <div id="page-inner">
            	<div class="col-md-12">
					<div class="col-md-7 col-md-offset-4">
						<h1 class="h1">增加图书类别</h1>
					</div>
					<div class="col-md-12"><hr/></div>
				</div>
				<%-- 编写数据增加表单 --%>
					<form action="pages/back/item/ItemServlet/insert" method="post" class="form-horizontal" id="insertForm" >
						
						<%-- 类别名称 --%>
						<div class="form-group">
							<label for="name" class="col-md-3 control-label">类别名称</label>
							<div class="col-md-6">
								<input type="text" name="name" id="name" class="form-control input-sm"/>
							</div>
						</div>
						
						<%-- 内容简介信息 --%>
						<div class="form-group">
							<label for="note" class="col-md-3 control-label">内容简介信息</label>
							<div class="col-md-6">
								<textarea name="note" id="note" class="form-control"></textarea>
							</div>
						</div>
						
						<div class="from-group">
							<div class="col-md-5 col-md-offset-3">
								<button type="submit" class="btn btn-success c">提交</button>
								<button type="reset" class="btn btn-success">重置</button>
							</div>
						</div>
					</form>
            </div>
        </div>
    </div>

	<jsp:include page="/pages/back/footer.jsp"></jsp:include>
</body>
</html>