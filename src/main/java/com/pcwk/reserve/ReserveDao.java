package com.pcwk.reserve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pcwk.ehr.cmn.DBUtil;
import com.pcwk.ehr.cmn.SearchDTO;
import com.pcwk.ehr.cmn.ConnectionMaker;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.PLog;
import com.pcwk.ehr.cmn.WorkDiv;

public class ReserveDao implements WorkDiv<ReserveDTO>,PLog {
	
	private ConnectionMaker connectionMaker;
	
	public ReserveDao() {
		connectionMaker = new ConnectionMaker();
	}
	
	@Override
	public List<ReserveDTO> doRetrieve(DTO search) {
		SearchDTO searchVO = (SearchDTO) search;
		
		StringBuilder sbWhere = new StringBuilder(300);
		if(null != searchVO.getSearchDiv() && searchVO.getSearchDiv().equals("10")) {
			sbWhere.append("WHERE user_id = ?  \n");
		}else if(null != searchVO.getSearchDiv() && searchVO.getSearchDiv().equals("20")) {
			sbWhere.append("WHERE shop_no = ?  \n");
		}
		
		List<ReserveDTO> list = new ArrayList<ReserveDTO>();
		
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder(1000);
		
		sb.append("SELECT t2.*, t3.*                                                      \n");
		sb.append("  FROM(                                                                \n");
		sb.append("		SELECT tt1.rnum as num,                                           \n");
		sb.append("			   tt1.reserve_no,                                            \n");
		sb.append("			   tt1.user_id,                                               \n");
		sb.append("			   tt1.shop_no,                                               \n");
		sb.append("			   tt1.people,                                               \n");
		sb.append("			   tt1.reserve_date,                                          \n");
		sb.append("			   tt1.reserve_app_date,                                      \n");
		sb.append("			   tt1.user_tel,                                              \n");
		sb.append("			   tt1.reserve_state,                                         \n");
		sb.append("			   tt1.confirmed_date,                                        \n");
		sb.append("			   tt1.user_comment                                           \n");
		sb.append("		FROM(                                                             \n");
		sb.append("				SELECT ROWNUM as rnum, t1.*                               \n");
		sb.append("				FROM                                                      \n");
		sb.append("					(SELECT *                                             \n");
		sb.append("						FROM reserve                                      \n");
		sb.append(sbWhere.toString());                                
		sb.append("						ORDER BY reserve_state desc, confirmed_date desc  \n");
		sb.append("						)t1                                               \n");
		sb.append("			WHERE rownum <= (?*(?-1)+?)                                   \n");
		sb.append("			)tt1                                                          \n");
		sb.append("		WHERE rnum >= (?*(?-1)+1)                                         \n");
		sb.append("	  )t2,(                                                               \n");
		sb.append("		SELECT COUNT(*) totalCnt                                          \n");
		sb.append("		  FROM reserve                                                    \n");
		sb.append(sbWhere.toString());                                                  
		sb.append("  )t3                                                                  \n");
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", search);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4. pstmt : {}", pstmt);
			
			if(null != searchVO.getSearchDiv() && searchVO.getSearchDiv().equals("10")) {
				log.debug("4-1. pstmt : {}", searchVO.getSearchDiv());
			
				pstmt.setString(1, searchVO.getSearchWord());
				pstmt.setInt(2, searchVO.getPageSize());
				pstmt.setInt(3, searchVO.getPageNo());
				pstmt.setInt(4, searchVO.getPageSize());
				pstmt.setInt(5, searchVO.getPageSize());
				pstmt.setInt(6, searchVO.getPageNo());
				pstmt.setString(7, searchVO.getSearchWord());
			
			
			}else if(null != searchVO.getSearchDiv() && searchVO.getSearchDiv().equals("20")) {
				log.debug("4-1. pstmt : {}", searchVO.getSearchDiv());
				pstmt.setInt(1, searchVO.getSearchSeq());
				pstmt.setInt(2, searchVO.getPageSize());
				pstmt.setInt(3, searchVO.getPageNo());
				pstmt.setInt(4, searchVO.getPageSize());
				pstmt.setInt(5, searchVO.getPageSize());
				pstmt.setInt(6, searchVO.getPageNo());
				pstmt.setInt(7, searchVO.getSearchSeq());
			
			}
			rs = pstmt.executeQuery();
			log.debug("5.rs:{}",rs);
			
			while(rs.next()) {
				ReserveDTO outVO = new ReserveDTO();
				outVO.setNum(rs.getInt("num"));
				outVO.setReserveNo(rs.getInt("reserve_no"));
				outVO.setUserId(rs.getString("user_id"));
				outVO.setShopNo(rs.getInt("shop_no"));
				outVO.setPeople(rs.getInt("people"));
				outVO.setReserveDate(rs.getString("reserve_date"));
				outVO.setReserveAppDate(rs.getString("reserve_app_date"));
				outVO.setUserTel(rs.getString("user_tel"));
				outVO.setReserveState(rs.getString("reserve_state"));
				outVO.setConfirmedDate(rs.getString("confirmed_date"));
				outVO.setUserComment(rs.getString("user_comment"));
				outVO.setTotalCnt(rs.getInt("totalCnt"));
				
				list.add(outVO);
			
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			DBUtil.close(conn, pstmt);
			log.debug("5. finally : conn : {} pstmt : {}", conn, pstmt,rs);
		}
		
		return list;
	}

	@Override
	public int doSave(ReserveDTO param) {
		int flag = 0;
		Connection conn = connectionMaker.getConnection();
		 
		PreparedStatement pstmt = null; 
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO reserve (      \n");
		sb.append("    reserve_no,            \n");
		sb.append("    user_id,               \n");
		sb.append("    shop_no,               \n");
		sb.append("    people,                \n");
		sb.append("    reserve_date,          \n");
		sb.append("    reserve_app_date,      \n");
		sb.append("    user_tel,              \n");
		sb.append("    reserve_state,         \n");
		sb.append("    confirmed_date,        \n");
		sb.append("    user_comment           \n");
		sb.append(") VALUES (                 \n");
		sb.append("    reserve_seq.NEXTVAL,  \n");
		sb.append("    ?,                    \n");
		sb.append("    ?,                    \n");
		sb.append("    ?,                    \n");
		sb.append("    ?,                    \n");
		sb.append("    ?,                    \n");
		sb.append("    ?,                    \n");
		sb.append("    ?,                    \n");
		sb.append("    ?,                    \n");
		sb.append("    ?                     \n");
		sb.append(")                          \n");
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4. pstmt : {}", pstmt);
			
			pstmt.setString(1, param.getUserId());
			pstmt.setInt(2, param.getShopNo());
			pstmt.setInt(3, param.getPeople());
			pstmt.setString(4, param.getReserveDate());
			pstmt.setString(5, param.getReserveAppDate());
			pstmt.setString(6, param.getUserTel());
			pstmt.setString(7, param.getReserveState());
			pstmt.setString(8, param.getConfirmedDate());
			pstmt.setString(9, param.getUserComment());
			
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
	public int doUpdate(ReserveDTO param) {
		int flag = 0;
		Connection conn = connectionMaker.getConnection();
		 
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE reserve                 \n");
		sb.append("SET                            \n");
		sb.append("        user_id = ? ,          \n");
		sb.append("        shop_no = ? ,          \n");
		sb.append("        people = ? ,           \n");
		sb.append("        reserve_date = ?,      \n");
		sb.append("        reserve_app_date = ?,  \n");
		sb.append("        user_tel = ?  ,        \n");
		sb.append("        reserve_state = ? ,    \n");
		sb.append("        confirmed_date = ?  ,  \n");
		sb.append("        user_comment = ?       \n");
		sb.append("WHERE                          \n");
		sb.append("reserve_no = ?                 \n");
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4. pstmt : {}", pstmt);
			
			pstmt.setString(1, param.getUserId());
			pstmt.setInt(2, param.getShopNo());
			pstmt.setInt(3, param.getPeople());
			pstmt.setString(4, param.getReserveDate());
			pstmt.setString(5, param.getReserveAppDate());
			pstmt.setString(6, param.getUserTel());
			pstmt.setString(7, param.getReserveState());
			pstmt.setString(8, param.getConfirmedDate());
			pstmt.setString(9, param.getUserComment());	
			pstmt.setInt(10, param.getReserveNo());
			
			
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
	public int doDelete(ReserveDTO param) {
		int flag = 0;
		Connection conn = connectionMaker.getConnection();
		
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("delete from reserve 	     \n");		
		sb.append("    where reserve_no = ?	 \n"); 
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4. pstmt : {}", pstmt);
			
			pstmt.setInt(1, param.getReserveNo());
			
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
	
	public int updateState(ReserveDTO param) {
		int flag = 0;
		Connection conn = connectionMaker.getConnection();
		 
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE reserve                 \n");
		sb.append("SET                            \n");
		sb.append("        reserve_state = ?      \n");
		sb.append("WHERE                          \n");
		sb.append("reserve_no = ?                 \n");
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4. pstmt : {}", pstmt);
			
			pstmt.setString(1, param.getReserveState());
			pstmt.setInt(2, param.getReserveNo());
			
			
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
	public ReserveDTO doSelectOne(ReserveDTO param) {
		ReserveDTO outVO = null;
		Connection conn = connectionMaker.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder(1000);
		sb.append("SELECT                 \n");
		sb.append("    reserve_no,        \n");
		sb.append("    user_id,           \n");
		sb.append("    shop_no,           \n");
		sb.append("    people,            \n");
		sb.append("    reserve_date,      \n");
		sb.append("    reserve_app_date,  \n");
		sb.append("    user_tel,          \n");
		sb.append("    reserve_state,     \n");
		sb.append("    confirmed_date,    \n");
		sb.append("    user_comment       \n");
		sb.append("FROM  reserve          \n");
		sb.append("where reserve_no =?    \n");
		
		log.debug("1.sql:\n"+sb.toString());
		log.debug("2.conn:"+conn);
		log.debug("3.param:"+param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt:"+pstmt);
			
			pstmt.setInt(1,param.getReserveNo());
			
			rs = pstmt.executeQuery();
			log.debug("5.rs:" +rs);
			if(rs.next()) {
				outVO = new ReserveDTO(); 
				
				outVO.setReserveNo(rs.getInt("reserve_no"));
				outVO.setUserId(rs.getString("user_id"));
				outVO.setShopNo(rs.getInt("shop_no"));
				outVO.setPeople(rs.getInt("people"));
				outVO.setReserveDate(rs.getString("reserve_date"));
				outVO.setReserveAppDate(rs.getString("reserve_app_date"));
				outVO.setUserTel(rs.getString("user_tel"));
				outVO.setReserveState(rs.getString("reserve_state"));
				outVO.setConfirmedDate(rs.getString("confirmed_date"));
				outVO.setUserComment(rs.getString("user_comment"));
				log.debug("6.outVO:"+outVO);
			}
			
			
		}catch (SQLException e) {
			log.debug("____________________________");
			log.debug("SQLException"+e.getMessage());
			log.debug("____________________________");
				//e.printStackTrace();
				// TODO: handle exception
			}finally { 
				DBUtil.close(conn, pstmt, rs);
			log.debug("5. finally : conn : {} pstmt : {} rs : {}", conn, pstmt, rs);
		}
		log.debug("6. flag : {}", outVO);
		
		
		return outVO;
	}

	@Override
	public int doUpdateReadCnt(ReserveDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
