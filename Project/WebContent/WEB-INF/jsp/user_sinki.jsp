<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link  rel="stylesheet" type="text/css" href="style.css">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>ユーザー新規登録</title>
</head>
<body>
<div class=userfile>
	<h1 >ユーザー新規登録</h1>
	<br>
	<br>
	<br>
	<br>
 	<form action="UTF-8" method="post">
		ログインID　　　　<input type="text" name="searth" size="44">
		<br>
		<br>
		パスワード　　　　<input type="password" name="pass" size="44" maxlength="8">
		<br>
		<br>
		パスワード（確認）<input type="password" name="pass" size="44" maxlength="8">
		<br>
		<br>
		ユーザー名　　　　<input type="text" name="searth" size="44"><br>
		<br>
		<br>
		生年月日　　　　　<input type="date" name="searth" size="44">
		<br>
		<br>
		<br>
		<input type="submit" onclick="location.href='file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/user_top.html'"value="登録">
		<br>
		<br>
	</form>

	<span class="text-primary" >
	<a href="file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/user_top.html">戻る</a>
	</span>
</div>

</body>
</html>