package dto;

public class Dantai {

	private int dantaiNo;
	private String dantaiName;

	public Dantai(){

	}

	public Dantai(int dantaiNo, String dantaiName) {
		this.dantaiNo = dantaiNo;
		this.dantaiName = dantaiName;
	}

	public int getDantaiNo() {
		return dantaiNo;
	}

	public void setDantaiNo(int dantaiNo) {
		this.dantaiNo = dantaiNo;
	}

	public String getDantaiName() {
		return dantaiName;
	}

	public void setDantaiName(String dantaiName) {
		this.dantaiName = dantaiName;
	}



}
