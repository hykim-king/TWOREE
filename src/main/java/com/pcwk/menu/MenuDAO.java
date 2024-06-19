package com.pcwk.menu;

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

public class MenuDAO implements WorkDiv<MenuDTO> {
	
	ConnectionMaker connectionMaker;

	public Connection getConnection() {
		return connectionMaker.getConnection();
	}
	 

	public MenuDAO() {
		super();
		connectionMaker = new ConnectionMaker();
	}

	@Override
	public List<MenuDTO> doRetrieve(DTO search) {
		SearchDTO searchVO = (SearchDTO) search;
		List<MenuDTO> list = new ArrayList<MenuDTO>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM
		ResultSet rs = null;// SQL문의 결과
		
		StringBuilder sb = new StringBuilder(1000);

		sb.append(" select a.*,b.*                            \n");
		sb.append(" from(select tt1.rnum as num,              \n");
		sb.append("        tt1.menu_no,                     \n");
		sb.append("        tt1.menu_name,                     \n");
		sb.append("        tt1.menu_info,                     \n");
		sb.append("        tt1.price                          \n");
		sb.append(" from(select rownum as rnum,t1.*           \n");
		sb.append("   from( select *                          \n");
		sb.append("           from menu                       \n");
		sb.append("         where shop_no =?                  \n");
		sb.append("         order by menu_no asc)t1           \n");
		sb.append("         where rownum <=(?*(?-1)+?))tt1    \n");
		sb.append("         where rnum>=(?*(?-1)+1))a,        \n");
		sb.append("     (select count(*) totalCnt             \n");
		sb.append("       from menu                           \n");
		sb.append("     where shop_no=?)b                     \n");
		sb.append("                                           \n");
		
		
		log.debug("1.sql:{}", sb.toString());
		log.debug("2.conn:{}", conn);
		log.debug("3.param:{}", search);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt: {} ", pstmt);

			    pstmt.setInt(1, searchVO.getSearchSeq());
				pstmt.setInt(2, searchVO.getPageSize());
				pstmt.setInt(3, searchVO.getPageNo());
				pstmt.setInt(4, searchVO.getPageSize());
				pstmt.setInt(5, searchVO.getPageSize());
				pstmt.setInt(6, searchVO.getPageNo());
				pstmt.setInt(7, searchVO.getSearchSeq());
			

			rs = pstmt.executeQuery();
			log.debug("5.rs:{}", rs);
			while (rs.next()) {
				MenuDTO outVO = new MenuDTO();

				outVO.setNum(rs.getInt("num"));
				outVO.setmenuNo(rs.getInt("menu_no"));
				outVO.setMenuName(rs.getString("menu_name"));
				outVO.setMenuInfo(rs.getString("menu_info"));
				outVO.setPrice(rs.getInt("price"));
				outVO.setTotalCnt(rs.getInt("totalCnt"));

				list.add(outVO);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);

			log.debug("5.finally conn:{} pstmt:{} rs:{}", conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public int doSave(MenuDTO param) {
		int flag = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM

		StringBuilder sb = new StringBuilder(300);
		sb.append(" INSERT INTO menu ( \n");
		sb.append("     shop_no,       \n");
		sb.append("     menu_name,     \n");
		sb.append("     menu_info,     \n");
		sb.append("     price          \n");
		sb.append(" ) VALUES (         \n");
		sb.append("     ?,             \n");
		sb.append("     ?,             \n");
		sb.append("     ?,             \n");
		sb.append("     ?              \n");
		sb.append(" )                 \n");

		log.debug("1.sql:{}", sb.toString());
		log.debug("2.conn:{}", conn);
		log.debug("3.param:{}", param);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt:{}", pstmt);
			
			pstmt.setInt(1, param.getShopNo());
			pstmt.setString(2, param.getMenuName());
			pstmt.setString(3, param.getMenuInfo());
			pstmt.setInt(4, param.getPrice());
			
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
	public int doUpdate(MenuDTO param) {
		int flag = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM

		StringBuilder sb = new StringBuilder(300);
		sb.append(" UPDATE MENU          \n");
		sb.append("    SET menu_name =?, \n");
		sb.append("        menu_info =?, \n");
		sb.append("        price =    ?  \n");
		sb.append("  WHERE menu_no=?     \n");

		log.debug("1.sql:{}", sb.toString());
		log.debug("2.conn:{}", conn);
		log.debug("3.param:{}", param);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt:{}", pstmt);
			pstmt.setString(1, param.getMenuName());
			pstmt.setString(2, param.getMenuInfo());
			pstmt.setInt(3, param.getPrice());
			pstmt.setInt(4, param.getmenuNo());
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
	public int doDelete(MenuDTO param) {
		int flag = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM

		StringBuilder sb = new StringBuilder(300);
		sb.append(" DELETE FROM MENU  \n");
		sb.append(" WHERE menu_no = ? \n");

		log.debug("1.sql:{}", sb.toString());
		log.debug("2.conn:{}", conn);
		log.debug("3.param:{}", param);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt:{}", pstmt);
			
			pstmt.setInt(1, param.getmenuNo());
			
			
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
	public MenuDTO doSelectOne(MenuDTO param) {
		MenuDTO outVO = null; // 단건조회 결과
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM
		ResultSet rs = null;// SQL문의 결과

		StringBuilder sb = new StringBuilder(300);
		sb.append(" select menu_name, \n");
		sb.append("        menu_no, \n");
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
			pstmt.setInt(1, param.getmenuNo());

			// SELECT실행
			rs = pstmt.executeQuery();
			log.debug("5.rs:" + rs);

			if (rs.next()) {
				outVO = new MenuDTO();
				outVO.setMenuName(rs.getString("menu_name"));
				outVO.setMenuInfo(rs.getString("menu_info"));
				outVO.setPrice(rs.getInt("price"));
				outVO.setmenuNo(rs.getInt("menu_no"));
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
	public int doUpdateReadCnt(MenuDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
