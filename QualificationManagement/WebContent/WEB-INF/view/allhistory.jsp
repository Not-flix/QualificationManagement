<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.ExamInfo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dao.QualificationDAO" %>
<%@ page import="dto.Login"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>受験履歴：資格管理システム</title>
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
				<li><a href="/QualificationManagement/QualiHistory"><img
						src="./img/受験履歴.png" width="170" height="60" alt="受験履歴"></a></li>
				<li><a href="/QualificationManagement/Passed"><img
						src="./img/試験合格者.png" width="170" height="60" alt="試験合格者"></a></li>
			</ul>
		</nav>
	</header>





	<center>
		<h3><%=user.getStuName()%>さんの受験履歴です。
		</h3>

		<table class="table">
			<thead class="scrollHead">
				<tr>
					<th>no.</th>
					<th>資格名</th>
					<th>分類</th>
					<th>主催団体</th>
					<th>受験日</th>
					<th>結果</th>
				</tr>
			</thead>
			<tbody class="scrollBody">
				<%

				%>
				<tr>

				</tr>

				<%

				%>
			</tbody>
		</table><br><br>

			<input type="button" class="button" value="受験データを新たに登録" onclick="location.href='/QualificationManagement/ExaRegister'" style="WIDTH: 200px; HEIGHT: 50px;">
</body>
</html>