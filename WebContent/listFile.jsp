<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%
	String id = request.getParameter("id");
%>
<head>
<style type="text/css">
    .one{
        front-family:黑体;
        color:white;
        font-size:20px;
    }

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载文件显示页面</title>
</head>
<body style="background:url(img/tea.jpg)">
<br>
<div class="one" style="width:100%;text-align:left;">
    <!-- 遍历Map集合 -->
    <c:forEach var="me" items="${fileNameMap}">
        <c:url value="/download" var="downurl">
            <c:param name="filename" value="${me.key}"></c:param>
        </c:url>
        ${me.value}<a href="${downurl}">下载</a>
        <br />
    </c:forEach>
    </div>
    <br>
    <br>    
    <div style="width:100%;text-align:left;">
    <br>
    <form action="teacher.jsp" >
	 	<input type="submit" value="返回上一页">
	 	<input type="hidden" value="<%=id %>" name="id" >
    </form>
	</div>
</body>
</html>