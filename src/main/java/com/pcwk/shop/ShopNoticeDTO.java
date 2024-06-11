package com.pcwk.shop;

import com.pcwk.ehr.cmn.DTO;
//update 0611 0630
public class ShopNoticeDTO extends DTO{

	private     int     noticeNo       ;
	private     int     shopNo         ;
	private     String  noticeTitle    ;
	private     String  noticeWrtDate  ;
	private     String  content        ;
	private     String  fixed          ;
	
	public ShopNoticeDTO() { 
	}

	public ShopNoticeDTO(int noticeNo, int shopNo, String noticeTitle, String noticeWrtDate, String content,
			String fixed) {
		super();
		this.noticeNo = noticeNo;
		this.shopNo = shopNo;
		this.noticeTitle = noticeTitle;
		this.noticeWrtDate = noticeWrtDate;
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

	public String getNoticeWrtDate() {
		return noticeWrtDate;
	}

	public void setNoticeWrtDate(String noticeWrtDate) {
		this.noticeWrtDate = noticeWrtDate;
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
				+ ", noticeWrtDate=" + noticeWrtDate + ", content=" + content + ", fixed=" + fixed + "]";
	}
 
}
