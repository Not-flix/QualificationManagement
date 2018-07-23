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
 * Servlet implementation class ShowQualiData
 */
@WebServlet("/ShowQualiData")
public class ShowQualiData extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowQualiData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//教員用の資格情報確認画面で「学年」を選択した場合
		if(request.getParameter("year") != null){
			int year = Integer.parseInt(request.getParameter("year"));
			request.setAttribute("qualiList", QualificationDAO.getYearInfo(year));

		//教員用の資格情報確認画面で「クラス」を選択した場合
		} else if(request.getParameter("class") != null){
			String[] yearClass = request.getParameter("class").split(",");
			int year = Integer.parseInt(yearClass[0]);
			int cls = Integer.parseInt(yearClass[1]);
			request.setAttribute("qualiList", QualificationDAO.getClassInfo(cls, year));

		//教員用の資格情報確認画面で「全生徒」を選択した場合
		} else {
			request.setAttribute("qualiList", QualificationDAO.getStudentsInfo());
		}

		String view = "/WEB-INF/view/showqualidata.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
