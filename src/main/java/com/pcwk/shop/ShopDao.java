
package com.pcwk.shop;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pcwk.ehr.cmn.ConnectionMaker;
import com.pcwk.ehr.cmn.DBUtil;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.SearchDTO;
import com.pcwk.ehr.cmn.WorkDiv;
import com.pcwk.user.UserDTO;
import com.pcwk.user.UserDao;

public class ShopDao implements WorkDiv<ShopDTO>{

	//connectionmaker 생성
	private ConnectionMaker connectionMaker;
	
	public ShopDao() {
		connectionMaker = new ConnectionMaker();
		
	}

	@Override
	public int doSave(ShopDTO param) {
		int flag = 0;
		
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO shop (   \n");
		sb.append("	                    \n");
		sb.append("	    manager_id,     \n");
		sb.append("	    shop_name,      \n");
		sb.append("	    reg_date,       \n");
		sb.append("	    score,          \n");
		sb.append("	    review_cnt,     \n");
		sb.append("	    reserve_cnt,    \n");
		sb.append("	    is_verified     \n");
		sb.append("	) VALUES (          \n");
		sb.append("	              	\n");
		sb.append("	    ?,            	\n");
		sb.append("	    ?,            	\n");
		sb.append("	    sysdate,        \n");
		sb.append("	    0,              \n");
		sb.append("	    0,              \n");
		sb.append("	    0,           	\n");
		sb.append("	    ?             	\n");
		sb.append("	)                   \n");
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4. pstmt : {}", pstmt);
			
		 
			
			pstmt.setString(1, param.getManagerId()); 
			pstmt.setString(2, param.getShopName());
			pstmt.setString(3, param.getIsVerified());
			 
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
	public int doUpdate(ShopDTO param) {
		int flag = 0;
		
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("UPDATE shop           	\n");
		sb.append("SET                    	\n");
		sb.append("    shop_name = ?,   	\n");
		sb.append("    score = ?,       	\n");
		sb.append("    review_cnt = ?,  	\n");
		sb.append("    reserve_cnt = ?, 	\n");
		sb.append("    is_verified = ?		\n");
		sb.append("WHERE                  	\n");
		sb.append("    shop_no = ?      	\n");
		
		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4. pstmt : {}", pstmt);
			
			pstmt.setString(1, param.getShopName());
			log.debug("4.1 getShopName : {}",  param.getShopName());
			pstmt.setInt(2, param.getScore());
			log.debug("4.2 getScore : {}",  param.getScore());
			pstmt.setInt(3, param.getReviewCnt());
			log.debug("4.3 getReviewCnt : {}",  param.getReviewCnt());
			pstmt.setInt(4, param.getReserveCnt());
			log.debug("4.4 getReserveCnt : {}",  param.getReserveCnt());
			pstmt.setString(5, param.getIsVerified());
			log.debug("4.5 getIsVerified : {}",  param.getIsVerified());
			pstmt.setInt(6, param.getShopNo());
			log.debug("4.6 getShopNo : {}",  param.getShopNo());
			
			flag = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt);
			log.debug("5. finally : conn : {} pstmt : {}", conn, pstmt);
		}
		log.debug("6. flag : {}", flag);
		return flag;
	}
    
	
	@Override
	public int doDelete(ShopDTO param) {
		int flag = 0;

		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;

		StringBuilder sb = new StringBuilder();
		
		sb.append(" DELETE FROM shop  \n");
		sb.append(" WHERE shop_no = ?		\n");

		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", param);

		try {
			pstmt = conn.prepareStatement(sb.toString()); // 쿼리를 넘기자~.
			log.debug("4. pstmt : {}", pstmt);

			// param 설정
			pstmt.setInt(1, param.getShopNo());

			// DML 수행
			flag = pstmt.executeUpdate(); // 반영 건수 리턴

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt);
			log.debug("5. finally : conn : {} pstmt : {}", conn, pstmt);
		} 
		log.debug("6. flag : {}", flag);

		return flag;
	}

	@Override
	public ShopDTO doSelectOne(ShopDTO param) {
		ShopDTO outVO = null;

		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("	SELECT          \n");
		sb.append("    shop_no,     \n");
		sb.append("    manager_id,  \n");
		sb.append("    shop_name,   \n");
		sb.append("    reg_date,    \n");
		sb.append("    score,       \n");
		sb.append("    review_cnt,  \n");
		sb.append("    reserve_cnt, \n");
		sb.append("    is_verified  \n");
		sb.append("FROM             \n");
		sb.append("    shop         \n");
		sb.append("WHERE            \n");
		sb.append("    SHOP_NO = ?  \n");

		log.debug("1.sql : {} \n " + sb.toString());
		log.debug("2.conn : {} ", conn);
		log.debug("3.param : {}", param);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt : {} ", pstmt);

			pstmt.setInt(1, param.getShopNo());
			rs = pstmt.executeQuery();
			log.debug("5. rs : " + rs);

			if (rs.next()) {
				outVO = new ShopDTO();
				outVO.setShopNo(rs.getInt("shop_no"));
				outVO.setManagerId(rs.getString("manager_id"));
				outVO.setShopName(rs.getString("shop_name"));
				outVO.setRegDate(rs.getString("reg_date"));
				outVO.setScore(rs.getInt("score"));
				outVO.setReviewCnt(rs.getInt("review_cnt"));
				outVO.setReserveCnt(rs.getInt("reserve_cnt"));
				outVO.setIsVerified(rs.getString("is_verified"));
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
	public List<ShopDTO> doRetrieve(DTO search) {
		
		SearchDTO searchVO = (SearchDTO) search;
		
		StringBuilder sbWhere = new StringBuilder();
		StringBuilder sbWhere2 = new StringBuilder();
//		 --WHERE shop_name    LIKE :searchWord||'%'	"10"
//	     --WHERE REVIEW_CNT LIKE :searchWord||'%' "20"
//	     --WHERE SCORE   = :searchWord			"30"
		if(null != searchVO.getSearchDiv() &&searchVO.getSearchDiv().equals("10")) {
			sbWhere.append("WHERE shop_name LIKE '%' || ? || '%' \n");
		}else if(null != searchVO.getSearchDiv() &&searchVO.getSearchDiv().equals("20")) {
			sbWhere.append("ORDER BY SCORE DESC \n");
		}else if(null != searchVO.getSearchDiv() &&searchVO.getSearchDiv().equals("30")) {
			sbWhere.append("ORDER BY REVIEW_CNT DESC \n");
		}else if(null != searchVO.getSearchDiv() &&searchVO.getSearchDiv().equals("40")) {
			sbWhere2.append("WHERE manager_id = ?  \n");
		}
		
		List<ShopDTO> list = new ArrayList<ShopDTO>();
		
		Connection conn = connectionMaker.getConnection();  //DB 연결
		PreparedStatement pstmt = null;						//SQL + param
		ResultSet rs = null;								//SQL 결과
		
		StringBuilder sb = new StringBuilder(1000);
                                         
		sb.append("SELECT A.SHOP_NAME,                                           \n");
		sb.append("		  A.SHOP_NO,                                           \n");
	    sb.append("   B.SHOP_LOC,                                                \n");
	    sb.append("   A.MANAGER_ID,                                              \n");
	    sb.append("   A.REG_DATE,                                                \n");
	    sb.append("    A.SCORE,                                                  \n");
	    sb.append("   A.REVIEW_CNT,                                              \n");
	    sb.append("   A.RESERVE_CNT,                                             \n");
	    sb.append("   A.IS_VERIFIED                                              \n");
		sb.append("FROM (                                                        \n");
		sb.append("	SELECT TT1.rnum AS num,                                      \n");
		sb.append("            tt1.shop_no,                                      \n");
		sb.append("            tt1.MANAGER_ID,                                   \n");
		sb.append("			   tt1.shop_name,                                    \n");
		sb.append("            TT1.REG_DATE,                                     \n");
		sb.append("            TT1.SCORE,                                        \n");
		sb.append("			tt1.REVIEW_CNT,                                      \n");
		sb.append("            TT1.RESERVE_CNT,                                  \n");
		sb.append("            TT1.IS_VERIFIED                                   \n");
		sb.append("	FROM (                                                       \n");
		sb.append("			SELECT ROWNUM AS rnum, T1.*                          \n");
		sb.append("				FROM (                                           \n");
		sb.append("					SELECT *                                     \n");
		sb.append("					FROM shop                                    \n");
		sb.append("					--WHERE                                      \n");
//----where-----------------------------------------------------------------------------------------------------
		sb.append(sbWhere.toString());
		sb.append(sbWhere2.toString());
//----where-----------------------------------------------------------------------------------------------------
		sb.append("					                                             \n");
		sb.append("			)T1                                                  \n");
		sb.append("			WHERE ROWNUM <= ( ? * (? -1) + ?)					 \n");
		sb.append("	 )TT1                                                        \n");
		sb.append("	WHERE rnum >= ( ? * ( ? -1) +1)           				     \n");
		sb.append("	)A, (                                                        \n");
		sb.append("	    SELECT SHOP_NO,                                          \n");
		sb.append("	        SHOP_LOC                                             \n");
		sb.append("	    FROM SHOP_DETAIL                                         \n");
		sb.append("	)B                                                           \n");
		sb.append("	WHERE A.SHOP_NO = B.SHOP_NO                                  \n");

		log.debug("1. SQL : {}", sb.toString());
		log.debug("2. Conn : {}", conn);
		log.debug("3. param : {}", search);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4. pstmt : {}", pstmt);
						
				//가게 이름으로 검색
				if(null != searchVO.getSearchDiv() && searchVO.getSearchDiv().equals("10")) {
					log.debug("4.1 searchDiv : 가게명으로 검색 {}", searchVO.getSearchDiv());
					
					pstmt.setString(1,  searchVO.getSearchWord());
					
					//ROWNUM
					pstmt.setInt(2, searchVO.getPageSize());
					pstmt.setInt(3, searchVO.getPageNo());
					pstmt.setInt(4, searchVO.getPageSize());
					
					//rnum
					pstmt.setInt(5, searchVO.getPageSize());
					pstmt.setInt(6, searchVO.getPageNo());
					
					
				//리뷰 갯수로 검색 : 20
				//별점 갯수 순서로 검색 : 30
				}else if(null != searchVO.getSearchDiv() && searchVO.getSearchDiv().equals("20")
						|| null != searchVO.getSearchDiv() && searchVO.getSearchDiv().equals("30")) {
					log.debug("4.2 searchDiv : 리뷰 갯수로 검색 {}", searchVO.getSearchDiv());
					
					//ROWNUM
					pstmt.setInt(1, searchVO.getPageSize());
					pstmt.setInt(2, searchVO.getPageNo());
					pstmt.setInt(3, searchVO.getPageSize());
					
					//rnum
					pstmt.setInt(4, searchVO.getPageSize());
					pstmt.setInt(5, searchVO.getPageNo());
					
					
				}else if(null != searchVO.getSearchDiv() && searchVO.getSearchDiv().equals("40")) {
					log.debug("4.1 searchDiv : 매니저 ID로 검색 {}", searchVO.getSearchDiv());
					
					pstmt.setString(1,  searchVO.getSearchWord());
					
					//ROWNUM
					pstmt.setInt(2, searchVO.getPageSize());
					pstmt.setInt(3, searchVO.getPageNo());
					pstmt.setInt(4, searchVO.getPageSize());
					
					//rnum
					pstmt.setInt(5, searchVO.getPageSize());
					pstmt.setInt(6, searchVO.getPageNo());
					
					
				//리뷰 갯수로 검색 : 20
				//별점 갯수 순서로 검색 : 30
				}else {
					//ROWNUM
					pstmt.setInt(1, searchVO.getPageSize());
					pstmt.setInt(2, searchVO.getPageNo());
					pstmt.setInt(3, searchVO.getPageSize());
					
					pstmt.setInt(4, searchVO.getPageSize());
					pstmt.setInt(5, searchVO.getPageNo());				
				}
			
			//select 실행
			rs = pstmt.executeQuery(); 
			log.debug("5. rs : {}", rs);
			
			while(rs.next()) {
				ShopDTO outVO = new ShopDTO();
				log.debug("5.0 성공! outVO : {}, ", outVO);
				outVO.setShopName(rs.getString("shop_name"));
				log.debug("5.1 성공! shopname : {}, ", rs.getString("shop_name"));
				
				outVO.setShopNo(rs.getInt("shop_no"));
				log.debug("5.2 성공! shop_no : {}, ", rs.getString("shop_no"));
				
				outVO.setShopLoc(rs.getString("shop_loc"));
				log.debug("5.3 성공! shop_loc : {}, ", rs.getString("shop_loc"));
				
				outVO.setManagerId(rs.getString("manager_id"));
				log.debug("5.4 성공! Manager_id : {}, ", rs.getString("manager_id"));
				
				outVO.setRegDate(rs.getString("reg_date"));
				log.debug("5.5 성공! reg_date : {}, ", rs.getString("reg_date"));
				
				outVO.setScore(rs.getInt("score"));
				log.debug("5.6 성공! score : {}, ", rs.getString("score"));
				
				outVO.setReviewCnt(rs.getInt("review_cnt"));
				log.debug("5.7 성공! review_cnt : {}, ", rs.getString("review_cnt"));
				
				outVO.setReserveCnt(rs.getInt("reserve_cnt"));
				log.debug("5.8 성공! reserve_cnt : {}, ", rs.getString("reserve_cnt"));
				
				outVO.setIsVerified(rs.getString("is_verified"));
				log.debug("5.9 성공! is_verified : {}, ", rs.getString("is_verified"));
				
				list.add(outVO);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return list;
		
	}
	
	@Override
	public int doUpdateReadCnt(ShopDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}
}

