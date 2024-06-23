package com.pcwk.reserve;

import com.pcwk.ehr.cmn.DTO;

public class ReserveDTO extends DTO {

	private int reserveNo;
	private String userId;
	private int shopNo;
	private int people;
	private String reserveDate;
	private String reserveAppDate;
	private String userTel;
	private String reserveTime;
	public String getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

	private String reserveState;
	private String confirmedDate;
	private String userComment;

	public ReserveDTO() {
		
	}

	public ReserveDTO(int reserveNo, String userId, int shopNo, int people, String reserveDate,
			String reserveAppDate, String userTel, String reserveState, String confirmedDate, String userComment) {
		super();
		this.reserveNo = reserveNo;
		this.userId = userId;
		this.shopNo = shopNo;
		this.people = people;
		this.reserveDate = reserveDate;
		this.reserveAppDate = reserveAppDate;
		this.userTel = userTel;
		this.reserveState = reserveState;
		this.confirmedDate = confirmedDate;
		this.userComment = userComment;
	}

	public int getReserveNo() {
		return reserveNo;
	}

	public void setReserveNo(int reserveNo) {
		this.reserveNo = reserveNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getShopNo() {
		return shopNo;
	}

	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public String getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}

	public String getReserveAppDate() {
		return reserveAppDate;
	}

	public void setReserveAppDate(String reserveAppDate) {
		this.reserveAppDate = reserveAppDate;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getReserveState() {
		return reserveState;
	}

	public void setReserveState(String reserveState) {
		this.reserveState = reserveState;
	}

	public String getConfirmedDate() {
		return confirmedDate;
	}

	public void setConfirmedDate(String confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	@Override
	public String toString() {
		return "ReserveDTO [reserveNo=" + reserveNo + ", userId=" + userId + ", shopNo=" + shopNo + ", people=" + people + ", reserveDate=" + reserveDate + ", reserveAppDate=" + reserveAppDate
				+ ", userTel=" + userTel + ", reserveState=" + reserveState + ", confirmedDate=" + confirmedDate
				+ ", userComment=" + userComment + ", toString()=" + super.toString() + "]";
	}

	
}


