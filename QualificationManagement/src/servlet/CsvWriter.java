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
 * Servlet implementation class CsvWriter
 */
@WebServlet("/CsvWriter")
public class CsvWriter extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsvWriter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] csvArgument =request.getParameterValues("csvArg");

		//1クラス分の受験情報をCSVファイルへ出力
		if(!("null".equals(csvArgument[0])) && !("null".equals(csvArgument[1]))){
			QualificationDAO.writersCSV(Integer.parseInt(csvArgument[1]), Integer.parseInt(csvArgument[0]));

		//1学年分の受験情報をCSVファイルへ出力
		} else if(!("null".equals(csvArgument[0])) && "null".equals(csvArgument[1])){
			QualificationDAO.writersCSV(Integer.parseInt(csvArgument[0]));

		//全生徒の受験情報をCSVファイルへ出力
		} else {
			QualificationDAO.writersCSV();
		}

		String view = "/WEB-INF/view/writerscsv.jsp";
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
