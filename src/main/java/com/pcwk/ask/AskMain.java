package com.pcwk.ask;

import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.SearchDTO;
import com.pcwk.menu.MenuDTO;

public class AskMain implements PLog {
	 AskDAO dao;
	 AskDTO ask;
	 SearchDTO searchVO;
	 
	 public AskMain() {
		super();
		dao = new AskDAO();
		ask = new AskDTO();
		
	}
	public void doSave() {
	    	int flag =0;
	    	ask.setShopNo(2);
	    	ask.setUserId("user1");
	    	ask.setAskState("문의 요청");
	    	ask.setUserAsk("고객 문의");
	    	ask.setAskDate("20240611");
	    	ask.setShopAnswer("답변");
	    	ask.setAnswerDate("20240611");
	    	
	    	flag=dao.doSave(ask);
	    	if (0 == flag) {
				log.debug("등록 실패 :{}", flag);
			} else {
				log.debug("등록 성공 :{}", flag);
			}
	    }
	
	
	public void doDelete() {
		ask.setAskNo(41);
		int flag =0;
		
    	flag=dao.doDelete(ask);
    	
    	if (0 == flag) {
			log.debug("삭제 실패 :{}", flag);
		} else {
			log.debug("삭제 성공 :{}", flag);
		}
	
	}
	
	public void doUpdate() {
		
		ask.setAskNo(42);
		
    	String updateStr = "_U";
    	ask.setAskState(ask.getAskState() + updateStr);
    	ask.setUserAsk(ask.getUserAsk() + updateStr);
    	ask.setAskDate("20240611");
    	ask.setShopAnswer(ask.getShopAnswer() + updateStr);
    	ask.setAnswerDate("20240611");
    	
		int flag = dao.doUpdate(ask);
		if (0 == flag) {
			log.debug("업데이트 실패 ");
		} else {
			log.debug("업데이트 성공 ");
		}
		
	}
	
	
	public void doSelectOne() {
		ask.setAskNo(42);
		AskDTO outVO = dao.doSelectOne(ask);
		if (null != outVO) {
			log.debug("단건 조회 성공");
		} else {
			log.debug("단건 조회 실패");
		}
		log.debug(outVO);
	}
	
	
	public static void main(String[] args) {

		AskMain a = new AskMain();
		a.doSave();	
	    //a.doDelete();
		//a.doUpdate();
		//a.doSelectOne();
		//a.doRetrieve();

	}

}
