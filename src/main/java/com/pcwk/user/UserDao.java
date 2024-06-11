package com.pcwk.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.cmn.ConnectionMaker;
import com.pcwk.ehr.cmn.DBUtil;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.WorkDiv;

public class UserDao implements WorkDiv<UserDTO> {
	
	UserDTO DTO;
	
	private ConnectionMaker connectionMaker;
	
	public UserDao() {
		connectionMaker=new ConnectionMaker();
		DTO = new UserDTO();
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
		
		UserDTO outVO = null;

		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null; // ResultSet은 대소문자를 구분하지 않는다.

		StringBuilder sb = new StringBuilder();
		
		sb.append("	SELECT           							\n");
		sb.append("    user_id,      							\n");
		sb.append("    password,     							\n");
		sb.append("    name,         							\n");
		sb.append("    user_email,  							\n");
		sb.append("    tel,          							\n");
		sb.append("    birthday,							 	\n");
		sb.append("    shop_admin,   							\n");
		sb.append("    penalty_date  							\n");
		sb.append("FROM              							\n");
		sb.append("    userinfo      							\n");
		sb.append("WHERE user_id = ?     						\n");
			
		log.debug("1.sql : {} \n " + sb.toString());
		log.debug("2.conn : {} ", conn);
		log.debug("3.param : {}", param);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt : {} ", pstmt);

			pstmt.setString(1, param.getUserId());
			rs = pstmt.executeQuery();
			log.debug("5. rs : " + rs);

			if (rs.next()) {
				outVO = new UserDTO();
				outVO.setUserId(rs.getString("user_id"));
				outVO.setPassword(rs.getString("password"));
				outVO.setName(rs.getString("name"));
				outVO.setUserEmail(rs.getString("user_email"));
				outVO.setTel(rs.getString("tel"));
				outVO.setBirthday(rs.getString("birthday"));
				outVO.setShopAdmin(rs.getString("shop_admin"));
				outVO.setPenaltyDate(rs.getString("penalty_date"));
				log.debug("6.outVO:" + outVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return outVO;
	}

	@Override
	public int doUpdateReadCnt(UserDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
