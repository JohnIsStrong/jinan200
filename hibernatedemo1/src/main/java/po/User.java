package po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
//JPA javaEE规范之一
//WebService,JNDI,JMS,JTA JavaMail

@Entity
@Table(name="users")
public class User {
	@Id
	@GenericGenerator(name="myGen",strategy="sequence",parameters = {@Parameter(name = "sequence", value = "seq_users") })
	@GeneratedValue(generator="myGen")
	
	private Integer id;
	
	@Column(name="u_name")
	private String uname;
	private int age;
	
	@Transient
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
