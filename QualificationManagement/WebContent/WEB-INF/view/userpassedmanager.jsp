<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.PassedInfo"%>
<%@ page import="dto.Bunrui" %>
<%@ page import="dto.Dantai" %>
<%@ page import="dto.Qualification"%>
<%@ page import="dto.Login"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>試験合格者：資格管理システム</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/QualificationManagement.css">
</head>
<body onLoad="functionName()">
	<%
		request.setCharacterEncoding("UTF-8");
		ArrayList<PassedInfo> userPassed = (ArrayList<PassedInfo>) session.getAttribute("passedUserList");
		ArrayList<Qualification> qualiNameList = (ArrayList<Qualification>) request.getAttribute("qualiNameList");
		ArrayList<Bunrui> bunruiList = (ArrayList<Bunrui>) request.getAttribute("bunruiList");
		ArrayList<Dantai> dantaiList = (ArrayList<Dantai>) request.getAttribute("dantaiList");
		Login user = (Login) session.getAttribute("user");
	%>
	<script>
		function functionName() {
			var select1 = document.forms.formName.selectName1; //変数select1を宣言
			var select2 = document.forms.formName.selectName2; //変数select2を宣言

			select2.options.length = 0;

			if (select1.options[select1.selectedIndex].value == "q.quali_name") {
				<%
				int i = 0;
				for(Qualification qf : qualiNameList){
				%>

				select2.options[<%=i%>] = new Option("<%=qf.getQualiName()%>");

				<%
				i++;
				}
				%>
			}

			else if (select1.options[select1.selectedIndex].value == "b.bunrui_name") {
				<%
				int a = 0;
				for(Bunrui bi : bunruiList){
				%>

				select2.options[<%=a%>] = new Option("<%=bi.getBunruiName()%>");

				<%
				a++;
				}
				%>
			}

			else if (select1.options[select1.selectedIndex].value == "d.dantai_name") {
				<%
				int b = 0;
				for(Dantai di : dantaiList){
				%>

				select2.options[<%=b%>] = new Option("<%=di.getDantaiName()%>");

				<%
				b++;
				}
				%>
			}
		}
	</script>
	<header>

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
			</ul>
		</nav>
	</header>




	<center>
		<h3>試験合格者の一覧です。</h3>
		<a><font color="blue" style="bold" size="3">絞り込み検索も可能です。</font></a>

		<form name="formName" action="/QualificationManagement/PassedManager"
			method="post">
				<!--選択肢①-->
				<select name="selectName1" onChange="functionName()">
					<option value="q.quali_name">資格名</option>
					<option value="b.bunrui_name">分類</option>
					<option value="d.dantai_name">団体</option>
				</select>

				<!--選択肢②（選択肢①の項目によって変化）-->
				<select name="selectName2"></select>
			<input type="submit" value="検索！" style="WIDTH: 100px; HEIGHT: 30px;">
		</form><br>

		<table class="table">
			<thead class="scrollHead">
				<tr>
					<th>no.</th>
					<th>氏名</th>
					<th>資格名</th>
					<th>分類</th>
					<th>主催団体</th>
					<th>合格日</th>
				</tr>
			</thead>
			<tbody class="scrollBody">
				<%
					int j = 1;
					for (PassedInfo pi : userPassed) {
				%>
				<tr>
					<th><%=j%></th>
					<th><%=pi.getPassedName()%></th>
					<th><%=pi.getQualiName()%></th>
					<th><%=pi.getBunrui()%></th>
					<th><%=pi.getDantai()%></th>
					<th><%=pi.getQualiDate()%></th>

				</tr>

				<%
					j++;
					}
				%>
			</tbody>
		</table>
</body>
</html>