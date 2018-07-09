package dto;

public class Qualification {

	private int qualiNo;
	private String qualiName;

	public Qualification(){

	}

	public Qualification(int qualiNo, String qualiName) {
		this.qualiNo = qualiNo;
		this.qualiName = qualiName;
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

}
