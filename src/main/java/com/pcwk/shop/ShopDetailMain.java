package com.pcwk.shop;
 
import com.pcwk.ehr.cmn.PLog;

public class ShopDetailMain implements PLog{
	
	ShopDetailDao sdao;
	ShopDetailDTO sdto;
	
	public ShopDetailMain() {
		sdao = new ShopDetailDao();
		sdto = new ShopDetailDTO(0, "������", "111-111", "����", "�����ٹ�", "����������", "�г�Ƽ����", "8", "18");
	}
	
	public void doSave() {
		log.debug("doSave()");
		int flag = sdao.doSave(sdto);
		if(1 == flag) {
			log.debug("����:{}",flag);
			
		}else {
			log.debug("����:{}",flag);
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
