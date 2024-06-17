package com.pcwk.shop;

import java.util.List;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.PLog;

public class ShopDetailService implements PLog {
	private ShopDetailDao dao;

	public ShopDetailService() {
		dao = new ShopDetailDao();
	}
    
	public List<ShopDetailDTO> doRetrieve(DTO search) {
		
		return dao.doRetrieve(search);
	}
	

	public int doSave(ShopDetailDTO param) {
		
		return dao.doSave(param);
	}
	

	public int doUpdate(ShopDetailDTO param) {
		
		return dao.doUpdate(param);
	}
	

	public int doDelete(ShopDetailDTO param) {
		
		return dao.doDelete(param);
	}


	public ShopDetailDTO doSelectOne(ShopDetailDTO param) {
		ShopDetailDTO outVO = new ShopDetailDTO();
		outVO=dao.doSelectOne(param);
		return outVO;
	}

}
