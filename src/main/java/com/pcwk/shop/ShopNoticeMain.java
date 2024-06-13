package com.pcwk.shop;

import java.util.List;
 
import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.SearchDTO;
//update 0611 0630
public class ShopNoticeMain implements PLog {
	ShopNoticeDao ndao;
	ShopNoticeDTO ndto;
	
	public ShopNoticeMain() {
		ndao = new ShopNoticeDao();
		ndto = new ShopNoticeDTO(8, 2, "공지제목", "사용안함", "공지내용","Y");
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
	
	
	public void doRetrieve() {
		log.debug("doRetrieve()");
		SearchDTO searchVO = new SearchDTO();

		searchVO.setSearchDiv("10");
		searchVO.setSearchWord("2"); //shop_no로 검색
		
		List<ShopNoticeDTO> list = ndao.doRetrieve(searchVO);
		int i = 0;
		for(ShopNoticeDTO vo : list) {
			log.debug("i: {}, vi: {}",++i,vo);
		}
	 
	}  
	
	
	 
	public static void main(String[] args) { 
		
		ShopNoticeMain m = new ShopNoticeMain();
		// m.doSave();      //insert
		//m.doUpdate();    //update
		//m.doDelete();    //delete
		
		//m.deSelectOne(); //select
		m.doRetrieve(); 
	  
	}

}
