package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QualificationDAO;

/**
 * Servlet implementation class TopLogin
 */
@WebServlet("/Top")
public class Top extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int registFlg = 0;
	public static boolean flag = true;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Top() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/view/toplogin.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//formに入力された値を取得
		request.setCharacterEncoding("UTF-8");
		String stuMyoji = request.getParameter("myoji");
		String stuName = request.getParameter("name");
		String fullName = stuMyoji.concat(stuName);
		int stuYear = Integer.parseInt(request.getParameter("year"));
		int stuClass = Integer.parseInt(request.getParameter("class"));
		String gen = request.getParameter("gender");
		String pass = request.getParameter("pass1");

		//入力した2つのパスワードが一致していた場合
		if(request.getParameter("pass1").equals(request.getParameter("pass2"))){

			//studentsテーブルへデータを格納
			QualificationDAO.insertStudent(fullName, stuYear, stuClass, gen, pass);

			String view = "/WEB-INF/view/toplogin.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);

		//入力した2つのパスワードが一致しなかった場合
		} else {
			//エラーアラートの表示
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.println("<script>");
			printWriter.println("alert('入力した2つのパスワードが一致しませんでした。');");		//アラート表示
			printWriter.println("history.go(-1)");											//前のページに戻るスクリプト
			printWriter.println("</script>");

		}
	}

}
