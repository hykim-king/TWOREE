package com.pcwk.shop;


import com.pcwk.ehr.cmn.DTO;

public class ShopDTO extends DTO{
	
	private int shopNo;
	private String managerId;
	private String shopName;
	private String regDate;
	private int score;
	private int reviewCnt;
	private int reserveCnt;
	private String isVerified;
	
	public ShopDTO() {
		super();
	}

	public ShopDTO(int shopNo, String managerId, String shopName, String regDate, int score, int reviewCnt,
			int reserveCnt, String isVerified) {
		super();
		this.shopNo = shopNo;
		this.managerId = managerId;
		this.shopName = shopName;
		this.regDate = regDate;
		this.score = score;
		this.reviewCnt = reviewCnt;
		this.reserveCnt = reserveCnt;
		this.isVerified = isVerified;
	}

	public int getShopNo() {
		return shopNo;
	}

	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	public int getReserveCnt() {
		return reserveCnt;
	}

	public void setReserveCnt(int reserveCnt) {
		this.reserveCnt = reserveCnt;
	}

	public String getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(String isVerified) {
		this.isVerified = isVerified;
	}

	@Override
	public String toString() {
		return "ShopDTO [shopNo=" + shopNo + ", managerId=" + managerId + ", shopName=" + shopName + ", regDate="
				+ regDate + ", score=" + score + ", reviewCnt=" + reviewCnt + ", reserveCnt=" + reserveCnt
				+ ", isVerified=" + isVerified + "]";
	}
	
	
}
