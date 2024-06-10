package com.pcwk.shop;


public class ShopReserveSetDTO {
	
	private int shopNo;
	private int tableCap;
	private int peopleCap;
	private String startTime;
	private String endTime;
	
	public ShopReserveSetDTO() {
		super();
	}

	public ShopReserveSetDTO(int shopNo, int tableCap, int peopleCap, String startTime, String endTime) {
		super();
		this.shopNo = shopNo;
		this.tableCap = tableCap;
		this.peopleCap = peopleCap;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getShopNo() {
		return shopNo;
	}

	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}

	public int getTableCap() {
		return tableCap;
	}

	public void setTableCap(int tableCap) {
		this.tableCap = tableCap;
	}

	public int getPeopleCap() {
		return peopleCap;
	}

	public void setPeopleCap(int peopleCap) {
		this.peopleCap = peopleCap;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "ShopReserveSetDTO [shopNo=" + shopNo + ", tableCap=" + tableCap + ", peopleCap=" + peopleCap
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
}
