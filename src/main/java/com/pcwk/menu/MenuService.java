package com.pcwk.menu;

import java.util.List;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.PLog;

public class MenuService implements PLog {
	private MenuDAO dao;

	public MenuService() {
		dao = new MenuDAO();
	}
    
	public List<MenuDTO> doRetrieve(DTO search) {
		
		return dao.doRetrieve(search);
	}
	

	public int doSave(MenuDTO param) {
		
		return dao.doSave(param);
	}
	

	public int doUpdate(MenuDTO param) {
		
		return dao.doUpdate(param);
	}
	

	public int doDelete(MenuDTO param) {
		
		return dao.doDelete(param);
	}


	public MenuDTO doSelectOne(MenuDTO param) {
		MenuDTO outVO = new MenuDTO();
		outVO=dao.doSelectOne(param);
		return outVO;
	}

}
