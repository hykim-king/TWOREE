package com.pcwk.ehr.shop_eom;

import com.pcwk.ehr.cmn_eom.DTO;

public class ShopNoticeDTO extends DTO{

	private     int     noticeNo       ;
	private     int     shopNo         ;
	private     String  noticeTitle    ;
	private     String  noticeWatDate  ;
	private     String  content        ;
	private     String  fixed          ;
	
	public ShopNoticeDTO() { 
	}

	public ShopNoticeDTO(int noticeNo, int shopNo, String noticeTitle, String noticeWatDate, String content,
			String fixed) {
		super();
		this.noticeNo = noticeNo;
		this.shopNo = shopNo;
		this.noticeTitle = noticeTitle;
		this.noticeWatDate = noticeWatDate;
		this.content = content;
		this.fixed = fixed;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public int getShopNo() {
		return shopNo;
	}

	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeWatDate() {
		return noticeWatDate;
	}

	public void setNoticeWatDate(String noticeWatDate) {
		this.noticeWatDate = noticeWatDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFixed() {
		return fixed;
	}

	public void setFixed(String fixed) {
		this.fixed = fixed;
	}

	@Override
	public String toString() {
		return "ShopNoticeDTO [noticeNo=" + noticeNo + ", shopNo=" + shopNo + ", noticeTitle=" + noticeTitle
				+ ", noticeWatDate=" + noticeWatDate + ", content=" + content + ", fixed=" + fixed + ", getTotalCnt()="
				+ getTotalCnt() + "]";
	}
	
	
	
	
	
	
	
}
