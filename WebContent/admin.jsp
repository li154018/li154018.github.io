<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String id=request.getParameter("id");
%>
<style type="text/css">
    .one{
        front-family:黑体;
        color:black;
    }
    .two{
        front-family:黑体;
        color:black;
        font-size:20px;
    }    
</style>
<meta charset="UTF-8">
<title>作业管理-管理员</title>
</head>
<body style="background:url(img/admin.png)">

<div style="width:100%;text-align:right;"><a href="login.jsp" class="two">退出</a></div>
    <h1 class="one">用户：<%=id %></h1>
    <h1 class="one">${xiaoxi}</h1>
    <br>
    <form action="zhuce.jsp" >
	 	<input type="submit" value="注册新用户">
    </form>
    <br>
    <form action="Workinfo_Servlet" >
	 	<h3>    
	 	<input type="submit" value="查看所有用户">
	 	<input name="shenfen" type="radio" value="1" checked>学生 
		<input name="shenfen" type="radio" value="2" >教师
		<input type="hidden" value="<%=id %>" name="id" >
		</h3>
    </form>

</body>
</html>