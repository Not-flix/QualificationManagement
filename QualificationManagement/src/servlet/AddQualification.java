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
 * Servlet implementation class AddQualification
 */
@WebServlet("/AddQualification")
public class AddQualification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddQualification() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("qualiList", QualificationDAO.getAllQualification());
		request.setAttribute("bunruiList", QualificationDAO.getAllBunrui());
		request.setAttribute("dantaiList", QualificationDAO.getAllDantai());

		String view = "/WEB-INF/view/addqualification.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//formに入力された値を取得
		request.setCharacterEncoding("UTF-8");
		String addQualiName = request.getParameter("addQuali");
		String bunruiName = request.getParameter("bunrui");
		String dantaiName = request.getParameter("dantai");

		//入力された分類がＤＢに存在していない場合bunruiテーブルに登録する
		if(!(QualificationDAO.checkBunrui(bunruiName))){
			QualificationDAO.insertBunrui(bunruiName);
		}
		//分類ＩＤを取得
		int bunruiId = QualificationDAO.getBunruiId(bunruiName);

		//入力された団体がＤＢに存在していない場合dantaiテーブルに登録する
		if(!(QualificationDAO.checkDantai(dantaiName))){
			QualificationDAO.insertDantai(dantaiName);
		}
		//団体ＩＤを取得
		int dantaiId = QualificationDAO.getDantaiId(dantaiName);

		//取得した値をもとに資格登録処理
		QualificationDAO.insertQualification(addQualiName, bunruiId, dantaiId);


		doGet(request, response);
	}

}
