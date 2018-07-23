<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dao.QualificationDAO"%>
<%@ page import="dto.StudentsInfo" %>
<%@ page import="dto.Qualification" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>受験情報更新：資格管理システム</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/QualificationManagement.css">
</head>
<body>
	<header>

		<%
			request.setCharacterEncoding("UTF-8");
			StudentsInfo si = (StudentsInfo)request.getAttribute("examination");
			ArrayList<Qualification> qualiNameList = (ArrayList<Qualification>) request.getAttribute("qualiNameList");
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
				<li><a href="/QualificationManagement/AllHistory"><img
						src="./img/掲示板.png" width="170" height="60" alt="掲示板"></a></li>
			</ul>
		</nav>
	</header>

	<center>
		<a>氏名：</a> <a><%=si.getStuName()%></a> <br>
		<a>資格名：</a> <a><%=si.getQualiName()%></a> <br>
		<a>受験日：</a> <a><%=si.getQualiDate()%></a> <br>
		<a>結果：</a> <a><%=si.getSucces()%></a> <br>


	<%
		int examId = si.getExaId();
		request.setAttribute("updateId", examId);
	%>

	<form action="/QualificationManagement/UpdateQualiData" method="post">
	<a>更新項目：</a>
	<select name="updateData">
	<option value="qualiName">資格名</option>
	<option value="qualiDate">受験日</option>
	<option value="succes">結果</option>
	</select><br>
	更新後の値：<input type="text" name="updateName"><br>
	<input type="hidden" name="guitarId" value=<%=si.getExaId()%>>
	<input type="submit" value="更新">
	</form>


</body>
</html>