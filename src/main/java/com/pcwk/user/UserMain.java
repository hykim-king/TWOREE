package com.pcwk.user;

import com.pcwk.ehr.cmn.PLog;

public class UserMain implements PLog {
	
	UserDTO DTO;
	UserDao Dao;
	
	public UserMain() {
		DTO = new UserDTO("admin","pcwk","관리자","admin123@admin.com","1012341234","20010101","Y","null");
		Dao = new UserDao();
	}
	
	public void doSelectOne() {
		log.debug("doDelete()");
		UserDTO outVO = Dao.doSelectOne(DTO);
		
		if(outVO != null) {
			log.debug("성공 : {} ", outVO);
		}else {
			log.debug("실패 : {} ", outVO);
		}
	}
	
	public static void main(String[] args) {
		
		UserMain m = new UserMain();
		
		m.doSelectOne();
	}
}
