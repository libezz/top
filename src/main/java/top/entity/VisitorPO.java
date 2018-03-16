package top.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import top.global.VisitorRole;

@Entity
@Table(name = "visitor")
public class VisitorPO extends BasePO {

	private static final long serialVersionUID = 1L;

	@Column(length = 25, nullable = false)
	private String visitIp;
	@Column
	private Integer visitCount = 0;
	@Column
	private Integer messageCount = VisitorRole.MESSAGE_COUNT;
	@Column
	private Integer signUpCount = VisitorRole.SIGN_UP_COUNT;
	
	public String getVisitIp() {
		return visitIp;
	}
	public void setVisitIp(String visitIp) {
		this.visitIp = visitIp;
	}
	public Integer getVisitCount() {
		return visitCount;
	}
	public void setVisitCount(Integer visitCount) {
		this.visitCount = visitCount;
	}
	public Integer getMessageCount() {
		return messageCount;
	}
	public void setMessageCount(Integer messageCount) {
		this.messageCount = messageCount;
	}
	public Integer getSignUpCount() {
		return signUpCount;
	}
	public void setSignUpCount(Integer signUpCount) {
		this.signUpCount = signUpCount;
	}
}
