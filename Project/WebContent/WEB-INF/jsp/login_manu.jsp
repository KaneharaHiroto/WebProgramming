<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link  rel="stylesheet" type="text/css" href="style.css">
<title>ログイン画面</title>
</head>
<body>
<div class="userfile">
	<h1 >ログイン画面</h1>
	<br>
	<c:if test="${errMsg != null}" >
		<div class="alert alert-danger" role="alert">
		${errMsg}
		</div>
	</c:if>
	 <br>
	 <br>
	 <br>
	  <form class="form_singin" action="login" method="post">
	  ログインID　　　　<input type="text" name="login_id" size="30">
	  <br>
	  <br>
	  <br>
	  パスワード　　　　<input type="password" name="password" size="30" maxlength="8">
	  <br>
	  <br>
	  <br>
	  <input type="submit" value="ログイン">
	</form>
</div>
</body>
</html>