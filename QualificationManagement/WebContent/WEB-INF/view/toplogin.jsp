<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="servlet.Top"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン：資格管理システム</title>
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
				<td align="center" bgcolor="#E6E6FA"><font color="BLACK"><b>LOGIN</b></font>
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
			氏：<input type="text" name="myoji">
			名：<input type="text" name="name"> <br><br>
			パスワード：<input type="password" name="pass"><br><br><br>
			<input type="submit" value="ログイン" style="WIDTH: 100px; HEIGHT: 35px;">
		</form>
		<br> <br> 初めてのご利用ですか？<a
			href="/QualificationManagement/StudentRegister">新規登録はこちら</a> <br>
		<br> <br> <br> <br> <br> <br> <br>
		<hr>
</body>
</html>