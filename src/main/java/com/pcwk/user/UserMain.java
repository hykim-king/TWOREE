package com.pcwk.user;

import com.pcwk.ehr.cmn.PLog;

public class UserMain implements PLog {
	

	UserDao uao;
	UserDTO udto;

	public UserMain() {
		uao = new UserDao();
		udto = new UserDTO("user1","4321","찬호","ch@naver.com1","010-9999-9990","19940907","Y","");
		
	}
	public void isExistId() {
		log.debug("isExistId()");
		udto.setUserId("user123");
		int flag = uao.isExistId(udto);
		if(1 == flag) {
			log.debug("중복된 아이디:{}",flag);
			
		}else {
			log.debug("사용가능한 아이디:{}",flag);
		}
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
	
	public void doUpdate() {
		log.debug("doUpdate()");
		String updateStr = "";
	
		udto.setUserId(udto.getUserId()+updateStr);
		udto.setPassword(udto.getPassword()+updateStr);
		udto.setName(udto.getName()+updateStr);
		udto.setUserEmail(udto.getUserEmail()+updateStr);
		udto.setTel(udto.getTel()+updateStr);
		udto.setBirthday("20132222");
		udto.setShopAdmin(udto.getShopAdmin()+updateStr);
		udto.setPenaltyDate(udto.getPenaltyDate()+updateStr);
	
		uao.doUpdate(udto);
		int flag = uao.doUpdate(udto);
		if(1== flag) {
			log.debug("성공:{}",flag);
		}else {
		log.debug("실패:{}",flag);
	
		}
	
	}
	public void doDelete() {
		log.debug("doDelete()");
		int flag = uao.doDelete(udto);
		if(1 == flag) {
			log.debug("성공:{}",flag);
			
		}else {
			log.debug("실패:{}",flag);
		}
	}
	
	public UserDTO doSelectOne() {
		log.debug("doSelectOne()");
		UserDTO outVO = uao.doSelectOne(udto);
		
		if(null !=outVO) {
			log.debug("단건 조회 성공"+outVO);
		}else {
			log.debug("단건 조회 실패"+outVO);
		}
		return outVO;
	}
	
	
	public static void main(String[] args) {
		
		UserMain m = new UserMain();
		//m.doSave();
		//m.doUpdate();
		//m.doDelete();
		//m.doSelectOne();
		m.isExistId();
	}
}