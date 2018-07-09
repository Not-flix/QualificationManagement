package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QualificationDAO;

/**
 * Servlet implementation class Passed
 */
@WebServlet("/Passed")
public class Passed extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Passed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("passedList", QualificationDAO.getPassedList());
		request.setAttribute("qualiNameList", QualificationDAO.getAllQualiName());
		request.setAttribute("bunruiList", QualificationDAO.getAllBunrui());
		request.setAttribute("dantaiList", QualificationDAO.getAllDantai());

		String view = "/WEB-INF/view/passed.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String item = request.getParameter("selectName1");
		String condition = request.getParameter("selectName2");
		HttpSession session = request.getSession();
		session.setAttribute("passedUserList", QualificationDAO.getUserPassedList(item, condition));
		response.sendRedirect("http://localhost:8080/QualificationManagement/UserPassed");
	}

}
