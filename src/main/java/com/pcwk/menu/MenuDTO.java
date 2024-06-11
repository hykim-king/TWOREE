package com.pcwk.menu;

import com.pcwk.ehr.cmn.DTO;

public class MenuDTO extends DTO {
	private int menuNO;
	private int shopNo;
	private String menuName;
	private String menuInfo;
	private int price;
	private String regId;
	public MenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuDTO(int menuNO, int shopNo, String menuName, String menuInfo, int price, String regId) {
		super();
		this.menuNO = menuNO;
		this.shopNo = shopNo;
		this.menuName = menuName;
		this.menuInfo = menuInfo;
		this.price = price;
		this.regId = regId;
	}
	public int getMenuNO() {
		return menuNO;
	}
	public void setMenuNO(int menuNO) {
		this.menuNO = menuNO;
	}
	public int getShopNo() {
		return shopNo;
	}
	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuInfo() {
		return menuInfo;
	}
	public void setMenuInfo(String menuInfo) {
		this.menuInfo = menuInfo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}

}
