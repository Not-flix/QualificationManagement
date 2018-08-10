package dto;

public class Qualification {

	private int qualiNo;
	private String qualiName;
	private String bunruiName;
	private String dantaiName;

	public Qualification(){

	}

	public Qualification(int qualiNo, String qualiName) {
		this.qualiNo = qualiNo;
		this.qualiName = qualiName;
	}

	public Qualification(int qualiNo, String qualiName, String bunruiName, String dantaiName){
		this.qualiNo = qualiNo;
		this.qualiName = qualiName;
		this.bunruiName = bunruiName;
		this.dantaiName = dantaiName;
	}

	public int getQualiNo() {
		return qualiNo;
	}

	public void setQualiNo(int qualiNo) {
		this.qualiNo = qualiNo;
	}

	public String getQualiName() {
		return qualiName;
	}

	public void setQualiName(String qualiName) {
		this.qualiName = qualiName;
	}

	public String getBunruiName(){
		return bunruiName;
	}

	public void setBunruiName(String bunruiName){
		this.bunruiName = bunruiName;
	}

	public String getDantaiName(){
		return dantaiName;
	}

	public void setDantaiName(String dantaiName){
		this.dantaiName = dantaiName;
	}

}
