package dto;

public class Login {
	private String stuName;
	private String stuPass;

	public Login(){

	}

	public Login(String stuName, String stuPass) {
		this.stuName = stuName;
		this.stuPass = stuPass;
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
