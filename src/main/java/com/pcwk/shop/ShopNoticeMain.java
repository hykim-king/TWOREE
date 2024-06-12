package com.pcwk.shop;

import com.pcwk.ehr.cmn.PLog;
//update 0611 0630
public class ShopNoticeMain implements PLog {
	ShopNoticeDao ndao;
	ShopNoticeDTO ndto;
	
	public ShopNoticeMain() {
		ndao = new ShopNoticeDao();
		ndto = new ShopNoticeDTO(4, 2, "공지제목", "사용안함", "공지내용","y");
	}
	
	
	public void doSave() {
		log.debug("doSave()");
		int flag = ndao.doSave(ndto);
		if(1 == flag) {
			log.debug("notice success:{}",flag);
			
		}else {
			log.debug("notice fail:{}",flag);
		}
	}
	
	public void doUpdate() {
		log.debug("doUpdate()"); 
		String updateStr = "_U";
		ndto.setNoticeTitle(ndto.getNoticeTitle()    +updateStr);
		ndao.doUpdate(ndto);
		int flag = ndao.doUpdate(ndto);
		if(1 == flag) {
			log.debug("success:{}",flag);
			
		}else {
			log.debug("fail:{}",flag);
		}
	}
	
	public void doDelete() {
		log.debug("doDelete()");
		int flag = ndao.doDelete(ndto);
		if(1 == flag) {
			log.debug("success:{}",flag);
			
		}else {
			log.debug("fail:{}",flag);
		}
	} 
	
	
	public ShopNoticeDTO deSelectOne() {
		log.debug("doSelectOne()");  
		ShopNoticeDTO outVO = ndao.doSelectOne(ndto);
		
		if(null !=outVO) {
			log.debug("success:{}"+outVO);
		}else {
			log.debug("fail:{}"+outVO);
		}
		return outVO;
	}
	
	
	 
	public static void main(String[] args) { 
		
		ShopNoticeMain m = new ShopNoticeMain();
		//m.doSave();      //insert
		//m.doUpdate();    //update
		//m.doDelete();    //delete
		
		m.deSelectOne(); //select
		
		//m.doUpdateReadCnt();
	  
	}

}
