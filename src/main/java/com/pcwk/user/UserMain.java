package com.pcwk.user;

import com.pcwk.ehr.cmn.PLog;

public class UserMain implements PLog {
	
	UserDao uao;
	UserDTO udto;

	public UserMain() {
		uao = new UserDao();
		udto = new UserDTO("user1","4321","찬호","ch@naver.com","010-9999-9998","19940907","Y","");
		
	}
	public void doSave() {
		log.debug("doSave()");
		int flag = uao.doSave(udto);
		if(1 == flag) {
			log.debug("성공:{}",flag);
			
		}else {
			log.debug("실패:{}",flag);
		}
	}
	
	public static void main(String[] args) {
	
		UserMain m = new UserMain();
		m.doSave();

	}

}
