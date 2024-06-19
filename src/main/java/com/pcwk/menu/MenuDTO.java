package com.pcwk.menu;

import com.pcwk.ehr.cmn.DTO;

public class MenuDTO extends DTO {
	private int menuNo;
	private int shopNo;
	private String menuName;
	private String menuInfo;
	private int price;
	public MenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuDTO(int menuNo, int shopNo, String menuName, String menuInfo, int price) {
		super();
		this.menuNo = menuNo;
		this.shopNo = shopNo;
		this.menuName = menuName;
		this.menuInfo = menuInfo;
		this.price = price;
	}
	@Override
	public String toString() {
		return "MenuDTO [menuNo=" + menuNo + ", shopNo=" + shopNo + ", menuName=" + menuName + ", menuInfo=" + menuInfo
				+ ", price=" + price + "]";
	}
	public int getmenuNo() {
		return menuNo;
	}
	public void setmenuNo(int menuNo) {
		this.menuNo = menuNo;
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

}
