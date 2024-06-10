package com.pcwk.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.pcwk.user.ConnectionMaker;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.WorkDlv;

public class UserDao implements WorkDlv<UserDTO> {

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
		int flag =0;
		
		Connection conn = connectionMaker.getConnection();
		
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder(1000);
		sb.append(" INSERT INTO userinfo (  \n");
		sb.append("     user_id,            \n");
		sb.append("     password,           \n");
		sb.append("     name,               \n");
		sb.append("     user_email,         \n");
		sb.append("     tel,                \n");
		sb.append("     birthday,           \n");
		sb.append("     shop_admin          \n");
		sb.append(" ) VALUES (              \n");
		sb.append("     ?,                 \n");
		sb.append("     ?,                 \n");
		sb.append("     ?,                 \n");
		sb.append("     ?,                 \n");
		sb.append("     ?,                 \n");
		sb.append("     ?,                 \n");
		sb.append("     ?                  \n");
		sb.append(" )                      \n");
		
		log.debug("1.sql:{}",sb.toString());
		log.debug("2.conn:{}",conn);
		log.debug("3.param:{}",param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, param.getUserId());
			pstmt.setString(2, param.getPassword());
			pstmt.setString(3, param.getName());
			pstmt.setString(4, param.getUserEmail());
			pstmt.setString(5, param.getTel());
			pstmt.setString(6, param.getBirthday());
			pstmt.setString(7, param.getShopAdmin());
			
			flag = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		
		}finally {
			DBUtil.close(conn, pstmt);
			log.debug("4.finally conn:{} pstmt:{}",conn,pstmt);
		}
		log.debug("5.flag:{}",flag);
		return flag;
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
