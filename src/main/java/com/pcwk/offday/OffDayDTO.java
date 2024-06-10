package com.pcwk.offday;

import com.pcwk.ehr.cmn.DTO;

public class OffDayDTO extends DTO {
	private int offDaySeq;
	private int shopNo;
	private String clesedDay;
	public OffDayDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOffDaySeq() {
		return offDaySeq;
	}
	public void setOffDaySeq(int offDaySeq) {
		this.offDaySeq = offDaySeq;
	}
	public int getShopNo() {
		return shopNo;
	}
	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}
	public String getClesedDay() {
		return clesedDay;
	}
	public void setClesedDay(String clesedDay) {
		this.clesedDay = clesedDay;
	}
	@Override
	public String toString() {
		return "OffDayDTO [offDaySeq=" + offDaySeq + ", shopNo=" + shopNo + ", clesedDay=" + clesedDay + "]";
	}

}
