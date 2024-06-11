package com.pcwk.review;

import java.time.LocalDateTime;

public class reviewDTO {
	
	private int reviewNo; 					//리뷰 고유 번호
	private String shopNo; 					// 리뷰 작성받은 가게
	private String userId; 				// 유저 아이디
	private String writerId;					//리뷰 작성자 아이디
	private String reviewWrtDate; 			//리뷰 작성 날짜
	private String reviewModDate; 			// 리뷰 수정 시간
	private String reviewContent; 			// 리뷰 내용
	private int score; 						// 점수 (1 ~5점)
	
	public reviewDTO(int reviewNo, String shopNo, String userId, String writerId, String reviewWrtDate,
			String reviewModDate, String reviewContent, int score) {
		super();
		this.reviewNo = reviewNo;
		this.shopNo = shopNo;
		this.userId = userId;
		this.writerId = writerId;
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

	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
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
		return "reviewDTO [reviewNo=" + reviewNo + ", shopNo=" + shopNo + ", userId=" + userId + ", writerId="
				+ writerId + ", reviewWrtDate=" + reviewWrtDate + ", reviewModDate=" + reviewModDate
				+ ", reviewContent=" + reviewContent + ", score=" + score + "]";
	}
	
	
	
}




