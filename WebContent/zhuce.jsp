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
    .two{
        margin-left:100px;
    }
</style>
<script type="text/javascript">
	function check() {
		if (zhuce.id.value == "") {
			alert("用户名不能为空！");
			zhuce.id.focus();
			return false;
		} else if (zhuce.pwd.value == "") {
			alert("密码不能为空！");
			zhuce.pwd.focus();
			return;
		} else {
			zhuce.submit();
		}
	}
</script>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String id=request.getParameter("id");
%>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body style="background:url(img/admin.png)">
	<form name="zhuce" action="ZhuceServlet">
		<table align="center" >
			<caption>
				<h1>注册</h1>
				<HR style="FILTER: alpha(opacity = 100, finishopacity = 0, style = 3)" width="80%" color=red SIZE=3>
			</caption>
			<tr>
				<td align="left" valign="middle">用户名：
				    <input name="id" type="text" size="30" maxlength="20"></td>
			</tr>
			<tr>
				<td align="left" valign="middle">密&nbsp;&nbsp;&nbsp;&nbsp;码：
				    <input name="pwd" type="password" size="30" maxlength="20"></td>
			</tr>
			<tr>
				<td align="left" valign="middle">姓&nbsp;&nbsp;&nbsp;&nbsp;名：
				    <input name="name" type="text" size="30" maxlength="20"></td>
			</tr>			
			<tr>
				<td align="left" valign="middle">身&nbsp;&nbsp;&nbsp;&nbsp;份：
				    <input name="shenfen" type="radio" value="1" checked>学生 
				    <input name="shenfen" type="radio" value="2" >教师
				</td>
			</tr>
			<tr>
				<td align="left" valign="middle">性&nbsp;&nbsp;&nbsp;&nbsp;别：
				    <input name="sex" type="radio" value="男" checked>男&nbsp;&nbsp;&nbsp;&nbsp;
				    <input name="sex" type="radio" value="女">女
				</td>
			</tr>
			<tr>
				<td align="left" valign="middle" data-toggle="distpicker">所在地：
						<select data-province="---- 选择省 ----" name="sheng"></select> 
						<select data-city="---- 选择市 ----" name="shi"></select> 
						<select data-district="---- 选择区 ----" name="qu"></select>
				</td>
			</tr>
			<tr>
			<td>
			    <p>
			<td>
			</tr>			
			<tr>
				<td align="center" valign="middle">
				    <input name="zhuce" type="button" value="提交" onclick="check()">
				    <input name="Reset" type="reset" value="重置" class="two">
				</td>
			</tr>
		</table>
	</form>
	
    <br>
    <br>    
    <div style="width:100%;text-align:center;">
    <input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回上一页">
	</div>
	
		<script src="JS/jquery.min.js"></script>
	<script src="JS/distpicker.js"></script>
</body>
</html>