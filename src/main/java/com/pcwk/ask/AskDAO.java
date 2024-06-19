package com.pcwk.ask;

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
import com.pcwk.review.ReviewDTO;

public class AskDAO implements WorkDiv<AskDTO> {
	ConnectionMaker connectionMaker;

	public Connection getConnection() {
		return connectionMaker.getConnection();
	}
	

	public AskDAO() {
		super();
		connectionMaker = new ConnectionMaker();
	}


	@Override
	public List<AskDTO> doRetrieve(DTO search) {
        SearchDTO searchVO = (SearchDTO) search;
		
		StringBuilder sbWhere = new StringBuilder(300);
		if(null != searchVO.getSearchDiv() && searchVO.getSearchDiv().equals("10")) {
			sbWhere.append("WHERE user_id = ?  \n");
		}else if(null != searchVO.getSearchDiv() && searchVO.getSearchDiv().equals("20")) {
			sbWhere.append("WHERE shop_no = ?  \n");
		}
		
		List<AskDTO> list = new ArrayList<AskDTO>();
		
		Connection conn = connectionMaker.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder(1000);
		
		sb.append(" select a.*,b.*,c.shop_name                 \n");
		sb.append("  from(select tt1.rnum as num,              \n");
		sb.append("        tt1.ask_no,                         \n");
		sb.append(" 	   tt1.shop_no,                        \n");
		sb.append(" 	   tt1.user_id,                        \n");
		sb.append(" 	   tt1.ask_state,                      \n");
		sb.append(" 	   tt1.user_ask,                       \n");
		sb.append(" 	   tt1.ask_date,                       \n");
		sb.append(" 	   tt1.shop_answer,                    \n");
		sb.append("        tt1.answer_Date                     \n");
		sb.append(" 	   from (select rownum as rnum, t1.*   \n");
		sb.append("                from  (select *             \n");
		sb.append("                         from ask           \n");
		sb.append(sbWhere.toString());
		sb.append(" 		             )t1                   \n");
		sb.append(" 	  where rownum<=(?*(?-1)+?)            \n");
		sb.append(" 		    )tt1                           \n");
		sb.append("       where rownum >=(?*(?-1)+1) )a,(      \n");
		sb.append(" 		select count(*) totalCnt           \n");
		sb.append("           from ask                         \n");
		sb.append(sbWhere.toString());
		sb.append("          )b, (select shop_no,              \n");
		sb.append("                      shop_name             \n");
		sb.append("                 from shop                  \n");
		sb.append("              )c	                           \n");
		sb.append("         where a.shop_no=c.shop_no		   \n");
		sb.append("         order by ask_state desc,ask_date desc             \n");		
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
				AskDTO outVO = new AskDTO();
				outVO.setNum (rs.getInt("num"));
				outVO.setAskNo(rs.getInt("ask_no"));
				outVO.setShopNo(rs.getInt("shop_no"));
				outVO.setUserId(rs.getString("user_id"));
				outVO.setAskState(rs.getString("ask_state"));
				outVO.setUserAsk(rs.getString("user_ask"));
				outVO.setAskDate(rs.getString("ask_date"));
				outVO.setShopAnswer(rs.getString("shop_answer"));
				outVO.setAnswerDate(rs.getString("answer_Date"));
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

	
	
	
	/***
	 * insert 
	 */
	@Override
	public int doSave(AskDTO param) {
		int flag = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM

		StringBuilder sb = new StringBuilder(300);
		sb.append(" INSERT INTO ask (  \n");   
		sb.append("                    \n");
		sb.append("     shop_no,       \n");
		sb.append("     user_id,       \n");
		sb.append("     ask_state,     \n");
		sb.append("     user_ask,      \n");
		sb.append("     ask_date,      \n");
		sb.append("     shop_answer,   \n");
		sb.append("     answer_date    \n");
		sb.append(" ) VALUES (         \n");
		sb.append("                    \n");
		sb.append("     ?,             \n");
		sb.append("     ?,             \n");
		sb.append("     ?,             \n");
		sb.append("     ?,             \n");
		sb.append("     to_date(?),    \n");
		sb.append("     ?,             \n");
		sb.append("      to_date(?)   \n");
		sb.append(" )                  \n");

		log.debug("1.sql:{}", sb.toString());
		log.debug("2.conn:{}", conn);
		log.debug("3.param:{}", param);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt:{}", pstmt);
			
			pstmt.setInt(1, param.getShopNo());
			pstmt.setString(2, param.getUserId());
			pstmt.setString(3, param.getAskState());
			pstmt.setString(4, param.getUserAsk());
			pstmt.setString(5, param.getAskDate());
			pstmt.setString(6, param.getShopAnswer());
			pstmt.setString(7, param.getAnswerDate());
			
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
	
	
	
	
	/***
	 * 수정 update
	 */
	@Override
	public int doUpdate(AskDTO param) {
		int flag = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM

		StringBuilder sb = new StringBuilder(300);
		sb.append("UPDATE ask               \n");  
		sb.append("    set                  \n");
		sb.append("         ask_state = ?,   \n");
		sb.append("         user_ask = ?,    \n");
		sb.append("         ask_date = ?,    \n");
		sb.append("         shop_answer = ?, \n");
		sb.append("         answer_date = ? \n");
		sb.append("    where ask_no = ?     \n");
		log.debug("1.sql:{}", sb.toString());
		log.debug("2.conn:{}", conn);
		log.debug("3.param:{}", param);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt:{}", pstmt);
			pstmt.setString(1, param.getAskState());
			pstmt.setString(2, param.getUserAsk());
			pstmt.setString(3, param.getAskDate());
			pstmt.setString(4, param.getShopAnswer());
			pstmt.setString(5, param.getAnswerDate());
			pstmt.setInt(6, param.getAskNo());
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
	
	
	public int doUpdateAnswer(AskDTO param) {
		int flag = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM

		StringBuilder sb = new StringBuilder(300);
		sb.append("UPDATE ask               \n");  
		sb.append("    set                  \n");
		sb.append("         ask_state = ?,   \n");
		sb.append("         shop_answer = ?, \n");
		sb.append("         answer_date = sysdate \n");
		sb.append("    where ask_no = ?     \n");
		log.debug("1.sql:{}", sb.toString());
		log.debug("2.conn:{}", conn);
		log.debug("3.param:{}", param);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt:{}", pstmt);
			pstmt.setString(1, param.getAskState());
			pstmt.setString(2, param.getShopAnswer());
			pstmt.setInt(3, param.getAskNo());
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
	
	/***
	 * 삭제 delete
	 */
	@Override
	public int doDelete(AskDTO param) {
		int flag = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM
		
		StringBuilder sb = new StringBuilder(300);
		sb.append("DELETE FROM ask        \n");       
		sb.append("WHERE                  \n");
		sb.append("   ask_no =?        \n");
		
		
		log.debug("1.sql:{}", sb.toString());
		log.debug("2.conn:{}", conn);
		log.debug("3.param:{}", param);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt:{}", pstmt);
		
			pstmt.setInt(1, param.getAskNo());
			
			
			
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
	
	
	
	/***
	 * 단건조회
	 * 
	 */
	@Override
	public AskDTO doSelectOne(AskDTO param) {
		AskDTO outVO = null; // 단건조회 결과
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM
		ResultSet rs = null;// SQL문의 결과

		StringBuilder sb = new StringBuilder(300);
		sb.append("SELECT           \n");
		sb.append("                 \n");
		sb.append("    shop_no,     \n");
		sb.append("    user_id,     \n");
		sb.append("    ask_state,   \n");
		sb.append("    user_ask,    \n");
		sb.append("    ask_date,    \n");
		sb.append("    shop_answer, \n");
		sb.append("    answer_date  \n");
		sb.append("FROM             \n");
		sb.append("    ask          \n");
		sb.append("where ask_no=?     \n");
		
		log.debug("1.sql:\n" + sb.toString());
		log.debug("2.conn:\n" + conn);
		log.debug("3.param:\n" + param);

		try {

			// param설정
			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setInt(1, param.getAskNo());
			// SELECT실행
			rs = pstmt.executeQuery();
			
			log.debug("5.rs:" + rs);

			if (rs.next()) {
				
				outVO = new AskDTO();
				outVO.setShopNo(rs.getInt("shop_no"));
				outVO.setUserId(rs.getString("user_id"));
				outVO.setAskState(rs.getString("ask_state"));
				outVO.setUserAsk(rs.getString("user_ask"));
				outVO.setAskDate(rs.getString("ask_date"));
				outVO.setShopAnswer(rs.getString("shop_answer"));
				outVO.setAnswerDate(rs.getString("answer_date "));
				
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
	public int doUpdateReadCnt(AskDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
