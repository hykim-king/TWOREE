package com.pcwk.offday;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.cmn.ConnectionMaker;
import com.pcwk.ehr.cmn.DBUtil;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.WorkDiv;

public class OffDayDAO implements WorkDiv<OffDayDTO> {
	ConnectionMaker connectionMaker;

	public Connection getConnection() {
		return connectionMaker.getConnection();
	}
	 

	public OffDayDAO(ConnectionMaker connectionMaker) {
		super();
		connectionMaker = new ConnectionMaker();
	}


	@Override
	public int doUpdate(OffDayDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doUpdateReadCnt(OffDayDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OffDayDTO> doRetrieve(DTO search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doSave(OffDayDTO param) {
		return 0;
	}

	@Override
	public int doDelete(OffDayDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OffDayDTO doSelectOne(OffDayDTO param) {
		// TODO Auto-generated method stub
		return null;
	}

}
