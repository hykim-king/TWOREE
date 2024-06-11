package com.pcwk.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.pcwk.ehr.cmn.ConnectionMaker;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.WorkDiv;

public class ShopDAO implements WorkDiv<ShopDTO>{

	//connectionmaker 생성
	private ConnectionMaker connectionMaker;
	
	public ShopDAO() {
		connectionMaker = new ConnectionMaker();
	}

	@Override
	public List<ShopDTO> doRetrieve(DTO search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doSave(ShopDTO param) {
		int flag = 0;
		
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		return 0;
	}

	@Override
	public int doUpdate(ShopDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDelete(ShopDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShopDTO doSelectOne(ShopDTO param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doUpdateReadCnt(ShopDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
