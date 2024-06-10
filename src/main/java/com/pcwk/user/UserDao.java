package com.pcwk.user;

import java.util.List;

import com.pcwk.user.ConnectionMaker;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.WorkDiv;

public class UserDao implements WorkDiv<UserDTO> {

	private ConnectionMaker connectionMaker;
	public UserDao() {
		connectionMaker=new ConnectionMaker();
	}
	
	@Override
	public List<UserDTO> doRetrieve(DTO search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doSave(UserDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doUpdate(UserDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDelete(UserDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserDTO doSelectOne(UserDTO param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doUpdateReadCnt(UserDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
