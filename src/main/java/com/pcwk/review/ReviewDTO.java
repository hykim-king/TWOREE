package com.pcwk.review;

import com.pcwk.ehr.cmn.DTO;

public class ReviewDTO extends DTO{
	
	private int reviewNo; 					//리뷰 고유 번호
	private int shopNo; 					// 리뷰 작성받은 가게
	private String userId; 				// 유저 아이디
	private String reviewWrtDate; 			//리뷰 작성 날짜
	private String reviewModDate; 			// 리뷰 수정 시간
	private String reviewContent; 			// 리뷰 내용
	private int score; 						// 점수 (1 ~5점)
	private String shopName;
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public ReviewDTO() {
		super();
	}

	public ReviewDTO(int reviewNo, int shopNo, String userId, String reviewWrtDate,
			String reviewModDate, String reviewContent, int score) {
		super();
		this.reviewNo = reviewNo;
		this.shopNo = shopNo;
		this.userId = userId;
		this.reviewWrtDate = reviewWrtDate;
		this.reviewModDate = reviewModDate;
		this.reviewContent = reviewContent;
		this.score = score;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getShopNo() {
		return shopNo;
	}

	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getReviewWrtDate() {
		return reviewWrtDate;
	}

	public void setReviewWrtDate(String reviewWrtDate) {
		this.reviewWrtDate = reviewWrtDate;
	}

	public String getReviewModDate() {
		return reviewModDate;
	}

	public void setReviewModDate(String reviewModDate) {
		this.reviewModDate = reviewModDate;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "ReviewDTO [reviewNo=" + reviewNo + ", shopNo=" + shopNo + ", userId=" + userId + ", reviewWrtDate="
				+ reviewWrtDate + ", reviewModDate=" + reviewModDate + ", reviewContent=" + reviewContent + ", score="
				+ score + ", shopName=" + shopName + ", toString()=" + super.toString() + "]";
	}

	
	
	
	
}




