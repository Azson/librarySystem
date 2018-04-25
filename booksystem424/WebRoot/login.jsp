<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <script type="text/javascript" src="validate/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="validate/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="validate/js/additional-methods.min.js"></script>
    <script type="text/javascript" src="validate/js/jquery.metadata.js"></script>
    <script type="text/javascript" src="validate/js/Message_zh_CN.js"></script>
    <script type="text/javascript" src="validate/login.js"></script>
</head>
<body style="background-color: #E2E2E2;">
    <div class="container">
        <div class="row text-center " style="padding-top:100px;">
            <div class="col-md-12">
                <h2>别人家的图书管理系统</h2>
            </div>
        </div>
         <div class="row ">
               
                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
                           
                            <div class="panel-body">
                                <form id="loginForm" role="form" action="pages/back/AdminServlet/login" method="post">
                                    <hr />
                                    <h5>Enter Details to Login</h5>
                                       <br />
                                     <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-user"  ></i></span>
                                            <input type="text" id="aid" name="aid" value="admin" class="form-control" placeholder="Your Username " />
                                        </div>
                                                                              <div class="form-group input-group">
                                            <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                            <input type="password" id="password" name="password" value="admin123" class="form-control"  placeholder="Your Password" />
                                        </div>

                                     <!-- <a href="index.html" class="btn btn-primary col-md-offset-7">Login Now</a> -->
                                     <input type="submit" value="登 录" class="btn btn-primary col-md-offset-5"/>
                                    <hr />
                                    忘记密码 ? <a href="https://www.baidu.com" >点击这里，你就知道 </a> 或者联系QQ： <a href="#">1234567</a>
                                    </form>
                            </div>
                           
                        </div>
        </div>
    </div>
</body>
</html>

