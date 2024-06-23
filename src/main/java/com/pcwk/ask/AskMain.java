package com.pcwk.ask;

import java.util.List;

import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.SearchDTO;
import com.pcwk.menu.MenuDTO;
import com.pcwk.review.ReviewDTO;

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
	    	ask.setAskState("臾몄쓽 �슂泥�");
	    	ask.setUserAsk("怨좉컼 臾몄쓽");
	    	ask.setAskDate("20240611");
	    	ask.setShopAnswer("�떟蹂�");
	    	ask.setAnswerDate("20240611");
	    	
	    	flag=dao.doSave(ask);
	    	if (0 == flag) {
				log.debug("�벑濡� �떎�뙣 :{}", flag);
			} else {
				log.debug("�벑濡� �꽦怨� :{}", flag);
			}
	    }
	
	
	public void doDelete() {
		ask.setAskNo(41);
		int flag =0;
		
    	flag=dao.doDelete(ask);
    	
    	if (0 == flag) {
			log.debug("�궘�젣 �떎�뙣 :{}", flag);
		} else {
			log.debug("�궘�젣 �꽦怨� :{}", flag);
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
			log.debug("�뾽�뜲�씠�듃 �떎�뙣 ");
		} else {
			log.debug("�뾽�뜲�씠�듃 �꽦怨� ");
		}
		
	}
	
	
	public void doSelectOne() {
		ask.setAskNo(42);
		AskDTO outVO = dao.doSelectOne(ask);
		if (null != outVO) {
			log.debug("�떒嫄� 議고쉶 �꽦怨�");
		} else {
			log.debug("�떒嫄� 議고쉶 �떎�뙣");
		}
		log.debug(outVO);
	}
	
	public void doRetrieve() {
		log.debug(" doRetrieve()");
		searchVO = new SearchDTO();
		searchVO.setPageNo(1);
		searchVO.setPageSize(10);
		searchVO.setSearchSeq(2);
		searchVO.setSearchWord("user1");
		searchVO.setSearchDiv("10");
		List <AskDTO> list = dao.doRetrieve(searchVO);
		int i = 0;
		for (AskDTO vo : list) {
			log.debug("i: {}, vo: {}", ++i, vo);
		}

	}
	
	public static void main(String[] args) {

		AskMain a = new AskMain();
		//a.doSave();	
	    //a.doDelete();
		//a.doUpdate();
		a.doSelectOne();
		//a.doRetrieve();

	}

}
