package dto;

public class StudentsInfo {
	private int exaId;
	private String stuName;
	private int stuYear;
	private int stuClass;
	private String qualiName;
	private String bunruiName;
	private String dantaiName;
	private String qualiDate;
	private String succes;

	public StudentsInfo(){

	}

	public StudentsInfo(int exaId, String stuName, String qualiName, String qualiDate, String succes) {
		this.exaId = exaId;
		this.stuName = stuName;
		this.qualiName = qualiName;
		this.qualiDate = qualiDate;
		this.succes = succes;
	}

	public StudentsInfo(int exaId, String stuName, int stuYear, int stuClass, String qualiName, String bunruiName,
			String dantaiName, String qualiDate, String succes) {
		this.exaId = exaId;
		this.stuName = stuName;
		this.stuYear = stuYear;
		this.stuClass = stuClass;
		this.qualiName = qualiName;
		this.bunruiName = bunruiName;
		this.dantaiName = dantaiName;
		this.qualiDate = qualiDate;
		this.succes = succes;
	}

	public int getExaId(){
		return exaId;
	}

	public void setExaId(int exaId){
		this.exaId = exaId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuYear() {
		return stuYear;
	}

	public void setStuYear(int stuYear) {
		this.stuYear = stuYear;
	}

	public int getStuClass() {
		return stuClass;
	}

	public void setStuClass(int stuClass) {
		this.stuClass = stuClass;
	}

	public String getQualiName() {
		return qualiName;
	}

	public void setQualiName(String qualiName) {
		this.qualiName = qualiName;
	}

	public String getBunruiName() {
		return bunruiName;
	}

	public void setBunruiName(String bunruiName) {
		this.bunruiName = bunruiName;
	}

	public String getDantaiName() {
		return dantaiName;
	}

	public void setDantaiName(String dantaiName) {
		this.dantaiName = dantaiName;
	}

	public String getQualiDate() {
		return qualiDate;
	}

	public void setQualiDate(String qualiDate) {
		this.qualiDate = qualiDate;
	}

	public String getSucces(){
		return succes;
	}

	public void setSucces(String succes){
		this.succes = succes;
	}

}
