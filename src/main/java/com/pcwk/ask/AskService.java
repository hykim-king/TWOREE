package com.pcwk.ask;

import java.util.List;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.PLog;

public class AskService implements PLog {
	private AskDAO dao;

	public AskService() {
		dao = new AskDAO();
	}
    
	public List<AskDTO> doRetrieve(DTO search) {
		
		return dao.doRetrieve(search);
	}
	

	public int doSave(AskDTO param) {
		
		return dao.doSave(param);
	}
	

	public int doUpdate(AskDTO param) {
		
		return dao.doUpdate(param);
	}
	

	public int doDelete(AskDTO param) {
		
		return dao.doDelete(param);
	}


	public AskDTO doSelectOne(AskDTO param) {
		AskDTO outVO = new AskDTO();
		outVO=dao.doSelectOne(param);
		return outVO;
	}

}
