package dto;

public class Login {
	private int stuId;
	private String stuName;
	private String stuPass;

	public Login(){

	}

	public Login(int stuId, String stuName, String stuPass) {
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuPass = stuPass;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuPass() {
		return stuPass;
	}

	public void setStuPass(String stuPass) {
		this.stuPass = stuPass;
	}


}
