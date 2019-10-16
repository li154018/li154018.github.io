<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String id=request.getParameter("id");
%>
 
<!DOCTYPE html>
<html>
  <head>
    <style type="text/css">
    .one{
        front-family:黑体;
        color:red;
    }
</style>
    <base href="<%=basePath%>">
    <title>所有教师</title>
  </head>
  <body style="background:url(img/admin.png)">
  <h1>${xiaoxi}</h1>
  <br>
  <table  width="600" border="1" cellpadding="0" align="center">
  		<tr>
  			<th>账号</th>
	  		<th>密码</th>
	  		<th>姓名</th>
	  		<th>性别</th>
	  		<th>专业</th>
	  		<th>职称</th>
  		</tr>
     <c:forEach var="U" items="${teacherAll}"  > 
       <tr>
	       <td><input type="text" value="${U.id}" name="id" disabled="disabled" class="one"></td>
	       <td><input type="text" value="${U.pwd}" name="pwd" disabled="disabled" class="one"></td>
	       <td><input type="text" value="${U.name}" name="name" disabled="disabled" class="one"></td>
	       <td><input type="text" value="${U.sex}" name="sex" disabled="disabled" class="one"></td>
	       <td><input type="text" value="${U.zhuanye}" name="zhuanye" disabled="disabled" class="one"></td>
	       <td><input type="text" value="${U.zhicheng}" name="zhicheng" disabled="disabled" class="one"></td>
	   </tr>
	 </c:forEach>  
    </table>
    <br>
    <br>    
    <div style="width:100%;text-align:center;">
    <input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回上一页">
	</div> 
  </body>
</html>
