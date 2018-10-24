<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link  rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>ユーザー情報詳細</title>
</head>
<body>
<div class="alert alert-dark" role="alert">
  <p class="right">${userInfo.name}さん　　　
    <span>
    	<a  class="colorred"  href="Logout">ログアウト</a>
    </span>
  </p>
</div>
    <div class="userfile">
  <h1 >ユーザー情報詳細参照</h1>
  <div class="txt">
  <br>
  <br>

    <p>ログインID　　　　　　　　　　　　　　　　　　　　　${selectlist.login_id}</p>
    <br>
    <br>
    <p>ユーザー名　　　　　　　　　　　　　　　　　　　　　${selectlist.name}</p>
    <br>
    <br>
    <p>生年月日　　　　　　　　　　　　　　　　　　　　　　${selectlist.birthDate}</p>
    <br>
    <br>
    <p>登録日時　　　　　　　　　　　　　　　　　　　　　　${selectlist.createDate}</p>
    <br>
    <br>
   <p>更新日時　　　　　　　　　　　　　　　　　　　　　　${selectlist.updateDate}</p>
  </div>
  <br>
  <br>
	<span class="text-primary" >
	<a href="top">戻る</a></span>
	</div>
</body>
</html>