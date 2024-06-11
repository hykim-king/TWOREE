package com.pcwk.offday;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.cmn.DBUtil;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.WorkDiv;
import com.pcwk.user.ConnectionMaker;

public class OffDayDAO implements WorkDiv<OffDayDTO> {
	ConnectionMaker connectionMaker;

	public Connection getConnection() {
		return connectionMaker.getConnection();
	}
	 

	public OffDayDAO(ConnectionMaker connectionMaker) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doSave(OffDayDTO param) {
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
			/*
			pstmt.setInt(1, param.getSeq());
			pstmt.setString(2, param.getContents());
			pstmt.setInt(3, param.getBoardSeq());
			pstmt.setString(4, param.getRegId());
			*/
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OffDayDTO doSelectOne(OffDayDTO param) {
		// TODO Auto-generated method stub
		return null;
	}

}
