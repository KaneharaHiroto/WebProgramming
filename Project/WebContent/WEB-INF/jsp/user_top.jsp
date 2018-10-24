<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
 <link  rel="stylesheet" type="text/css" href="style.css">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
 <title>ユーザー一覧</title>
</head>
<body>
<div class="alert alert-dark" role="alert">
  <p class="right">${userInfo.name} さん　　　
    <span>
    	<a  class="colorred"  href="Logout">ログアウト</a>
    </span>
  </p>
</div>
<div class="container">
	<h1 class="userfile">ユーザー一覧</h1>
	 <c:if test="${userInfo.login_id=='admin'}">
	  <div class="sinki">
	   <a href="sinki">新規登録</a>
	  </div>
	  </c:if>
	<form action="top" method="post">
	 <div class="userfile">
	 ログインID　　　　<input type="text" name="login_id" size="44"><br>
	 <br>
	 ユーザー名　　　　<input type="text" name="name" size="44"><br>
	 <br>
	 生年月日　　　　　<input type="date" name="rowdate" size="10">～<input type="date" name="highdate" size="10"><br>
	</div>
	<br>
	 <div class="right">
	  <button type="submit" class="btn btn-secondary btn-sm">検索</button>
	 </div>
</form>
</div>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">ログインID</th>
      <th scope="col">ユーザー名</th>
      <th scope="col">生年月日</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
   <c:if test="${userInfo.login_id=='admin'}">
    <c:forEach var="user" items="${userList}" >
     <tr>
      <td scope="row">${user.login_id}</td>
      <td>${user.name}</td>
      <td>${user.birthDate}</td>
      <td>
        <a class="btn btn-primary" href="jougou?id=${user.id}" role="button">詳細</a>
       	<a class="btn btn-success" href="koushin?id=${user.id}" role="button">更新</a>
       	<a class="btn btn-danger"  href="Delete?id=${user.id}" role="button">削除</a>
      </td>
     </tr>
    </c:forEach>
   </c:if>
   <c:if test="${userInfo.login_id!='admin'}">
    <c:forEach var="user" items="${userList}" >
     <tr>
      <td scope="row">${user.login_id}</td>
      <td>${user.name}</td>
      <td>${user.birthDate}</td>
      <c:if test="${user.id!=1}">
       <td>
        <a class="btn btn-primary" href="jougou?id=${user.id}" role="button">詳細</a>
         <c:if test="${user.login_id==userInfo.login_id}">
       	  <a class="btn btn-success" href="koushin?id=${user.id}" role="button">更新</a>
         </c:if>
       </td>
      </c:if>
     </tr>
    </c:forEach>
   </c:if>
  </tbody>
</table>

</body>
</html>