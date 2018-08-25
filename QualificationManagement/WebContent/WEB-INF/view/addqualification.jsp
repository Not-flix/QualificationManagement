<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Login" %>
<%@ page import="dto.Qualification" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Bunrui" %>
<%@ page import="dto.Dantai" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資格追加：資格管理システム</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/QualificationManagement.css">
</head>
<body>
<header>
		<%
			request.setCharacterEncoding("UTF-8");
			ArrayList<Qualification> qualiList = (ArrayList<Qualification>)request.getAttribute("qualiList");
			ArrayList<Bunrui> bunruiList = (ArrayList<Bunrui>)request.getAttribute("bunruiList");
			ArrayList<Dantai> dantaiList = (ArrayList<Dantai>)request.getAttribute("dantaiList");
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
		<h3>現在システムに登録されている資格の一覧です。</h3>

		<table class="table">
			<thead class="scrollHead">
				<tr>
					<th>no.</th>
					<th>資格名</th>
					<th>分類</th>
					<th>団体</th>
				</tr>
			</thead>
			<tbody class="scrollBody">
				<%
					int i = 1;
					for (Qualification qc : qualiList) {
				%>
				<tr>
					<th><%=i%></th>
					<th><%=qc.getQualiName()%></th>
					<th><%=qc.getBunruiName()%></th>
					<th><%=qc.getDantaiName()%></th>
				</tr>
				<%
					i++;
					}
				%>
			</tbody>
		</table>
		<br><br>

		<form method="post" action="/QualificationManagement/AddQualification">
		追加資格：<input type="text" name="addQuali">
		分類名：<input type="text" name="bunrui" list="bunruiList" placeholder="リストに無い場合はテキスト入力" autocomplete="off">
  			<datalist id="bunruiList">
  			<%for(Bunrui bunrui : bunruiList){ %>
  　		<option value=<%=bunrui.getBunruiName() %>>>
  			<%} %>>
  		</datalist>
  		団体名：<input type="text" name="dantai" list="dantaiList" placeholder="リストに無い場合はテキスト入力" autocomplete="off">
  			<datalist id="dantaiList">
  			<%for(Dantai dantai : dantaiList){ %>
  　		<option value=<%=dantai.getDantaiName() %>>>
  			<%} %>>
  		</datalist><br><br>
  		<input type="submit" value="新規登録" style="WIDTH: 120px; HEIGHT: 35px;" onClick="alert('1件の資格情報を登録しました。');">
		</form>

</body>
</html>