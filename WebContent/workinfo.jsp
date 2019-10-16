<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String id=request.getParameter("id");
String s=request.getParameter("s");
%>
 
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <style type="text/css">
    .one{
        front-family:黑体;
        color:white;
    }
    .two{
        front-family:黑体;
        color:red;
    }
    #description{
overflow: hidden; 
white-space: nowrap;
text-overflow: ellipsis;
}
</style>
    <title>已发布作业</title>
  </head>
  <body style="background:url(img/student.jpg)">
  <h1>${xiaoxi}</h1>
  <br>
  <br>
  <table  width="600" border="1" cellpadding="0" align="center">
  		<tr>
  			<th class="one">作业名</th>
	  		<th class="one">所属课程</th>
	  		<th class="one">教师</th>
	  		<th class="one">作业内容</th>
	  		<th class="one">发布时间</th>
  		</tr>
     <c:forEach var="U" items="${workAll}"  > 
       <tr>
	       <td><input type="text" value="${U.work_name}" name="work_name" disabled="disabled" class="two"></td>
	       <td><input type="text" value="${U.course}" name="course" disabled="disabled" class="two"></td>
	       <td><input type="text" value="${U.name}" name="name" disabled="disabled" class="two"></td>
	       <td id='description' title='${item.description}' style='width: 50px; text-align: left;'><input type="text" value="${U.work_detail}" name="work_detail" disabled="disabled" class="two"></td>
	       <td><input type="text" value="${U.time}" name="time" disabled="disabled" class="two"></td>
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
