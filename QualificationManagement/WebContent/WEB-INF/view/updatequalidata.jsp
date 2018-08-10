<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dao.QualificationDAO"%>
<%@ page import="dto.StudentsInfo"%>
<%@ page import="dto.Qualification"%>
<%@ page import="dto.Login" %>
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
			ArrayList<Qualification> qualiNameList = (ArrayList<Qualification>) request.getAttribute("qualiNameList");
			Login user = (Login) session.getAttribute("user");
		%>

	<script>
		function functionName() {
			var select1 = document.forms.formName.selectName1; //変数select1を宣言
			var select2 = document.forms.formName.selectName2; //変数select2を宣言
			select2.options.length = 0;

			//選択肢の中で「資格名」を選んだ場合
			if (select1.options[select1.selectedIndex].value == "quali_id") {
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

			//選択肢の中で「結果」を選んだ場合
			else if (select1.options[select1.selectedIndex].value == "succes") {
				select2.options[0] = new Option("合格");
				select2.options[1] = new Option("不合格");
			}
		}
	</script>

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
		<a>氏名：</a> <a><%=si.getStuName()%></a> <br> <a>資格名：</a> <a><%=si.getQualiName()%></a>
		<br> <a>受験日：</a> <a><%=si.getQualiDate()%></a> <br> <a>結果：</a>
		<a><%=si.getSucces()%></a> <br><br><br>


		<%
			int examId = si.getExaId();
			request.setAttribute("updateId", examId);
		%>

		<form name="formName" action="/QualificationManagement/UpdateQualiData" method="post">

		<!--選択肢①-->
				更新項目：<select name="selectName1" onChange="functionName()">
					<option value="quali_id">資格名</option>
					<option value="succes">結果</option>
				</select><br><br>

				<!--選択肢②（選択肢①の項目によって変化）-->
				更新内容：<select name="selectName2"></select><br><br>
				<input type="hidden" name="examid" value=<%=examId %>>
				<input type="submit" value="更新" onClick="alert('1件の受験情報を更新しました。');">
		</form>

			<br><br><br>

</body>
</html>