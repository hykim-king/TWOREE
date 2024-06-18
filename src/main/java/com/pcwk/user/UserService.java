package com.pcwk.user;

import java.util.List;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.MessageVO;
import com.pcwk.ehr.cmn.PLog;

public class UserService implements PLog {

	private UserDao uao;
	
	public UserService() {
		uao = new UserDao();
	}
	
	public int idCheck(UserDTO param) {
		return uao.idCheck(param);
	}
	
	public int loginStatus(UserDTO param) {
		int result = 0;
		int flag = uao.idCheck(param);
		
		if(flag ==0) {
			result = 10;
			return result;
		}
		
		flag = uao.idPasswordCheck(param);
		if(flag == 0) {
			result = 20;
			return result;
		}
		return 30;
	}
	
	public DTO doUserSelect(UserDTO param) {
		int result = loginStatus(param);
		
		if(30 == result) {
			DTO outVO = uao.doSelectOne(param);
			return outVO;
		}else {
			MessageVO message = new MessageVO();
			message.setMessageId(String.valueOf(result));
			
			String messageStr = "";
			if(10 == result) {
				messageStr = "ID를 확인 하세요.";
			}else if(20==result) {
				messageStr = "비번을 확인 하세요.";
			}
		
			message.setMsgContents(messageStr);
			log.debug("message:{}",message);
			return message;
		}
	}
	
	public List<UserDTO> doRetrieve(DTO search){
		return uao.doRetrieve(search);
	}
	
	public int doSave(UserDTO param) {
		return uao.doSave(param);
	}
	
	public int doUpdate(UserDTO param) {
		return uao.doUpdate(param);
	}
	
	public UserDTO doSelectOne(UserDTO param) {
		return uao.doSelectOne(param);
	}
}