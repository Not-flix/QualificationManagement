package dto;

public class Bunrui {

	private int bunruiNo;
	private String bunruiName;

	public Bunrui(){

	}

	public Bunrui(int bunruiNo, String bunruiName) {
		this.bunruiNo = bunruiNo;
		this.bunruiName = bunruiName;
	}

	public int getBunruiNo() {
		return bunruiNo;
	}

	public void setBunruiNo(int bunruiNo) {
		this.bunruiNo = bunruiNo;
	}

	public String getBunruiName() {
		return bunruiName;
	}

	public void setBunruiName(String bunruiName) {
		this.bunruiName = bunruiName;
	}


}
