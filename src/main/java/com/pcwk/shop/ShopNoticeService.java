package com.pcwk.shop;

import java.util.List;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.PLog;

public class ShopNoticeService implements PLog {
	
	private ShopNoticeDao dao;

	public ShopNoticeService() {
		dao = new ShopNoticeDao();
	}
    
	public List<ShopNoticeDTO> doRetrieve(DTO search) {
		
		return dao.doRetrieve(search);
	}
	

	public int doSave(ShopNoticeDTO param) {
		
		return dao.doSave(param);
	}
	

	public int doUpdate(ShopNoticeDTO param) {
		
		return dao.doUpdate(param);
	}
	

	public int doDelete(ShopNoticeDTO param) {
		
		return dao.doDelete(param);
	}


	public ShopNoticeDTO doSelectOne(ShopNoticeDTO param) {
		ShopNoticeDTO outVO = new ShopNoticeDTO();
		outVO=dao.doSelectOne(param);
		return outVO;
	}


}
