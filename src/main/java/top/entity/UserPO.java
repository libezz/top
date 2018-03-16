package top.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserPO extends BasePO {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 25, nullable = false)
	private String username;
	@Column(length = 25, nullable = false)
	private String password;
	@Column(length = 25, nullable = false)
	private String signIp;
	@Column
	private Integer signCount = 0;
	@Column
	private Long sumRole = 0L;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSignIp() {
		return signIp;
	}
	public void setSignIp(String signIp) {
		this.signIp = signIp;
	}
	public Integer getSignCount() {
		return signCount;
	}
	public void setSignCount(Integer signCount) {
		this.signCount = signCount;
	}
	public Long getSumRole() {
		return sumRole;
	}
	public void setSumRole(Long sumRole) {
		this.sumRole = sumRole;
	}
}
