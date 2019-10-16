<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
    .one{
        front-family:黑体;
        color:white;
    }

</style>
<meta charset="UTF-8">
<title>2</title>
</head>
<body style="background:url(img/student.jpg)">
<br>
<h1 class="one">${message} </h1>
<br>
<br>
    <div style="width:100%;text-align:center;">
    <input type="button" name="Submit" onclick="javascript:history.go(-2);" value="返回">
	</div>
</body>
</html>