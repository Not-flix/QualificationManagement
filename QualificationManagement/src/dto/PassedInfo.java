package dto;

public class PassedInfo {

	private String passedName;
	private String qualiName;
	private String bunrui;
	private String dantai;
	private String qualiDate;

	public PassedInfo(){

	}

	public PassedInfo(String passedName, String qualiName, String bunrui, String dantai, String qualiDate) {
		this.passedName = passedName;
		this.qualiName = qualiName;
		this.bunrui = bunrui;
		this.dantai = dantai;
		this.qualiDate = qualiDate;
	}

	public String getPassedName() {
		return passedName;
	}

	public void setPassedName(String passedName) {
		this.passedName = passedName;
	}

	public String getQualiName() {
		return qualiName;
	}

	public void setQualiName(String qualiName) {
		this.qualiName = qualiName;
	}

	public String getBunrui() {
		return bunrui;
	}

	public void setBunrui(String bunrui) {
		this.bunrui = bunrui;
	}

	public String getDantai() {
		return dantai;
	}

	public void setDantai(String dantai) {
		this.dantai = dantai;
	}

	public String getQualiDate() {
		return qualiDate;
	}

	public void setQualiDate(String qualiDate) {
		this.qualiDate = qualiDate;
	}

}
