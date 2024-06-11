package com.pcwk.shop;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List; 
 
import com.pcwk.ehr.cmn.DBUtil;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.WorkDiv;
import com.pcwk.ehr.cmn.ConnectionMaker;   


import com.pcwk.ehr.cmn.ConnectionMaker; 
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.WorkDiv;

import com.pcwk.ehr.cmn.DBUtil;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.WorkDiv; 
 

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.WorkDiv;
//왜 자꾸 늘어나는거야
public class ShopDetailDao implements WorkDiv<ShopDetailDTO> {

    private ConnectionMaker connectionMaker;
	
	public ShopDetailDao() { 
		connectionMaker = new ConnectionMaker();
	}
	
	 
	@Override
	public int doSave(ShopDetailDTO param) { 
		int flag = 0;
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO shop_detail (     \n");
		sb.append("     shop_no,                  \n");
		sb.append("     owner_name,               \n");
		sb.append("     shop_tel,                 \n");
		sb.append("     shop_loc,                 \n");
		sb.append("     shop_rule,                \n");
		sb.append("     park_info,                \n");
		sb.append("     reserve_info,             \n");
		sb.append("     open_time,                \n");
		sb.append("     close_time                \n");
		sb.append(" ) VALUES (                    \n");
		sb.append("     ?,                        \n");
		sb.append("     ?,                        \n");
		sb.append("     ?,                        \n");
		sb.append("     ?,                        \n");
		sb.append("     ?,                        \n");
		sb.append("     ?,                        \n");
		sb.append("     ?,                        \n");
		sb.append("     ?,                        \n");
		sb.append("     ?                         \n");
		sb.append(" )                             \n");
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString()); //荑쇰━瑜� �꽆寃⑥빞 �맂�떎.
			log.debug("4. pstmt : {}", pstmt);
			
		 
			pstmt.setInt(1, param.getShopNo()); 
			pstmt.setString(2, param.getOwnerName()); 
			pstmt.setString(3, param.getShopTel()); 
			pstmt.setString(4, param.getShopLoc()); 
			pstmt.setString(5, param.getShopRule()); 
			pstmt.setString(6, param.getParkInfo()); 
			pstmt.setString(7, param.getReserverInfo()); 
			pstmt.setString(8, param.getOpenTime()); 
			pstmt.setString(9, param.getCloseTime());
			 
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
	public int doUpdate(ShopDetailDTO param) {
		int flag = 0;
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE shop_detail      \n");
		sb.append(" SET                     \n");
		sb.append("      owner_name   = ?,  \n");
		sb.append("      shop_tel     = ?,  \n");
		sb.append("      shop_loc     = ?,  \n");
		sb.append("      shop_rule    = ?,  \n");
		sb.append("      park_info    = ?,  \n");
		sb.append("      reserve_info = ?,  \n");
		sb.append("      open_time    = ?,  \n");
		sb.append("      close_time   = ?   \n");
		sb.append(" WHERE                   \n");
		sb.append("      shop_no      = ?   \n");
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());  
			log.debug("4. pstmt : {}", pstmt);
		
			pstmt.setString(1, param.getOwnerName());
			pstmt.setString(2, param.getShopTel()); 
			pstmt.setString(3, param.getShopLoc()); 
			pstmt.setString(4, param.getShopRule()); 
			pstmt.setString(5, param.getParkInfo()); 
			pstmt.setString(6, param.getReserverInfo()); 
			pstmt.setString(7, param.getOpenTime()); 
			pstmt.setString(8, param.getCloseTime());
			pstmt.setInt(9, param.getShopNo()); 
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
	public int doDelete(ShopDetailDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShopDetailDTO doSelectOne(ShopDetailDTO param) {
		// TODO Auto-generated method stub
		return null;
		//#no
	}

	@Override
	public int doUpdateReadCnt(ShopDetailDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<ShopDetailDTO> doRetrieve(DTO search) {
		// TODO Auto-generated method stub
		return null;
	}

}
