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
		<h3>各学年・クラスの受験状況の確認や更新が出来ます。</h3>

		<table>
			<tr>
				<td rowspan="16"><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit">全生徒</button></form></td>
				<td rowspan="4"><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="year" value=1>１年</button></form></td>
				<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=1,1>１組</button></form></td>
			</tr>
			<tr>
			<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=1,2>２組</button></form></td>
			</tr>
			<tr>
			<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=1,3>３組</button></form></td>
			</tr>
			<tr>
			<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=1,4>４組</button></form></td>
			</tr>
			<tr>
			<td rowspan="4"><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="year" value=2>２年</button></form></td>
			<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=2,1>１組</button></form></td>
			</tr>
			<tr>
			<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=2,2>２組</button></form></td>
			</tr>
			<tr>
			<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=2,3>３組</button></form></td>
			</tr>
			<tr>
			<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=2,4>４組</button></form></td>
			</tr>
			<tr>
			<td rowspan="4"><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="year" value=3>３年</button></form></td>
			<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=3,1>１組</button></form></td>
			</tr>
			<tr>
			<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=3,2>２組</button></form></td>
			</tr>
			<tr>
			<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=3,3>３組</button></form></td>
			</tr>
			<tr>
			<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=3,4>４組</button></form></td>
			</tr>
			<tr>
			<td rowspan="4"><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="year" value=4>４年</button></form></td>
			<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=4,1>１組</button></form></td>
			</tr>
			<tr>
			<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=4,2>２組</button></form></td>
			</tr>
			<tr>
			<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=4,3>３組</button></form></td>
			</tr>
			<tr>
			<td><form action="/QualificationManagement/ShowQualiData" method="get"><button type="submit" name="class" value=4,4>４組</button></form></td>
			</tr>
		</table>
		<br>
</body>
</html>