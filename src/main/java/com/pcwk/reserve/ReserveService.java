package com.pcwk.reserve;

import java.util.List;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.PLog;


public class ReserveService implements PLog {
	private ReserveDao dao;

	public ReserveService() {
		dao = new ReserveDao();
	}
    
	public List<ReserveDTO> doRetrieve(DTO search) {
		
		return dao.doRetrieve(search);
	} 

	public int doSave(ReserveDTO param) {
		
		return dao.doSave(param);
	}
	

	public int doUpdate(ReserveDTO param) {
		
		return dao.doUpdate(param);
	}
	

	public int doDelete(ReserveDTO param) {
		
		return dao.doDelete(param);
	}


	public ReserveDTO doSelectOne(ReserveDTO param) {
		ReserveDTO outVO = new ReserveDTO();
		outVO=dao.doSelectOne(param);
		return outVO;
	}


}
