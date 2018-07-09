package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QualificationDAO;

/**
 * Servlet implementation class ExaRegister
 */
@WebServlet("/ExaRegister")
public class ExaRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExaRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("qualiNameList", QualificationDAO.getAllQualiName());

		String view = "/WEB-INF/view/exaregister.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//formに入力された値を取得
		request.setCharacterEncoding("UTF-8");
		//学生ID
		int studentId = Integer.parseInt(request.getParameter("stuId"));
		//資格ID
		int qualiNo = Integer.parseInt(request.getParameter("qualiName"));
		//資格年月日
		String year = request.getParameter("qualiYear");
		String month = request.getParameter("qualiMonth");
		String day = request.getParameter("qualiDay");
		String qualiDate = year.concat("/").concat(month).concat("/").concat(day);	//結合
		//合否
		String succes = request.getParameter("succes");

		//データの挿入
		QualificationDAO.insertExamination(studentId, qualiNo, qualiDate, succes);

		//遷移先で資格名一覧を使用するため
		request.setAttribute("qualiNameList", QualificationDAO.getAllQualiName());

		String view = "/WEB-INF/view/exaregister.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
