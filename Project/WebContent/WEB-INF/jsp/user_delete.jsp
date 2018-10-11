<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link  rel="stylesheet" type="text/css" href="style.css">
<title>ユーザー削除確認</title>
</head>
<body>
<div class="alert alert-dark" role="alert">
  <p class="right">ユーザー名さん　　　
    <span>
    	<a  class="colorred"  href="file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/login_manu.html">ログアウト</a>
    </span>
  </p>
</div>
  <div class="userfile">
  <h1 >ユーザー削除確認</h1>
  <br>
  <br>
  <div class="txt">
  <p>ログインID:id0001</p>
  <p>を本当に削除してもよろしいでしょうか。</p>
  </div>
  <br>
  <br>
  <br>
  <br>
  <br>
  <p><input type="button" onclick="location.href='file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/user_top.html'"value="キャンセル">
  <input type="submit" onclick="location.href='file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/user_top.html'"value="OK">
  </p>
  </div>
</body>
</html>