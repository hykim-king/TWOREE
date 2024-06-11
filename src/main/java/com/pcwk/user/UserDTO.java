package com.pcwk.user;

import com.pcwk.ehr.cmn.DTO;

public class UserDTO extends DTO {
	
	private String userId;
	private String password;
	private String name;
	private String userEmail;
	private String tel;
	private String birthday;
	private String shopAdmin;
	private String penaltyDate;
	
	public UserDTO() {
		
	}

	public UserDTO(String userId, String password, String name, String userEmail, String tel, String birthday,
			String shopAdmin, String penaltyDate) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.userEmail = userEmail;
		this.tel = tel;
		this.birthday = birthday;
		this.shopAdmin = shopAdmin;
		this.penaltyDate = penaltyDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getShopAdmin() {
		return shopAdmin;
	}

	public void setShopAdmin(String shopAdmin) {
		this.shopAdmin = shopAdmin;
	}

	public String getPenaltyDate() {
		return penaltyDate;
	}

	public void setPenaltyDate(String penaltyDate) {
		this.penaltyDate = penaltyDate;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", password=" + password + ", name=" + name + ", userEmail=" + userEmail
				+ ", tel=" + tel + ", birthday=" + birthday + ", shopAdmin=" + shopAdmin + ", penaltyDate="
				+ penaltyDate + ", toString()=" + super.toString() + "]";
	}
	
	
}

