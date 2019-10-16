<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.entity.Student"%>
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
    .two{
        margin-left:1480;
    }
</style>
<meta charset="UTF-8">
<title>个人中心</title>
</head>
<body style="background:url(img/student.jpg)">
<%Student student=(Student)request.getAttribute("student"); %>
  <form action="UpdateServlet" method="post">
<br>
<br>
<br>
<br>
<br>
  <table  width="400" border="1" cellpadding="0" align="center">
      <caption><h1 class="one">个人信息</h1></caption>
      <tr>
        <td align="center" valign="middle" class="one">账号</td>
        <td align="center" valign="middle"><input type="text" value="<%=student.getId() %>" name="id" ></td>
      </tr>
      <tr>
        <td align="center" valign="middle" class="one">姓名</td>
        <td align="center" valign="middle"><input type="text" value="<%=student.getName() %>" name="name"></td>
      </tr>
      <tr>
        <td align="center" valign="middle" class="one">密码</td>
        <td align="center" valign="middle"><input type="text" value="<%=student.getpwd() %>" name="pwd"></td>
      </tr>
      <tr>
        <td align="center" valign="middle" class="one">性别</td>
        <td align="center" valign="middle"><input type="text" value="<%=student.getSex() %>" name="sex"></td>
      </tr>
      <tr>
        <td align="center" valign="middle" class="one">邮箱</td>
        <td align="center" valign="middle"><input type="email" value="<%=student.getemail() %>" name="email"></td>
      </tr>
      <tr>
        <td align="center" valign="middle" class="one">所在班级</td>
        <td align="center" valign="middle"><input type="text" value="<%=student.getbanji() %>" name="banji"></td>
      </tr>
      <tr>
        <td align="center" valign="middle" class="one">籍贯</td>
        <td align="center" valign="middle"><input type="text" value="<%=student.getAddress() %>" name="address"></td>
      </tr>
	  <tr>
		<td align="center" valign="middle"><input type="submit" value="修改" name="xiugai"></td>
		<td align="center" valign="middle"><input name="Reset" type="reset" value="重置"></td>
	  </tr>
   </table>
   </form>
    <br>

    <br>
    <br>    
    <div style="width:100%;text-align:center;">
    <input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回上一页">
	</div> 

</body>
</html>