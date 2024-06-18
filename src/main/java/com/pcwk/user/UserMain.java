package com.pcwk.user;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.PLog;

public class UserMain implements PLog {
	

	UserDao uao;
	UserDTO udto;

	public UserMain() {
		uao = new UserDao();
		udto = new UserDTO();
		udto.setUserId("hosu");
		udto.setPassword("2852");
		
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
	
	public void idCheck() {
		log.debug("idCheck()");
		int flag = uao.idCheck(udto);
		if(1==flag) {
			log.debug("idCheck성공:{}",flag);
		}else {
			log.debug("idCheck실패:{}",flag);
		}
		
	}
	
	public void idPassworkCheck() {
		log.debug("idPassworkCheck()");
		int flag = uao.idPasswordCheck(udto);
		if(1==flag) {
			log.debug("idPassworkCheck성공:{}",flag);
		}else {
			log.debug("idPassworkCheck실패:{}",flag);
		}
		
	}
	
	public int login() {
		int result = 0;
		int flag = uao.idCheck(udto);
		
		if(flag ==0) {
			result = 10;
			return result;
		}
		
		flag = uao.idPasswordCheck(udto);
		if(flag == 0) {
			result = 20;
			return result;
		}
		return 30;
	}
	
	public DTO doUserSelect() {
		int result = login();
		UserDTO outVO = null;
		if(30==result) {
			outVO = uao.doSelectOne(udto);
		}
		return outVO;
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
		//m.isExistId();
		
		int result = m.login();
		log.debug("result:{}",result);
		UserDTO user = (UserDTO) m.doUserSelect();
		log.debug("user:{}",user);
		
	}
}