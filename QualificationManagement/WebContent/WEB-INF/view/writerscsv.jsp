<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.Login" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ファイル出力完了：資格管理システム</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/QualificationManagement.css">
</head>
<body>
	<header>

		<%
			request.setCharacterEncoding("UTF-8");
			Login user = (Login) session.getAttribute("user");
		%>

		<h1>
			<img src="./img/資格管理.png" width="210" height="60" alt="ヘッダー">
		</h1>
		<nav>
			<ul>
				<li><a href="/QualificationManagement/ManagerTop"><img
						src="./img/受験状況.png" width="170" height="60" alt="受験状況"></a></li>
				<li><a href="/QualificationManagement/Passed"><img
						src="./img/試験合格者.png" width="170" height="60" alt="試験合格者"></a></li>
				<li><a href="/QualificationManagement/AddQualification"><img
						src="./img/資格追加.png" width="170" height="60" alt="資格追加"></a></li>
				<li>　　<a><%=user.getStuName() %>さん、ログイン中</a><br>
						<form>　　　　　　 　　<button type="button" onClick="location.href='/QualificationManagement/LogOut'">ログアウト</button></form></li>
			</ul>
		</nav>
	</header>

	<center>
	<a>CSVファイル出力完了</a><br>
	<a href="javascript:history.go(-1)">[戻る]</a>
</body>
</html>