<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%String id=request.getParameter("id"); %>
<style type="text/css">
    .one{
        front-family:黑体;
        color:black;
    }
        .two{
        front-family:黑体;
        color:black;
    }
</style>
<meta charset="UTF-8">
<title>发送信息</title>
</head>
<body style="background:url(img/admin.png)">
<form action="Message_add_Servlet" method="post" >
<input type="hidden" value=<%=id %> name="id">
    <h2 class="one">${xiaoxi}<br></h1>
<table align="center">
    <caption>
				<h1 class="one">发送信息</h1>
			    <HR style="FILTER: alpha(opacity = 100%, finishopacity = 0%, style = 3)" width="100%" color=red SIZE=4>
    </caption>
    <tr>
        <td aligin="center" valign="middle" class="two">主题</td>
        <td aligin="center" valign="middle"><input type="text" name="title"></td>
    </tr>
    <tr>
        <td aligin="center" valign="middle" class="two">接收人</td>
        <td aligin="center" valign="middle"><input type="text" name="recipient"></td>
    </tr>
	<tr>
		<td align="left" valign="middle" class="two">身份</td>
			<td>
			<input name="shenfen" type="radio" value="1" checked >学生 
			<input name="shenfen" type="radio" value="2" >教师
			</td>
	</tr>
    <tr>
        <td aligin="center" valign="middle" class="two">内容</td>
        <td aligin="center" valign="middle"><textarea rows="10" cols="30" name="detail"></textarea></td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td aligin="center" valign="middle">
            <input type="submit" name="publish" value="发布">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input name="Reset" type="reset" value="重置">
        </td>
    </tr>
</table>
</form>
    <br>
    <br>    
    <div style="width:100%;text-align:center;">
    <input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回上一页">
	</div>
</body>
</html>