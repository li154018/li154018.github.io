<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%String id=request.getParameter("id"); %>
<style type="text/css">
    .one{
        front-family:黑体;
        color:white;
    }
    .two{
        front-family:黑体;
        color:white;
        font-size:20px;
    }
</style>
<meta charset="UTF-8">
<title>作业管理-教师</title>
</head>
<body style="background:url(img/tea.jpg)">
<div style="width:100%;text-align:right;"><a href="login.jsp" class="two">退出</a></div>
    <h1 class="one">用户：<%=id %>  <br> </h1>
    <h1 class="one">${xiaoxi}<br></h1>
    <br> 
    <form action="listFile" >
	 	<input type="submit" value="下载作业">
	 	<input type="hidden" value=<%=id %> name="id">
    </form>
    <br>
    <form action="publish_work.jsp" >
        <input type="hidden" value=<%=id %> name="id">
	 	<input type="submit" value="发布作业">
    </form>    
    <br>
    <form action="Workinfo_Servlet" method="post">
	 	<input type="submit" value="已发布作业">
	 	<input type="hidden" value="3" name="shenfen">
	 	<input type="hidden" value=<%=id %> name="id">
    </form>
    <br>
    <form action="liuyan.jsp" method="post">
        <input type="hidden" value=<%=id %> name="id">
        <input type="hidden" value="2" name="shenfen">
	 	<input type="submit" value="发送信息">
    </form>
        <br>
    <form action="Shouxin_Servlet" method="post">
        <input type="hidden" value=<%=id %> name="id">
        <input type="hidden" value="2" name="shenfen">
	 	<input type="submit" value="收件箱">
    </form>      
</body>
</html>