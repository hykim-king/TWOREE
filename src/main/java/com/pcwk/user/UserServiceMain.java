package com.pcwk.user;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.MessageVO;
import com.pcwk.ehr.cmn.PLog;

public class UserServiceMain implements PLog {

	UserService service;
	UserDTO user01;
	
	public UserServiceMain() {
		service = new UserService();
		user01 = new UserDTO();
		user01.setUserId("hosu");
		user01.setPassword("2852");
	}
	
	public void doUserSelect() {
		log.debug("doUserSelect()");
		
		DTO dto = service.doUserSelect(user01);
		if(dto instanceof UserDTO) {
			UserDTO outVO = (UserDTO) dto;
		}else {
			MessageVO message = (MessageVO) dto;
		}
		
		
		
	}
	
	public static void main(String[] args) {
		UserServiceMain main = new UserServiceMain();
		main.doUserSelect();

	}

}
