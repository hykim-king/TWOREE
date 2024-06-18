package com.pcwk.offday;

import java.util.List;

import com.pcwk.ehr.cmn.DTO;


public class OffDayService {
	private OffDayDAO dao;

	public OffDayService() {
		dao = new OffDayDAO();
	}
    
	public List<OffDayDTO> doRetrieve(DTO search) {
		
		return dao.doRetrieve(search);
	}
	

	public int doSave(OffDayDTO param) {
		
		return dao.doSave(param);
	}
	

	public int doUpdate(OffDayDTO param) {
		
		return dao.doUpdate(param);
	}
	

	public int doDelete(OffDayDTO param) {
		
		return dao.doDelete(param);
	}


	public OffDayDTO doSelectOne(OffDayDTO param) {
		OffDayDTO outVO = new OffDayDTO();
		outVO=dao.doSelectOne(param);
		return outVO;
	}

}
