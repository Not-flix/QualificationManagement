<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="servlet.Top"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン：資格管理システム</title>

</head>
<body>


	<center>
		<table width="100%">
			<tr>
				<td align="center" bgcolor="#2b1872"><font color="#ffffff"><b>LOGIN</b></font>
				</td>
			</tr>
		</table>
		<br>氏名、パスワードを入力してください。<br> <br>


		<%
			if (Top.registFlg == 1) {
		%>
		<script>
			alert("ユーザー登録に成功しました。");
		</script>
		<%
			}
			Top.registFlg = 0;
		%>

		<form action="/QualificationManagement/QualiHistory" method="post">
			氏：<input type="text" name="myoji"> 名：<input type="text"
				name="name"><br> パスワード：<input type="password"
				name="pass"><br>
			<br> <input type="submit" value="ログイン">
		</form>
		<br>
		<br> 初めてのご利用ですか？<a
			href="/QualificationManagement/StudentRegister">新規登録はこちら</a> <br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<hr>
</body>
</html>