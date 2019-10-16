<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String id = request.getParameter("id");
%>

<html>
<head>
  <style type="text/css">
    .one{
        front-family:黑体;
        color:white;
    }
</style>
<meta charset="UTF-8">
<title>提交作业</title>
</head>
    <body style="background:url(img/student.jpg)">
    <h1><br></h1>
    <div style="width:100%;text-align:center;">
        <form action="UploadServlet" enctype="multipart/form-data" method="post">
             <h1 class="one">上传文件：<input type="file" name="file1" ><br></h1>
             <br>
                       <input type="submit" value="提交">
                       <input type="hidden" value=<%=id %> name="id">
        </form>
    </div>
        <br>
    <br>    
    <div style="width:100%;text-align:center;">
    <br>
    <form action="student.jsp" >
	 	<input type="submit" value="返回上一页">
	 	<input type="hidden" value="<%=id %>" name="id" >
    </form>
	</div>
    </body>
</html>