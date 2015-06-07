package po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="addrs")
public class Addr {
	@Id
	@GenericGenerator(name="myGen",strategy="sequence",parameters = {@Parameter(name = "sequence", value = "seq_addrs") })
	@GeneratedValue(generator="myGen")
	private Integer id;
	@Column(name="addr_name")
	private String addrName;
	
	@ManyToOne
	@JoinColumn(name="u_id")
	private User u;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddrName() {
		return addrName;
	}
	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	
}
