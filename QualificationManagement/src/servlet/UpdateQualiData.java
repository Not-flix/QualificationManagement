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
 * Servlet implementation class UpdateQualiData
 */
@WebServlet("/UpdateQualiData")
public class UpdateQualiData extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQualiData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int updateKey = Integer.parseInt(request.getParameter("update"));
		request.setAttribute("examination", QualificationDAO.searchExam(updateKey));
		request.setAttribute("qualiNameList", QualificationDAO.getAllQualiName());

		String view = "/WEB-INF/view/updatequalidata.jsp";
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
		int examId = Integer.parseInt(request.getParameter("examid"));
		if("quali_id".equals(item)){
			condition = String.valueOf(QualificationDAO.getQualiNo(condition));
		}
		QualificationDAO.updateExamList(item, condition, examId);

		//前のページに戻る処理
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<script>");
		printWriter.println("history.go(-2)");					//前のページに戻るスクリプト
		printWriter.println("window.location.reload(true);");		//ページのリロード
		printWriter.println("</script>");

	}

}
