<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<div>
<div>
	<form method="post" action="/reservation/authenticate">
	<div>
	<label>ID</label>
	<input type="text" name="userId">
	</div>
	<div>
	<label>Password</label>
	<input type="text" name="password">
	</div>
	<div>
	<label></label>
	<input type="submit" value="로그인">
	</div>
	</form>
</div>
</div>
</body>
</html>