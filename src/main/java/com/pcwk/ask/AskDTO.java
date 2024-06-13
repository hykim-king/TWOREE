package com.pcwk.ask;

import com.pcwk.ehr.cmn.DTO;

public class AskDTO extends DTO {
		
		private int askNo;
		private int shopNo;
		private String userId;
		private String askState;
		private String userAsk;
		private String askDate;
		private String shopAnswer;
		private String answerDate;
		private String shopName;
		public String getShopName() {
			return shopName;
		}
		public void setShopName(String shopName) {
			this.shopName = shopName;
		}
		public int getAskNo() {
			return askNo;
		}
		public String getAskDate() {
			return askDate;
		}
		public void setAskDate(String askDate) {
			this.askDate= askDate;
			
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
		public void setAskState(String askState) {
			this.askState = askState;
		}
		public String getUserAsk() {
			return userAsk;
		}
		public void setUserAsk(String userAsk) {
			this.userAsk = userAsk;
		}
		public String getShopAnswer() {
			return shopAnswer;
		}
		public void setShopAnswer(String shopAnswer) {
			this.shopAnswer = shopAnswer;
		}
		public String getAnswerDate() {
			return answerDate;
		}
		public void setAnswerDate(String answerDate) {
			this.answerDate = answerDate;
		}
		@Override
		public String toString() {
			return "AskDTO [askNo=" + askNo + ", shopNo=" + shopNo + ", userId=" + userId + ", askState=" + askState
					+ ", userAsk=" + userAsk + ", askDate=" + askDate + ", shopAnswer=" + shopAnswer + ", answerDate="
					+ answerDate + ", shopName=" + shopName + ", toString()=" + super.toString() + "]";
		}
		
		
		

		
		
	}

