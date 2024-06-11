package com.pcwk.review;

import java.time.LocalDateTime;

public class reviewDTO {
	
	private int review_no; 						//리뷰 고유 번호
	private String shopNo; 						// 리뷰 작성받은 가게
	private String userId; 						// 유저 아이디
	private String reviewId; 					//리뷰 작성자 아이디
	private LocalDateTime createDate; 			//리뷰 작성 날짜
	private LocalDateTime updateDate; 			// 리뷰 수정 시간
	private String reviewText; 					// 리뷰 내용
	private int rating; 						// 점수 (1 ~5점)
	
	public reviewDTO(int review_no, String shopNo, String userId, String reviewId, LocalDateTime createDate,
			LocalDateTime updateDate, String reviewText, int rating) {
		super();
		this.review_no = review_no;
		this.shopNo = shopNo;
		this.userId = userId;
		this.reviewId = reviewId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.reviewText = reviewText;
		this.rating = rating;
	}

	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(int review_no) {
		this.review_no = review_no;
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

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "reviewDTO [review_no=" + review_no + ", shopNo=" + shopNo + ", userId=" + userId + ", reviewId="
				+ reviewId + ", createDate=" + createDate + ", updateDate=" + updateDate + ", reviewText=" + reviewText
				+ ", rating=" + rating + "]";
	}
	
	
	
	
}
