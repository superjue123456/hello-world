package beans;

import java.io.Serializable;

public class Course implements Serializable{
	private String courseid;
	private String coursename;
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
 
}
