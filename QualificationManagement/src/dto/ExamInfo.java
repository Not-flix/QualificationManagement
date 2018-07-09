package dto;

public class ExamInfo {

	private String qualiName;			//資格名
	private String qualiBunrui;			//資格分類
	private String qualiDantai;			//資格主催団体
	private String qualiDate;			//受験日
	private String succes;				//結果（合否）

	public ExamInfo(){

	}

	public ExamInfo(String qualiName, String qualiBunrui, String qualiDantai, String qualiDate, String succes) {
		this.qualiName = qualiName;
		this.qualiBunrui = qualiBunrui;
		this.qualiDantai = qualiDantai;
		this.qualiDate = qualiDate;
		this.succes = succes;
	}

	public String getQualiName() {
		return qualiName;
	}

	public void setQualiName(String qualiName) {
		this.qualiName = qualiName;
	}

	public String getQualiBunrui() {
		return qualiBunrui;
	}

	public void setQualiBunrui(String qualiBunrui) {
		this.qualiBunrui = qualiBunrui;
	}

	public String getQualiDantai() {
		return qualiDantai;
	}

	public void setQualiDantai(String qualiDantai) {
		this.qualiDantai = qualiDantai;
	}

	public String getQualiDate() {
		return qualiDate;
	}

	public void setQualiDate(String qualiDate) {
		this.qualiDate = qualiDate;
	}

	public String getSucces() {
		return succes;
	}

	public void setSucces(String succes) {
		this.succes = succes;
	}


}