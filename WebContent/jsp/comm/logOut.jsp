<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
}

#d11 {
	margin-left: 470px;
	float: left;
}

#d22 {
	float: left;
}

p {
	font-size: 18px;
}
</style>
</head>
<body>
	<div id="d11">
		<img alt="" src="<%=request.getContextPath() %>/img/sorry.gif ">
	</div>
	<div id="d22">
		<p>对不起，您尚未登陆！</p>
		<p>如果您尚未注册，请先注册后登录！</p>
		<p>谢谢合作！</p>
	</div>
</body>
</html>