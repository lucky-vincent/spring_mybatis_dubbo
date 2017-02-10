package com.demo.entity;

import java.io.Serializable;

/**
 * 
 * @Description : 用户实体
 * @author : liwenjian
 * @version : 1.0
 * @Date : 2016年1月28日 下午3:06:48
 */
public class Member extends BaseEntity implements Serializable {

	/**
	 * serialVersionUID:TODO
	 * 
	 * @since 1.0.0
	 */

	private static final long serialVersionUID = 1L;

	private String memberName;
	private String memberPassword;
	private String memberEmail;
	private String memberBirthday;
	private Integer memberSex;

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberBirthday() {
		return memberBirthday;
	}

	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
	}

	public Integer getMemberSex() {
		return memberSex;
	}

	public void setMemberSex(Integer memberSex) {
		this.memberSex = memberSex;
	}

}
