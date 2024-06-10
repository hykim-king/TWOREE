package com.pcwk.shop;

import com.pcwk.ehr.cmn.DTO;

public class ShopDetailDTO extends DTO{
	
	private     int     shopNo         ;
	private     String  ownerName      ;
	private     String  shopTel        ;
	private     String  shopLoc        ;
	private     String  shopRule       ;
	private     String  parkInfo       ;
	private     String  reserverInfo   ;
	private     String  openTime       ;
	private     String  closeTime      ;
	
	public ShopDetailDTO() { 
	}

	public ShopDetailDTO(int shopNo, String ownerName, String shopTel, String shopLoc, String shopRule, String parkInfo,
			String reserverInfo, String openTime, String closeTime) {
		super();
		this.shopNo = shopNo;
		this.ownerName = ownerName;
		this.shopTel = shopTel;
		this.shopLoc = shopLoc;
		this.shopRule = shopRule;
		this.parkInfo = parkInfo;
		this.reserverInfo = reserverInfo;
		this.openTime = openTime;
		this.closeTime = closeTime;
	}

	public int getShopNo() {
		return shopNo;
	}

	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getShopTel() {
		return shopTel;
	}

	public void setShopTel(String shopTel) {
		this.shopTel = shopTel;
	}

	public String getShopLoc() {
		return shopLoc;
	}

	public void setShopLoc(String shopLoc) {
		this.shopLoc = shopLoc;
	}

	public String getShopRule() {
		return shopRule;
	}

	public void setShopRule(String shopRule) {
		this.shopRule = shopRule;
	}

	public String getParkInfo() {
		return parkInfo;
	}

	public void setParkInfo(String parkInfo) {
		this.parkInfo = parkInfo;
	}

	public String getReserverInfo() {
		return reserverInfo;
	}

	public void setReserverInfo(String reserverInfo) {
		this.reserverInfo = reserverInfo;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	@Override
	public String toString() {
		return "ShopDetailDTO [shopNo=" + shopNo + ", ownerName=" + ownerName + ", shopTel=" + shopTel + ", shopLoc="
				+ shopLoc + ", shopRule=" + shopRule + ", parkInfo=" + parkInfo + ", reserverInfo=" + reserverInfo
				+ ", openTime=" + openTime + ", closeTime=" + closeTime + "]";
	}
	
	
	
	

}
