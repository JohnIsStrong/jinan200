package po;

public class User {
	private Integer id;
	private String uname;
	private int age;
	private boolean sex;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String uname, int age, boolean sex) {
		super();
		this.uname = uname;
		this.age = age;
		this.sex = sex;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	
}
