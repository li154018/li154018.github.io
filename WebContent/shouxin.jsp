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
    <title>收件箱</title>
  </head>
<body style="background:url(img/admin.png)">
  <br>
  <table  width="600" border="1" cellpadding="0" align="center">
  		<tr>
  			<th>发件人</th>
	  		<th>主题</th>
	  		<th>发送时间</th>
	  		<th>内容</th>
  		</tr>
     <c:forEach var="U" items="${MessageAll}"  > 
       <tr>
	       <td><input type="text" value="${U.sender}" name="sender" disabled="disabled" class="one"></td>
	       <td><input type="text" value="${U.title}" name="title" disabled="disabled" class="one"></td>
	       <td><input type="text" value="${U.send_time}" name="send_time" disabled="disabled" class="one"></td>
	       <td><input type="text" value="${U.detail}" name="detail" disabled="disabled" class="one"></td>

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
