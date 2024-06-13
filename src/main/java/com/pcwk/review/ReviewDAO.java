package com.pcwk.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.cmn.ConnectionMaker;
import com.pcwk.ehr.cmn.DBUtil;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.WorkDiv;
import com.pcwk.menu.MenuDTO;


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
		// TODO Auto-generated method stub
		return null;
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
		sb.append(" select menu_name, \n");
		sb.append("        menu_info, \n");
		sb.append("        price      \n");
		sb.append("   from menu       \n");
		sb.append(" where menu_no = ? \n");

		log.debug("1.sql:\n" + sb.toString());
		log.debug("2.conn:\n" + conn);
		log.debug("3.param:\n" + param);

		try {

			// param설정
			pstmt = conn.prepareStatement(sb.toString());
			//pstmt.setInt(1, param.getMenuNO());

			// SELECT실행
			rs = pstmt.executeQuery();
			log.debug("5.rs:" + rs);

			if (rs.next()) {
			//	outVO = new MenuDTO();
			//	outVO.setMenuName(rs.getString("menu_name"));
			//	outVO.setMenuInfo(rs.getString("menu_info"));
			//	outVO.setPrice(rs.getInt("price"));
				
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
