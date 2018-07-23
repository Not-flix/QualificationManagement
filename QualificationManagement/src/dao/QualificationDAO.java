package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Bunrui;
import dto.Dantai;
import dto.ExamInfo;
import dto.Login;
import dto.PassedInfo;
import dto.Qualification;
import dto.StudentsInfo;
import servlet.Top;

public class QualificationDAO {

	//ログイン処理
	public static Login login(String stuName){

		Login login = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qualification_management?useSSL=false",
					"nozomi",
					"nozomi01");

			String sql = "SELECT stu_id, stu_name, stu_pass FROM students WHERE stu_name = ?";

			pstmt = con.prepareStatement(sql);

			String sName = stuName;
			pstmt.setString(1,sName);
			rs = pstmt.executeQuery();
			rs.next();

			int studentId = rs.getInt("stu_id");
			String studentName = rs.getString("stu_name");
			String studentPass = rs.getString("stu_pass");
			login = new Login(studentId, studentName, studentPass);

		} catch (SQLException se){
			se.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return login;

	}

	//新規ユーザー登録処理
	public static void insertStudent(String studentName, int schoolYear, int schoolClass, String gender, String studentPass){
		Connection con = null;
		PreparedStatement pstmt = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qualification_management?useSSL=false",
					"nozomi",
					"nozomi01");

			String sql = "INSERT INTO students(stu_name, school_year, school_class, gender, stu_pass) VALUES(?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);

			String stuName = studentName;
			int sclYear = schoolYear;
			int sclClass = schoolClass;
			String gen = gender;
			String stuPass = studentPass;

			pstmt.setString(1, stuName);
			pstmt.setInt(2, sclYear);
			pstmt.setInt(3, sclClass);
			pstmt.setString(4, gen);
			pstmt.setString(5, stuPass);

			pstmt.executeUpdate();
			Top.registFlg = 1;

		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {

			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

	}

	//examinationテーブルの主キーをもとにした一件分の試験データを取得
	public static StudentsInfo searchExam(int key){

		StudentsInfo studentsInfo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qualification_management?useSSL=false",
					"nozomi",
					"nozomi01");

			String sql = "select e.exa_id, s.stu_name, q.quali_name, e.quali_date, e.succes"
					+ " from examination e "
					+ " inner join students s"
					+ " on e.stu_id = s.stu_id"
					+ " inner join qualification q"
					+ " on e.quali_id = q.quali_id"
					+ " where e.exa_id = ?";


			pstmt = con.prepareStatement(sql);
			int id = key;
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			rs.next();

			int examId = rs.getInt("e.exa_id");
			String stuName = rs.getString("s.stu_name");
			String qualiName = rs.getString("q.quali_name");
			String date = rs.getString("e.quali_date");
			String succes = rs.getString("e.succes");
			studentsInfo = new StudentsInfo(examId, stuName, qualiName, date, succes);

		} catch (SQLException se){
			se.printStackTrace();
		} catch (Exception e){

		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		return studentsInfo;

	}

	//ユーザーごとの全受験データを取得
	public static ArrayList<ExamInfo> getExamList(String stuName){

		ArrayList<ExamInfo> examList = new ArrayList<ExamInfo>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qualification_management?useSSL=false",
					"nozomi",
					"nozomi01");

			String sql = "SELECT q.quali_name, b.bunrui_name, d.dantai_name, e.quali_date, e.succes"
					+ " FROM qualification q"
					+ " INNER JOIN examination e"
					+ " ON q.quali_id = e.quali_id"
					+ " INNER JOIN students s"
					+ " ON s.stu_id = e.stu_id"
					+ " INNER JOIN bunrui b"
					+ " ON b.bunrui_id = q.bunrui_id"
					+ " INNER JOIN dantai d"
					+ " ON d.dantai_id = q.dantai_id"
					+ " WHERE s.stu_name = ?"
					+ " ORDER BY e.quali_date DESC";

			pstmt = con.prepareStatement(sql);
			String name = stuName;
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while(rs.next() == true){
				String qualiName = rs.getString("q.quali_name");
				String bunruiName = rs.getString("b.bunrui_name");
				String dantaiName = rs.getString("d.dantai_name");
				String date = rs.getString("e.quali_date");
				String succes = rs.getString("e.succes");

				examList.add(new ExamInfo(qualiName, bunruiName, dantaiName, date, succes));
			}


		} catch (SQLException se){
			se.printStackTrace();
		} catch (Exception e){

		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		return examList;

	}

	//全ての資格の合格情報を取得
	public static ArrayList<PassedInfo> getPassedList(){

		ArrayList<PassedInfo> passedList = new ArrayList<PassedInfo>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qualification_management?useSSL=false",
					"nozomi",
					"nozomi01");

			String sql = "select s.stu_name, q.quali_name, b.bunrui_name, d.dantai_name, e.quali_date"
					+ " from students s inner join examination e"
					+ " on s.stu_id = e.stu_id"
					+ " inner join qualification q "
					+ " on q.quali_id = e.quali_id "
					+ " inner join bunrui b"
					+ " on b.bunrui_id = q.bunrui_id "
					+ " inner join dantai d "
					+ " on d.dantai_id = q.dantai_id "
					+ " where e.succes = \"合格\""
					+ " ORDER BY e.quali_date DESC";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next() == true){
				String stuName = rs.getString("s.stu_name");
				String qualiName = rs.getString("q.quali_name");
				String bunruiName = rs.getString("b.bunrui_name");
				String dantaiName = rs.getString("d.dantai_name");
				String date = rs.getString("e.quali_date");

				passedList.add(new PassedInfo(stuName, qualiName, bunruiName, dantaiName, date));
			}


		} catch (SQLException se){
			se.printStackTrace();
		} catch (Exception e){

		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		return passedList;

	}

	//絞り込み検索の条件に合った資格合格者の取得
	public static ArrayList<PassedInfo> getUserPassedList(String item, String condition){

		ArrayList<PassedInfo> passedUserList = new ArrayList<PassedInfo>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qualification_management?useSSL=false",
					"nozomi",
					"nozomi01");

			String sql = "select s.stu_name, q.quali_name, b.bunrui_name, d.dantai_name, e.quali_date"
					+ " from students s inner join examination e"
					+ " on s.stu_id = e.stu_id"
					+ " inner join qualification q "
					+ " on q.quali_id = e.quali_id "
					+ " inner join bunrui b"
					+ " on b.bunrui_id = q.bunrui_id "
					+ " inner join dantai d "
					+ " on d.dantai_id = q.dantai_id "
					+ " where e.succes = \"合格\""
					+ "and " + item + " = ?";

			pstmt = con.prepareStatement(sql);
			String cdtn = condition;
			pstmt.setString(1, cdtn);
			rs = pstmt.executeQuery();

			while(rs.next() == true){
				String stuName = rs.getString("s.stu_name");
				String qualiName = rs.getString("q.quali_name");
				String bunruiName = rs.getString("b.bunrui_name");
				String dantaiName = rs.getString("d.dantai_name");
				String date = rs.getString("e.quali_date");

				passedUserList.add(new PassedInfo(stuName, qualiName, bunruiName, dantaiName, date));
			}


		} catch (SQLException se){
			se.printStackTrace();
		} catch (Exception e){

		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		return passedUserList;

	}

	//全資格名を取得
	public static ArrayList<Qualification> getAllQualiName(){

		ArrayList<Qualification> qualiList = new ArrayList<Qualification>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qualification_management?useSSL=false",
					"nozomi",
					"nozomi01");

			String sql = "select distinct quali_id, quali_name from qualification";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next() == true){
				int qualiNo = rs.getInt("quali_id");
				String qualiName = rs.getString("quali_name");
				qualiList.add(new Qualification(qualiNo, qualiName));
			}


		} catch (SQLException se){
			se.printStackTrace();
		} catch (Exception e){

		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		return qualiList;

	}

	//全分類を取得
	public static ArrayList<Bunrui> getAllBunrui(){

		ArrayList<Bunrui> bunruiList = new ArrayList<Bunrui>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qualification_management?useSSL=false",
					"nozomi",
					"nozomi01");

			String sql = " select distinct * from bunrui";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next() == true){
				int bunruiNo = rs.getInt("bunrui_id");
				String bunruiName = rs.getString("bunrui_name");
				bunruiList.add(new Bunrui(bunruiNo, bunruiName));
			}


		} catch (SQLException se){
			se.printStackTrace();
		} catch (Exception e){

		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		return bunruiList;

	}

	//全資格主催団体を取得
	public static ArrayList<Dantai> getAllDantai(){

		ArrayList<Dantai> dantaiList = new ArrayList<Dantai>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qualification_management?useSSL=false",
					"nozomi",
					"nozomi01");

			String sql = "select distinct * from dantai";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next() == true){
				int dantaiNo = rs.getInt("dantai_id");
				String dantaiName = rs.getString("dantai_name");
				dantaiList.add(new Dantai(dantaiNo, dantaiName));
			}


		} catch (SQLException se){
			se.printStackTrace();
		} catch (Exception e){

		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		return dantaiList;

	}

	//教員用ページに表示する生徒の受験情報の取得(全校)
	public static ArrayList<StudentsInfo> getStudentsInfo(){

		ArrayList<StudentsInfo> qualiStuList = new ArrayList<StudentsInfo>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qualification_management?useSSL=false",
					"nozomi",
					"nozomi01");

			String sql = "select e.exa_id, s.stu_name, s.school_year, s.school_class, q.quali_name, b.bunrui_name, d.dantai_name, e.quali_date, e.succes"
					+ " from students s"
					+" inner join examination e "
					+" on s.stu_id = e.stu_id"
					+" inner join qualification q"
					+" on e.quali_id = q.quali_id"
					+" inner join bunrui b"
					+" on q.bunrui_id = b.bunrui_id"
					+" inner join dantai d"
					+" on q.dantai_id = d.dantai_id"
					+" order by s.school_year asc, s.school_class asc, s.stu_name asc, e.quali_date desc;";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next() == true){
				int exaId = rs.getInt("e.exa_id");
				String stuName = rs.getString("s.stu_name");
				int stuYear = rs.getInt("s.school_year");
				int stuClass = rs.getInt("s.school_class");
				String qualiName = rs.getString("q.quali_name");
				String bunruiName = rs.getString("b.bunrui_name");
				String dantaiName = rs.getString("d.dantai_name");
				String date = rs.getString("e.quali_date");
				String succes = rs.getString("e.succes");

				qualiStuList.add(new StudentsInfo(exaId, stuName, stuYear, stuClass, qualiName, bunruiName, dantaiName, date, succes));
			}


		} catch (SQLException se){
			se.printStackTrace();
		} catch (Exception e){

		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		return qualiStuList;

	}

	//教員用ページに表示する生徒の受験情報の取得(学年)
	public static ArrayList<StudentsInfo> getYearInfo(int stYear){

		ArrayList<StudentsInfo> qualiStuList = new ArrayList<StudentsInfo>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qualification_management?useSSL=false",
					"nozomi",
					"nozomi01");

			String sql = "select e.exa_id, s.stu_name, s.school_year, s.school_class, q.quali_name, b.bunrui_name, d.dantai_name, e.quali_date, e.succes"
					+ " from students s"
					+" inner join examination e "
					+" on s.stu_id = e.stu_id"
					+" inner join qualification q"
					+" on e.quali_id = q.quali_id"
					+" inner join bunrui b"
					+" on q.bunrui_id = b.bunrui_id"
					+" inner join dantai d"
					+" on q.dantai_id = d.dantai_id"
					+" where s.school_year = ?"
					+" order by s.school_year asc, s.school_class asc, s.stu_name asc, e.quali_date desc;";

			pstmt = con.prepareStatement(sql);
			int year = stYear;
			pstmt.setInt(1, year);
			rs = pstmt.executeQuery();

			while(rs.next() == true){
				int exaId = rs.getInt("e.exa_id");
				String stuName = rs.getString("s.stu_name");
				int stuYear = rs.getInt("s.school_year");
				int stuClass = rs.getInt("s.school_class");
				String qualiName = rs.getString("q.quali_name");
				String bunruiName = rs.getString("b.bunrui_name");
				String dantaiName = rs.getString("d.dantai_name");
				String date = rs.getString("e.quali_date");
				String succes = rs.getString("e.succes");

				qualiStuList.add(new StudentsInfo(exaId, stuName, stuYear, stuClass, qualiName, bunruiName, dantaiName, date, succes));
			}


		} catch (SQLException se){
			se.printStackTrace();
		} catch (Exception e){

		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		return qualiStuList;

	}

	//教員用ページに表示する生徒の受験情報の取得(クラス)
	public static ArrayList<StudentsInfo> getClassInfo(int stYear, int stClass){

		ArrayList<StudentsInfo> qualiStuList = new ArrayList<StudentsInfo>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qualification_management?useSSL=false",
					"nozomi",
					"nozomi01");

			String sql = "select e.exa_id, s.stu_name, s.school_year, s.school_class, q.quali_name, b.bunrui_name, d.dantai_name, e.quali_date, e.succes"
					+ " from students s"
					+" inner join examination e "
					+" on s.stu_id = e.stu_id"
					+" inner join qualification q"
					+" on e.quali_id = q.quali_id"
					+" inner join bunrui b"
					+" on q.bunrui_id = b.bunrui_id"
					+" inner join dantai d"
					+" on q.dantai_id = d.dantai_id"
					+"  where s.school_year = ? and s.school_class = ?"
					+" order by s.school_year asc, s.school_class asc, s.stu_name asc, e.quali_date desc;";

			pstmt = con.prepareStatement(sql);
			int cls = stClass;
			int year = stYear;
			pstmt.setInt(1, cls);
			pstmt.setInt(2, year);
			rs = pstmt.executeQuery();

			while(rs.next() == true){
				int exaId = rs.getInt("e.exa_id");
				String stuName = rs.getString("s.stu_name");
				int stuYear = rs.getInt("s.school_year");
				int stuClass = rs.getInt("s.school_class");
				String qualiName = rs.getString("q.quali_name");
				String bunruiName = rs.getString("b.bunrui_name");
				String dantaiName = rs.getString("d.dantai_name");
				String date = rs.getString("e.quali_date");
				String succes = rs.getString("e.succes");

				qualiStuList.add(new StudentsInfo(exaId, stuName, stuYear, stuClass, qualiName, bunruiName, dantaiName, date, succes));
			}


		} catch (SQLException se){
			se.printStackTrace();
		} catch (Exception e){

		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		return qualiStuList;

	}

	//新規受験情報登録
	public static void insertExamination(int studentId, int qualificationId, String date, String succes){
		Connection con = null;
		PreparedStatement pstmt = null;

		try{

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qualification_management?useSSL=false",
					"nozomi",
					"nozomi01");

			String sql = "insert into examination(stu_id, quali_id, quali_date, succes) values(?,?,?,?);";

			pstmt = con.prepareStatement(sql);

			int stuId = studentId;
			int qualiId = qualificationId;
			String qualiDate = date;
			String qualiSucces = succes;

			pstmt.setInt(1, stuId);
			pstmt.setInt(2, qualiId);
			pstmt.setString(3, qualiDate);
			pstmt.setString(4, qualiSucces);

			pstmt.executeUpdate();

		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {

			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}

}
