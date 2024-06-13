package com.pcwk.review;

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
import com.pcwk.menu.MenuDTO;
import com.pcwk.reserve.ReserveDTO;


public class ReviewDAO implements WorkDiv<ReviewDTO> {
	
	ConnectionMaker connectionMaker;

	public Connection getConnection() {
		return connectionMaker.getConnection();
	}
	 

	public ReviewDAO() {
		super();
		connectionMaker = new ConnectionMaker();
	}

	@Override
	public List<ReviewDTO> doRetrieve(DTO search) {
        SearchDTO searchVO = (SearchDTO) search;
		
		StringBuilder sbWhere = new StringBuilder(300);
		if(null != searchVO.getSearchDiv() && searchVO.getSearchDiv().equals("10")) {
			sbWhere.append("WHERE user_id = ?  \n");
		}else if(null != searchVO.getSearchDiv() && searchVO.getSearchDiv().equals("20")) {
			sbWhere.append("WHERE shop_no = ?  \n");
		}
		
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder(1000);
		
		sb.append(" select a.*,b.*,c.shop_name as                \n");
		sb.append("  from(select tt1.rnum as num,                \n");
		sb.append("        tt1.review_no,                        \n");
		sb.append(" 	   tt1.shop_no,                          \n");
		sb.append(" 	   tt1.user_id,                          \n");
		sb.append(" 	   tt1.review_Wrt_Date,                  \n");
		sb.append(" 	   tt1.review_Mod_Date,                  \n");
		sb.append(" 	   tt1.review_Content,                   \n");
		sb.append(" 	   tt1.score                             \n");
		sb.append(" 	   from (select rownum as rnum, t1.*     \n");
		sb.append("                from  (select *               \n");
		sb.append("                         from review          \n");
		sb.append(sbWhere.toString());
		sb.append(" 		             )t1                     \n");
		sb.append(" 	  where rownum<=(?*(?-1)+?)              \n");
		sb.append(" 		    )tt1                             \n");
		sb.append("       where rownum >=(?*(?-1)+1) )a,(        \n");
		sb.append(" 		select count(*) totalCnt             \n");
		sb.append("           from review                        \n");
		sb.append(sbWhere.toString());
		sb.append("          )b, (select shop_no,                \n");
		sb.append("                      shop_name               \n");
		sb.append("                 from shop                    \n");
		sb.append("              )c	                             \n");
		sb.append("         where a.shop_no=c.shop_no			 \n");
		
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
				ReviewDTO outVO = new ReviewDTO();
				outVO.setNum (rs.getInt("num"));
				outVO.setReviewNo(rs.getInt("review_no"));
				outVO.setShopNo(rs.getInt("shop_no"));
				outVO.setUserId(rs.getString("user_id"));
				outVO.setReviewWrtDate(rs.getString("review_Wrt_Date"));
				outVO.setReviewModDate(rs.getString("review_Mod_Date"));
				outVO.setScore(rs.getInt("score"));
				outVO.setTotalCnt(rs.getInt("totalCnt"));
				outVO.setShopName(rs.getString("shop_name"));
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
	public int doSave(ReviewDTO param) {
		int flag = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM

		StringBuilder sb = new StringBuilder(300);
		sb.append(" INSERT INTO review (  \n");
		sb.append("     shop_no,          \n");
		sb.append("     user_id,          \n");
		sb.append("     review_wrt_date,  \n");
		sb.append("     review_mod_date,  \n");
		sb.append("     review_content,   \n");
		sb.append("     score             \n");
		sb.append(" ) VALUES (            \n");
		sb.append("     ?,                \n");
		sb.append("     ?,                \n");
		sb.append("     sysdate,          \n");
		sb.append("     sysdate,          \n");
		sb.append("     ?,                \n");
		sb.append("     ?                 \n");
		sb.append(" )                     \n");

		log.debug("1.sql:{}", sb.toString());
		log.debug("2.conn:{}", conn);
		log.debug("3.param:{}", param);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt:{}", pstmt);
			
			pstmt.setInt(1, param.getShopNo());
			pstmt.setString(2, param.getUserId());
			pstmt.setString(3, param.getReviewContent());
			pstmt.setInt(4, param.getScore());
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt);
			log.debug("5.finally conn:{} pstmt:{}", conn, pstmt);
		}

		log.debug("6.flag:{}", flag);

		return flag;
	}

	@Override
	public int doUpdate(ReviewDTO param) {
		int flag = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM

		StringBuilder sb = new StringBuilder(300);
		sb.append(" UPDATE review                       \n");
		sb.append("    SET review_content =?,           \n");
		sb.append("        score =?,                    \n");
		sb.append("        review_mod_date =   sysdate  \n");
		sb.append("  WHERE review_no=?                  \n");

		log.debug("1.sql:{}", sb.toString());
		log.debug("2.conn:{}", conn);
		log.debug("3.param:{}", param);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt:{}", pstmt);
			pstmt.setString(1, param.getReviewContent());
			pstmt.setInt(2, param.getScore());
			pstmt.setInt(3, param.getReviewNo());
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt);

			log.debug("5.finally conn:{} pstmt:{}", conn, pstmt);
		}

		log.debug("6.flag:{}", flag);

		return flag;
	}

	@Override
	public int doDelete(ReviewDTO param) {
		int flag = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM

		StringBuilder sb = new StringBuilder(300);
		sb.append(" DELETE FROM review   \n");
		sb.append(" WHERE review_no = ?  \n");

		log.debug("1.sql:{}", sb.toString());
		log.debug("2.conn:{}", conn);
		log.debug("3.param:{}", param);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt:{}", pstmt);
			
			pstmt.setInt(1, param.getReviewNo());
			
			
			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt);
			log.debug("5.finally conn:{} pstmt:{}", conn, pstmt);
		}

		log.debug("6.flag:{}", flag);

		return flag;
	}

	@Override
	public ReviewDTO doSelectOne(ReviewDTO param) {
		ReviewDTO outVO = null; // 단건조회 결과
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM
		ResultSet rs = null;// SQL문의 결과

		StringBuilder sb = new StringBuilder(300);
		sb.append(" select                   \n");
		sb.append("         shop_no,         \n");
		sb.append("         user_id,         \n");
		sb.append("         review_wrt_date, \n");
		sb.append("         review_mod_date, \n");
		sb.append("         review_content,  \n");
		sb.append("         score            \n");
		sb.append("    from review           \n");
		sb.append("   where review_no=?      \n");

		log.debug("1.sql:\n" + sb.toString());
		log.debug("2.conn:\n" + conn);
		log.debug("3.param:\n" + param);

		try {

			// param설정
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, param.getReviewNo());

			// SELECT실행
			rs = pstmt.executeQuery();
			log.debug("5.rs:" + rs);

			if (rs.next()) {
				outVO = new ReviewDTO();
				outVO.setShopNo(rs.getInt("shop_no"));
				outVO.setUserId(rs.getString("user_id"));
				outVO.setReviewWrtDate(rs.getString("review_wrt_date"));
				outVO.setReviewModDate(rs.getString("review_mod_date"));
				outVO.setReviewContent(rs.getString("review_content"));
				outVO.setScore(rs.getInt("score"));
				log.debug("6.outVO:" + outVO);
			}

		} catch (SQLException e) {
			log.debug("────────────────");
			log.debug("SQLException:" + e.getMessage());
			log.debug("────────────────");
		} finally {

			DBUtil.close(conn, pstmt,rs);
		}
		return outVO;
	}

	@Override
	public int doUpdateReadCnt(ReviewDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
