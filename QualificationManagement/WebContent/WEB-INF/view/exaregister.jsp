<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Qualification"%>
<%@ page import="dto.Login"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>受験情報登録：資格管理システム</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/QualificationManagement.css">
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		ArrayList<Qualification> qualiNameList = (ArrayList<Qualification>) request.getAttribute("qualiNameList");
		Login user = (Login) session.getAttribute("user");
	%>

	<header>

		<h1>
			<img src="./img/資格管理.png" width="210" height="60" alt="ヘッダー">
		</h1>
		<nav>
			<ul>
				<li><a href="/QualificationManagement/QualiHistory"><img
						src="./img/受験履歴.png" width="170" height="60" alt="受験履歴"></a></li>
				<li><a href="/QualificationManagement/Passed"><img
						src="./img/試験合格者.png" width="170" height="60" alt="試験合格者"></a></li>
				<li><a href="/QualificationManagement/AllHistory"><img
						src="./img/掲示板.png" width="170" height="60" alt="掲示板"></a></li>
			</ul>
		</nav>
	</header>

	<center>
		<table width="100%">
			<tr>
				<td align="center" bgcolor="#E6E6FA"><font color="black"><b>受験した資格の情報を入力してください。</b></font>
				</td>
			</tr>
		</table><br>

		<form action="/QualificationManagement/ExaRegister" method="post">

			<input type="hidden" name="stuId" value=<%=user.getStuId()%>>

			<b><font size="3" style="bold">資格名</font></b><br><br>
			<select name="qualiName">
				<%
				for(Qualification qf : qualiNameList){
				%>
				<option value=<%=qf.getQualiNo() %>><%=qf.getQualiName() %></option>
				<%} %>
			</select><br><br>

			<b><font size="3" style="bold">受験日</font></b><br><br>
			年：<select name="qualiYear">
			<%for(int i = 2000; i <= 2018; i++) {%>
			<option value=<%=i %>><%=i %></option>
			<%} %>
			</select>

			　月：<select name="qualiMonth">
			<%for(int i = 1; i <= 12; i++) {%>
			<option value=<%=i %>><%=i %></option>
			<%} %>
			</select>

			　日：<select name="qualiDay">
			<%for(int i = 1; i <= 31; i++) {%>
			<option value=<%=i %>><%=i %></option>
			<%} %>
			</select><br><br>

			<b><font size="3" style="bold">結果</font></b><br><br>
			<select name="succes">
			<option value="合格">合格</option>
			<option value="不合格">不合格</option>
			</select>

			 <br><br><br>
			 <input type="submit" value="受験情報登録" style="WIDTH: 110px; HEIGHT: 40px;">
		</form>
</body>
</html>