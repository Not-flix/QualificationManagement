package dto;

public class Student {

	private String stuName;
	private int schoolYear;
	private int schoolClass;
	private String gender;
	private String stuPass;

	public Student(){

	}

	public Student(String stuName, int schoolYear, int schoolClass, String gender, String stuPass) {
		this.stuName = stuName;
		this.schoolYear = schoolYear;
		this.schoolClass = schoolClass;
		this.gender = gender;
		this.stuPass = stuPass;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(int schoolYear) {
		this.schoolYear = schoolYear;
	}

	public int getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(int schoolClass) {
		this.schoolClass = schoolClass;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStuPass() {
		return stuPass;
	}

	public void setStuPass(String stuPass) {
		this.stuPass = stuPass;
	}

}
