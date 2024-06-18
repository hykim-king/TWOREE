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

public class ShopReserveSetDao implements WorkDiv<ShopReserveSetDTO>{

	//connectionmaker 생성
		private ConnectionMaker connectionMaker;
		
	
	public ShopReserveSetDao() {
		connectionMaker = new ConnectionMaker();
	}
	
	public int isExist(ShopReserveSetDTO param) {
		int flag =0;

		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("select * from shop_reserve_set where shop_no=?  \n");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());  
			pstmt.setInt(1, param.getShopNo());
			flag = pstmt.executeUpdate(); 
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt);
		}
		return flag;
		
	}

	@Override
	public int doSave(ShopReserveSetDTO param) {
		int flag = 0;
		
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		
		
		sb.append("INSERT INTO shop_reserve_set ( 	\n");
		sb.append("	    shop_no,                  	\n");
		sb.append("	    table_cap,                	\n");
		sb.append("	    people_cap,               	\n");
		sb.append("	    start_time,               	\n");
		sb.append("	    end_time                  	\n");
		sb.append("	) VALUES (                    	\n");
		sb.append("	    ?,                    	  	\n");
		sb.append("	    ?,                    	 	\n");
		sb.append("	    ?,                      	\n");
		sb.append("	    ?,                      	\n");
		sb.append("	    ?                      	 	\n");
		sb.append("	)                            	\n");
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4. pstmt : {}", pstmt);
			
		 
			pstmt.setInt(1, param.getShopNo());
			pstmt.setInt(2, param.getTableCap()); 
			pstmt.setInt(3, param.getPeopleCap());
			pstmt.setString(4, param.getStartTime());
			pstmt.setString(5, param.getEndTime());
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
	public int doUpdate(ShopReserveSetDTO param) {
		int flag = 0;
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
	
		sb.append("UPDATE shop_reserve_set 	\n");
		sb.append("SET                     	\n");
		sb.append("   start_time = ?,    	\n");
		sb.append("   end_time = ?       	\n");
		sb.append("WHERE                   	\n");
		sb.append("        shop_no = ?   	\n");
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());  
			log.debug("4. pstmt : {}", pstmt);
		
			pstmt.setString(1, param.getStartTime());
			pstmt.setString(2, param.getEndTime());  
			pstmt.setInt(3, param.getShopNo()); 
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
	public int doDelete(ShopReserveSetDTO param) {
		
		int flag = 0;
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("delete from shop_reserve_set \n");
		sb.append("where  shop_no = ?      \n");
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString()); 
			log.debug("4. pstmt : {}", pstmt);
			 
			pstmt.setInt(1, param.getShopNo());  
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
	public ShopReserveSetDTO doSelectOne(ShopReserveSetDTO param) {
		
		ShopReserveSetDTO outVO = null;
			
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		StringBuilder sb = new StringBuilder(300);
		sb.append(" 	SELECT               \n");
		sb.append("     shop_no,             \n");
		sb.append("     table_cap,           \n");
		sb.append("     people_cap,          \n");
		sb.append("     start_time,          \n");
		sb.append("     end_time             \n");
		sb.append(" FROM                     \n");
		sb.append("     shop_reserve_set     \n");
		sb.append(" WHERE                    \n");
		sb.append("     shop_no = ?	         \n");
		
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
					outVO = new ShopReserveSetDTO();
					outVO.setShopNo(rs.getInt("shop_no")); 
					outVO.setTableCap(rs.getInt("table_cap")); 
					outVO.setPeopleCap(rs.getInt("people_cap")); 
					outVO.setStartTime(rs.getString("start_time")); 
					outVO.setEndTime(rs.getString("end_time"));  
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
	public List<ShopReserveSetDTO> doRetrieve(DTO search) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int doUpdateReadCnt(ShopReserveSetDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
