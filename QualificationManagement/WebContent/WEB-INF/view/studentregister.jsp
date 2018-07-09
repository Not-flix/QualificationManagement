<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録：資格管理システム</title>
</head>
<body>

<center>
<br>
		<table width="100%">
			<tr>
				<td align="center" bgcolor="#2b1872"><font color="#ffffff"><b>REGISTER</b></font>
				</td>
			</tr>
		</table>
		<br>アカウントの作成に必要な情報を入力してください。<br> <br>


	<form action="/QualificationManagement/Top" method="post">
	　　氏：<input type="text" name="myoji">　名：<input type="text" name="name"><br>
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
			</select><br>
		性別:
		男<input type="radio" name="gender" value="男">
		女<input type="radio" name="gender" value="女"><br>
	　　パスワード：<input type="password" name="pass1"><br>
	パスワード(再)：<input type="password" name="pass2"><br>
	<br><br>
	<input type="submit" value="アカウント登録" style="WIDTH: 110px; HEIGHT: 38px;">
	</form>
	<br><br><br><br><br><br><br><br>
		<hr>
</body>
</html>