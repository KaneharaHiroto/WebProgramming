<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link  rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>ユーザー情報更新</title>
</head>
<body>
<div class="alert alert-dark" role="alert">
  <p class="right">${userInfo.name}さん　　　
    <span>
    	<a  class="colorred"  href="Logout">ログアウト</a>
    </span>
  </p>
</div>
<div class="container">
	<h1 class="userfile">ユーザー情報更新</h1>
	  <div class="txt">
	   <c:if test="${checkerr != null}" >
		 <div class="alert alert-danger" role="alert">
	      ${checkerr}
	    </div>
	   </c:if>
	  <c:if test="${Mserr != null}" >
	   <div class="alert alert-danger" role="alert">
	    ${Mserr}
       </div>
	  </c:if>
  <form action="koushin" method="post">
  <input type="hidden" value="${selectlist.id}" name="id">
  <br>
  <br>  <p>ログインID　　　　 ${selectlist.login_id}</p>
  <br>
  パスワード　　　　<input type="password" name="Password" size="44" maxlength="8">
  <br>
  <br>
  パスワード（確認）<input type="password" name="Passwordc" size="44" maxlength="8">
  <br>
  <br>
  ユーザー名　　　　<input type="text" name="name" size="44" value=${selectlist.name}><br>
  <br>
  <br>
  生年月日　　　　　<input type="date" name="birthDate" size="44" value=${selectlist.birthDate}>
  <br>
  <br>
  <br>
  	<span class="userfile">
	<input type="submit" value="更新">
	</span>
		<br>
		<br>
	</form>
	</div>
	<span class="text-primary" >
	<a href="top">戻る</a>
	</span>
	</div>
</body>
</html>