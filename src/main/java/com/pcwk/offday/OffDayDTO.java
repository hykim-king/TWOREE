package com.pcwk.offday;

import com.pcwk.ehr.cmn.DTO;

public class OffDayDTO extends DTO {
	private int offDaySeq;
	private int shopNo;
	private String closedDay;
	public OffDayDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OffDayDTO(int offDaySeq, int shopNo, String clesedDay) {
		super();
		this.offDaySeq = offDaySeq;
		this.shopNo = shopNo;
		this.closedDay = clesedDay;
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
	public String getClosedDay() {
		return closedDay;
	}
	public void setClosedDay(String closedDay) {
		this.closedDay = closedDay;
	}
	@Override
	public String toString() {
		return "OffDayDTO [offDaySeq=" + offDaySeq + ", shopNo=" + shopNo + ", closedDay=" + closedDay + "]";
	}

}
