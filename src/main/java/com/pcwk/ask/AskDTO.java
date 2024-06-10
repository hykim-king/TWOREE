package com.pcwk.ask;

import com.pcwk.ehr.cmn.DTO;

public class AskDTO extends DTO {
		
		private int askNo;
		private int shopNo;
		private String userId;
		private String askState;
		private String userAsk;
		private String shopAnswer;
		private String asnwerDate;
		public int getAskNo() {
			return askNo;
		}
		public void setAskNo(int askNo) {
			this.askNo = askNo;
		}
		public int getShopNo() {
			return shopNo;
		}
		public void setShopNo(int shopNo) {
			this.shopNo = shopNo;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getAskState() {
			return askState;
		}
		
		
		@Override
		public String toString() {
			return "AskDTO [askNo=" + askNo + ", shopNo=" + shopNo + ", userId=" + userId + ", askState=" + askState
					+ ", userAsk=" + userAsk + ", shopAnswer=" + shopAnswer + ", asnwerDate=" + asnwerDate + "]";
		}
		
		
		
	}

