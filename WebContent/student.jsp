<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String id=request.getParameter("id");
%>
<html>
<head>
<style type="text/css">
    .one{
        front-family:黑体;
        color:white;
    }

</style>
    <base href="<%=basePath%>">
<meta charset="UTF-8">
<title>作业管理-学生</title>
</head>
<body style="background:url(img/student.jpg)">
<div style="width:100%;text-align:right;"><a href="login.jsp" class="one">退出</a></div>
    <h1 class="one">用户：<%=id %>  <br> </h1>
    <h1 class="one">${xiaoxi}<br></h1>
    <br>
    <form action="upload.jsp" >
	 	<input type="submit" value="作业提交">
	 	<input type="hidden" value=<%=id %> name="id">
    </form>
    <br>



    <br>
    <form action="Workinfo_Servlet" method="post">
	 	<input type="submit" value="已发布作业">
	 	<input type="hidden" value="3" name="shenfen">
	 	<input type="hidden" value=<%=id %> name="id">
    </form>
    <br>
    <form action="liuyan.jsp" method="post">
        <input type="hidden" value=<%=id %> name="id">
        <input type="hidden" value="1" name="shenfen">
	 	<input type="submit" value="发送信息">
    </form>
        <br>
    <form action="Shouxin_Servlet" method="post">
        <input type="hidden" value=<%=id %> name="id">
        <input type="hidden" value="1" name="shenfen">
	 	<input type="submit" value="收件箱">
    </form>    
</body>
</html>