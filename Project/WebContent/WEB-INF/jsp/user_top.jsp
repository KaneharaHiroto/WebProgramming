<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
 <link  rel="stylesheet" type="text/css" href="style.css">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

 <title>ユーザー一覧</title>
</head>
<body>
<div class="alert alert-dark" role="alert">
  <p class="right">ユーザー名さん　　　
    <span>
    	<a  class="colorred"  href="file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/login_manu.html">ログアウト</a>
    </span>
  </p>
</div>
<div class="container">
	<h1 class="userfile">ユーザー一覧</h1>
	<div class="sinki">
	<a href="file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/user_sinki.html">新規登録</a>
	</div>
	<form action="UTF-8" method="post">
	<div class="userfile">
	ログインID　　　　<input type="text" name="searth" size="44"><br>
	<br>
	ユーザー名　　　　<input type="text" name="searth" size="44"><br>
	<br>
	生年月日　　　　　<input type="date" name="searth" size="10">～<input type="date" name="searth" size="10"><br>
	</div>
	<br>
	<div class="right">
	<button type="button" class="btn btn-secondary btn-sm">検索</button>
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
    <tr>
      <th scope="row">id0001</th>
      <td>田中太郎</td>
      <td>1989年04月26日</td>
      <td><a class="btn btn-primary" href="file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/userjouhou.html" role="button">詳細</a>　
      	<a class="btn btn-success" href="file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/userkousin.html" role="button">更新</a>　
      	<a class="btn btn-danger" href="file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/user_delete.html" role="button">削除</a></td>
    </tr>
    <tr>
      <th scope="row">id0002</th>
      <td>佐藤二郎</td>
      <td>2001年11月12日</td>
      <td><a class="btn btn-primary" href="file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/userjouhou.html" role="button">詳細</a>　
      	<a class="btn btn-success" href="file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/userkousin.html" role="button">更新</a>　
      	<a class="btn btn-danger" href="file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/user_delete.html" role="button">削除</a></td>
    </tr>
    <tr>
      <th scope="row">id0003</th>
      <td>佐川真司</td>
      <td>2000年01月01日</td>
       <td><a class="btn btn-primary" href="file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/userjouhou.html" role="button">詳細</a>　
       	<a class="btn btn-success" href="file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/userkousin.html" role="button">更新</a>　
       	<a class="btn btn-danger" href="file:///C:/Users/user/Documents/WebProgramming/Mock/WebContent/user_delete.html" role="button">削除</a></td>
    </tr>
  </tbody>
</table>

</body>
</html>