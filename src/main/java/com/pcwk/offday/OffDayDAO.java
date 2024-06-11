package com.pcwk.offday;

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

public class OffDayDAO implements WorkDiv<OffDayDTO> {
	ConnectionMaker connectionMaker;

	public Connection getConnection() {
		return connectionMaker.getConnection();
	}
	 

	public OffDayDAO() {
		super();
		connectionMaker = new ConnectionMaker();
	}


	@Override
	public int doUpdate(OffDayDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doUpdateReadCnt(OffDayDTO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OffDayDTO> doRetrieve(DTO search) {
		SearchDTO searchVO = (SearchDTO) search;
		List<OffDayDTO> list = new ArrayList<OffDayDTO>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM
		ResultSet rs = null;// SQL문의 결과
		
		StringBuilder sb = new StringBuilder(1000);

		sb.append(" select to_char(closed_day,'YYYYMMDD') closed_day     \n");
		sb.append("   from off_day                                       \n");
		sb.append(" where shop_no =? and closed_day>=sysdate             \n");
		
		
		log.debug("1.sql:{}", sb.toString());
		log.debug("2.conn:{}", conn);
		log.debug("3.param:{}", search);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt: {} ", pstmt);

			    pstmt.setInt(1, searchVO.getSearchSeq());

			rs = pstmt.executeQuery();
			log.debug("5.rs:{}", rs);
			while (rs.next()) {
				OffDayDTO outVO = new OffDayDTO();

				outVO.setClosedDay(rs.getString("closed_day"));
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
	public int doSave(OffDayDTO param) {
		int flag = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM

		StringBuilder sb = new StringBuilder(300);
		sb.append(" INSERT INTO off_day ( \n");
		sb.append("     shop_no,          \n");
		sb.append("     closed_day        \n");
		sb.append(" ) VALUES (            \n");
		sb.append("     ?,                \n");
		sb.append("     to_date(?)        \n");
		sb.append(" )                     \n");

		log.debug("1.sql:{}", sb.toString());
		log.debug("2.conn:{}", conn);
		log.debug("3.param:{}", param);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt:{}", pstmt);
			
			pstmt.setInt(1, param.getShopNo());
			pstmt.setString(2, param.getClosedDay());
			
			
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
	public int doDelete(OffDayDTO param) {
		int flag = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null; // SQL+PARAM

		StringBuilder sb = new StringBuilder(300);
		sb.append(" DELETE FROM OFF_DAY  \n");
		sb.append(" WHERE OFFDAY_NO = ? \n");

		log.debug("1.sql:{}", sb.toString());
		log.debug("2.conn:{}", conn);
		log.debug("3.param:{}", param);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			log.debug("4.pstmt:{}", pstmt);
			
			pstmt.setInt(1, param.getOffDaySeq());
			
			
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
	public OffDayDTO doSelectOne(OffDayDTO param) {
		// TODO Auto-generated method stub
		return null;
	}

}
