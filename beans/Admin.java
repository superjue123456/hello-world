package beans;
 
public class Admin {
	private String adminid;
	private String adminname;
	private String password;
	public Admin(){}
	public Admin(String adminid,String adminname,String password){
		this.adminid=adminid;
		this.adminname=adminname;
		this.password=password;
	}
	public String getAdminid(){
		return adminid;
	}
	public void setAdminid(String studentid){
		this.adminid=studentid;
	}
	public String getAdminname(){
		return adminname;
	}
	public void setAdminname(String studentname){
		this.adminname=studentname;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
}
