<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.ExamInfo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dao.QualificationDAO"%>
<%@ page import="dto.Login"%>
<%@ page import="dto.StudentsInfo" %>
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
			ArrayList<StudentsInfo> qualiStuList = (ArrayList<StudentsInfo>)request.getAttribute("qualiList");
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
			</ul>
		</nav>
	</header>





	<center>
		<h3>生徒の受験状況の確認や更新が出来ます。</h3>

		<table class="table">
			<thead class="scrollHead">
				<tr>
					<th>氏名</th>
					<th>学年</th>
					<th>クラス</th>
					<th>資格名</th>
					<th>分類</th>
					<th>主催</th>
					<th>受験日</th>
					<th>結果</th>
					<th>更新</th>
					<th>削除</th>
				</tr>
			</thead>
			<tbody class="scrollBody">
				<%
					for (StudentsInfo si : qualiStuList) {
				%>
				<tr>
					<td><%=si.getStuName()%></td>
					<td><%=si.getStuYear()%></td>
					<td><%=si.getStuClass()%></td>
					<td><%=si.getQualiName()%></td>
					<td><%=si.getBunruiName()%></td>
					<td><%=si.getDantaiName()%></td>
					<td><%=si.getQualiDate()%></td>
					<td><%=si.getSucces()%></td>
					<td><form action="/QualificationManagement/UpdateQualiData" method="get"><button type="submit" name="update" value=<%=si.getExaId()%>>✎</button></form></td>
					<td><form action="/QualificationManagement/DeleteQualiData" method="get"><button type="submit" name="delete" value=<%=si.getExaId()%>>🗑️</button></form></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<br>
</body>
</html>
