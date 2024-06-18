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
	
	
	public int isExistId(UserDTO param) {
		int flag =0;
		
		Connection conn = connectionMaker.getConnection();
		
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder(1000);
		sb.append(" select *                \n");
		sb.append("   from userInfo         \n");
		sb.append("  where user_id =?       \n");
		
		log.debug("1.sql:{}",sb.toString());
		log.debug("2.conn:{}",conn);
		log.debug("3.param:{}",param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, param.getUserId());
			
			
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
		int flag = 0;
		Connection conn = connectionMaker.getConnection();
		
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE userinfo       \n");
		sb.append("SET                   \n");
		sb.append("     user_id = ?,     \n");
		sb.append("     password = ?,    \n");
		sb.append("     name = ?,        \n");
		sb.append("     user_email = ?,  \n");
		sb.append("     tel = ?,         \n");
		sb.append("     birthday = ?,    \n");
		sb.append("     shop_admin = ?,  \n");
		sb.append("     penalty_date = ? \n");
		sb.append(" where user_id =?     \n");
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4. pstmt : {}", pstmt);
		
			pstmt.setString(1, param.getUserId());
			pstmt.setString(2, param.getPassword());
			pstmt.setString(3, param.getName());
			pstmt.setString(4, param.getUserEmail());
			pstmt.setString(5, param.getTel());
			pstmt.setString(6, param.getBirthday());
			pstmt.setString(7, param.getShopAdmin());
			pstmt.setString(8, param.getPenaltyDate());
			pstmt.setString(9, param.getUserId());
			
			flag = pstmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt);
			log.debug("5. finally : conn : {} pstmt : {}", conn, pstmt);
		}
		log.debug("6. flag : {}", flag);	
			return flag;
	}

	@Override
	public int doDelete(UserDTO param) {
		int flag = 0;
		Connection conn = connectionMaker.getConnection();
		 
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM userinfo  \n");
		sb.append(" where user_id =?     \n");
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4. pstmt : {}", pstmt);
		
			pstmt.setString(1, param.getUserId());
		
			flag = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt);
			log.debug("5. finally : conn : {} pstmt : {}", conn, pstmt); //자원반납 안해주면 DB접속이 안돼용
		}
		log.debug("6. flag : {}", flag);
			return flag;
	}

	@Override
	public UserDTO doSelectOne(UserDTO param) {
		UserDTO outVO = null;
		
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder(1000);
		sb.append("SELECT            \n");
		sb.append("    user_id,      \n");
		sb.append("    password,     \n");
		sb.append("    name,         \n");
		sb.append("    user_email,   \n");
		sb.append("    tel,          \n");
		sb.append("    birthday,     \n");
		sb.append("    shop_admin,   \n");
		sb.append("    penalty_date  \n");
		sb.append("FROM userinfo     \n");
		sb.append("WHERE user_id =?  \n");
		
		log.debug("1.sql:\n"+sb.toString());
		log.debug("2.conn:"+conn);
		log.debug("3.param:"+param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt:"+pstmt);
			
			pstmt.setString(1, param.getUserId());
			
			rs = pstmt.executeQuery();
			log.debug("5.rs:" +rs);
			if(rs.next()) {
				outVO = new UserDTO();
				
				outVO.setUserId(rs.getString("user_id"));
				outVO.setPassword(rs.getString("password"));
				outVO.setName(rs.getString("name"));
				outVO.setUserEmail(rs.getString("user_email"));
				outVO.setTel(rs.getString("tel"));
				outVO.setBirthday(rs.getString("user_id"));
				outVO.setUserId(rs.getString("user_id"));
				
				
			}
			
			
		}catch (SQLException e) {
			log.debug("____________________________");
			log.debug("SQLException"+e.getMessage());
			log.debug("____________________________");
		}finally { 
			DBUtil.close(conn, pstmt, rs);
		log.debug("5. finally : conn : {} pstmt : {} rs : {}", conn, pstmt, rs);
		}
		log.debug("6. flag : {}", outVO);
		
		
		return outVO;
	}
	
	public int idCheck(UserDTO param) {
		int flag = 0;
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder(500);
		
		sb.append(" SELECT COUNT(*) cnt  \n");
		sb.append("   FROM userinfo      \n");
		sb.append("  WHERE user_id = ?   \n");
		
		log.debug("1.sql:\n"+sb.toString());
		log.debug("2.conn:"+conn);
		log.debug("3.param:"+param);
		
		try {
		pstmt = conn.prepareStatement(sb.toString());
		log.debug("4.pstmt:"+pstmt);
		pstmt.setString(1,param.getUserId());
		
		rs = pstmt.executeQuery();
		log.debug("5.rs:" +rs);
		
		if(rs.next()) {
			flag = rs.getInt("cnt");
			log.debug("6. flag : {}", flag);
		}
			
		}catch (SQLException e) {
			log.debug("____________________________");
			log.debug("SQLException"+e.getMessage());
			log.debug("____________________________");
		}finally { 
			DBUtil.close(conn, pstmt, rs);
		
		}
		
		return flag;
	}
	public int idPasswordCheck(UserDTO param) {
		int flag = 0;
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder(500);
		
		sb.append(" SELECT COUNT(*) cnt  \n");
		sb.append("   FROM userinfo      \n");
		sb.append("  WHERE user_id = ?   \n");
		sb.append("    AND password  = ? \n"); 	
		 
			log.debug("1.sql:\n"+sb.toString());
			log.debug("2.conn:"+conn);
			log.debug("3.param:"+param);
			
			try {
				pstmt = conn.prepareStatement(sb.toString());
				log.debug("4.pstmt:"+pstmt);
				
				pstmt.setString(1,param.getUserId());
				pstmt.setString(2,param.getPassword());
				
				rs = pstmt.executeQuery();
				log.debug("5.rs:" +rs);
				
				if(rs.next()) {
				 flag =	rs.getInt("cnt");
					log.debug("6. flag : {}", flag);
				}
					
				}catch (SQLException e) {
					log.debug("____________________________");
					log.debug("SQLException"+e.getMessage());
					log.debug("____________________________");
				}finally { 
					DBUtil.close(conn, pstmt, rs);
				
				}				

		return flag;
	}	
	
	
	@Override
	public int doUpdateReadCnt(UserDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
