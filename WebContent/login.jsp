<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css" media="screen">
    .one{
        front-family:黑体;
        color:black;
    }
            /* 清除掉一些标签默认自带的 padding 和  margin*/
            * {
                padding: 0px;
                margin: 0px;
            }
            /* 用于设置DIV的位置*/
            .div_show {
                margin-left: 150px;
                margin-top: -200px;
            }
            .div_show2 {
                margin-left: 500px;
                margin-top: 200px;
            }
            /* 用于ul的款对，和显示的边框颜色，颜色为灰色
             在此处只设置了，ul的宽度，没有设置高度
             因为高度是随着li的变化而变化的
             */
            ul.topic_show {
                list-style: none;
                width: 249px;
                border: 1px solid #999;
            }
            /* 用于设置ul中标题大小，背景和颜色，以及字体大小
             */
            ul.topic_show  h3 {
                height: 30px;
                width: 249px;
                background: #111155;
                color: #FFFFFF;
                font-size: 14px;
            }
            /* 利用span和position的relative来设置ul中标题中的字的位置
             */
            ul.topic_show  h3 span {
                position: relative;
                left: 10px;
                top: 8px;
            }
            /* li中字体通知内容,以及li大小和背景图片的设置
             */
            ul.topic_show li {
                font-size: 12px;
                height: 25px;
                color: #555;
                border: 1px solid red;
                background: url("point.jpg") no-repeat;
                background-position: 10px 7px;
            }
            /* 利用span和relative来解决，li中字体的位置
             */
            ul.topic_show li  span {
                position: relative;
                left: 20px;
                top: 5px;
            }

        </style>
<script type="text/javascript">
	function check() {
		if (login.id.value == "") {
			alert("用户名不能为空！");
			login.id.focus();
			return false;
		} else if (login.pwd.value == "") {
			alert("密码不能为空！");
			login.pwd.focus();
			return;
		} else {
			login.submit();
		}
	}
	  var error ='<%=request.getParameter("error")%>';
	  if(error=='1'){
	   alert("登录失败!密码或用户名错误");
	  }
</script>
<meta charset="UTF-8">
<title>作业提交系统</title>
</head>
<body style="background:url(img/background.jpg)">
	<form name="login" action="login_Servlet" method="post">
		<div class="div_show2">
		<table align="center" >
			<caption>
			<h1 class="one">作业提交系统</h1>
			<p>
				<h1 class="one">登陆
			    <HR style="FILTER: alpha(opacity = 100%, finishopacity = 0%, style = 3)" width="100%" color=red SIZE=4>
			</h1>
			</caption>
			<tr>
				<td align="left" valign="middle" class="one">用户名：
				    <input name="id" type="text" size="30" maxlength="20">
				</td>
			</tr>
			<tr>
				<td align="left" valign="middle" class="one">密&nbsp;&nbsp;&nbsp;&nbsp;码：
				    <input name="pwd" type="password" size="30" maxlength="20">
				</td>
			</tr>
			<tr>
				<td align="left" valign="middle" class="one">身&nbsp;&nbsp;&nbsp;&nbsp;份：
				    <input name="shenfen" type="radio" value="1" class="one" checked>学生 
					<input name="shenfen" type="radio" value="2" class="one">教师
					<input name="shenfen" type="radio" value="3" class="one">管理员
				</td>
			</tr>
			<tr>
				<td align="center" valign="middle">
				    <input type="button" value="登录" name="denglu" onclick="check()" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="Reset" type="reset" value="重置">
				</td>
			</tr>
		</table>
		</div>
	</form>
	<div class="div_show">
            <ul class="topic_show">
                <h3><span>通知公告</span></h3>
                <li>
                    <span>关于五一放假的公告通知</span>
                </li>
                <li>
                    <span>关于论文答辩的公告通知</span>
                </li>
                <li>
                    <span>提醒同学们提交Java作业</span>
                </li>
                <li>
                    <span>关于Java作业的公告通知</span>
                </li>
                <li>
                    <span>关于XXXXXXXXX的公告通知</span>
                </li>
                <li>
                    <span>关于XXXXXXXXX的公告通知</span>
                </li>
                <li>
                    <span>关于XXXXXXXXX的公告通知</span>
                </li>

            </ul>

        </div>
	
</body>
</html>