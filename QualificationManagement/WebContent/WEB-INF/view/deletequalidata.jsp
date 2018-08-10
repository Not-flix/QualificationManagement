<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dao.QualificationDAO"%>
<%@ page import="dto.StudentsInfo"%>
<%@ page import="dto.Login" %>
<%@ page import="dto.Qualification"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>受験情報更新：資格管理システム</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/QualificationManagement.css">
</head>
<body onLoad="functionName()">
	<header>

		<%
			request.setCharacterEncoding("UTF-8");
			StudentsInfo si = (StudentsInfo) request.getAttribute("examination");
			Login user = (Login) session.getAttribute("user");
		%>


		<h1>
			<img src="./img/資格管理.png" width="210" height="60" alt="ヘッダー">
		</h1>
		<nav>
			<ul>
				<li><a href="/QualificationManagement/ManagerTop"><img
						src="./img/受験状況.png" width="170" height="60" alt="受験状況"></a></li>
				<li><a href="/QualificationManagement/PassedManager"><img
						src="./img/試験合格者.png" width="170" height="60" alt="試験合格者"></a></li>
				<li><a href="/QualificationManagement/AddQualification"><img
						src="./img/資格追加.png" width="170" height="60" alt="資格追加"></a></li>
				<li>　　<a><%=user.getStuName() %>さん、ログイン中</a><br>
						<form>　　　　　　 　　<button type="button" onClick="location.href='/QualificationManagement/LogOut'">ログアウト</button></form></li>
			</ul>
		</nav>
	</header>

	<center>
	<a>このデータを削除しますか?</a><br><br>
	<a>氏名：</a> <a><%=si.getStuName() %></a><br>
	<a>資格名：</a> <a><%=si.getQualiName() %></a><br>
	<a>受験日：</a> <a><%=si.getQualiDate() %></a><br>
	<a>結果：</a> <a><%=si.getSucces() %></a><br>

	<form action="/QualificationManagement/DeleteQualiData" method="post">
	<input type="hidden" name="examId" value=<%=si.getExaId() %>>
	<input type="submit" value="削除" onClick="alert('1件の受験情報を削除しました。');">
	</form>

</body>
</html>
