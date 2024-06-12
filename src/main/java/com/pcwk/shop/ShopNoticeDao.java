package com.pcwk.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.cmn.ConnectionMaker;
import com.pcwk.ehr.cmn.DBUtil;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.WorkDiv;
//update 0611 0630
public class ShopNoticeDao implements WorkDiv<ShopNoticeDTO> {
	
	private ConnectionMaker connectionMaker;
	
	public ShopNoticeDao() { 
		connectionMaker = new ConnectionMaker();
	}


	@Override
	public int doSave(ShopNoticeDTO param) { 
	    int flag = 0;
	    Connection conn = connectionMaker.getConnection();
	    PreparedStatement pstmt = null;
	    
	    StringBuilder sb = new StringBuilder();
	    sb.append("  INSERT INTO shop_notice (          \n");
	    sb.append("     notice_no,                      \n");
	    sb.append("     shop_no,                        \n");
	    sb.append("     notice_title,                   \n");
	    sb.append("     notice_wrt_date,                \n");
	    sb.append("     content,                        \n");
	    sb.append("     fixed                           \n");
	    sb.append(" ) VALUES (                          \n");
	    sb.append("     ?,                              \n");
	    sb.append("     ?,                              \n");
	    sb.append("     ?,                              \n");
	    sb.append("     SYSDATE,                        \n");
	    sb.append("     ?,                              \n");
	    sb.append("     ?                               \n");
	    sb.append(" )                                   \n");
	    
	    log.debug("1. SQL : {}", sb.toString());
	    log.debug("2. Conn : {}", conn);
	    log.debug("3. param : {}", param);
	    
	    try {
	        pstmt = conn.prepareStatement(sb.toString()); // PreparedStatement를 생성합니다.
	        log.debug("4. pstmt : {}", pstmt);
	        
	        pstmt.setInt(1, param.getNoticeNo());  
	        pstmt.setInt(2, param.getShopNo());
	        pstmt.setString(3, param.getNoticeTitle());  
	        pstmt.setString(4, param.getContent()); 
	        pstmt.setString(5, param.getFixed()); 
	        
	        flag = pstmt.executeUpdate();  
	        
	    } catch(SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.close(conn, pstmt);
	        log.debug("5. finally : conn : {} pstmt : {}", conn, pstmt);
	    }
	    log.debug("6. flag : {}", flag);
	    
	    return flag;
	}


	@Override
	public int doUpdate(ShopNoticeDTO param) {
		int flag = 0;
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE shop_notice           \n");
		sb.append(" SET                          \n");
		sb.append("     shop_no        = ?,    \n"); 
		sb.append("     notice_title     = ?,    \n");
		sb.append("     notice_wrt_date  = SYSDATE,    \n");
		sb.append("     content          = ?,    \n");
		sb.append("     fixed            = ?     \n");
		sb.append(" WHERE    notice_no = ?         \n"); 
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());  
			log.debug("4. pstmt : {}", pstmt);
		
			pstmt.setInt(1, param.getShopNo());
			pstmt.setString(2, param.getNoticeTitle());  
			pstmt.setString(3, param.getContent()); 
			pstmt.setString(4, param.getFixed());   
			
			pstmt.setInt(5, param.getNoticeNo()); 
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
	public int doDelete(ShopNoticeDTO param) {
		int flag = 0;
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("delete from shop_notice \n");
		sb.append("where  notice_no = ?      \n");
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString()); 
			log.debug("4. pstmt : {}", pstmt);
			 
			pstmt.setInt(1, param.getNoticeNo());  
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
	public ShopNoticeDTO doSelectOne(ShopNoticeDTO param) { 
		ShopNoticeDTO outVO = null;
		
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder(300);
		sb.append("  select                  \n");
		sb.append("  notice_no,              \n");
		sb.append("  shop_no,                \n");
		sb.append("  notice_title,           \n");
		sb.append("  notice_wrt_date,        \n");
		sb.append("  content,                \n");
		sb.append("  fixed                   \n");
		sb.append("  from shop_notice        \n"); 
		sb.append("  where notice_no = ?     \n");
		
		log.debug("1.sql:\n"+sb.toString());
		log.debug("2.conn:"+conn);
		log.debug("3.param:"+param);
		
		try { 
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt:"+pstmt);
			
			pstmt.setInt(1,param.getShopNo());
			//pstmt.setInt(0,0);
			
			
			rs = pstmt.executeQuery();
			log.debug("5.rs:" +rs);
			if(rs.next()) {
				outVO = new ShopNoticeDTO();
				outVO.setNoticeNo   (rs.getInt("notice_no")); 
				outVO.setShopNo      (rs.getInt("shop_no")); 
				outVO.setNoticeTitle     (rs.getString("notice_title")); 
				outVO.setNoticeWrtDate  (rs.getString("notice_wrt_date")); 
				outVO.setContent   (rs.getString("content")); 
				outVO.setFixed    (rs.getString("fixed"));  
				log.debug("6.outVO:"+outVO);
			}
			
			
		}catch (SQLException e) {
		log.debug("____________________________");
		log.debug("SQLException"+e.getMessage());
		log.debug("____________________________");
			//e.printStackTrace();c
		}finally { 
			DBUtil.close(conn, pstmt, rs);
		log.debug("5. finally : conn : {} pstmt : {} rs : {}", conn, pstmt, rs);
	}
	log.debug("6. flag : {}", outVO);
	
	return outVO;
} 
	
	@Override
	public List<ShopNoticeDTO> doRetrieve(DTO search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doUpdateReadCnt(ShopNoticeDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
