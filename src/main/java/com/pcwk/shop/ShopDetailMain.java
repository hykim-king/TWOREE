package com.pcwk.shop;
 
import com.pcwk.ehr.cmn.PLog;

public class ShopDetailMain implements PLog{
	
	ShopDetailDao sdao;
	ShopDetailDTO sdto;
	
	public ShopDetailMain() {
		sdao = new ShopDetailDao();
		sdto = new ShopDetailDTO(0, "엄기은", "111-111", "서울", "오전근무", "주정차금지", "패널티적용", "8", "18");
	}
	
	public void doSave() {
		log.debug("doSave()");
		int flag = sdao.doSave(sdto);
		if(1 == flag) {
			log.debug("성공:{}",flag);
			
		}else {
			log.debug("실패:{}",flag);
		}
	}
	
	public static void main(String[] args) { 
		
		ShopDetailMain m = new ShopDetailMain();
		//m.doUpdateReadCnt();
		//m.doRetrieve();
		//m.doUpdate();
		m.doSave();
		//m.doDelete();
		//m.doSelectOne();
		//m.addAndGet();
	}
	
	
}
