package com.pcwk.shop;

import java.util.List;

import com.pcwk.ehr.cmn.DTO;

public class ShopReserveSetService {
	private ShopReserveSetDao dao;

	public ShopReserveSetService() {
		dao = new ShopReserveSetDao();
	}
    
	public int doSaveOrModify(ShopReserveSetDTO param) {
		int flag =0;
		flag=dao.isExist(param);
		if(flag==1) {
			dao.doUpdate(param);
		}else {
			dao.doSave(param);
		}
		return flag;
	}

	
	public List<ShopReserveSetDTO> doRetrieve(DTO search) {
		
		return dao.doRetrieve(search);
	}
	
	
	public int doSave(ShopReserveSetDTO param) {
		
		return dao.doSave(param);
	}
	

	public int doUpdate(ShopReserveSetDTO param) {
		
		return dao.doUpdate(param);
	}
	

	public int doDelete(ShopReserveSetDTO param) {
		
		return dao.doDelete(param);
	}


	public ShopReserveSetDTO doSelectOne(ShopReserveSetDTO param) {
		ShopReserveSetDTO outVO = new ShopReserveSetDTO();
		outVO=dao.doSelectOne(param);
		return outVO;
	}

}
