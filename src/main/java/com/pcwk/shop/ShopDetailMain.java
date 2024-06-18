package com.pcwk.shop;
  
import com.pcwk.ehr.cmn.PLog;

public class ShopDetailMain implements PLog{
	
	ShopDetailDao sdao;
	ShopDetailDTO sdto;
	
	public ShopDetailMain() {
		sdao = new ShopDetailDao();
		sdto = new ShopDetailDTO(2, "EOMGIEUN", "000-2222-2222", "서울", "오전근무", "주정차금지", "패널티적용", "0800", "1800");
	}
	
	public void doSave() {
		log.debug("doSave()");
		int flag = sdao.doSave(sdto);
		if(1 == flag) {
			log.debug("success:{}",flag);
			
		}else {
			log.debug("fail:{}",flag);
		}
	}
	
	public void doUpdate() {
		log.debug("doUpdate()"); 
		String updateStr = "_U";
		sdto.setShopLoc(sdto.getShopLoc()    +updateStr);
		sdao.doUpdate(sdto);
		int flag = sdao.doUpdate(sdto);
		if(1 == flag) {
			log.debug("success:{}",flag);
			
		}else {
			log.debug("fail:{}",flag);
		}
	}
	
	public void doDelete() {
		log.debug("doDelete()");
		int flag = sdao.doDelete(sdto);
		if(1 == flag) {
			log.debug("success:{}",flag);
			
		}else {
			log.debug("fail:{}",flag);
		}
	}
	
	public ShopDetailDTO deSelectOne() {
		log.debug("doSelectOne()");  
		ShopDetailDTO outVO = sdao.doSelectOne(sdto);
		
		if(null !=outVO) {
			log.debug("success:{}"+outVO);
		}else {
			log.debug("fail:{}"+outVO);
		}
		return outVO;
	}
	public void isExist() {
		int i=sdao.isExist(sdto);
		System.out.println(i);
	}
	
		 
	
	public static void main(String[] args) { 
		
		ShopDetailMain m = new ShopDetailMain();
		//m.doSave();      //insert
		//m.doUpdate();    //update
		//m.doDelete();    //delete
		m.isExist();
		//m.deSelectOne(); //select
		
		//m.doUpdateReadCnt();
	  
	}
	
	
}
