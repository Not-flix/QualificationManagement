<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録：資格管理システム</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/QualificationManagement.css">
</head>
<body>
	<header>
		<h1>
			<img src="./img/資格管理.png" width="210" height="60" alt="ヘッダー">
		</h1>
	</header>

	<center>
		<table width="100%">
			<tr>
				<td align="center" bgcolor="#E6E6FA"><font color="black"><b>REGISTER</b></font>
				</td>
			</tr>
		</table>
		<br>アカウントの作成に必要な情報を入力してください。<br> <br>


	<form action="/QualificationManagement/Top" method="post">
	　　氏：<input type="text" name="myoji">
	  　名：<input type="text" name="name"><br><br>
		学年<select name="year">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			</select>
			クラス<select name="class">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			</select><br><br>
		性別:
		男<input type="radio" name="gender" value="男">
		女<input type="radio" name="gender" value="女"><br><br>
	　　パスワード：<input type="password" name="pass1"><br>
	パスワード(再)：<input type="password" name="pass2"><br>
	<br><br>
	<input type="submit" value="アカウント登録" style="WIDTH: 107px; HEIGHT: 35px;"><br><br><br>
	<a href="javascript:history.go(-1)">[戻る]</a>
	</form>
	<br><br>
		<hr>
</body>
</html>